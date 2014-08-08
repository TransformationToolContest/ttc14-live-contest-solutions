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

import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.StrUtil;

public class GoalField extends Field
{

   
   //==========================================================================
   
   @Override
   public void removeYou()
   {
      super.removeYou();

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
   
   public static final String PROPERTY_TEAM = "team";
   
   private String team;

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
   
   public GoalField withTeam(String value)
   {
      setTeam(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getTeam());
      result.append(" ").append(this.getXPos());
      result.append(" ").append(this.getYPos());
      result.append(" ").append(this.getOpponentDistance());
      return result.substring(1);
   }

}
