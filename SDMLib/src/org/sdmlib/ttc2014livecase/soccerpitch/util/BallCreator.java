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
   
package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.serialization.EntityFactory;

import de.uniks.networkparser.json.JsonIdMap;

import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;

public class BallCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      Ball.PROPERTY_FIELD,
      Ball.PROPERTY_PLAYER,
      Ball.PROPERTY_PITCH,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Ball();
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

      if (Ball.PROPERTY_FIELD.equalsIgnoreCase(attribute))
      {
         return ((Ball) target).getField();
      }

      if (Ball.PROPERTY_PLAYER.equalsIgnoreCase(attribute))
      {
         return ((Ball) target).getPlayer();
      }

      if (Ball.PROPERTY_PITCH.equalsIgnoreCase(attribute))
      {
         return ((Ball) target).getPitch();
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

      if (Ball.PROPERTY_FIELD.equalsIgnoreCase(attrName))
      {
         ((Ball) target).setField((Field) value);
         return true;
      }

      if (Ball.PROPERTY_PLAYER.equalsIgnoreCase(attrName))
      {
         ((Ball) target).setPlayer((Player) value);
         return true;
      }

      if (Ball.PROPERTY_PITCH.equalsIgnoreCase(attrName))
      {
         ((Ball) target).setPitch((SoccerPitch) value);
         return true;
      }
      
      return false;
   }
   public static JsonIdMap createIdMap(String sessionID)
   {
      return org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
   
   @Override
   public void removeObject(Object entity)
   {
      ((Ball) entity).removeYou();
   }
}
