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

import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;
import org.sdmlib.ttc2014livecase.soccerpitch.FieldPlayer;
import org.sdmlib.ttc2014livecase.soccerpitch.GoalKeeper;

public class Field implements PropertyChangeInterface
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
      setNorth(null);
      setSouth(null);
      setEast(null);
      setWest(null);
      withoutPlayers(this.getPlayers().toArray(new Player[this.getPlayers().size()]));
      setBall(null);
      setPitch(null);
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_XPOS = "xPos";
   
   private int xPos;

   public int getXPos()
   {
      return this.xPos;
   }
   
   public void setXPos(int value)
   {
      if (this.xPos != value)
      {
         int oldValue = this.xPos;
         this.xPos = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_XPOS, oldValue, value);
      }
   }
   
   public Field withXPos(int value)
   {
      setXPos(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getXPos());
      result.append(" ").append(this.getYPos());
      result.append(" ").append(this.getOpponentDistance());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_YPOS = "yPos";
   
   private int yPos;

   public int getYPos()
   {
      return this.yPos;
   }
   
   public void setYPos(int value)
   {
      if (this.yPos != value)
      {
         int oldValue = this.yPos;
         this.yPos = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_YPOS, oldValue, value);
      }
   }
   
   public Field withYPos(int value)
   {
      setYPos(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Field ----------------------------------- Field
    *              south                   north
    * </pre>
    */
   
   public static final String PROPERTY_NORTH = "north";

   private Field north = null;

   public Field getNorth()
   {
      return this.north;
   }
   public FieldSet getNorthTransitive()
   {
      FieldSet result = new FieldSet().with(this);
      return result.getNorthTransitive();
   }


   public boolean setNorth(Field value)
   {
      boolean changed = false;
      
      if (this.north != value)
      {
         Field oldValue = this.north;
         
         if (this.north != null)
         {
            this.north = null;
            oldValue.setSouth(null);
         }
         
         this.north = value;
         
         if (value != null)
         {
            value.withSouth(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_NORTH, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Field withNorth(Field value)
   {
      setNorth(value);
      return this;
   } 

   public Field createNorth()
   {
      Field value = new Field();
      withNorth(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Field ----------------------------------- Field
    *              north                   south
    * </pre>
    */
   
   public static final String PROPERTY_SOUTH = "south";

   private Field south = null;

   public Field getSouth()
   {
      return this.south;
   }
   public FieldSet getSouthTransitive()
   {
      FieldSet result = new FieldSet().with(this);
      return result.getSouthTransitive();
   }


   public boolean setSouth(Field value)
   {
      boolean changed = false;
      
      if (this.south != value)
      {
         Field oldValue = this.south;
         
         if (this.south != null)
         {
            this.south = null;
            oldValue.setNorth(null);
         }
         
         this.south = value;
         
         if (value != null)
         {
            value.withNorth(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_SOUTH, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Field withSouth(Field value)
   {
      setSouth(value);
      return this;
   } 

   public Field createSouth()
   {
      Field value = new Field();
      withSouth(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Field ----------------------------------- Field
    *              west                   east
    * </pre>
    */
   
   public static final String PROPERTY_EAST = "east";

   private Field east = null;

   public Field getEast()
   {
      return this.east;
   }
   public FieldSet getEastTransitive()
   {
      FieldSet result = new FieldSet().with(this);
      return result.getEastTransitive();
   }


   public boolean setEast(Field value)
   {
      boolean changed = false;
      
      if (this.east != value)
      {
         Field oldValue = this.east;
         
         if (this.east != null)
         {
            this.east = null;
            oldValue.setWest(null);
         }
         
         this.east = value;
         
         if (value != null)
         {
            value.withWest(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_EAST, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Field withEast(Field value)
   {
      setEast(value);
      return this;
   } 

   public Field createEast()
   {
      Field value = new Field();
      withEast(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Field ----------------------------------- Field
    *              east                   west
    * </pre>
    */
   
   public static final String PROPERTY_WEST = "west";

   private Field west = null;

   public Field getWest()
   {
      return this.west;
   }
   public FieldSet getWestTransitive()
   {
      FieldSet result = new FieldSet().with(this);
      return result.getWestTransitive();
   }


   public boolean setWest(Field value)
   {
      boolean changed = false;
      
      if (this.west != value)
      {
         Field oldValue = this.west;
         
         if (this.west != null)
         {
            this.west = null;
            oldValue.setEast(null);
         }
         
         this.west = value;
         
         if (value != null)
         {
            value.withEast(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_WEST, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Field withWest(Field value)
   {
      setWest(value);
      return this;
   } 

   public Field createWest()
   {
      Field value = new Field();
      withWest(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Field ----------------------------------- Player
    *              field                   players
    * </pre>
    */
   
   public static final String PROPERTY_PLAYERS = "players";

   private PlayerSet players = null;
   
   public PlayerSet getPlayers()
   {
      if (this.players == null)
      {
         return Player.EMPTY_SET;
      }
   
      return this.players;
   }

   public Field withPlayers(Player... value)
   {
      if(value==null){
         return this;
      }
      for (Player item : value)
      {
         if (item != null)
         {
            if (this.players == null)
            {
               this.players = new PlayerSet();
            }
            
            boolean changed = this.players.add (item);

            if (changed)
            {
               item.withField(this);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYERS, null, item);
            }
         }
      }
      return this;
   } 

   public Field withoutPlayers(Player... value)
   {
      for (Player item : value)
      {
         if ((this.players != null) && (item != null))
         {
            if (this.players.remove(item))
            {
               item.setField(null);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYERS, item, null);
            }
         }
      }
      return this;
   }

   public Player createPlayers()
   {
      Player value = new Player();
      withPlayers(value);
      return value;
   } 

   public FieldPlayer createPlayersFieldPlayer()
   {
      FieldPlayer value = new FieldPlayer();
      withPlayers(value);
      return value;
   } 

   public GoalKeeper createPlayersGoalKeeper()
   {
      GoalKeeper value = new GoalKeeper();
      withPlayers(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Field ----------------------------------- Ball
    *              field                   ball
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
            oldValue.setField(null);
         }
         
         this.ball = value;
         
         if (value != null)
         {
            value.withField(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_BALL, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Field withBall(Ball value)
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

   
   public static final FieldSet EMPTY_SET = new FieldSet().withReadonly(true);

   
   /********************************************************************
    * <pre>
    *              many                       one
    * Field ----------------------------------- SoccerPitch
    *              fields                   pitch
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
            oldValue.withoutFields(this);
         }
         
         this.pitch = value;
         
         if (value != null)
         {
            value.withFields(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PITCH, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Field withPitch(SoccerPitch value)
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

   
   //==========================================================================
   
   public static final String PROPERTY_OPPONENTDISTANCE = "opponentDistance";
   
   private int opponentDistance = 999;

   public int getOpponentDistance()
   {
      return this.opponentDistance;
   }
   
   public void setOpponentDistance(int value)
   {
      if (this.opponentDistance != value)
      {
         int oldValue = this.opponentDistance;
         this.opponentDistance = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_OPPONENTDISTANCE, oldValue, value);
      }
   }
   
   public Field withOpponentDistance(int value)
   {
      setOpponentDistance(value);
      return this;
   } 
}
