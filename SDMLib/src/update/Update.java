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
   
package update;

import org.sdmlib.serialization.PropertyChangeInterface;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import update.util.ActionSet;

public class Update implements PropertyChangeInterface
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
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_ACTIONS = "actions";
   
   private ActionSet actions = new ActionSet();

   public ActionSet getActions()
   {
      return this.actions;
   }
   
   public void setActions(ActionSet value)
   {
      if (this.actions != value)
      {
         ActionSet oldValue = this.actions;
         this.actions = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_ACTIONS, oldValue, value);
      }
   }
   
   public Update withActions(ActionSet value)
   {
      setActions(value);
      return this;
   }

   public MovePlayer createMoveAction()
   {
      MovePlayer movePlayer = new MovePlayer();
      this.withAction(movePlayer);
      return movePlayer;
   }

   public ShootBall createShootBall()
   {
      ShootBall action = new ShootBall();
      this.withAction(action);
      return action;
   }
   
   private Update withAction(Action action)
   {
      this.getActions().add(action);
      return this;
   } 
   
   
}
