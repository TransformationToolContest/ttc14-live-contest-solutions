import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

import java.lang.*;
import java.lang.reflect.*;
import java.util.StringTokenizer;
import java.io.*;



class Ball
  implements SystemTypes
{
  private AbstractField field;
  private List player = new Vector(); // of Player

  public Ball(AbstractField field)
  {
    this.field = field;

  }

  public Ball() { }



  public String toString()
  { String _res_ = "(Ball) ";
    return _res_;
  }

  public void setfield(AbstractField fieldxx) { field = fieldxx;
  }

  public static void setAllfield(List balls,AbstractField _val)
  { for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      Controller.inst().setfield(ballx, _val); } }

  public void setplayer(List playerxx) { if (playerxx.size() > 1) { return; } 
    player = playerxx;
  }
 
  public void addplayer(Player playerxx) { if (player.size() > 0) { return; } 
    player.add(playerxx);
    }
 
  public void removeplayer(Player playerxx) { Vector _removedplayerplayerxx = new Vector();
  _removedplayerplayerxx.add(playerxx);
  player.removeAll(_removedplayerplayerxx);
    }

  public static void setAllplayer(List balls,List _val)
  { for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      Controller.inst().setplayer(ballx, _val); } }

  public static void addAllplayer(List balls,Player _val)
  { for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      Controller.inst().addplayer(ballx, _val); } }


  public static void removeAllplayer(List balls,Player _val)
  { for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      Controller.inst().removeplayer(ballx, _val); } }


  public static void unionAllplayer(List balls, List _val)
  { for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      Controller.inst().unionplayer(ballx, _val); } }


  public static void subtractAllplayer(List balls, List _val)
  { for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      Controller.inst().subtractplayer(ballx, _val); } }


  public AbstractField getfield() { return field; }

  public static List getAllfield(List balls)
  { List result = new Vector();
    for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      if (result.contains(ballx.getfield())) {}
      else { result.add(ballx.getfield()); }
 }
    return result; }

  public static List getAllOrderedfield(List balls)
  { List result = new Vector();
    for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      if (result.contains(ballx.getfield())) {}
      else { result.add(ballx.getfield()); }
 }
    return result; }

  public List getplayer() { return (Vector) ((Vector) player).clone(); }

  public static List getAllplayer(List balls)
  { List result = new Vector();
    for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      result = Set.union(result,ballx.getplayer()); }
    return result; }

  public static List getAllOrderedplayer(List balls)
  { List result = new Vector();
    for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx = (Ball) balls.get(_i);
      result = Set.union(result,ballx.getplayer()); }
    return result; }

    public boolean blueTeamhasBall()
  {   boolean result = false;
 
  if (player.size() > 0 && !(Player.getAllteam(player).contains("RED"))) 
  {   result = true;
 
  }    return result;
  }



}


abstract class AbstractField
  implements SystemTypes
{
  protected int xPos = 0; // internal
  protected int yPos = 0; // internal
  protected List ball = new Vector(); // of Ball
  protected List players = new Vector(); // of Player

  public AbstractField()
  {
    this.xPos = 0;
    this.yPos = 0;

  }



  public String toString()
  { String _res_ = "(AbstractField) ";
    _res_ = _res_ + xPos + ",";
    _res_ = _res_ + yPos;
    return _res_;
  }

  public void setxPos(int xPos_x) { xPos = xPos_x;  }


  public static void setAllxPos(List abstractfields,int val)
{ for (int i = 0; i < abstractfields.size(); i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(i);
      Controller.inst().setxPos(abstractfieldx,val); } }


  public void setyPos(int yPos_x) { yPos = yPos_x;  }


  public static void setAllyPos(List abstractfields,int val)
{ for (int i = 0; i < abstractfields.size(); i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(i);
      Controller.inst().setyPos(abstractfieldx,val); } }


  public void setball(List ballxx) { if (ballxx.size() > 1) { return; } 
    ball = ballxx;
  }
 
  public void addball(Ball ballxx) { if (ball.size() > 0) { return; } 
    ball.add(ballxx);
    }
 
  public void removeball(Ball ballxx) { Vector _removedballballxx = new Vector();
  _removedballballxx.add(ballxx);
  ball.removeAll(_removedballballxx);
    }

  public static void setAllball(List abstractfields,List _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().setball(abstractfieldx, _val); } }

  public static void addAllball(List abstractfields,Ball _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().addball(abstractfieldx, _val); } }


  public static void removeAllball(List abstractfields,Ball _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().removeball(abstractfieldx, _val); } }


  public static void unionAllball(List abstractfields, List _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().unionball(abstractfieldx, _val); } }


  public static void subtractAllball(List abstractfields, List _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().subtractball(abstractfieldx, _val); } }


  public void setplayers(List playersxx) { players = playersxx;
    }
 
  public void addplayers(Player playersxx) { players.add(playersxx);
    }
 
  public void removeplayers(Player playersxx) { Vector _removedplayersplayersxx = new Vector();
  _removedplayersplayersxx.add(playersxx);
  players.removeAll(_removedplayersplayersxx);
    }

  public static void setAllplayers(List abstractfields,List _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().setplayers(abstractfieldx, _val); } }

  public static void addAllplayers(List abstractfields,Player _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().addplayers(abstractfieldx, _val); } }


  public static void removeAllplayers(List abstractfields,Player _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().removeplayers(abstractfieldx, _val); } }


  public static void unionAllplayers(List abstractfields, List _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().unionplayers(abstractfieldx, _val); } }


  public static void subtractAllplayers(List abstractfields, List _val)
  { for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      Controller.inst().subtractplayers(abstractfieldx, _val); } }


  public int getxPos() { return xPos; }

  public static List getAllxPos(List abstractfields)
  { List result = new Vector();
    for (int i = 0; i < abstractfields.size(); i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(i);
      if (result.contains(new Integer(abstractfieldx.getxPos()))) { }
      else { result.add(new Integer(abstractfieldx.getxPos())); } }
    return result; }

  public static List getAllOrderedxPos(List abstractfields)
  { List result = new Vector();
    for (int i = 0; i < abstractfields.size(); i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(i);
      result.add(new Integer(abstractfieldx.getxPos())); } 
    return result; }

  public int getyPos() { return yPos; }

  public static List getAllyPos(List abstractfields)
  { List result = new Vector();
    for (int i = 0; i < abstractfields.size(); i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(i);
      if (result.contains(new Integer(abstractfieldx.getyPos()))) { }
      else { result.add(new Integer(abstractfieldx.getyPos())); } }
    return result; }

  public static List getAllOrderedyPos(List abstractfields)
  { List result = new Vector();
    for (int i = 0; i < abstractfields.size(); i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(i);
      result.add(new Integer(abstractfieldx.getyPos())); } 
    return result; }

  public List getball() { return (Vector) ((Vector) ball).clone(); }

  public static List getAllball(List abstractfields)
  { List result = new Vector();
    for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      result = Set.union(result,abstractfieldx.getball()); }
    return result; }

  public static List getAllOrderedball(List abstractfields)
  { List result = new Vector();
    for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      result = Set.union(result,abstractfieldx.getball()); }
    return result; }

  public List getplayers() { return (Vector) ((Vector) players).clone(); }

  public static List getAllplayers(List abstractfields)
  { List result = new Vector();
    for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      result = Set.union(result,abstractfieldx.getplayers()); }
    return result; }

  public static List getAllOrderedplayers(List abstractfields)
  { List result = new Vector();
    for (int _i = 0; _i < abstractfields.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) abstractfields.get(_i);
      result = Set.union(result,abstractfieldx.getplayers()); }
    return result; }


}


class SoccerPitch
  implements SystemTypes
{
  private List players = new Vector(); // of Player
  private Ball balls;
  private List fields = new Vector(); // of AbstractField

  public SoccerPitch(Ball balls)
  {
    this.balls = balls;

  }

  public SoccerPitch() { }



  public String toString()
  { String _res_ = "(SoccerPitch) ";
    return _res_;
  }

  public void setplayers(List playersxx) { players = playersxx;
    }
 
  public void addplayers(Player playersxx) { players.add(playersxx);
    }
 
  public void removeplayers(Player playersxx) { Vector _removedplayersplayersxx = new Vector();
  _removedplayersplayersxx.add(playersxx);
  players.removeAll(_removedplayersplayersxx);
    }

  public static void setAllplayers(List soccerpitchs,List _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().setplayers(soccerpitchx, _val); } }

  public static void addAllplayers(List soccerpitchs,Player _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().addplayers(soccerpitchx, _val); } }


  public static void removeAllplayers(List soccerpitchs,Player _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().removeplayers(soccerpitchx, _val); } }


  public static void unionAllplayers(List soccerpitchs, List _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().unionplayers(soccerpitchx, _val); } }


  public static void subtractAllplayers(List soccerpitchs, List _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().subtractplayers(soccerpitchx, _val); } }


  public void setballs(Ball ballsxx) { balls = ballsxx;
  }

  public static void setAllballs(List soccerpitchs,Ball _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().setballs(soccerpitchx, _val); } }

  public void setfields(List fieldsxx) { fields = fieldsxx;
    }
 
  public void addfields(AbstractField fieldsxx) { fields.add(fieldsxx);
    }
 
  public void removefields(AbstractField fieldsxx) { Vector _removedfieldsfieldsxx = new Vector();
  _removedfieldsfieldsxx.add(fieldsxx);
  fields.removeAll(_removedfieldsfieldsxx);
    }

  public static void setAllfields(List soccerpitchs,List _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().setfields(soccerpitchx, _val); } }

  public static void addAllfields(List soccerpitchs,AbstractField _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().addfields(soccerpitchx, _val); } }


  public static void removeAllfields(List soccerpitchs,AbstractField _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().removefields(soccerpitchx, _val); } }


  public static void unionAllfields(List soccerpitchs, List _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().unionfields(soccerpitchx, _val); } }


  public static void subtractAllfields(List soccerpitchs, List _val)
  { for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      Controller.inst().subtractfields(soccerpitchx, _val); } }


  public List getplayers() { return (Vector) ((Vector) players).clone(); }

  public static List getAllplayers(List soccerpitchs)
  { List result = new Vector();
    for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      result = Set.union(result,soccerpitchx.getplayers()); }
    return result; }

  public static List getAllOrderedplayers(List soccerpitchs)
  { List result = new Vector();
    for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      result = Set.union(result,soccerpitchx.getplayers()); }
    return result; }

  public Ball getballs() { return balls; }

  public static List getAllballs(List soccerpitchs)
  { List result = new Vector();
    for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      if (result.contains(soccerpitchx.getballs())) {}
      else { result.add(soccerpitchx.getballs()); }
 }
    return result; }

  public static List getAllOrderedballs(List soccerpitchs)
  { List result = new Vector();
    for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      if (result.contains(soccerpitchx.getballs())) {}
      else { result.add(soccerpitchx.getballs()); }
 }
    return result; }

  public List getfields() { return (Vector) ((Vector) fields).clone(); }

  public static List getAllfields(List soccerpitchs)
  { List result = new Vector();
    for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      result = Set.union(result,soccerpitchx.getfields()); }
    return result; }

  public static List getAllOrderedfields(List soccerpitchs)
  { List result = new Vector();
    for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) soccerpitchs.get(_i);
      result = Set.union(result,soccerpitchx.getfields()); }
    return result; }


}


abstract class Player
  implements SystemTypes
{
  protected String team = ""; // internal
  protected int number = 0; // internal
  protected AbstractField field;
  protected List ball = new Vector(); // of Ball

  public Player(AbstractField field)
  {
    this.team = "";
    this.number = 0;
    this.field = field;

  }

  public Player() { }



  public String toString()
  { String _res_ = "(Player) ";
    _res_ = _res_ + team + ",";
    _res_ = _res_ + number;
    return _res_;
  }

  public void setteam(String team_x) { team = team_x;  }


  public static void setAllteam(List players,String val)
{ for (int i = 0; i < players.size(); i++)
    { Player playerx = (Player) players.get(i);
      Controller.inst().setteam(playerx,val); } }


  public void setnumber(int number_x) { number = number_x;  }


  public static void setAllnumber(List players,int val)
{ for (int i = 0; i < players.size(); i++)
    { Player playerx = (Player) players.get(i);
      Controller.inst().setnumber(playerx,val); } }


  public void setfield(AbstractField fieldxx) { field = fieldxx;
  }

  public static void setAllfield(List players,AbstractField _val)
  { for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      Controller.inst().setfield(playerx, _val); } }

  public void setball(List ballxx) { if (ballxx.size() > 1) { return; } 
    ball = ballxx;
  }
 
  public void addball(Ball ballxx) { if (ball.size() > 0) { return; } 
    ball.add(ballxx);
    }
 
  public void removeball(Ball ballxx) { Vector _removedballballxx = new Vector();
  _removedballballxx.add(ballxx);
  ball.removeAll(_removedballballxx);
    }

  public static void setAllball(List players,List _val)
  { for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      Controller.inst().setball(playerx, _val); } }

  public static void addAllball(List players,Ball _val)
  { for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      Controller.inst().addball(playerx, _val); } }


  public static void removeAllball(List players,Ball _val)
  { for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      Controller.inst().removeball(playerx, _val); } }


  public static void unionAllball(List players, List _val)
  { for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      Controller.inst().unionball(playerx, _val); } }


  public static void subtractAllball(List players, List _val)
  { for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      Controller.inst().subtractball(playerx, _val); } }


  public String getteam() { return team; }

  public static List getAllteam(List players)
  { List result = new Vector();
    for (int i = 0; i < players.size(); i++)
    { Player playerx = (Player) players.get(i);
      if (result.contains(playerx.getteam())) { }
      else { result.add(playerx.getteam()); } }
    return result; }

  public static List getAllOrderedteam(List players)
  { List result = new Vector();
    for (int i = 0; i < players.size(); i++)
    { Player playerx = (Player) players.get(i);
      result.add(playerx.getteam()); } 
    return result; }

  public int getnumber() { return number; }

  public static List getAllnumber(List players)
  { List result = new Vector();
    for (int i = 0; i < players.size(); i++)
    { Player playerx = (Player) players.get(i);
      if (result.contains(new Integer(playerx.getnumber()))) { }
      else { result.add(new Integer(playerx.getnumber())); } }
    return result; }

  public static List getAllOrderednumber(List players)
  { List result = new Vector();
    for (int i = 0; i < players.size(); i++)
    { Player playerx = (Player) players.get(i);
      result.add(new Integer(playerx.getnumber())); } 
    return result; }

  public AbstractField getfield() { return field; }

  public static List getAllfield(List players)
  { List result = new Vector();
    for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      if (result.contains(playerx.getfield())) {}
      else { result.add(playerx.getfield()); }
 }
    return result; }

  public static List getAllOrderedfield(List players)
  { List result = new Vector();
    for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      if (result.contains(playerx.getfield())) {}
      else { result.add(playerx.getfield()); }
 }
    return result; }

  public List getball() { return (Vector) ((Vector) ball).clone(); }

  public static List getAllball(List players)
  { List result = new Vector();
    for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      result = Set.union(result,playerx.getball()); }
    return result; }

  public static List getAllOrderedball(List players)
  { List result = new Vector();
    for (int _i = 0; _i < players.size(); _i++)
    { Player playerx = (Player) players.get(_i);
      result = Set.union(result,playerx.getball()); }
    return result; }

    public void cmaction(Update u,Ball theball)
  {   if (this.getball().size() > 0 && this.getfield().getxPos() < 39) 
  { MovePlayer m = new MovePlayer();
    Controller.inst().addMovePlayer(m);
    Controller.inst().setplayerNumber(m,this.getnumber());
    Controller.inst().setxDist(m,2);
    Controller.inst().setyDist(m,0);
    Controller.inst().addactions(u,m);}
      if (this.getball().size() > 0 && this.getfield().getxPos() >= 39) 
  { ShootBall m = new ShootBall();
    Controller.inst().addShootBall(m);
    Controller.inst().setplayerNumber(m,this.getnumber());
    Controller.inst().setxDist(m,44 - this.getfield().getxPos());
    Controller.inst().setyDist(m,0);
    Controller.inst().addactions(u,m);}
      if (theball.blueTeamhasBall() == false) 
  { this.moveToBall(u,theball);}
  }

    public boolean withinShootingDist(int x,int y)
  {   boolean result = false;
 
  if (field.getxPos() - x <= 7 && field.getxPos() - x >= -7 && field.getyPos() - y <= 7 && field.getyPos() - y >= -7) 
  {   result = true;
 
  }  else   if (field.getxPos() - x > 7 || field.getxPos() - x < -7 || field.getyPos() - y > 7 || field.getyPos() - y < -7) 
  {   result = false;
 
  }    return result;
  }


    public void goalkeeperaction(Update u)
  {   if (this.getball().size() > 0) 
  { ShootBall a = new ShootBall();
    Controller.inst().addShootBall(a);
    Controller.inst().setplayerNumber(a,this.getnumber());
    Controller.inst().setxDist(a,7);
    Controller.inst().setyDist(a,-3);
    Controller.inst().addactions(u,a);
    MovePlayer m = new MovePlayer();
    Controller.inst().addMovePlayer(m);
    Controller.inst().setplayerNumber(m,5);
    Controller.inst().setxDist(m,-3);
    Controller.inst().setyDist(m,-3);
    Controller.inst().addactions(u,m);}
  }

    public void defenderaction(Update u,Ball theball)
  {   if (this.getball().size() > 0 && this.getfield().getxPos() < 22) 
  { MovePlayer m = new MovePlayer();
    Controller.inst().addMovePlayer(m);
    Controller.inst().setplayerNumber(m,this.getnumber());
    Controller.inst().setxDist(m,2);
    Controller.inst().setyDist(m,0);
    Controller.inst().addactions(u,m);}
      if (this.getball().size() > 0 && this.getfield().getxPos() >= 22 && this.getfield().getyPos() <= 12) 
  { ShootBall s = new ShootBall();
    Controller.inst().addShootBall(s);
    Controller.inst().setplayerNumber(s,this.getnumber());
    Controller.inst().setxDist(s,0);
    Controller.inst().setyDist(s,4);
    Controller.inst().addactions(u,s);}
      if (this.getball().size() > 0 && this.getfield().getxPos() >= 22 && this.getfield().getyPos() > 12) 
  { ShootBall s1 = new ShootBall();
    Controller.inst().addShootBall(s1);
    Controller.inst().setplayerNumber(s1,this.getnumber());
    Controller.inst().setxDist(s1,0);
    Controller.inst().setyDist(s1,-4);
    Controller.inst().addactions(u,s1);}
      if (this.getball().size() == 0 && theball.blueTeamhasBall() && this.getfield().getxPos() < 22) 
  { MovePlayer mp = new MovePlayer();
    Controller.inst().addMovePlayer(mp);
    Controller.inst().setplayerNumber(mp,this.getnumber());
    Controller.inst().setxDist(mp,2);
    Controller.inst().setyDist(mp,0);
    Controller.inst().addactions(u,mp);}
      if (theball.blueTeamhasBall() == false) 
  { this.moveToBall(u,theball);}
  }

    public void moveToBall(Update u,Ball b)
  {   if (this.getfield().getxPos() > b.getfield().getxPos() && this.getfield().getyPos() > b.getfield().getyPos()) 
  { MovePlayer mp = new MovePlayer();
    Controller.inst().addMovePlayer(mp);
    Controller.inst().setplayerNumber(mp,this.getnumber());
    Controller.inst().setxDist(mp,-((Integer) Set.min((new SystemTypes.Set()).add(( this.getfield().getxPos() - b.getfield().getxPos() )).add(3).getElements())).intValue());
    Controller.inst().setyDist(mp,-((Integer) Set.min((new SystemTypes.Set()).add(( this.getfield().getyPos() - b.getfield().getyPos() )).add(3).getElements())).intValue());
    Controller.inst().addactions(u,mp);}
      if (this.getfield().getxPos() > b.getfield().getxPos() && this.getfield().getyPos() <= b.getfield().getyPos()) 
  { MovePlayer mp1 = new MovePlayer();
    Controller.inst().addMovePlayer(mp1);
    Controller.inst().setplayerNumber(mp1,this.getnumber());
    Controller.inst().setxDist(mp1,-((Integer) Set.min((new SystemTypes.Set()).add(( this.getfield().getxPos() - b.getfield().getxPos() )).add(3).getElements())).intValue());
    Controller.inst().setyDist(mp1,((Integer) Set.min((new SystemTypes.Set()).add(( b.getfield().getyPos() - this.getfield().getyPos() )).add(3).getElements())).intValue());
    Controller.inst().addactions(u,mp1);}
      if (this.getfield().getxPos() <= b.getfield().getxPos() && this.getfield().getyPos() > b.getfield().getyPos()) 
  { MovePlayer mp2 = new MovePlayer();
    Controller.inst().addMovePlayer(mp2);
    Controller.inst().setplayerNumber(mp2,this.getnumber());
    Controller.inst().setxDist(mp2,((Integer) Set.min((new SystemTypes.Set()).add(( b.getfield().getxPos() - this.getfield().getxPos() )).add(3).getElements())).intValue());
    Controller.inst().setyDist(mp2,-((Integer) Set.min((new SystemTypes.Set()).add(( this.getfield().getyPos() - b.getfield().getyPos() )).add(3).getElements())).intValue());
    Controller.inst().addactions(u,mp2);}
      if (this.getfield().getxPos() <= b.getfield().getxPos() && this.getfield().getyPos() <= b.getfield().getyPos()) 
  { MovePlayer mp3 = new MovePlayer();
    Controller.inst().addMovePlayer(mp3);
    Controller.inst().setplayerNumber(mp3,this.getnumber());
    Controller.inst().setxDist(mp3,((Integer) Set.min((new SystemTypes.Set()).add(( b.getfield().getxPos() - this.getfield().getxPos() )).add(3).getElements())).intValue());
    Controller.inst().setyDist(mp3,((Integer) Set.min((new SystemTypes.Set()).add(( b.getfield().getyPos() - this.getfield().getyPos() )).add(3).getElements())).intValue());
    Controller.inst().addactions(u,mp3);}
  }

    public void midfielderaction(Update u,Ball theball)
  {   if (this.getball().size() > 0 && this.getfield().getxPos() >= 37 && 2 <= this.getfield().getyPos() && this.getfield().getyPos() <= 22) 
  { ShootBall sb = new ShootBall();
    Controller.inst().addShootBall(sb);
    Controller.inst().setplayerNumber(sb,this.getnumber());
    Controller.inst().setxDist(sb,44 - this.getfield().getxPos());
    Controller.inst().setyDist(sb,((Integer) Set.min((new SystemTypes.Set()).add(( 22 - this.getfield().getyPos() )).add(( this.getfield().getyPos() - 2 )).getElements())).intValue());
    Controller.inst().addactions(u,sb);}
      if (this.getball().size() > 0 && this.getfield().getxPos() < 37) 
  { MovePlayer mp = new MovePlayer();
    Controller.inst().addMovePlayer(mp);
    Controller.inst().setplayerNumber(mp,this.getnumber());
    Controller.inst().setxDist(mp,2);
    Controller.inst().setyDist(mp,0);
    Controller.inst().addactions(u,mp);}
      if (this.getball().size() > 0 && this.getfield().getxPos() >= 37 && this.getfield().getyPos() < 2) 
  { MovePlayer mp1 = new MovePlayer();
    Controller.inst().addMovePlayer(mp1);
    Controller.inst().setplayerNumber(mp1,this.getnumber());
    Controller.inst().setxDist(mp1,0);
    Controller.inst().setyDist(mp1,2);
    Controller.inst().addactions(u,mp1);}
      if (this.getball().size() > 0 && this.getfield().getxPos() >= 37 && this.getfield().getyPos() > 22) 
  { MovePlayer mp2 = new MovePlayer();
    Controller.inst().addMovePlayer(mp2);
    Controller.inst().setplayerNumber(mp2,this.getnumber());
    Controller.inst().setxDist(mp2,0);
    Controller.inst().setyDist(mp2,-2);
    Controller.inst().addactions(u,mp2);}
      if (this.getball().size() == 0 && this.getfield().getxPos() < 42 && theball.blueTeamhasBall()) 
  { MovePlayer mp3 = new MovePlayer();
    Controller.inst().addMovePlayer(mp3);
    Controller.inst().setplayerNumber(mp3,this.getnumber());
    Controller.inst().setxDist(mp3,2);
    Controller.inst().setyDist(mp3,0);
    Controller.inst().addactions(u,mp3);}
      if (theball.blueTeamhasBall() == false) 
  { this.moveToBall(u,theball);}
  }


}


class FieldPlayer
  extends Player
  implements SystemTypes
{

  public FieldPlayer()
  {

  }



  public String toString()
  { String _res_ = "(FieldPlayer) ";
    return _res_ + super.toString();
  }


}


class GoalKeeper
  extends Player
  implements SystemTypes
{

  public GoalKeeper()
  {

  }



  public String toString()
  { String _res_ = "(GoalKeeper) ";
    return _res_ + super.toString();
  }


}


class GoalField
  extends AbstractField
  implements SystemTypes
{
  private String team = ""; // internal

  public GoalField()
  {
    this.team = "";

  }



  public String toString()
  { String _res_ = "(GoalField) ";
    _res_ = _res_ + team;
    return _res_ + super.toString();
  }

  public void setteam(String team_x) { team = team_x;  }


  public static void setAllteam(List goalfields,String val)
{ for (int i = 0; i < goalfields.size(); i++)
    { GoalField goalfieldx = (GoalField) goalfields.get(i);
      Controller.inst().setteam(goalfieldx,val); } }


  public String getteam() { return team; }

  public static List getAllteam(List goalfields)
  { List result = new Vector();
    for (int i = 0; i < goalfields.size(); i++)
    { GoalField goalfieldx = (GoalField) goalfields.get(i);
      if (result.contains(goalfieldx.getteam())) { }
      else { result.add(goalfieldx.getteam()); } }
    return result; }

  public static List getAllOrderedteam(List goalfields)
  { List result = new Vector();
    for (int i = 0; i < goalfields.size(); i++)
    { GoalField goalfieldx = (GoalField) goalfields.get(i);
      result.add(goalfieldx.getteam()); } 
    return result; }


}


class Field
  extends AbstractField
  implements SystemTypes
{

  public Field()
  {

  }



  public String toString()
  { String _res_ = "(Field) ";
    return _res_ + super.toString();
  }


}


class Update
  implements SystemTypes
{
  private List actions = new Vector(); // of Action

  public Update()
  {

  }



  public String toString()
  { String _res_ = "(Update) ";
    return _res_;
  }

  public void setactions(List actionsxx) { actions = actionsxx;
    }
 
  public void addactions(Action actionsxx) { actions.add(actionsxx);
    }
 
  public void removeactions(Action actionsxx) { Vector _removedactionsactionsxx = new Vector();
  _removedactionsactionsxx.add(actionsxx);
  actions.removeAll(_removedactionsactionsxx);
    }

  public static void setAllactions(List updates,List _val)
  { for (int _i = 0; _i < updates.size(); _i++)
    { Update updatex = (Update) updates.get(_i);
      Controller.inst().setactions(updatex, _val); } }

  public static void addAllactions(List updates,Action _val)
  { for (int _i = 0; _i < updates.size(); _i++)
    { Update updatex = (Update) updates.get(_i);
      Controller.inst().addactions(updatex, _val); } }


  public static void removeAllactions(List updates,Action _val)
  { for (int _i = 0; _i < updates.size(); _i++)
    { Update updatex = (Update) updates.get(_i);
      Controller.inst().removeactions(updatex, _val); } }


  public static void unionAllactions(List updates, List _val)
  { for (int _i = 0; _i < updates.size(); _i++)
    { Update updatex = (Update) updates.get(_i);
      Controller.inst().unionactions(updatex, _val); } }


  public static void subtractAllactions(List updates, List _val)
  { for (int _i = 0; _i < updates.size(); _i++)
    { Update updatex = (Update) updates.get(_i);
      Controller.inst().subtractactions(updatex, _val); } }


  public List getactions() { return (Vector) ((Vector) actions).clone(); }

  public static List getAllactions(List updates)
  { List result = new Vector();
    for (int _i = 0; _i < updates.size(); _i++)
    { Update updatex = (Update) updates.get(_i);
      result = Set.union(result,updatex.getactions()); }
    return result; }

  public static List getAllOrderedactions(List updates)
  { List result = new Vector();
    for (int _i = 0; _i < updates.size(); _i++)
    { Update updatex = (Update) updates.get(_i);
      result = Set.union(result,updatex.getactions()); }
    return result; }


}


abstract class Action
  implements SystemTypes
{
  protected int playerNumber = 0; // internal
  protected int xDist = 0; // internal
  protected int yDist = 0; // internal

  public Action()
  {
    this.playerNumber = 0;
    this.xDist = 0;
    this.yDist = 0;

  }



  public String toString()
  { String _res_ = "(Action) ";
    _res_ = _res_ + playerNumber + ",";
    _res_ = _res_ + xDist + ",";
    _res_ = _res_ + yDist;
    return _res_;
  }

  public void setplayerNumber(int playerNumber_x) { playerNumber = playerNumber_x;  }


  public static void setAllplayerNumber(List actions,int val)
{ for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      Controller.inst().setplayerNumber(actionx,val); } }


  public void setxDist(int xDist_x) { xDist = xDist_x;  }


  public static void setAllxDist(List actions,int val)
{ for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      Controller.inst().setxDist(actionx,val); } }


  public void setyDist(int yDist_x) { yDist = yDist_x;  }


  public static void setAllyDist(List actions,int val)
{ for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      Controller.inst().setyDist(actionx,val); } }


  public int getplayerNumber() { return playerNumber; }

  public static List getAllplayerNumber(List actions)
  { List result = new Vector();
    for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      if (result.contains(new Integer(actionx.getplayerNumber()))) { }
      else { result.add(new Integer(actionx.getplayerNumber())); } }
    return result; }

  public static List getAllOrderedplayerNumber(List actions)
  { List result = new Vector();
    for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      result.add(new Integer(actionx.getplayerNumber())); } 
    return result; }

  public int getxDist() { return xDist; }

  public static List getAllxDist(List actions)
  { List result = new Vector();
    for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      if (result.contains(new Integer(actionx.getxDist()))) { }
      else { result.add(new Integer(actionx.getxDist())); } }
    return result; }

  public static List getAllOrderedxDist(List actions)
  { List result = new Vector();
    for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      result.add(new Integer(actionx.getxDist())); } 
    return result; }

  public int getyDist() { return yDist; }

  public static List getAllyDist(List actions)
  { List result = new Vector();
    for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      if (result.contains(new Integer(actionx.getyDist()))) { }
      else { result.add(new Integer(actionx.getyDist())); } }
    return result; }

  public static List getAllOrderedyDist(List actions)
  { List result = new Vector();
    for (int i = 0; i < actions.size(); i++)
    { Action actionx = (Action) actions.get(i);
      result.add(new Integer(actionx.getyDist())); } 
    return result; }


}


class MovePlayer
  extends Action
  implements SystemTypes
{

  public MovePlayer()
  {

  }



  public String toString()
  { String _res_ = "(MovePlayer) ";
    return _res_ + super.toString();
  }


}


class ShootBall
  extends Action
  implements SystemTypes
{

  public ShootBall()
  {

  }



  public String toString()
  { String _res_ = "(ShootBall) ";
    return _res_ + super.toString();
  }


}



public class Controller implements SystemTypes, ControllerInterface
{
  Vector balls = new Vector();
  Vector abstractfields = new Vector();
  Vector soccerpitchs = new Vector();
  Vector players = new Vector();
  Vector fieldplayers = new Vector();
  Vector goalkeepers = new Vector();
  Vector goalfields = new Vector();
  Vector fields = new Vector();
  Vector updates = new Vector();
  Vector actions = new Vector();
  Vector moveplayers = new Vector();
  Vector shootballs = new Vector();
  private static Controller uniqueInstance; 


  private Controller() { } 


  public static Controller inst() 
    { if (uniqueInstance == null) 
    { uniqueInstance = new Controller(); }
    return uniqueInstance; } 


  public static void loadModel(String file)
  {
    try
    { BufferedReader br = null;
      File f = new File(file);
      try 
      { br = new BufferedReader(new FileReader(f)); }
      catch (Exception ex) 
      { System.err.println("No file: " + file); return; }
      Class cont = Class.forName("Controller");
      java.util.Map objectmap = new java.util.HashMap();
      while (true)
      { String line1;
        try { line1 = br.readLine(); }
        catch (Exception e)
        { return; }
        if (line1 == null)
        { return; }
        line1 = line1.trim();

        if (line1.length() == 0) { continue; }
        String left;
        String op;
        String right;
        if (line1.charAt(line1.length() - 1) == '"')
        { int eqind = line1.indexOf("="); 
          if (eqind == -1) { continue; }
          else 
          { left = line1.substring(0,eqind-1).trim();
            op = "="; 
            right = line1.substring(eqind+1,line1.length()).trim();
          }
        }
        else
        { StringTokenizer st1 = new StringTokenizer(line1);
          Vector vals1 = new Vector();
          while (st1.hasMoreTokens())
          { String val1 = st1.nextToken();
            vals1.add(val1);
          }
          if (vals1.size() < 3)
          { continue; }
          left = (String) vals1.get(0);
          op = (String) vals1.get(1);
          right = (String) vals1.get(2);
        }
        if (":".equals(op))
        { int i2 = right.indexOf(".");
          if (i2 == -1)
          { Class cl;
            try { cl = Class.forName("" + right); }
            catch (Exception _x) { System.err.println("No entity: " + right); continue; }
            Object xinst = cl.newInstance();
            objectmap.put(left,xinst);
            Class[] cargs = new Class[] { cl };
            Method addC = cont.getMethod("add" + right,cargs);
            if (addC == null) { continue; }
            Object[] args = new Object[] { xinst };
            addC.invoke(Controller.inst(),args);
          }
          else
          { String obj = right.substring(0,i2);
            String role = right.substring(i2+1,right.length());
            Object objinst = objectmap.get(obj); 
            if (objinst == null) 
            { continue; }
            Object val = objectmap.get(left);
            if (val == null) 
            { continue; }
            Class objC = objinst.getClass();
            Class typeclass = val.getClass(); 
            Object[] args = new Object[] { val }; 
            Class[] settypes = new Class[] { typeclass };
            Method addrole = Controller.findMethod(objC,"add" + role);
            if (addrole != null) 
            { addrole.invoke(objinst, args); }
            else { System.err.println("Error: cannot add to " + role); }
          }
        }
        else if ("=".equals(op))
        { int i1 = left.indexOf(".");
          if (i1 == -1) 
          { continue; }
          String obj = left.substring(0,i1);
          String att = left.substring(i1+1,left.length());
          Object objinst = objectmap.get(obj); 
          if (objinst == null) 
          { continue; }
          Class objC = objinst.getClass();
          Class typeclass; 
          Object val; 
          if (right.charAt(0) == '"' &&
              right.charAt(right.length() - 1) == '"')
          { typeclass = String.class;
            val = right.substring(1,right.length() - 1);
          } 
          else if ("true".equals(right) || "false".equals(right))
          { typeclass = boolean.class;
            if ("true".equals(right))
            { val = new Boolean(true); }
            else
            { val = new Boolean(false); }
          }
          else 
          { val = objectmap.get(right);
            if (val != null)
            { typeclass = val.getClass(); }
            else 
            { int i;
              double d;
              try 
              { i = Integer.parseInt(right);
                typeclass = int.class;
                val = new Integer(i); 
              }
              catch (Exception ee)
              { try
                { d = Double.parseDouble(right);
                  typeclass = double.class;
                  val = new Double(d);
                }
                catch (Exception ff)
                { continue; }
              }
            }
          }
          Object[] args = new Object[] { val }; 
          Class[] settypes = new Class[] { typeclass };
          Method setatt = Controller.findMethod(objC,"set" + att);
          if (setatt != null) 
          { setatt.invoke(objinst, args); }
          else { System.err.println("No attribute: " + att); }
        }
      }
    } catch (Exception e) { }
  }

  public static Method findMethod(Class c, String name)
  { Method[] mets = c.getMethods(); 
    for (int i = 0; i < mets.length; i++)
    { Method m = mets[i];
      if (m.getName().equals(name))
      { return m; }
    } 
    return null;
  }


  public void checkCompleteness()
  {   for (int _i = 0; _i < balls.size(); _i++)
  { Ball ball_ballx1 = (Ball) balls.get(_i);
    for (int _j = 0; _j < abstractfields.size(); _j++)
    { AbstractField field_abstractfieldx2 = (AbstractField) abstractfields.get(_j);
      if (ball_ballx1.getfield() == field_abstractfieldx2)
      { if (field_abstractfieldx2.getball().contains(ball_ballx1)) { }
        else { field_abstractfieldx2.addball(ball_ballx1); }
      }
      else if (field_abstractfieldx2.getball().contains(ball_ballx1))
      { ball_ballx1.setfield(field_abstractfieldx2); } 
    }
  }
  for (int _i = 0; _i < players.size(); _i++)
  { Player players_playerx1 = (Player) players.get(_i);
    for (int _j = 0; _j < abstractfields.size(); _j++)
    { AbstractField field_abstractfieldx2 = (AbstractField) abstractfields.get(_j);
      if (players_playerx1.getfield() == field_abstractfieldx2)
      { if (field_abstractfieldx2.getplayers().contains(players_playerx1)) { }
        else { field_abstractfieldx2.addplayers(players_playerx1); }
      }
      else if (field_abstractfieldx2.getplayers().contains(players_playerx1))
      { players_playerx1.setfield(field_abstractfieldx2); } 
    }
  }
  for (int _i = 0; _i < balls.size(); _i++)
  { Ball ball_ballx1 = (Ball) balls.get(_i);
    for (int _j = 0; _j < players.size(); _j++)
    { Player player_playerx2 = (Player) players.get(_j);
      if (ball_ballx1.getplayer().contains(player_playerx2))
      { if (player_playerx2.getball().contains(ball_ballx1)) { }
        else { player_playerx2.addball(ball_ballx1); }
      }
      else if (player_playerx2.getball().contains(ball_ballx1))
      { ball_ballx1.addplayer(player_playerx2); } 
    }
  }
  }


  public void saveModel(String file)
  { File outfile = new File(file); 
    PrintWriter out; 
    try { out = new PrintWriter(new BufferedWriter(new FileWriter(outfile))); }
    catch (Exception e) { return; } 
  for (int _i = 0; _i < balls.size(); _i++)
  { Ball ballx_ = (Ball) balls.get(_i);
    out.println("ballx_" + _i + " : Ball");
  }

  for (int _i = 0; _i < soccerpitchs.size(); _i++)
  { SoccerPitch soccerpitchx_ = (SoccerPitch) soccerpitchs.get(_i);
    out.println("soccerpitchx_" + _i + " : SoccerPitch");
  }

  for (int _i = 0; _i < fieldplayers.size(); _i++)
  { FieldPlayer fieldplayerx_ = (FieldPlayer) fieldplayers.get(_i);
    out.println("fieldplayerx_" + _i + " : FieldPlayer");
    out.println("fieldplayerx_" + _i + ".team = \"" + fieldplayerx_.getteam() + "\"");
    out.println("fieldplayerx_" + _i + ".number = " + fieldplayerx_.getnumber());
  }

  for (int _i = 0; _i < goalkeepers.size(); _i++)
  { GoalKeeper goalkeeperx_ = (GoalKeeper) goalkeepers.get(_i);
    out.println("goalkeeperx_" + _i + " : GoalKeeper");
    out.println("goalkeeperx_" + _i + ".team = \"" + goalkeeperx_.getteam() + "\"");
    out.println("goalkeeperx_" + _i + ".number = " + goalkeeperx_.getnumber());
  }

  for (int _i = 0; _i < goalfields.size(); _i++)
  { GoalField goalfieldx_ = (GoalField) goalfields.get(_i);
    out.println("goalfieldx_" + _i + " : GoalField");
    out.println("goalfieldx_" + _i + ".team = \"" + goalfieldx_.getteam() + "\"");
    out.println("goalfieldx_" + _i + ".xPos = " + goalfieldx_.getxPos());
    out.println("goalfieldx_" + _i + ".yPos = " + goalfieldx_.getyPos());
  }

  for (int _i = 0; _i < fields.size(); _i++)
  { Field fieldx_ = (Field) fields.get(_i);
    out.println("fieldx_" + _i + " : Field");
    out.println("fieldx_" + _i + ".xPos = " + fieldx_.getxPos());
    out.println("fieldx_" + _i + ".yPos = " + fieldx_.getyPos());
  }

  for (int _i = 0; _i < updates.size(); _i++)
  { Update updatex_ = (Update) updates.get(_i);
    out.println("updatex_" + _i + " : Update");
  }

  for (int _i = 0; _i < moveplayers.size(); _i++)
  { MovePlayer moveplayerx_ = (MovePlayer) moveplayers.get(_i);
    out.println("moveplayerx_" + _i + " : MovePlayer");
    out.println("moveplayerx_" + _i + ".playerNumber = " + moveplayerx_.getplayerNumber());
    out.println("moveplayerx_" + _i + ".xDist = " + moveplayerx_.getxDist());
    out.println("moveplayerx_" + _i + ".yDist = " + moveplayerx_.getyDist());
  }

  for (int _i = 0; _i < shootballs.size(); _i++)
  { ShootBall shootballx_ = (ShootBall) shootballs.get(_i);
    out.println("shootballx_" + _i + " : ShootBall");
    out.println("shootballx_" + _i + ".playerNumber = " + shootballx_.getplayerNumber());
    out.println("shootballx_" + _i + ".xDist = " + shootballx_.getxDist());
    out.println("shootballx_" + _i + ".yDist = " + shootballx_.getyDist());
  }

  for (int _i = 0; _i < balls.size(); _i++)
  { Ball ballx_ = (Ball) balls.get(_i);
    if (ballx_.getfield() instanceof GoalField)
    { out.println("ballx_" + _i + ".field = goalfieldx_" + goalfields.indexOf(ballx_.getfield())); } 
    if (ballx_.getfield() instanceof Field)
    { out.println("ballx_" + _i + ".field = fieldx_" + fields.indexOf(ballx_.getfield())); } 
    List ball_player_Player = ballx_.getplayer();
    for (int _k = 0; _k < ball_player_Player.size(); _k++)
    { if (ball_player_Player.get(_k) instanceof FieldPlayer)
      { out.println("fieldplayerx_" + fieldplayers.indexOf(ball_player_Player.get(_k)) + " : ballx_" + _i + ".player"); }
 if (ball_player_Player.get(_k) instanceof GoalKeeper)
      { out.println("goalkeeperx_" + goalkeepers.indexOf(ball_player_Player.get(_k)) + " : ballx_" + _i + ".player"); }
  }
  }
  for (int _i = 0; _i < soccerpitchs.size(); _i++)
  { SoccerPitch soccerpitchx_ = (SoccerPitch) soccerpitchs.get(_i);
    List soccerpitch_players_Player = soccerpitchx_.getplayers();
    for (int _k = 0; _k < soccerpitch_players_Player.size(); _k++)
    { if (soccerpitch_players_Player.get(_k) instanceof FieldPlayer)
      { out.println("fieldplayerx_" + fieldplayers.indexOf(soccerpitch_players_Player.get(_k)) + " : soccerpitchx_" + _i + ".players"); }
 if (soccerpitch_players_Player.get(_k) instanceof GoalKeeper)
      { out.println("goalkeeperx_" + goalkeepers.indexOf(soccerpitch_players_Player.get(_k)) + " : soccerpitchx_" + _i + ".players"); }
  }
    out.println("soccerpitchx_" + _i + ".balls = ballx_" + balls.indexOf(((SoccerPitch) soccerpitchs.get(_i)).getballs()));
    List soccerpitch_fields_AbstractField = soccerpitchx_.getfields();
    for (int _k = 0; _k < soccerpitch_fields_AbstractField.size(); _k++)
    { if (soccerpitch_fields_AbstractField.get(_k) instanceof GoalField)
      { out.println("goalfieldx_" + goalfields.indexOf(soccerpitch_fields_AbstractField.get(_k)) + " : soccerpitchx_" + _i + ".fields"); }
 if (soccerpitch_fields_AbstractField.get(_k) instanceof Field)
      { out.println("fieldx_" + fields.indexOf(soccerpitch_fields_AbstractField.get(_k)) + " : soccerpitchx_" + _i + ".fields"); }
  }
  }
  for (int _i = 0; _i < fieldplayers.size(); _i++)
  { FieldPlayer fieldplayerx_ = (FieldPlayer) fieldplayers.get(_i);
    if (fieldplayerx_.getfield() instanceof GoalField)
    { out.println("fieldplayerx_" + _i + ".field = goalfieldx_" + goalfields.indexOf(fieldplayerx_.getfield())); } 
    if (fieldplayerx_.getfield() instanceof Field)
    { out.println("fieldplayerx_" + _i + ".field = fieldx_" + fields.indexOf(fieldplayerx_.getfield())); } 
    List fieldplayer_ball_Ball = fieldplayerx_.getball();
    for (int _j = 0; _j < fieldplayer_ball_Ball.size(); _j++)
    { out.println("ballx_" + balls.indexOf(fieldplayer_ball_Ball.get(_j)) + " : fieldplayerx_" + _i + ".ball");
    }
  }
  for (int _i = 0; _i < goalkeepers.size(); _i++)
  { GoalKeeper goalkeeperx_ = (GoalKeeper) goalkeepers.get(_i);
    if (goalkeeperx_.getfield() instanceof GoalField)
    { out.println("goalkeeperx_" + _i + ".field = goalfieldx_" + goalfields.indexOf(goalkeeperx_.getfield())); } 
    if (goalkeeperx_.getfield() instanceof Field)
    { out.println("goalkeeperx_" + _i + ".field = fieldx_" + fields.indexOf(goalkeeperx_.getfield())); } 
    List goalkeeper_ball_Ball = goalkeeperx_.getball();
    for (int _j = 0; _j < goalkeeper_ball_Ball.size(); _j++)
    { out.println("ballx_" + balls.indexOf(goalkeeper_ball_Ball.get(_j)) + " : goalkeeperx_" + _i + ".ball");
    }
  }
  for (int _i = 0; _i < goalfields.size(); _i++)
  { GoalField goalfieldx_ = (GoalField) goalfields.get(_i);
    List goalfield_ball_Ball = goalfieldx_.getball();
    for (int _j = 0; _j < goalfield_ball_Ball.size(); _j++)
    { out.println("ballx_" + balls.indexOf(goalfield_ball_Ball.get(_j)) + " : goalfieldx_" + _i + ".ball");
    }
    List goalfield_players_Player = goalfieldx_.getplayers();
    for (int _k = 0; _k < goalfield_players_Player.size(); _k++)
    { if (goalfield_players_Player.get(_k) instanceof FieldPlayer)
      { out.println("fieldplayerx_" + fieldplayers.indexOf(goalfield_players_Player.get(_k)) + " : goalfieldx_" + _i + ".players"); }
 if (goalfield_players_Player.get(_k) instanceof GoalKeeper)
      { out.println("goalkeeperx_" + goalkeepers.indexOf(goalfield_players_Player.get(_k)) + " : goalfieldx_" + _i + ".players"); }
  }
  }
  for (int _i = 0; _i < fields.size(); _i++)
  { Field fieldx_ = (Field) fields.get(_i);
    List field_ball_Ball = fieldx_.getball();
    for (int _j = 0; _j < field_ball_Ball.size(); _j++)
    { out.println("ballx_" + balls.indexOf(field_ball_Ball.get(_j)) + " : fieldx_" + _i + ".ball");
    }
    List field_players_Player = fieldx_.getplayers();
    for (int _k = 0; _k < field_players_Player.size(); _k++)
    { if (field_players_Player.get(_k) instanceof FieldPlayer)
      { out.println("fieldplayerx_" + fieldplayers.indexOf(field_players_Player.get(_k)) + " : fieldx_" + _i + ".players"); }
 if (field_players_Player.get(_k) instanceof GoalKeeper)
      { out.println("goalkeeperx_" + goalkeepers.indexOf(field_players_Player.get(_k)) + " : fieldx_" + _i + ".players"); }
  }
  }
  for (int _i = 0; _i < updates.size(); _i++)
  { Update updatex_ = (Update) updates.get(_i);
    List update_actions_Action = updatex_.getactions();
    for (int _k = 0; _k < update_actions_Action.size(); _k++)
    { if (update_actions_Action.get(_k) instanceof MovePlayer)
      { out.println("moveplayerx_" + moveplayers.indexOf(update_actions_Action.get(_k)) + " : updatex_" + _i + ".actions"); }
 if (update_actions_Action.get(_k) instanceof ShootBall)
      { out.println("shootballx_" + shootballs.indexOf(update_actions_Action.get(_k)) + " : updatex_" + _i + ".actions"); }
  }
  }
    out.close(); 
  }


  public void saveXSI(String file)
  { File outfile = new File(file); 
    PrintWriter out; 
    try { out = new PrintWriter(new BufferedWriter(new FileWriter(outfile))); }
    catch (Exception e) { return; } 
    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<My:model xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\">");
    for (int _i = 0; _i < balls.size(); _i++)
    { Ball ballx_ = (Ball) balls.get(_i);
       out.print("<balls xsi:type=\"My:Ball\"");
    if (ballx_.getfield() instanceof GoalField)
    {   out.print(" field=\"");
    out.print("//@goalfields." + goalfields.indexOf(((Ball) balls.get(_i)).getfield()));
    out.print("\""); }
    if (ballx_.getfield() instanceof Field)
    {   out.print(" field=\"");
    out.print("//@fields." + fields.indexOf(((Ball) balls.get(_i)).getfield()));
    out.print("\""); }
    out.print(" player = \"");
    List ball_player = ballx_.getplayer();
    for (int _k = 0; _k < ball_player.size(); _k++)
    {      if (ball_player.get(_k) instanceof FieldPlayer)
      { out.print(" //@fieldplayers." + fieldplayers.indexOf(ball_player.get(_k)));
    }
      if (ball_player.get(_k) instanceof GoalKeeper)
      { out.print(" //@goalkeepers." + goalkeepers.indexOf(ball_player.get(_k)));
    }
  }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < soccerpitchs.size(); _i++)
    { SoccerPitch soccerpitchx_ = (SoccerPitch) soccerpitchs.get(_i);
       out.print("<soccerpitchs xsi:type=\"My:SoccerPitch\"");
    out.print(" players = \"");
    List soccerpitch_players = soccerpitchx_.getplayers();
    for (int _k = 0; _k < soccerpitch_players.size(); _k++)
    {      if (soccerpitch_players.get(_k) instanceof FieldPlayer)
      { out.print(" //@fieldplayers." + fieldplayers.indexOf(soccerpitch_players.get(_k)));
    }
      if (soccerpitch_players.get(_k) instanceof GoalKeeper)
      { out.print(" //@goalkeepers." + goalkeepers.indexOf(soccerpitch_players.get(_k)));
    }
  }
    out.print("\"");
    out.print(" balls=\"");
    out.print("//@balls." + balls.indexOf(((SoccerPitch) soccerpitchs.get(_i)).getballs()));
    out.print("\"");
    out.print(" fields = \"");
    List soccerpitch_fields = soccerpitchx_.getfields();
    for (int _k = 0; _k < soccerpitch_fields.size(); _k++)
    {      if (soccerpitch_fields.get(_k) instanceof GoalField)
      { out.print(" //@goalfields." + goalfields.indexOf(soccerpitch_fields.get(_k)));
    }
      if (soccerpitch_fields.get(_k) instanceof Field)
      { out.print(" //@fields." + fields.indexOf(soccerpitch_fields.get(_k)));
    }
  }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < fieldplayers.size(); _i++)
    { FieldPlayer fieldplayerx_ = (FieldPlayer) fieldplayers.get(_i);
       out.print("<fieldplayers xsi:type=\"My:FieldPlayer\"");
    out.print(" team=\"" + fieldplayerx_.getteam() + "\" ");
    out.print(" number=\"" + fieldplayerx_.getnumber() + "\" ");
    if (fieldplayerx_.getfield() instanceof GoalField)
    {   out.print(" field=\"");
    out.print("//@goalfields." + goalfields.indexOf(((FieldPlayer) fieldplayers.get(_i)).getfield()));
    out.print("\""); }
    if (fieldplayerx_.getfield() instanceof Field)
    {   out.print(" field=\"");
    out.print("//@fields." + fields.indexOf(((FieldPlayer) fieldplayers.get(_i)).getfield()));
    out.print("\""); }
    out.print(" ball = \"");
    List fieldplayer_ball = fieldplayerx_.getball();
    for (int _j = 0; _j < fieldplayer_ball.size(); _j++)
    { out.print(" //@balls." + balls.indexOf(fieldplayer_ball.get(_j)));
    }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < goalkeepers.size(); _i++)
    { GoalKeeper goalkeeperx_ = (GoalKeeper) goalkeepers.get(_i);
       out.print("<goalkeepers xsi:type=\"My:GoalKeeper\"");
    out.print(" team=\"" + goalkeeperx_.getteam() + "\" ");
    out.print(" number=\"" + goalkeeperx_.getnumber() + "\" ");
    if (goalkeeperx_.getfield() instanceof GoalField)
    {   out.print(" field=\"");
    out.print("//@goalfields." + goalfields.indexOf(((GoalKeeper) goalkeepers.get(_i)).getfield()));
    out.print("\""); }
    if (goalkeeperx_.getfield() instanceof Field)
    {   out.print(" field=\"");
    out.print("//@fields." + fields.indexOf(((GoalKeeper) goalkeepers.get(_i)).getfield()));
    out.print("\""); }
    out.print(" ball = \"");
    List goalkeeper_ball = goalkeeperx_.getball();
    for (int _j = 0; _j < goalkeeper_ball.size(); _j++)
    { out.print(" //@balls." + balls.indexOf(goalkeeper_ball.get(_j)));
    }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < goalfields.size(); _i++)
    { GoalField goalfieldx_ = (GoalField) goalfields.get(_i);
       out.print("<goalfields xsi:type=\"My:GoalField\"");
    out.print(" team=\"" + goalfieldx_.getteam() + "\" ");
    out.print(" xPos=\"" + goalfieldx_.getxPos() + "\" ");
    out.print(" yPos=\"" + goalfieldx_.getyPos() + "\" ");
    out.print(" ball = \"");
    List goalfield_ball = goalfieldx_.getball();
    for (int _j = 0; _j < goalfield_ball.size(); _j++)
    { out.print(" //@balls." + balls.indexOf(goalfield_ball.get(_j)));
    }
    out.print("\"");
    out.print(" players = \"");
    List goalfield_players = goalfieldx_.getplayers();
    for (int _k = 0; _k < goalfield_players.size(); _k++)
    {      if (goalfield_players.get(_k) instanceof FieldPlayer)
      { out.print(" //@fieldplayers." + fieldplayers.indexOf(goalfield_players.get(_k)));
    }
      if (goalfield_players.get(_k) instanceof GoalKeeper)
      { out.print(" //@goalkeepers." + goalkeepers.indexOf(goalfield_players.get(_k)));
    }
  }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < fields.size(); _i++)
    { Field fieldx_ = (Field) fields.get(_i);
       out.print("<fields xsi:type=\"My:Field\"");
    out.print(" xPos=\"" + fieldx_.getxPos() + "\" ");
    out.print(" yPos=\"" + fieldx_.getyPos() + "\" ");
    out.print(" ball = \"");
    List field_ball = fieldx_.getball();
    for (int _j = 0; _j < field_ball.size(); _j++)
    { out.print(" //@balls." + balls.indexOf(field_ball.get(_j)));
    }
    out.print("\"");
    out.print(" players = \"");
    List field_players = fieldx_.getplayers();
    for (int _k = 0; _k < field_players.size(); _k++)
    {      if (field_players.get(_k) instanceof FieldPlayer)
      { out.print(" //@fieldplayers." + fieldplayers.indexOf(field_players.get(_k)));
    }
      if (field_players.get(_k) instanceof GoalKeeper)
      { out.print(" //@goalkeepers." + goalkeepers.indexOf(field_players.get(_k)));
    }
  }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < updates.size(); _i++)
    { Update updatex_ = (Update) updates.get(_i);
       out.print("<updates xsi:type=\"My:Update\"");
    out.print(" actions = \"");
    List update_actions = updatex_.getactions();
    for (int _k = 0; _k < update_actions.size(); _k++)
    {      if (update_actions.get(_k) instanceof MovePlayer)
      { out.print(" //@moveplayers." + moveplayers.indexOf(update_actions.get(_k)));
    }
      if (update_actions.get(_k) instanceof ShootBall)
      { out.print(" //@shootballs." + shootballs.indexOf(update_actions.get(_k)));
    }
  }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < moveplayers.size(); _i++)
    { MovePlayer moveplayerx_ = (MovePlayer) moveplayers.get(_i);
       out.print("<moveplayers xsi:type=\"My:MovePlayer\"");
    out.print(" playerNumber=\"" + moveplayerx_.getplayerNumber() + "\" ");
    out.print(" xDist=\"" + moveplayerx_.getxDist() + "\" ");
    out.print(" yDist=\"" + moveplayerx_.getyDist() + "\" ");
    out.println(" />");
  }

    for (int _i = 0; _i < shootballs.size(); _i++)
    { ShootBall shootballx_ = (ShootBall) shootballs.get(_i);
       out.print("<shootballs xsi:type=\"My:ShootBall\"");
    out.print(" playerNumber=\"" + shootballx_.getplayerNumber() + "\" ");
    out.print(" xDist=\"" + shootballx_.getxDist() + "\" ");
    out.print(" yDist=\"" + shootballx_.getyDist() + "\" ");
    out.println(" />");
  }

    out.println("</My:model>");
    out.close(); 
  }



  public void addBall(Ball oo) { balls.add(oo); }

  public void addAbstractField(AbstractField oo) { abstractfields.add(oo); }

  public void addSoccerPitch(SoccerPitch oo) { soccerpitchs.add(oo); }

  public void addPlayer(Player oo) { players.add(oo); }

  public void addFieldPlayer(FieldPlayer oo) { fieldplayers.add(oo); addPlayer(oo); }

  public void addGoalKeeper(GoalKeeper oo) { goalkeepers.add(oo); addPlayer(oo); }

  public void addGoalField(GoalField oo) { goalfields.add(oo); addAbstractField(oo); }

  public void addField(Field oo) { fields.add(oo); addAbstractField(oo); }

  public void addUpdate(Update oo) { updates.add(oo); }

  public void addAction(Action oo) { actions.add(oo); }

  public void addMovePlayer(MovePlayer oo) { moveplayers.add(oo); addAction(oo); }

  public void addShootBall(ShootBall oo) { shootballs.add(oo); addAction(oo); }



  public void createAllBall(List ballx)
  { for (int i = 0; i < ballx.size(); i++)
    { Ball ballx_x = (Ball) ballx.get(i);
      if (ballx_x == null) { ballx_x = new Ball(); }
      ballx.set(i,ballx_x);
      addBall(ballx_x);
    }
  }


  public Ball createBall(AbstractField fieldx)
  { 
    Ball ballx = new Ball(fieldx);
    addBall(ballx);
    setfield(ballx,fieldx);
    setplayer(ballx,new Vector());

    return ballx;
  }

  public void createAllSoccerPitch(List soccerpitchx)
  { for (int i = 0; i < soccerpitchx.size(); i++)
    { SoccerPitch soccerpitchx_x = (SoccerPitch) soccerpitchx.get(i);
      if (soccerpitchx_x == null) { soccerpitchx_x = new SoccerPitch(); }
      soccerpitchx.set(i,soccerpitchx_x);
      addSoccerPitch(soccerpitchx_x);
    }
  }


  public SoccerPitch createSoccerPitch(Ball ballsx)
  { 
    SoccerPitch soccerpitchx = new SoccerPitch(ballsx);
    addSoccerPitch(soccerpitchx);
    setplayers(soccerpitchx,new Vector());
    setballs(soccerpitchx,ballsx);
    setfields(soccerpitchx,new Vector());

    return soccerpitchx;
  }

  public void createAllFieldPlayer(List fieldplayerx)
  { for (int i = 0; i < fieldplayerx.size(); i++)
    { FieldPlayer fieldplayerx_x = (FieldPlayer) fieldplayerx.get(i);
      if (fieldplayerx_x == null) { fieldplayerx_x = new FieldPlayer(); }
      fieldplayerx.set(i,fieldplayerx_x);
      addFieldPlayer(fieldplayerx_x);
    }
  }


  public FieldPlayer createFieldPlayer()
  { 
    FieldPlayer fieldplayerx = new FieldPlayer();
    addFieldPlayer(fieldplayerx);

    return fieldplayerx;
  }

  public void createAllGoalKeeper(List goalkeeperx)
  { for (int i = 0; i < goalkeeperx.size(); i++)
    { GoalKeeper goalkeeperx_x = (GoalKeeper) goalkeeperx.get(i);
      if (goalkeeperx_x == null) { goalkeeperx_x = new GoalKeeper(); }
      goalkeeperx.set(i,goalkeeperx_x);
      addGoalKeeper(goalkeeperx_x);
    }
  }


  public GoalKeeper createGoalKeeper()
  { 
    GoalKeeper goalkeeperx = new GoalKeeper();
    addGoalKeeper(goalkeeperx);

    return goalkeeperx;
  }

  public void createAllGoalField(List goalfieldx)
  { for (int i = 0; i < goalfieldx.size(); i++)
    { GoalField goalfieldx_x = (GoalField) goalfieldx.get(i);
      if (goalfieldx_x == null) { goalfieldx_x = new GoalField(); }
      goalfieldx.set(i,goalfieldx_x);
      addGoalField(goalfieldx_x);
    }
  }


  public GoalField createGoalField()
  { 
    GoalField goalfieldx = new GoalField();
    addGoalField(goalfieldx);
    setteam(goalfieldx,"");

    return goalfieldx;
  }

  public void createAllField(List fieldx)
  { for (int i = 0; i < fieldx.size(); i++)
    { Field fieldx_x = (Field) fieldx.get(i);
      if (fieldx_x == null) { fieldx_x = new Field(); }
      fieldx.set(i,fieldx_x);
      addField(fieldx_x);
    }
  }


  public Field createField()
  { 
    Field fieldx = new Field();
    addField(fieldx);

    return fieldx;
  }

  public void createAllUpdate(List updatex)
  { for (int i = 0; i < updatex.size(); i++)
    { Update updatex_x = (Update) updatex.get(i);
      if (updatex_x == null) { updatex_x = new Update(); }
      updatex.set(i,updatex_x);
      addUpdate(updatex_x);
    }
  }


  public Update createUpdate()
  { 
    Update updatex = new Update();
    addUpdate(updatex);
    setactions(updatex,new Vector());

    return updatex;
  }

  public void createAllMovePlayer(List moveplayerx)
  { for (int i = 0; i < moveplayerx.size(); i++)
    { MovePlayer moveplayerx_x = (MovePlayer) moveplayerx.get(i);
      if (moveplayerx_x == null) { moveplayerx_x = new MovePlayer(); }
      moveplayerx.set(i,moveplayerx_x);
      addMovePlayer(moveplayerx_x);
    }
  }


  public MovePlayer createMovePlayer()
  { 
    MovePlayer moveplayerx = new MovePlayer();
    addMovePlayer(moveplayerx);

    return moveplayerx;
  }

  public void createAllShootBall(List shootballx)
  { for (int i = 0; i < shootballx.size(); i++)
    { ShootBall shootballx_x = (ShootBall) shootballx.get(i);
      if (shootballx_x == null) { shootballx_x = new ShootBall(); }
      shootballx.set(i,shootballx_x);
      addShootBall(shootballx_x);
    }
  }


  public ShootBall createShootBall()
  { 
    ShootBall shootballx = new ShootBall();
    addShootBall(shootballx);

    return shootballx;
  }


  public void setfield(Ball ballx, AbstractField fieldxx) 
  {   if (ballx.getfield() == fieldxx) { return; }
    if (ballx.getfield() != null)
    { AbstractField old_value = ballx.getfield();
      old_value.removeball(ballx);
      for (int _p = 0; _p < fieldxx.getball().size(); _p++)
      { Ball _p_xx = (Ball) fieldxx.getball().get(_p);
        _p_xx.setfield(null);
      }
    }
    Vector _exvect = new Vector();
    _exvect.add(ballx);
    fieldxx.setball(_exvect);
    ballx.setfield(fieldxx);
      }


  public void setplayer(Ball ballx, List playerxx) 
  {   if (playerxx.size() > 1) { return; }
  List _oldplayerxx = ballx.getplayer();
    for (int _j = 0; _j < _oldplayerxx.size(); _j++)
    { Player _yy = (Player) _oldplayerxx.get(_j);
      if (playerxx.contains(_yy)) { }
      else { _yy.removeball(ballx); }
    }
  for (int _i = 0; _i < playerxx.size(); _i++)
  { Player _xx = (Player) playerxx.get(_i);
    if (_oldplayerxx.contains(_xx)) { }
    else { Ball.removeAllplayer(_xx.getball(),_xx); }
    Vector _xxNewValue = new Vector();
    _xxNewValue.add(ballx);
    _xx.setball(_xxNewValue);
  }
    ballx.setplayer(playerxx);
      }


  public void addplayer(Ball ballx, Player playerxx) 
  { if (ballx.getplayer().contains(playerxx)) { return; }
    Ball.removeAllplayer(playerxx.getball(),playerxx);
  playerxx.addball(ballx);
    ballx.addplayer(playerxx);
    }


  public void removeplayer(Ball ballx, Player playerxx) 
  { ballx.removeplayer(playerxx);
    playerxx.removeball(ballx);
  }


 public void unionplayer(Ball ballx,List playerx)
  { for (int _i = 0; _i < playerx.size(); _i++)
    { Player playerxplayer = (Player) playerx.get(_i);
      addplayer(ballx,playerxplayer);
     } } 


 public void subtractplayer(Ball ballx,List playerx)
  { for (int _i = 0; _i < playerx.size(); _i++)
    { Player playerxplayer = (Player) playerx.get(_i);
      removeplayer(ballx,playerxplayer);
     } } 


public void setxPos(AbstractField abstractfieldx, int xPos_x) 
  { abstractfieldx.setxPos(xPos_x);
    }


public void setyPos(AbstractField abstractfieldx, int yPos_x) 
  { abstractfieldx.setyPos(yPos_x);
    }


  public void setball(AbstractField abstractfieldx, List ballxx) 
  {   if (ballxx.size() > 1) { return; }
  List _oldballxx = abstractfieldx.getball();
    for (int _j = 0; _j < _oldballxx.size(); _j++)
    { Ball _yy = (Ball) _oldballxx.get(_j);
      if (ballxx.contains(_yy)) { }
      else { _yy.setfield(null); }
    }
  for (int _i = 0; _i < ballxx.size(); _i++)
  { Ball _xx = (Ball) ballxx.get(_i);
    if (_oldballxx.contains(_xx)) { }
    else { if (_xx.getfield() != null) { _xx.getfield().removeball(_xx); }  }
    _xx.setfield(abstractfieldx);
  }
    abstractfieldx.setball(ballxx);
      }


  public void addball(AbstractField abstractfieldx, Ball ballxx) 
  { if (abstractfieldx.getball().contains(ballxx)) { return; }
    if (ballxx.getfield() != null) { ballxx.getfield().removeball(ballxx); }
  ballxx.setfield(abstractfieldx);
    abstractfieldx.addball(ballxx);
    }


  public void removeball(AbstractField abstractfieldx, Ball ballxx) 
  { abstractfieldx.removeball(ballxx);
    ballxx.setfield(null);
  }


 public void unionball(AbstractField abstractfieldx,List ballx)
  { for (int _i = 0; _i < ballx.size(); _i++)
    { Ball ballxball = (Ball) ballx.get(_i);
      addball(abstractfieldx,ballxball);
     } } 


 public void subtractball(AbstractField abstractfieldx,List ballx)
  { for (int _i = 0; _i < ballx.size(); _i++)
    { Ball ballxball = (Ball) ballx.get(_i);
      removeball(abstractfieldx,ballxball);
     } } 


  public void setplayers(AbstractField abstractfieldx, List playersxx) 
  {   List _oldplayersxx = abstractfieldx.getplayers();
    for (int _j = 0; _j < _oldplayersxx.size(); _j++)
    { Player _yy = (Player) _oldplayersxx.get(_j);
      if (playersxx.contains(_yy)) { }
      else { _yy.setfield(null); }
    }
  for (int _i = 0; _i < playersxx.size(); _i++)
  { Player _xx = (Player) playersxx.get(_i);
    if (_oldplayersxx.contains(_xx)) { }
    else { if (_xx.getfield() != null) { _xx.getfield().removeplayers(_xx); }  }
    _xx.setfield(abstractfieldx);
  }
    abstractfieldx.setplayers(playersxx);
      }


  public void addplayers(AbstractField abstractfieldx, Player playersxx) 
  { if (abstractfieldx.getplayers().contains(playersxx)) { return; }
    if (playersxx.getfield() != null) { playersxx.getfield().removeplayers(playersxx); }
  playersxx.setfield(abstractfieldx);
    abstractfieldx.addplayers(playersxx);
    }


  public void removeplayers(AbstractField abstractfieldx, Player playersxx) 
  { abstractfieldx.removeplayers(playersxx);
    playersxx.setfield(null);
  }


 public void unionplayers(AbstractField abstractfieldx,List playersx)
  { for (int _i = 0; _i < playersx.size(); _i++)
    { Player playerxplayers = (Player) playersx.get(_i);
      addplayers(abstractfieldx,playerxplayers);
     } } 


 public void subtractplayers(AbstractField abstractfieldx,List playersx)
  { for (int _i = 0; _i < playersx.size(); _i++)
    { Player playerxplayers = (Player) playersx.get(_i);
      removeplayers(abstractfieldx,playerxplayers);
     } } 


  public void setplayers(SoccerPitch soccerpitchx, List playersxx) 
  {   List _oldplayersxx = soccerpitchx.getplayers();
  for (int _i = 0; _i < playersxx.size(); _i++)
  { Player _xx = (Player) playersxx.get(_i);
    if (_oldplayersxx.contains(_xx)) { }
    else { SoccerPitch.removeAllplayers(soccerpitchs, _xx); }
  }
    soccerpitchx.setplayers(playersxx);
      }


  public void addplayers(SoccerPitch soccerpitchx, Player playersxx) 
  { if (soccerpitchx.getplayers().contains(playersxx)) { return; }
    SoccerPitch.removeAllplayers(soccerpitchs,playersxx);
    soccerpitchx.addplayers(playersxx);
    }


  public void removeplayers(SoccerPitch soccerpitchx, Player playersxx) 
  { soccerpitchx.removeplayers(playersxx);
    }


 public void unionplayers(SoccerPitch soccerpitchx,List playersx)
  { for (int _i = 0; _i < playersx.size(); _i++)
    { Player playerxplayers = (Player) playersx.get(_i);
      addplayers(soccerpitchx,playerxplayers);
     } } 


 public void subtractplayers(SoccerPitch soccerpitchx,List playersx)
  { for (int _i = 0; _i < playersx.size(); _i++)
    { Player playerxplayers = (Player) playersx.get(_i);
      removeplayers(soccerpitchx,playerxplayers);
     } } 


  public void setballs(SoccerPitch soccerpitchx, Ball ballsxx) 
  {   if (soccerpitchx.getballs() == ballsxx) { return; }
    for (int _q = 0; _q < soccerpitchs.size(); _q++)
    { SoccerPitch _q_E1x = (SoccerPitch) soccerpitchs.get(_q);
      if (_q_E1x.getballs() == ballsxx)
      { _q_E1x.setballs(null); }
    }
    soccerpitchx.setballs(ballsxx);
      }


  public void setfields(SoccerPitch soccerpitchx, List fieldsxx) 
  {   List _oldfieldsxx = soccerpitchx.getfields();
  for (int _i = 0; _i < fieldsxx.size(); _i++)
  { AbstractField _xx = (AbstractField) fieldsxx.get(_i);
    if (_oldfieldsxx.contains(_xx)) { }
    else { SoccerPitch.removeAllfields(soccerpitchs, _xx); }
  }
    soccerpitchx.setfields(fieldsxx);
      }


  public void addfields(SoccerPitch soccerpitchx, AbstractField fieldsxx) 
  { if (soccerpitchx.getfields().contains(fieldsxx)) { return; }
    SoccerPitch.removeAllfields(soccerpitchs,fieldsxx);
    soccerpitchx.addfields(fieldsxx);
    }


  public void removefields(SoccerPitch soccerpitchx, AbstractField fieldsxx) 
  { soccerpitchx.removefields(fieldsxx);
    }


 public void unionfields(SoccerPitch soccerpitchx,List fieldsx)
  { for (int _i = 0; _i < fieldsx.size(); _i++)
    { AbstractField abstractfieldxfields = (AbstractField) fieldsx.get(_i);
      addfields(soccerpitchx,abstractfieldxfields);
     } } 


 public void subtractfields(SoccerPitch soccerpitchx,List fieldsx)
  { for (int _i = 0; _i < fieldsx.size(); _i++)
    { AbstractField abstractfieldxfields = (AbstractField) fieldsx.get(_i);
      removefields(soccerpitchx,abstractfieldxfields);
     } } 


public void setteam(Player playerx, String team_x) 
  { playerx.setteam(team_x);
    }


public void setnumber(Player playerx, int number_x) 
  { playerx.setnumber(number_x);
    }


  public void setfield(Player playerx, AbstractField fieldxx) 
  {   if (playerx.getfield() == fieldxx) { return; }
    if (playerx.getfield() != null)
    { AbstractField old_value = playerx.getfield();
      old_value.removeplayers(playerx); } 
    fieldxx.addplayers(playerx);
    playerx.setfield(fieldxx);
      }


  public void setball(Player playerx, List ballxx) 
  {   if (ballxx.size() > 1) { return; }
  List _oldballxx = playerx.getball();
    for (int _j = 0; _j < _oldballxx.size(); _j++)
    { Ball _yy = (Ball) _oldballxx.get(_j);
      if (ballxx.contains(_yy)) { }
      else { _yy.removeplayer(playerx); }
    }
  for (int _i = 0; _i < ballxx.size(); _i++)
  { Ball _xx = (Ball) ballxx.get(_i);
    if (_oldballxx.contains(_xx)) { }
    else { Player.removeAllball(_xx.getplayer(),_xx); }
    Vector _xxNewValue = new Vector();
    _xxNewValue.add(playerx);
    _xx.setplayer(_xxNewValue);
  }
    playerx.setball(ballxx);
      }


  public void addball(Player playerx, Ball ballxx) 
  { if (playerx.getball().contains(ballxx)) { return; }
    Player.removeAllball(ballxx.getplayer(),ballxx);
  ballxx.addplayer(playerx);
    playerx.addball(ballxx);
    }


  public void removeball(Player playerx, Ball ballxx) 
  { playerx.removeball(ballxx);
    ballxx.removeplayer(playerx);
  }


 public void unionball(Player playerx,List ballx)
  { for (int _i = 0; _i < ballx.size(); _i++)
    { Ball ballxball = (Ball) ballx.get(_i);
      addball(playerx,ballxball);
     } } 


 public void subtractball(Player playerx,List ballx)
  { for (int _i = 0; _i < ballx.size(); _i++)
    { Ball ballxball = (Ball) ballx.get(_i);
      removeball(playerx,ballxball);
     } } 


public void setteam(GoalField goalfieldx, String team_x) 
  { goalfieldx.setteam(team_x);
    }


  public void setactions(Update updatex, List actionsxx) 
  {   List _oldactionsxx = updatex.getactions();
  for (int _i = 0; _i < actionsxx.size(); _i++)
  { Action _xx = (Action) actionsxx.get(_i);
    if (_oldactionsxx.contains(_xx)) { }
    else { Update.removeAllactions(updates, _xx); }
  }
    updatex.setactions(actionsxx);
      }


  public void addactions(Update updatex, Action actionsxx) 
  { if (updatex.getactions().contains(actionsxx)) { return; }
    Update.removeAllactions(updates,actionsxx);
    updatex.addactions(actionsxx);
    }


  public void removeactions(Update updatex, Action actionsxx) 
  { updatex.removeactions(actionsxx);
    }


 public void unionactions(Update updatex,List actionsx)
  { for (int _i = 0; _i < actionsx.size(); _i++)
    { Action actionxactions = (Action) actionsx.get(_i);
      addactions(updatex,actionxactions);
     } } 


 public void subtractactions(Update updatex,List actionsx)
  { for (int _i = 0; _i < actionsx.size(); _i++)
    { Action actionxactions = (Action) actionsx.get(_i);
      removeactions(updatex,actionxactions);
     } } 


public void setplayerNumber(Action actionx, int playerNumber_x) 
  { actionx.setplayerNumber(playerNumber_x);
    }


public void setxDist(Action actionx, int xDist_x) 
  { actionx.setxDist(xDist_x);
    }


public void setyDist(Action actionx, int yDist_x) 
  { actionx.setyDist(yDist_x);
    }



  public  List AllBallblueTeamhasBall(List ballxs)
  { 
    List result = new Vector();
    for (int i = 0; i < ballxs.size(); i++)
    { Ball ballx = (Ball) ballxs.get(i);
      result.add(new Boolean(ballx.blueTeamhasBall()));
    }
    return result; 
  }

  public void cmaction(Player playerx,Update u,Ball theball)
  {   playerx.cmaction(u, theball);
   }

  public  List AllPlayercmaction(List playerxs,Update u,Ball theball)
  { 
    List result = new Vector();
    for (int i = 0; i < playerxs.size(); i++)
    { Player playerx = (Player) playerxs.get(i);
      cmaction(playerx,u, theball);
    }
    return result; 
  }

  public  List AllPlayerwithinShootingDist(List playerxs,int x,int y)
  { 
    List result = new Vector();
    for (int i = 0; i < playerxs.size(); i++)
    { Player playerx = (Player) playerxs.get(i);
      result.add(new Boolean(playerx.withinShootingDist(x, y)));
    }
    return result; 
  }

  public void goalkeeperaction(Player playerx,Update u)
  {   playerx.goalkeeperaction(u);
   }

  public  List AllPlayergoalkeeperaction(List playerxs,Update u)
  { 
    List result = new Vector();
    for (int i = 0; i < playerxs.size(); i++)
    { Player playerx = (Player) playerxs.get(i);
      goalkeeperaction(playerx,u);
    }
    return result; 
  }

  public void defenderaction(Player playerx,Update u,Ball theball)
  {   playerx.defenderaction(u, theball);
   }

  public  List AllPlayerdefenderaction(List playerxs,Update u,Ball theball)
  { 
    List result = new Vector();
    for (int i = 0; i < playerxs.size(); i++)
    { Player playerx = (Player) playerxs.get(i);
      defenderaction(playerx,u, theball);
    }
    return result; 
  }

  public void moveToBall(Player playerx,Update u,Ball b)
  {   playerx.moveToBall(u, b);
   }

  public  List AllPlayermoveToBall(List playerxs,Update u,Ball b)
  { 
    List result = new Vector();
    for (int i = 0; i < playerxs.size(); i++)
    { Player playerx = (Player) playerxs.get(i);
      moveToBall(playerx,u, b);
    }
    return result; 
  }

  public void midfielderaction(Player playerx,Update u,Ball theball)
  {   playerx.midfielderaction(u, theball);
   }

  public  List AllPlayermidfielderaction(List playerxs,Update u,Ball theball)
  { 
    List result = new Vector();
    for (int i = 0; i < playerxs.size(); i++)
    { Player playerx = (Player) playerxs.get(i);
      midfielderaction(playerx,u, theball);
    }
    return result; 
  }



  public void killAllBall(List ballxx)
  { for (int _i = 0; _i < ballxx.size(); _i++)
    { killBall((Ball) ballxx.get(_i)); }
  }

  public void killBall(Ball ballxx)
  { balls.remove(ballxx);
    Vector _1removedballsSoccerPitch = new Vector();
    Vector _1qrangeballsSoccerPitch = new Vector();
    _1qrangeballsSoccerPitch.addAll(soccerpitchs);
    for (int _i = 0; _i < _1qrangeballsSoccerPitch.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) _1qrangeballsSoccerPitch.get(_i);
      if (soccerpitchx != null && ballxx.equals(soccerpitchx.getballs()))
      { _1removedballsSoccerPitch.add(soccerpitchx);
        soccerpitchx.setballs(null);
      }
    }
    Vector _2qrangeballAbstractField = new Vector();
    _2qrangeballAbstractField.add(ballxx.getfield());
    for (int _i = 0; _i < _2qrangeballAbstractField.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) _2qrangeballAbstractField.get(_i);
      if (abstractfieldx.getball().contains(ballxx))
      { removeball(abstractfieldx,ballxx); }
    }
    Vector _2qrangeballPlayer = new Vector();
    _2qrangeballPlayer.addAll(ballxx.getplayer());
    for (int _i = 0; _i < _2qrangeballPlayer.size(); _i++)
    { Player playerx = (Player) _2qrangeballPlayer.get(_i);
      if (playerx.getball().contains(ballxx))
      { removeball(playerx,ballxx); }
    }

    ballxx.setplayer(new Vector());
    for (int _i = 0; _i < _1removedballsSoccerPitch.size(); _i++)
    { killSoccerPitch((SoccerPitch) _1removedballsSoccerPitch.get(_i)); }
  }



  public void killAllAbstractField(List abstractfieldxx)
  { for (int _i = 0; _i < abstractfieldxx.size(); _i++)
    { killAbstractField((AbstractField) abstractfieldxx.get(_i)); }
  }

  public void killAbstractField(AbstractField abstractfieldxx)
  { abstractfields.remove(abstractfieldxx);
    Vector _1removedfieldBall = new Vector();
    Vector _1removedfieldPlayer = new Vector();
    Vector _1qrangefieldsSoccerPitch = new Vector();
    _1qrangefieldsSoccerPitch.addAll(soccerpitchs);
    for (int _i = 0; _i < _1qrangefieldsSoccerPitch.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) _1qrangefieldsSoccerPitch.get(_i);
      if (soccerpitchx.getfields().contains(abstractfieldxx))
      { removefields(soccerpitchx,abstractfieldxx); }
    }
    Vector _1qrangefieldBall = new Vector();
    _1qrangefieldBall.addAll(abstractfieldxx.getball());
    for (int _i = 0; _i < _1qrangefieldBall.size(); _i++)
    { Ball ballx = (Ball) _1qrangefieldBall.get(_i);
      if (ballx != null && abstractfieldxx.equals(ballx.getfield()))
      { _1removedfieldBall.add(ballx);
        ballx.setfield(null);
      }
    }
    Vector _1qrangefieldPlayer = new Vector();
    _1qrangefieldPlayer.addAll(abstractfieldxx.getplayers());
    for (int _i = 0; _i < _1qrangefieldPlayer.size(); _i++)
    { Player playerx = (Player) _1qrangefieldPlayer.get(_i);
      if (playerx != null && abstractfieldxx.equals(playerx.getfield()))
      { _1removedfieldPlayer.add(playerx);
        playerx.setfield(null);
      }
    }
    for (int _i = 0; _i < _1removedfieldBall.size(); _i++)
    { killBall((Ball) _1removedfieldBall.get(_i)); }
    for (int _i = 0; _i < _1removedfieldPlayer.size(); _i++)
    { killAbstractPlayer((Player) _1removedfieldPlayer.get(_i)); }
  }

  public void killAbstractAbstractField(AbstractField abstractfieldxx)
  {
    if (abstractfieldxx instanceof GoalField)
    { killGoalField((GoalField) abstractfieldxx); }
    if (abstractfieldxx instanceof Field)
    { killField((Field) abstractfieldxx); }
  }

  public void killAbstractAbstractField(List _l)
  { for (int _i = 0; _i < _l.size(); _i++)
    { AbstractField _e = (AbstractField) _l.get(_i);
      killAbstractAbstractField(_e);
    }
  }



  public void killAllSoccerPitch(List soccerpitchxx)
  { for (int _i = 0; _i < soccerpitchxx.size(); _i++)
    { killSoccerPitch((SoccerPitch) soccerpitchxx.get(_i)); }
  }

  public void killSoccerPitch(SoccerPitch soccerpitchxx)
  { soccerpitchs.remove(soccerpitchxx);
  }



  public void killAllPlayer(List playerxx)
  { for (int _i = 0; _i < playerxx.size(); _i++)
    { killPlayer((Player) playerxx.get(_i)); }
  }

  public void killPlayer(Player playerxx)
  { players.remove(playerxx);
    Vector _1qrangeplayersSoccerPitch = new Vector();
    _1qrangeplayersSoccerPitch.addAll(soccerpitchs);
    for (int _i = 0; _i < _1qrangeplayersSoccerPitch.size(); _i++)
    { SoccerPitch soccerpitchx = (SoccerPitch) _1qrangeplayersSoccerPitch.get(_i);
      if (soccerpitchx.getplayers().contains(playerxx))
      { removeplayers(soccerpitchx,playerxx); }
    }
    Vector _2qrangeplayersAbstractField = new Vector();
    _2qrangeplayersAbstractField.add(playerxx.getfield());
    for (int _i = 0; _i < _2qrangeplayersAbstractField.size(); _i++)
    { AbstractField abstractfieldx = (AbstractField) _2qrangeplayersAbstractField.get(_i);
      if (abstractfieldx.getplayers().contains(playerxx))
      { removeplayers(abstractfieldx,playerxx); }
    }
    Vector _1qrangeplayerBall = new Vector();
    _1qrangeplayerBall.addAll(playerxx.getball());
    for (int _i = 0; _i < _1qrangeplayerBall.size(); _i++)
    { Ball ballx = (Ball) _1qrangeplayerBall.get(_i);
      if (ballx.getplayer().contains(playerxx))
      { removeplayer(ballx,playerxx); }
    }
  }

  public void killAbstractPlayer(Player playerxx)
  {
    if (playerxx instanceof FieldPlayer)
    { killFieldPlayer((FieldPlayer) playerxx); }
    if (playerxx instanceof GoalKeeper)
    { killGoalKeeper((GoalKeeper) playerxx); }
  }

  public void killAbstractPlayer(List _l)
  { for (int _i = 0; _i < _l.size(); _i++)
    { Player _e = (Player) _l.get(_i);
      killAbstractPlayer(_e);
    }
  }



  public void killAllFieldPlayer(List fieldplayerxx)
  { for (int _i = 0; _i < fieldplayerxx.size(); _i++)
    { killFieldPlayer((FieldPlayer) fieldplayerxx.get(_i)); }
  }

  public void killFieldPlayer(FieldPlayer fieldplayerxx)
  { fieldplayers.remove(fieldplayerxx);
  killPlayer(fieldplayerxx);
  }



  public void killAllGoalKeeper(List goalkeeperxx)
  { for (int _i = 0; _i < goalkeeperxx.size(); _i++)
    { killGoalKeeper((GoalKeeper) goalkeeperxx.get(_i)); }
  }

  public void killGoalKeeper(GoalKeeper goalkeeperxx)
  { goalkeepers.remove(goalkeeperxx);
  killPlayer(goalkeeperxx);
  }



  public void killAllGoalField(List goalfieldxx)
  { for (int _i = 0; _i < goalfieldxx.size(); _i++)
    { killGoalField((GoalField) goalfieldxx.get(_i)); }
  }

  public void killGoalField(GoalField goalfieldxx)
  { goalfields.remove(goalfieldxx);
  killAbstractField(goalfieldxx);
  }



  public void killAllField(List fieldxx)
  { for (int _i = 0; _i < fieldxx.size(); _i++)
    { killField((Field) fieldxx.get(_i)); }
  }

  public void killField(Field fieldxx)
  { fields.remove(fieldxx);
  killAbstractField(fieldxx);
  }



  public void killAllUpdate(List updatexx)
  { for (int _i = 0; _i < updatexx.size(); _i++)
    { killUpdate((Update) updatexx.get(_i)); }
  }

  public void killUpdate(Update updatexx)
  { updates.remove(updatexx);
  }



  public void killAllAction(List actionxx)
  { for (int _i = 0; _i < actionxx.size(); _i++)
    { killAction((Action) actionxx.get(_i)); }
  }

  public void killAction(Action actionxx)
  { actions.remove(actionxx);
    Vector _1qrangeactionsUpdate = new Vector();
    _1qrangeactionsUpdate.addAll(updates);
    for (int _i = 0; _i < _1qrangeactionsUpdate.size(); _i++)
    { Update updatex = (Update) _1qrangeactionsUpdate.get(_i);
      if (updatex.getactions().contains(actionxx))
      { removeactions(updatex,actionxx); }
    }
  }

  public void killAbstractAction(Action actionxx)
  {
    if (actionxx instanceof MovePlayer)
    { killMovePlayer((MovePlayer) actionxx); }
    if (actionxx instanceof ShootBall)
    { killShootBall((ShootBall) actionxx); }
  }

  public void killAbstractAction(List _l)
  { for (int _i = 0; _i < _l.size(); _i++)
    { Action _e = (Action) _l.get(_i);
      killAbstractAction(_e);
    }
  }



  public void killAllMovePlayer(List moveplayerxx)
  { for (int _i = 0; _i < moveplayerxx.size(); _i++)
    { killMovePlayer((MovePlayer) moveplayerxx.get(_i)); }
  }

  public void killMovePlayer(MovePlayer moveplayerxx)
  { moveplayers.remove(moveplayerxx);
  killAction(moveplayerxx);
  }



  public void killAllShootBall(List shootballxx)
  { for (int _i = 0; _i < shootballxx.size(); _i++)
    { killShootBall((ShootBall) shootballxx.get(_i)); }
  }

  public void killShootBall(ShootBall shootballxx)
  { shootballs.remove(shootballxx);
  killAction(shootballxx);
  }




  
    public void play() 
  { 

    Ball theball = (Ball) Set.any(Controller.inst().balls);
    GoalKeeper goalkeeper = (GoalKeeper) Set.any(Set.select_0(Controller.inst().goalkeepers));
    FieldPlayer player5 = (FieldPlayer) Set.any(Set.select_1(Controller.inst().fieldplayers));
    FieldPlayer player2 = (FieldPlayer) Set.any(Set.select_2(Controller.inst().fieldplayers));
    FieldPlayer player3 = (FieldPlayer) Set.any(Set.select_3(Controller.inst().fieldplayers));
    FieldPlayer player4 = (FieldPlayer) Set.any(Set.select_4(Controller.inst().fieldplayers));
    FieldPlayer player6 = (FieldPlayer) Set.any(Set.select_5(Controller.inst().fieldplayers));
    FieldPlayer player7 = (FieldPlayer) Set.any(Set.select_6(Controller.inst().fieldplayers));
    FieldPlayer player8 = (FieldPlayer) Set.any(Set.select_7(Controller.inst().fieldplayers));
    FieldPlayer player9 = (FieldPlayer) Set.any(Set.select_8(Controller.inst().fieldplayers));
     Update u = new Update();
    Controller.inst().addUpdate(u);
    Controller.inst().goalkeeperaction(goalkeeper,u);
    Controller.inst().cmaction(player5,u,theball);
    Controller.inst().defenderaction(player2,u,theball);
    Controller.inst().defenderaction(player3,u,theball);
    Controller.inst().midfielderaction(player4,u,theball);
    Controller.inst().midfielderaction(player6,u,theball);
    Controller.inst().midfielderaction(player7,u,theball);
    Controller.inst().midfielderaction(player8,u,theball);
    Controller.inst().midfielderaction(player9,u,theball);

    // Controller.inst().saveModel("out.txt");
    // Controller.inst().saveXSI("xsi.txt");
  }


  public String makeMove() 
  { play(); 
    return XMLParser.saveXSI(Controller.inst().moveplayers, Controller.inst().shootballs); 

  }


  public static String cycle(String model)
  { Controller.inst().clearModel(); 
    XMLParser.convertXsiToData(model); 
    Controller.loadModel("in.txt"); 
    Controller c = Controller.inst(); 
    return c.makeMove(); 
  } 

   private void clearModel() 
  {   balls = new Vector();
   abstractfields = new Vector();
   soccerpitchs = new Vector();
   players = new Vector();
   fieldplayers = new Vector();
   goalkeepers = new Vector();
   goalfields = new Vector();
   fields = new Vector();
   updates = new Vector();
   actions = new Vector();
   moveplayers = new Vector();
   shootballs = new Vector();
  } 

 
}



