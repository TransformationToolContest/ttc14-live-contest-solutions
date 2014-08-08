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

public class PlayerCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      Player.PROPERTY_TEAM,
      Player.PROPERTY_NUMBER,
      Player.PROPERTY_FIELD,
      Player.PROPERTY_BALL,
      Player.PROPERTY_PITCH,
      Player.PROPERTY_TACKLEDISTANCE,
      Player.PROPERTY_TGTX,
      Player.PROPERTY_TGTY,
      Player.PROPERTY_INGOALSHOOTDISTANCE,
      Player.PROPERTY_INPOSITION,
      Player.PROPERTY_ONSAVEFIELD,
      Player.PROPERTY_SHOOTABLEFIELDS,
      Player.PROPERTY_RUNNABLEFIELDS,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Player();
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

      if (Player.PROPERTY_TEAM.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getTeam();
      }

      if (Player.PROPERTY_NUMBER.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getNumber();
      }

      if (Player.PROPERTY_FIELD.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getField();
      }

      if (Player.PROPERTY_BALL.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getBall();
      }

      if (Player.PROPERTY_PITCH.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getPitch();
      }

      if (Player.PROPERTY_TACKLEDISTANCE.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getTackleDistance();
      }

      if (Player.PROPERTY_TGTX.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getTgtX();
      }

      if (Player.PROPERTY_TGTY.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getTgtY();
      }

      if (Player.PROPERTY_INGOALSHOOTDISTANCE.equalsIgnoreCase(attribute))
      {
         return ((Player) target).isInGoalShootDistance();
      }

      if (Player.PROPERTY_INPOSITION.equalsIgnoreCase(attribute))
      {
         return ((Player) target).isInPosition();
      }

      if (Player.PROPERTY_ONSAVEFIELD.equalsIgnoreCase(attribute))
      {
         return ((Player) target).isOnSaveField();
      }

      if (Player.PROPERTY_SHOOTABLEFIELDS.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getShootableFields();
      }

      if (Player.PROPERTY_RUNNABLEFIELDS.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getRunnableFields();
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

      if (Player.PROPERTY_TEAM.equalsIgnoreCase(attrName))
      {
         ((Player) target).withTeam((String) value);
         return true;
      }

      if (Player.PROPERTY_NUMBER.equalsIgnoreCase(attrName))
      {
         ((Player) target).withNumber(Integer.parseInt(value.toString()));
         return true;
      }

      if (Player.PROPERTY_FIELD.equalsIgnoreCase(attrName))
      {
         ((Player) target).setField((Field) value);
         return true;
      }

      if (Player.PROPERTY_BALL.equalsIgnoreCase(attrName))
      {
         ((Player) target).setBall((Ball) value);
         return true;
      }

      if (Player.PROPERTY_PITCH.equalsIgnoreCase(attrName))
      {
         ((Player) target).setPitch((SoccerPitch) value);
         return true;
      }

      if (Player.PROPERTY_TACKLEDISTANCE.equalsIgnoreCase(attrName))
      {
         ((Player) target).withTackleDistance(Integer.parseInt(value.toString()));
         return true;
      }

      if (Player.PROPERTY_TGTX.equalsIgnoreCase(attrName))
      {
         ((Player) target).withTgtX(Integer.parseInt(value.toString()));
         return true;
      }

      if (Player.PROPERTY_TGTY.equalsIgnoreCase(attrName))
      {
         ((Player) target).withTgtY(Integer.parseInt(value.toString()));
         return true;
      }

      if (Player.PROPERTY_INGOALSHOOTDISTANCE.equalsIgnoreCase(attrName))
      {
         ((Player) target).withInGoalShootDistance((Boolean) value);
         return true;
      }

      if (Player.PROPERTY_INPOSITION.equalsIgnoreCase(attrName))
      {
         ((Player) target).withInPosition((Boolean) value);
         return true;
      }

      if (Player.PROPERTY_ONSAVEFIELD.equalsIgnoreCase(attrName))
      {
         ((Player) target).withOnSaveField((Boolean) value);
         return true;
      }

      if (Player.PROPERTY_SHOOTABLEFIELDS.equalsIgnoreCase(attrName))
      {
         ((Player) target).withShootableFields((FieldSet) value);
         return true;
      }

      if (Player.PROPERTY_RUNNABLEFIELDS.equalsIgnoreCase(attrName))
      {
         ((Player) target).withRunnableFields((FieldSet) value);
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
      ((Player) entity).removeYou();
   }
}
