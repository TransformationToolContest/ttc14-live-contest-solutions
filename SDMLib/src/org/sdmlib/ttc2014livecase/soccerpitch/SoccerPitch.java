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
import org.sdmlib.ttc2014livecase.soccerpitch.GoalField;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.FieldPlayer;
import org.sdmlib.ttc2014livecase.soccerpitch.GoalKeeper;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;

public class SoccerPitch implements PropertyChangeInterface
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
      withoutFields(this.getFields().toArray(new Field[this.getFields().size()]));
      setBall(null);
      withoutPlayers(this.getPlayers().toArray(new Player[this.getPlayers().size()]));
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   /********************************************************************
    * <pre>
    *              one                       many
    * SoccerPitch ----------------------------------- Field
    *              pitch                   fields
    * </pre>
    */
   
   public static final String PROPERTY_FIELDS = "fields";

   private FieldSet fields = null;
   
   public FieldSet getFields()
   {
      if (this.fields == null)
      {
         return Field.EMPTY_SET;
      }
   
      return this.fields;
   }

   public SoccerPitch withFields(Field... value)
   {
      if(value==null){
         return this;
      }
      for (Field item : value)
      {
         if (item != null)
         {
            if (this.fields == null)
            {
               this.fields = new FieldSet();
            }
            
            boolean changed = this.fields.add (item);

            if (changed)
            {
               item.withPitch(this);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_FIELDS, null, item);
            }
         }
      }
      return this;
   } 

   public SoccerPitch withoutFields(Field... value)
   {
      for (Field item : value)
      {
         if ((this.fields != null) && (item != null))
         {
            if (this.fields.remove(item))
            {
               item.setPitch(null);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_FIELDS, item, null);
            }
         }
      }
      return this;
   }

   public Field createFields()
   {
      Field value = new Field();
      withFields(value);
      return value;
   } 

   public GoalField createFieldsGoalField()
   {
      GoalField value = new GoalField();
      withFields(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * SoccerPitch ----------------------------------- Ball
    *              pitch                   ball
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
            oldValue.setPitch(null);
         }
         
         this.ball = value;
         
         if (value != null)
         {
            value.withPitch(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_BALL, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public SoccerPitch withBall(Ball value)
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
    *              one                       many
    * SoccerPitch ----------------------------------- Player
    *              pitch                   players
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

   public SoccerPitch withPlayers(Player... value)
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
               item.withPitch(this);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYERS, null, item);
            }
         }
      }
      return this;
   } 

   public SoccerPitch withoutPlayers(Player... value)
   {
      for (Player item : value)
      {
         if ((this.players != null) && (item != null))
         {
            if (this.players.remove(item))
            {
               item.setPitch(null);
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

   public Field getField(int xPos, int yPos)
   {
      for (Field field : fields)
      {
         if (field.getXPos() == xPos && field.getYPos() == yPos)
         {
            return field;
         }
      }
      return null;
   } 
}
