package de.uks.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.ListIterator;

import org.junit.Test;
import org.sdmlib.models.modelsets.SDMSetBase;
import org.sdmlib.serialization.xml.EmfIdMap;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.GoalKeeper;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldCreator;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;

import update.Action;
import update.MovePlayer;
import update.ShootBall;
import update.Update;
import update.util.ActionSet;
import update.util.UpdateCreator;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.xml.XMLEntity;

public class ServerConnection
{

   private static final String BLUE = "BLUE";
   private static final String RED = "RED";
   private static final Object START_MARKER = "#START_RESOURCE#";
   private static final Object END_MARKER = "#END_RESOURCE#";
   private BufferedReader in;
   private PrintWriter out;
   private String teamColor = BLUE;
   private String opponentColor = RED;

   public static void main(String[] args)
   {
      String host = "localHost";
      
      String port = "1234";
      
      String teamName = "SDMLib";
      
      if (args == null || args.length < 2)
      {
         System.out.println("Usage: java -jar SDMLibSoccerClient.jar <host> <port>");
         System.exit(42);
      }
      
      host = args[0];
      
      int portNum = Integer.parseInt(args[1]);
      
      if (args.length >= 3)
      {
         teamName = args[2];
      }
      
      new ServerConnection().connect(host, portNum, teamName);
   }


   @Test
   public void testSendUpdate()
   {
      Update update = new Update();

      ActionSet actions = update.getActions();
      actions.add((new ShootBall().withPlayerNumber(1).withXDist(7)));
      actions.add((new MovePlayer().withPlayerNumber(2).withXDist(3)));
      actions.add((new MovePlayer().withPlayerNumber(3).withXDist(2)));
      actions.add((new MovePlayer().withPlayerNumber(4).withXDist(-3)));
      actions.add((new MovePlayer().withPlayerNumber(5).withXDist(0)));
      actions.add((new MovePlayer().withPlayerNumber(5).withXDist(2).withYDist(4)));

      sendUpdate(update);
   }

   private void connect(String string, int i, String teamName)
   {
      try
      {
         Socket socket = new Socket(string, i);

         in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
         out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

         teamColor = in.readLine();
         System.out.println("color: " + teamColor);

         out.println(teamName);

         out.flush();
         new Thread(new Runnable()
         {

            @Override
            public void run()
            {
               while (true)
               {
                  receiveResource();
               }
            }
         }).start();
         ;
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   void receiveResource()
   {
      // socket is the Socket connected to the Server
      // in is new BufferedReader(new
      // InputStreamReader(socket.getInputStream()));
      try
      {
         String s = in.readLine();
         if (s == null)
            throw new RuntimeException("Connection lost.");
         if (!s.equals(START_MARKER))
            throw new RuntimeException("Bad message from server.");

         StringBuilder sb = new StringBuilder();
         while (!(s = in.readLine()).equals(END_MARKER))
         {
            sb.append(s);
         }
         s = sb.toString();
         System.out.println(s);

         loadPitch(s);
      }
      catch (IOException e)
      {
         e.printStackTrace();
         System.exit(42);
      }
   }

   private void loadPitch(String pitchXML)
   {
      // TODO Auto-generated method stub
      EmfIdMap idMap = new EmfIdMap();

      idMap.withCreator(FieldCreator.createIdMap("i"));

      Object root = idMap.decode(pitchXML);

      pitch = (SoccerPitch) root;



      Update update = computeMoves();

      sendUpdate(update);

      System.out.println(root);
   }

   private void sendUpdate(Update update)
   {
      // to xml 
      EmfIdMap idMap = new EmfIdMap();

      idMap.withCreator(UpdateCreator.createIdMap("o"));

      XMLEntity encode = idMap.encode(update);

      encode.put("xmi:version", "2.0");
      encode.put("xmlns:xmi", "http://www.omg.org/XMI");
      encode.put("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
      encode.put("xmlns:update", "http://www.transformation-tool-contest.eu/updatemodel/1.0");


      String result = "<?xml version=\"1.0\" encoding=\"ASCII\"?>\n" + encode.toString(3);

      out.println(START_MARKER);
      out.println(result);
      out.println(END_MARKER);
      out.flush();

      System.out.println("\nSending:");
      System.out.println(result);
      // send it

   }

   public static final int DEFENSE = 1;
   public static final int OFFENSE = 2;
   private int dir;
   private SoccerPitch pitch;
   private PlayerSet myTeam;
   private int goalX;
   private int mode;
   private Update update;
   private FieldSet goalFields;

   private Update computeMoves()
   {
      dir = 1;
      goalX = 44;


      if (this.teamColor.equals(RED))
      {
         dir = -1;
         goalX = 0;

         this.opponentColor = BLUE;
      }
      
      goalFields = pitch.getFields().hasXPos(goalX).hasYPos(9, 15);

      Player ballOwner = pitch.getBall().getPlayer();

      mode = DEFENSE;
      if (ballOwner == null)
      {
         mode = DEFENSE;
      }
      else if (ballOwner.getTeam().equals(this.teamColor))
      {
         mode = OFFENSE;
      }

      update = new Update();

      myTeam = pitch.getPlayers().hasTeam(this.teamColor);

      if (mode == DEFENSE)
      {
         defend(8);
      }
      else
      {
         offend();
      }


      return update;
   }


   private void offend()
   {
      if (mode != OFFENSE)
      {
         return;
      }

      computeOpponentDistances();

      evaluatePlayerPos();

      shoot(4);

      defend(4);
      
      moveToPositions();
   }


   private void moveToPositions()
   {
      Field ballField = pitch.getBall().getField();
      
      int goalDistance = distance(ballField, pitch.getField(goalX, 12));
      
      if (myTeam.size() == 0)
      {
         return;
      }
      
      int mateDistance = goalDistance / myTeam.size();
      
      int tgtX = goalX;
      
      int tgtY = ballField.getYPos();
      
      ListIterator<Player> iter = myTeam.reverseListIterator();

      while (iter.hasPrevious())
      {
         Player player = iter.previous();
         
         if (player instanceof GoalKeeper) continue;
         
         if (player.getBall() != null) 
         {
            System.out.println("player with ball can still move. Should not happen: " + player);
            continue;
         }
         
         // be passable and close to the goal
         tgtX = tgtX - mateDistance * dir;
         
         if (ballField.getYPos() > Math.min(15, tgtY + 3))
         {
            tgtY = Math.min(15, tgtY + 3);
         }
         else if (ballField.getYPos() < Math.min(9, tgtY - 3))
         {
            tgtY = Math.min(9, tgtY - 3);
         }
         
         int playerX = tgtX;
                  
         if (playerX - player.getField().getXPos() > 3)
         {
            playerX = player.getField().getXPos() + 3;
         }
         else if (player.getField().getXPos() - playerX > 3)
         {
            playerX = player.getField().getXPos() - 3;
         }
         
         FieldSet targetFields = pitch.getFields().hasXPos(playerX-1, playerX+1).hasYPos(tgtY-2, tgtY+2);
         Field betterField = findTargetFieldForMove(targetFields, player.getField());
         
         player.moveTo(betterField, update);
         
      }
   }


   private Field findTargetFieldForMove(FieldSet tgtFields, Field betterField)
   {
      for (Field tgtField : tgtFields)
      {
         if (tgtField.getOpponentDistance() >= 4 || tgtField.getOpponentDistance() >= betterField.getOpponentDistance())
         {
            if (distance(betterField, pitch.getField(goalX, 12)) >= distance(tgtField, pitch.getField(goalX, 12))
                  && Math.abs (goalX - betterField.getXPos() * dir) >  Math.abs (goalX - tgtField.getXPos() * dir))
            {
               betterField = tgtField;
            }
         }
      }
      return betterField;
   }

   private Field findTargetFieldForPass(FieldSet tgtFields, Field betterField)
   {
      for (Field tgtField : tgtFields)
      {
         if (isImprovedBy(betterField, tgtField))
         {
            betterField = tgtField;
         }
      }

      return betterField;
   }


   private boolean isImprovedBy(Field betterField, Field tgtField)
   {
      if (tgtField.getOpponentDistance() >= 4 && betterField.getOpponentDistance() < 4)
      {
         return true;
      }
      else if (tgtField.getOpponentDistance() >= 4 && betterField.getOpponentDistance() >= 4)
      {
         return distance(tgtField, pitch.getField(goalX, 12)) < distance(betterField, pitch.getField(goalX, 12));
      }
      else if (tgtField.getOpponentDistance() >= betterField.getOpponentDistance() && tgtField.getOpponentDistance() > 1)
      {
         return distance(tgtField, pitch.getField(goalX, 12)) < distance(betterField, pitch.getField(goalX, 12));
      }

      return false;
   }


   private void shoot(int hops)
   {
      if (hops <= 0)
      {
         return;
      }
      
      myTeam.withRunnableFields(null);
      myTeam.withShootableFields(null);

      Player shooter = pitch.getBall().getPlayer();

      if (canScoreGoal(shooter, 1))
      {
         Action shootAction = update.createShootBall().withPlayerNumber(shooter.getNumber())
               .withXDist(goalX-shooter.getField().getXPos(), 7);

         if (shooter.getField().getYPos() <= 12)
         {
            shootAction.withYDist(15 - shooter.getField().getYPos(), 7);
         }
         else
         {
            shootAction.withYDist(shooter.getField().getYPos() - 9, 7);
         }

         myTeam.remove(shooter);
         return;
      }
      else if (canScoreGoal(shooter, hops))
      {
         // loop through team (backwards) and pass to first who can score in hops - 1
         myTeam.remove(shooter);

         ListIterator<Player> iter = myTeam.reverseListIterator();
         
         while (iter.hasPrevious())
         {
            Player teamMate = iter.previous();
            
            if (canScoreGoal(teamMate, hops -1))
            {
               shootTo(shooter, teamMate.getField());
               pitch.getBall().setPlayer(teamMate);
               pitch.getBall().setField(teamMate.getField());
               
               
               break;
            }
         }
         
         shoot(hops - 1);
      }
      else
      {
         // pass (forward) to a save place
         FieldSet passToFields = passToFields(shooter, hops, (PlayerSet) myTeam.minus(new PlayerSet().with(shooter)));
         
         Field targetField = findTargetFieldForPass(passToFields, shooter.getField());
         
         if ( ! isImprovedBy(shooter.getField(), targetField))
         {
            return;
         }
         
         if (shooter.getShootableFields().contains(targetField))
         {
            // shoot
            shootTo(shooter, targetField);
            
            myTeam.remove(shooter);
            
            if (myTeam.getField().contains(targetField) == false)
            {
               // ask team mate to collect
               for (Player teamMate : myTeam)
               {
                  if (teamMate.getRunnableFields().contains(targetField))
                  {
                     teamMate.moveTo(targetField, update);
                     pitch.getBall().setPlayer(teamMate);
                     pitch.getBall().setField(targetField);
                     myTeam.remove(teamMate);
                     break;
                  }
               }
            }
            else
            {
               Player first = targetField.getPlayers().hasTeam(this.teamColor).first();
               pitch.getBall().setPlayer(first);
               pitch.getBall().setField(targetField);
               shoot(hops -1);
            }
         }
         else
         {
            // find team mate that reaches targetField and pass to it
            myTeam.remove(shooter);
            
            ListIterator<Player> iter = myTeam.reverseListIterator();
            while (iter.hasPrevious())
            {
               Player teamMate = iter.previous();
               PlayerSet teamMateSet = new PlayerSet().with(teamMate);
               if (distance(shooter.getField(), teamMate.getField()) <=7 && passToFields(teamMate, hops-1, (PlayerSet) myTeam.minus(teamMateSet)).contains(targetField))
               {
                  shootTo(shooter, teamMate.getField());
                  pitch.getBall().setPlayer(teamMate);
                  pitch.getBall().setField(teamMate.getField());
                  
                  myTeam.remove(shooter);
                  
                  shoot(hops -1);
                  
                  break;
               }
            }
         }
      }
      
      
//      else 
//      {
//         PlayerSet forwards = myTeam.hasNumber(shooter.getNumber(), shooter.getNumber()+hops-1);
//         if (shooter.getNumber() + hops > 9 && forwards.size() == forwards.hasInPosition(true).size())
//         {
//            // pass to next
//            Player nextForward = forwards.hasNumber(shooter.getNumber()+1).first();
//            
//            if (nextForward == null)
//            {
//               return;
//            }
//
//            Action shootAction = update.createShootBall().withPlayerNumber(shooter.getNumber())
//                  .withXDist(nextForward.getField().getXPos()-shooter.getField().getXPos(), 7)
//                  .withYDist(nextForward.getField().getYPos()-shooter.getField().getYPos(), 7);
//
//            pitch.getBall().setPlayer(nextForward);
//            pitch.getBall().setField(nextForward.getField());
//
//            myTeam.without(shooter);
//
//            shoot(hops-1);
//         }
//         else 
//         {
//            // try to pass to midfield player
//
//            forwards = shooter.getReachablePlayers(myTeam, hops);
//            forwards.remove(shooter);
//
//            if (forwards.hasOnSaveField(true).size() > 0 
//                  || ! shooter.isOnSaveField() && forwards.getField().getOpponentDistance().max() > shooter.getField().getOpponentDistance() ) 
//            {
//               // pass to next
//               Player nextForward = null;
//
//               for (int i = 9; i > 1; i--)
//               {
//                  nextForward = forwards.hasNumber(i).first();
//
//                  if (nextForward != null)
//                  {
//                     if ( ! shooter.isOnSaveField() || nextForward.isOnSaveField() || ! nextForward.getReachablePlayers(myTeam, hops-1).hasOnSaveField(true).isEmpty())
//                     {
//                        if (nextForward.getNumber() >= 6 && ! nextForward.isInPosition() && shooter.isOnSaveField())
//                        {
//                           // do not pass to attacker that is not yet in position
//                           return;
//                        }
//                        
//                        break;
//                     }
//                     else 
//                     {
//                        nextForward = null;
//                     }
//                  }
//               }
//
//               if (nextForward != null)
//               {
//                  Action shootAction = update.createShootBall().withPlayerNumber(shooter.getNumber())
//                        .withXDist(nextForward.getField().getXPos()-shooter.getField().getXPos(), 7)
//                        .withYDist(nextForward.getField().getYPos()-shooter.getField().getYPos(), 7);
//
//                  pitch.getBall().setPlayer(nextForward);
//                  pitch.getBall().setField(nextForward.getField());
//
//                  myTeam.without(shooter);
//
//                  shoot(hops-1);
//               }
//            }
//         }
//         // forwards.
//      }
   }

   private void shootTo(Player shooter, Field teamMateField)
   {
      if (update.getActions().size() > 0 && shooter.getNumber() == update.getActions().last().getPlayerNumber())
      {
         System.out.println("ups");
      }
      
      Action shootAction = update.createShootBall().withPlayerNumber(shooter.getNumber())
            .withXDist(teamMateField.getXPos() - shooter.getField().getXPos(), 7)
            .withYDist(teamMateField.getYPos() - shooter.getField().getYPos(), 7);
      
      System.out.println("" + shooter + " shoots to " + teamMateField + "  " + teamMateField.getPlayers().hasTeam(this.teamColor));
   }


   private FieldSet passToFields(Player shooter, int hops, PlayerSet remainingTeam)
   {
      if (hops <= 0)
      {
         FieldSet result = shooter.getRunnableFields();
         return result;
      }

      PlayerSet reachableTeamMates = shooter.getShootableFields().getPlayers().intersection(remainingTeam);
      
      FieldSet result = new FieldSet();
      
      for (Player teamMate : remainingTeam)
      {
         FieldSet intersection = shooter.getShootableFields().intersection(teamMate.getRunnableFields());
         
         result.addAll(intersection);
         
         if (distance(shooter.getField(), teamMate.getField()) <= 7)
         {
            result.addAll(passToFields(teamMate, hops - 1, (PlayerSet) remainingTeam.minus(new PlayerSet().with(teamMate))));
         }
      }
      
      return result;
   }


   private boolean canScoreGoal(Player shooter, int hops)
   {
      if (hops <= 1)
      {
         return shooter.getShootableFields().intersection(goalFields).isEmpty() == false;
      }

      PlayerSet reachableTeamMates = shooter.getShootableFields().getPlayers().intersection(myTeam).without(shooter);
      
      for (Player teamMate : reachableTeamMates)
      {
         if (canScoreGoal(teamMate, hops - 1))
         {
            return true;
         }
      }
      
      return false;
   }


   private void evaluatePlayerPos()
   {
      ListIterator<Player> iter = myTeam.reverseListIterator();

      int tgtX = goalX - 7 * dir;
      int tgtY = 9;

      int deltaY = 3;

      while (iter.hasPrevious())
      {
         Player player = iter.previous();

         player.withTgtX(tgtX).withTgtY(tgtY);

         if (player.getNumber() <= 6 || (player.getField().getXPos() == tgtX && tgtY -2 <= player.getField().getYPos() && player.getField().getYPos() <= tgtY+2))
         {
            player.setInPosition(true);
         }

         player.setOnSaveField(player.getField().getOpponentDistance() >= 4);
         
         if (5 <= player.getNumber() && player.getNumber() <= 6)
         {
            Player partner = myTeam.hasNumber(player.getNumber() + 3).first();
            player.withTgtX(partner.getTgtX()).withTgtY(partner.getTgtY() + 5);
         }

         tgtX = tgtX  - 7 * dir;
         
         if (tgtX < 3) tgtX = 3;
         if (tgtX > 41) tgtX = 41;
         
         if (tgtY - deltaY < 0)
         {
            deltaY = -deltaY;
         }
         if (tgtY - deltaY > 22)
         {
            deltaY = -deltaY;
         }

         tgtY = tgtY - deltaY;         
      }
   }


   private void computeOpponentDistances()
   {
      for (Player opponent : pitch.getPlayers().hasTeam(this.opponentColor))
      {
         Field opponentField = opponent.getField();

         if (opponent instanceof GoalKeeper)
         {
            // stays in its goal
            int goalX = opponentField.getXPos();
            int preGoalX = goalX == 0 ? 1 : goalX - 1;

            for (int y = 8; y <= 16; y++)
            {
               Field field = pitch.getField(goalX, y);
               field.setOpponentDistance(distance(field, opponentField));

               field = pitch.getField(preGoalX, y);
               field.setOpponentDistance(distance(field, opponentField));
            }
         }
         else
         {
            // field player

            for (Field field : pitch.getFields())
            {
               int distance = distance(field, opponentField);

               distance = Math.min(distance, field.getOpponentDistance());

               field.setOpponentDistance(distance);
            }
         }
      }
   }


   private void defend(int noOfDefenders)
   {
      // loop through the players from low numbers to high numbers
      PlayerSet players = new PlayerSet();
      players.addAll(myTeam);
      
      for (Player player : players)
      {
         if (noOfDefenders == 0)
         {
            return;
         }
         
         if (player instanceof GoalKeeper)
         {
            goaliDefend(update, player);
            myTeam.without(player);
         }
         else
         {
            if (player.getBall() != null)
            {
               // ups run for your live
               Field targetField = player.getField();
               FieldSet targets = pitch.getFields().hasXPos(targetField.getXPos()-2, targetField.getXPos()+2)
                     .hasYPos(targetField.getYPos()-2, targetField.getYPos()+2);
               targetField = findTargetFieldForMove(targets, targetField);
               player.moveTo(targetField, update);
               myTeam.without(player);
               continue;
            }
            noOfDefenders--;
            
            myTeam.without(player);
            
            // do I need to stay by an attacker?
            if ( (! player.getField().getPlayers().hasTeam(this.opponentColor).isEmpty())
                  && player.getField().getPlayers().hasTeam(this.teamColor).hasNumber(0, player.getNumber()-1).isEmpty())
            {
               // just move 0 in order to attack my opponent in case it has the ball
               update.createMoveAction().withPlayerNumber(player.getNumber());
            }
            else
            {
               // look for someone to go to 
               // look for the opponent closest to my goal that is not yet covered by a team mate
               // for simplicity assume that highest opponent number is closest to my goal
               PlayerSet opponentPlayers = pitch.getPlayers().hasTeam(this.opponentColor);

               ListIterator<Player> reverseIter = opponentPlayers.reverseListIterator();
               while (reverseIter.hasPrevious())
               {
                  Player opponent = reverseIter.previous();

                  // is he under control?
                  if ( ! opponent.getField().getPlayers().hasTeam(this.teamColor).hasNumber(0, player.getNumber()-1).isEmpty())
                  {
                     continue;
                  }

                  // is someone already going there that is nearer than me?
                  int myDistance = distance(player.getField(), opponent.getField());
                  if (opponent.getTackleDistance() <= myDistance)
                  {
                     continue;
                  }

                  // yes go for this one
                  player.moveTo(opponent.getField(), update);
                  opponent.withTackleDistance(myDistance);
                  System.out.println("" + player + " moves to " + opponent + " dist: " + myDistance);
                  break;
               }
            }
         }
      }
   }


   public static int distance(Field field, Field field2)
   {
      int xDist = Math.abs(field.getXPos() - field2.getXPos());
      int yDist = Math.abs(field.getYPos() - field2.getYPos());
      return Math.max(xDist, yDist);
   }


   private void goaliDefend(Update update, Player player)
   {
      // stay between the middle of my goal and the ball pos
      int ballY = pitch.getBall().getField().getYPos();
      int goalMiddleY = 12;
      int goaliY = player.getField().getYPos();

      int halfBallMiddleDistance = (ballY - goalMiddleY) / 2;

      int goaliTargetY = goalMiddleY + halfBallMiddleDistance;

      if (goaliTargetY > 15)
      {
         goaliTargetY = 15;
      }
      else if (goaliTargetY < 9)
      {
         goaliTargetY = 9;
      }

      Field targetField = pitch.getField(player.getField().getXPos(), goaliTargetY);

      player.moveTo(targetField, update);
   }

}
