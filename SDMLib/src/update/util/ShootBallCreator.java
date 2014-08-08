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
   
package update.util;

import org.sdmlib.serialization.EntityFactory;

import de.uniks.networkparser.json.JsonIdMap;
import update.Action;
import update.ShootBall;

public class ShootBallCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      Action.PROPERTY_PLAYERNUMBER,
      Action.PROPERTY_XDIST,
      Action.PROPERTY_YDIST,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new ShootBall();
   }
   
   @Override
   public Object getValue(Object target, String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (Action.PROPERTY_PLAYERNUMBER.equalsIgnoreCase(attribute))
      {
         return ((Action) target).getPlayerNumber();
      }

      if (Action.PROPERTY_XDIST.equalsIgnoreCase(attribute))
      {
         return ((Action) target).getXDist();
      }

      if (Action.PROPERTY_YDIST.equalsIgnoreCase(attribute))
      {
         return ((Action) target).getYDist();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (JsonIdMap.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Action.PROPERTY_PLAYERNUMBER.equalsIgnoreCase(attrName))
      {
         ((Action) target).withPlayerNumber(Integer.parseInt(value.toString()));
         return true;
      }

      if (Action.PROPERTY_XDIST.equalsIgnoreCase(attrName))
      {
         ((Action) target).withXDist(Integer.parseInt(value.toString()));
         return true;
      }

      if (Action.PROPERTY_YDIST.equalsIgnoreCase(attrName))
      {
         ((Action) target).withYDist(Integer.parseInt(value.toString()));
         return true;
      }
      
      return false;
   }
   public static JsonIdMap createIdMap(String sessionID)
   {
      return update.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
   
   @Override
   public void removeObject(Object entity)
   {
      ((ShootBall) entity).removeYou();
   }
}
