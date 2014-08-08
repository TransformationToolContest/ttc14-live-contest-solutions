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

public class Action implements PropertyChangeInterface
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
   
   public static final String PROPERTY_PLAYERNUMBER = "playerNumber";
   
   private int playerNumber;

   public int getPlayerNumber()
   {
      return this.playerNumber;
   }
   
   public void setPlayerNumber(int value)
   {
      if (this.playerNumber != value)
      {
         int oldValue = this.playerNumber;
         this.playerNumber = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYERNUMBER, oldValue, value);
      }
   }
   
   public Action withPlayerNumber(int value)
   {
      setPlayerNumber(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getPlayerNumber());
      result.append(" ").append(this.getXDist());
      result.append(" ").append(this.getYDist());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_XDIST = "xDist";
   
   private int xDist;

   public int getXDist()
   {
      return this.xDist;
   }
   
   public void setXDist(int value)
   {
      if (this.xDist != value)
      {
         int oldValue = this.xDist;
         this.xDist = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_XDIST, oldValue, value);
      }
   }
   
   public Action withXDist(int value)
   {
      setXDist(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_YDIST = "yDist";
   
   private int yDist;

   public int getYDist()
   {
      return this.yDist;
   }
   
   public void setYDist(int value)
   {
      if (this.yDist != value)
      {
         int oldValue = this.yDist;
         this.yDist = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_YDIST, oldValue, value);
      }
   }
   
   public Action withYDist(int value)
   {
      setYDist(value);
      return this;
   }

   public Action withXDist(int dist, int limit)
   {
      if (dist > limit)
      {
         dist = limit;
      }
      else if (dist < -limit)
      {
         dist = -limit;
      }
      
      return this.withXDist(dist);
   } 
   
   public Action withYDist(int dist, int limit)
   {
      if (dist > limit)
      {
         dist = limit;
      }
      else if (dist < -limit)
      {
         dist = -limit;
      }
      
      return this.withYDist(dist);
   } 
}
