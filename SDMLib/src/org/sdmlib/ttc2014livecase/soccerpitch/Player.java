/*
   Copyright (c) 2014 zuendorf 
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
   
package org.sdmlib.ttc2014livecase.soccerpitch;

import org.sdmlib.serialization.PropertyChangeInterface;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import org.sdmlib.StrUtil;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;

import de.uks.server.ServerConnection;
import update.Action;
import update.Update;

public class Player implements PropertyChangeInterface
{

   
   //==========================================================================
   
   protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);
   
   @Override
   public PropertyChangeSupport getPropertyChangeSupport()
   {
      return listeners;
   }
   
   public void addPropertyChangeListener(PropertyChangeListener listener) 
   {
      getPropertyChangeSupport().addPropertyChangeListener(listener);
   }

   
   //==========================================================================
   
   
   public void removeYou()
   {
      setField(null);
      setBall(null);
      setPitch(null);
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_TEAM = "team";
   
   private String team = "BLUE";

   public String getTeam()
   {
      return this.team;
   }
   
   public void setTeam(String value)
   {
      if ( ! StrUtil.stringEquals(this.team, value))
      {
         String oldValue = this.team;
         this.team = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_TEAM, oldValue, value);
      }
   }
   
   public Player withTeam(String value)
   {
      setTeam(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getTeam());
      result.append(" ").append(this.getNumber());
      result.append(" ").append(this.getTackleDistance());
      result.append(" ").append(this.getTgtX());
      result.append(" ").append(this.getTgtY());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_NUMBER = "number";
   
   private int number;

   public int getNumber()
   {
      return this.number;
   }
   
   public void setNumber(int value)
   {
      if (this.number != value)
      {
         int oldValue = this.number;
         this.number = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_NUMBER, oldValue, value);
      }
   }
   
   public Player withNumber(int value)
   {
      setNumber(value);
      return this;
   } 

   
   public static final PlayerSet EMPTY_SET = new PlayerSet().withReadonly(true);

   
   /********************************************************************
    * <pre>
    *              many                       one
    * Player ----------------------------------- Field
    *              players                   field
    * </pre>
    */
   
   public static final String PROPERTY_FIELD = "field";

   private Field field = null;

   public Field getField()
   {
      return this.field;
   }

   public boolean setField(Field value)
   {
      boolean changed = false;
      
      if (this.field != value)
      {
         Field oldValue = this.field;
         
         if (this.field != null)
         {
            this.field = null;
            oldValue.withoutPlayers(this);
         }
         
         this.field = value;
         
         if (value != null)
         {
            value.withPlayers(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_FIELD, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Player withField(Field value)
   {
      setField(value);
      return this;
   } 

   public Field createField()
   {
      Field value = new Field();
      withField(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Player ----------------------------------- Ball
    *              player                   ball
    * </pre>
    */
   
   public static final String PROPERTY_BALL = "ball";

   private Ball ball = null;

   public Ball getBall()
   {
      return this.ball;
   }

   public boolean setBall(Ball value)
   {
      boolean changed = false;
      
      if (this.ball != value)
      {
         Ball oldValue = this.ball;
         
         if (this.ball != null)
         {
            this.ball = null;
            oldValue.setPlayer(null);
         }
         
         this.ball = value;
         
         if (value != null)
         {
            value.withPlayer(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_BALL, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Player withBall(Ball value)
   {
      setBall(value);
      return this;
   } 

   public Ball createBall()
   {
      Ball value = new Ball();
      withBall(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * Player ----------------------------------- SoccerPitch
    *              players                   pitch
    * </pre>
    */
   
   public static final String PROPERTY_PITCH = "pitch";

   private SoccerPitch pitch = null;

   public SoccerPitch getPitch()
   {
      return this.pitch;
   }

   public boolean setPitch(SoccerPitch value)
   {
      boolean changed = false;
      
      if (this.pitch != value)
      {
         SoccerPitch oldValue = this.pitch;
         
         if (this.pitch != null)
         {
            this.pitch = null;
            oldValue.withoutPlayers(this);
         }
         
         this.pitch = value;
         
         if (value != null)
         {
            value.withPlayers(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PITCH, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Player withPitch(SoccerPitch value)
   {
      setPitch(value);
      return this;
   } 

   public SoccerPitch createPitch()
   {
      SoccerPitch value = new SoccerPitch();
      withPitch(value);
      return value;
   }

   public void moveTo(Field targetField, Update update)
   {
      int xDist = targetField.getXPos() - this.getField().getXPos();
      int yDist = targetField.getYPos() - this.getField().getYPos();
      
      int maxDist = 3;
      if (this.getBall() != null)
      {
         maxDist = 2;
      }
      
      Action action = update.createMoveAction().withPlayerNumber(this.getNumber()).withXDist(xDist, maxDist).withYDist(yDist, maxDist);
      
      int targetX = this.getField().getXPos()+action.getXDist();
      int targetY = this.getField().getYPos()+action.getYDist();
      targetField = this.getField().getPitch().getField(targetX, targetY);
      
      if (this.getBall() != null)
      {
         if (targetField.getOpponentDistance() < 4 && this.getField().getOpponentDistance() > targetField.getOpponentDistance())
         {
            // do not move
            update.getActions().remove(action);
         }
      }
      
      this.setField(targetField);
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_TACKLEDISTANCE = "tackleDistance";
   
   private int tackleDistance = Integer.MAX_VALUE;

   public int getTackleDistance()
   {
      return this.tackleDistance;
   }
   
   public void setTackleDistance(int value)
   {
      if (this.tackleDistance != value)
      {
         int oldValue = this.tackleDistance;
         this.tackleDistance = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_TACKLEDISTANCE, oldValue, value);
      }
   }
   
   public Player withTackleDistance(int value)
   {
      setTackleDistance(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_TGTX = "tgtX";
   
   private int tgtX;

   public int getTgtX()
   {
      return this.tgtX;
   }
   
   public void setTgtX(int value)
   {
      if (this.tgtX != value)
      {
         int oldValue = this.tgtX;
         this.tgtX = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_TGTX, oldValue, value);
      }
   }
   
   public Player withTgtX(int value)
   {
      setTgtX(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_TGTY = "tgtY";
   
   private int tgtY;

   public int getTgtY()
   {
      return this.tgtY;
   }
   
   public void setTgtY(int value)
   {
      if (this.tgtY != value)
      {
         int oldValue = this.tgtY;
         this.tgtY = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_TGTY, oldValue, value);
      }
   }
   
   public Player withTgtY(int value)
   {
      setTgtY(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_INGOALSHOOTDISTANCE = "inGoalShootDistance";
   
   private boolean inGoalShootDistance;

   public boolean isInGoalShootDistance()
   {
      return this.inGoalShootDistance;
   }
   
   public void setInGoalShootDistance(boolean value)
   {
      if (this.inGoalShootDistance != value)
      {
         boolean oldValue = this.inGoalShootDistance;
         this.inGoalShootDistance = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_INGOALSHOOTDISTANCE, oldValue, value);
      }
   }
   
   public Player withInGoalShootDistance(boolean value)
   {
      setInGoalShootDistance(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_INPOSITION = "inPosition";
   
   private boolean inPosition;

   public boolean isInPosition()
   {
      return this.inPosition;
   }
   
   public void setInPosition(boolean value)
   {
      if (this.inPosition != value)
      {
         boolean oldValue = this.inPosition;
         this.inPosition = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_INPOSITION, oldValue, value);
      }
   }
   
   public Player withInPosition(boolean value)
   {
      setInPosition(value);
      return this;
   }

   public PlayerSet getReachablePlayers(PlayerSet myTeam, int hops)
   {
      PlayerSet reachables = new PlayerSet();

      if (hops == 0)
      {
         return reachables;
      }
      
      for (Player forward : myTeam)
      {
         if (forward instanceof GoalKeeper) continue;
         
         Field myField = this.getField();
         Field forwardField = forward.getField();
         
         if (ServerConnection.distance(forwardField, this.getField()) <= 7 && forwardField.getOpponentDistance() > 1)
         {
            reachables.with(forward);
            
            reachables.addAll(forward.getReachablePlayers(myTeam, hops-1));
         }
         else 
         {
            // compute pass to fields
            FieldSet shootableFields = getShootableFields();
            
            FieldSet runnableFields = getRunnableFields();
            
            FieldSet passToFields = shootableFields.intersection(runnableFields);
            
            if (passToFields.isEmpty() == false)
            {
               reachables.with(forward);
            }
         }
      }
      
      return reachables;
   }
   
   

   public FieldSet getShootableFields()
   {
      if (this.shootableFields == null)
      {
         Field myField = this.getField();

         this.shootableFields = pitch.getFields()
               .hasXPos(myField.getXPos()-7, myField.getXPos()+7)
               .hasYPos(myField.getYPos()-7, myField.getYPos()+7);
      }
      
      return this.shootableFields;
   } 

   public FieldSet getRunnableFields()
   {
      if (this.runnableFields == null)
      {
         Field myField = this.getField();

         int dist = 3;

         if (this.getBall() != null)
         {
            dist = 2;
         }

         this.runnableFields = pitch.getFields()
               .hasXPos(myField.getXPos()-dist, myField.getXPos()+dist)
               .hasYPos(myField.getYPos()-dist, myField.getYPos()+dist);
      }
      
      return this.runnableFields;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_ONSAVEFIELD = "onSaveField";
   
   private boolean onSaveField;

   public boolean isOnSaveField()
   {
      return this.onSaveField;
   }
   
   public void setOnSaveField(boolean value)
   {
      if (this.onSaveField != value)
      {
         boolean oldValue = this.onSaveField;
         this.onSaveField = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_ONSAVEFIELD, oldValue, value);
      }
   }
   
   public Player withOnSaveField(boolean value)
   {
      setOnSaveField(value);
      return this;
   }



   
   //==========================================================================
   
   public static final String PROPERTY_SHOOTABLEFIELDS = "shootableFields";
   
   private FieldSet shootableFields;

   public void setShootableFields(FieldSet value)
   {
      if (this.shootableFields != value)
      {
         FieldSet oldValue = this.shootableFields;
         this.shootableFields = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_SHOOTABLEFIELDS, oldValue, value);
      }
   }
   
   public Player withShootableFields(FieldSet value)
   {
      setShootableFields(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_RUNNABLEFIELDS = "runnableFields";
   
   private FieldSet runnableFields;

   public void setRunnableFields(FieldSet value)
   {
      if (this.runnableFields != value)
      {
         FieldSet oldValue = this.runnableFields;
         this.runnableFields = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_RUNNABLEFIELDS, oldValue, value);
      }
   }
   
   public Player withRunnableFields(FieldSet value)
   {
      setRunnableFields(value);
      return this;
   } 
}
