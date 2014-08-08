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

public class Ball implements PropertyChangeInterface
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
      setPlayer(null);
      setPitch(null);
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Ball ----------------------------------- Field
    *              ball                   field
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
            oldValue.setBall(null);
         }
         
         this.field = value;
         
         if (value != null)
         {
            value.withBall(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_FIELD, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Ball withField(Field value)
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
    * Ball ----------------------------------- Player
    *              ball                   player
    * </pre>
    */
   
   public static final String PROPERTY_PLAYER = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public boolean setPlayer(Player value)
   {
      boolean changed = false;
      
      if (this.player != value)
      {
         Player oldValue = this.player;
         
         if (this.player != null)
         {
            this.player = null;
            oldValue.setBall(null);
         }
         
         this.player = value;
         
         if (value != null)
         {
            value.withBall(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Ball withPlayer(Player value)
   {
      setPlayer(value);
      return this;
   } 

   public Player createPlayer()
   {
      Player value = new Player();
      withPlayer(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Ball ----------------------------------- SoccerPitch
    *              ball                   pitch
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
            oldValue.setBall(null);
         }
         
         this.pitch = value;
         
         if (value != null)
         {
            value.withBall(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PITCH, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Ball withPitch(SoccerPitch value)
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
}
