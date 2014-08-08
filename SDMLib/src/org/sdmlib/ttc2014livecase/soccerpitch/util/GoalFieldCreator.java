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
import org.sdmlib.ttc2014livecase.soccerpitch.GoalField;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;

public class GoalFieldCreator extends EntityFactory
{
   private final String[] properties = new String[]
   {
      GoalField.PROPERTY_TEAM,
      Field.PROPERTY_XPOS,
      Field.PROPERTY_YPOS,
      Field.PROPERTY_NORTH,
      Field.PROPERTY_SOUTH,
      Field.PROPERTY_EAST,
      Field.PROPERTY_WEST,
      Field.PROPERTY_PLAYERS,
      Field.PROPERTY_BALL,
      Field.PROPERTY_PITCH,
      Field.PROPERTY_OPPONENTDISTANCE,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new GoalField();
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

      if (GoalField.PROPERTY_TEAM.equalsIgnoreCase(attribute))
      {
         return ((GoalField) target).getTeam();
      }

      if (Field.PROPERTY_XPOS.equalsIgnoreCase(attribute))
      {
         return ((Field) target).getXPos();
      }

      if (Field.PROPERTY_YPOS.equalsIgnoreCase(attribute))
      {
         return ((Field) target).getYPos();
      }

      if (GoalField.PROPERTY_NORTH.equalsIgnoreCase(attribute))
      {
         return ((GoalField) target).getNorth();
      }

      if (GoalField.PROPERTY_SOUTH.equalsIgnoreCase(attribute))
      {
         return ((GoalField) target).getSouth();
      }

      if (GoalField.PROPERTY_EAST.equalsIgnoreCase(attribute))
      {
         return ((GoalField) target).getEast();
      }

      if (GoalField.PROPERTY_WEST.equalsIgnoreCase(attribute))
      {
         return ((GoalField) target).getWest();
      }

      if (GoalField.PROPERTY_PLAYERS.equalsIgnoreCase(attribute))
      {
         return ((GoalField) target).getPlayers();
      }

      if (GoalField.PROPERTY_BALL.equalsIgnoreCase(attribute))
      {
         return ((GoalField) target).getBall();
      }

      if (GoalField.PROPERTY_PITCH.equalsIgnoreCase(attribute))
      {
         return ((GoalField) target).getPitch();
      }

      if (Field.PROPERTY_OPPONENTDISTANCE.equalsIgnoreCase(attribute))
      {
         return ((Field) target).getOpponentDistance();
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

      if (GoalField.PROPERTY_TEAM.equalsIgnoreCase(attrName))
      {
         ((GoalField) target).withTeam((String) value);
         return true;
      }

      if (Field.PROPERTY_XPOS.equalsIgnoreCase(attrName))
      {
         ((Field) target).withXPos(Integer.parseInt(value.toString()));
         return true;
      }

      if (Field.PROPERTY_YPOS.equalsIgnoreCase(attrName))
      {
         ((Field) target).withYPos(Integer.parseInt(value.toString()));
         return true;
      }

      if (GoalField.PROPERTY_NORTH.equalsIgnoreCase(attrName))
      {
         ((GoalField) target).setNorth((Field) value);
         return true;
      }

      if (GoalField.PROPERTY_SOUTH.equalsIgnoreCase(attrName))
      {
         ((GoalField) target).setSouth((Field) value);
         return true;
      }

      if (GoalField.PROPERTY_EAST.equalsIgnoreCase(attrName))
      {
         ((GoalField) target).setEast((Field) value);
         return true;
      }

      if (GoalField.PROPERTY_WEST.equalsIgnoreCase(attrName))
      {
         ((GoalField) target).setWest((Field) value);
         return true;
      }

      if (GoalField.PROPERTY_PLAYERS.equalsIgnoreCase(attrName))
      {
         ((GoalField) target).withPlayers((Player) value);
         return true;
      }
      
      if ((GoalField.PROPERTY_PLAYERS + JsonIdMap.REMOVE).equalsIgnoreCase(attrName))
      {
         ((GoalField) target).withoutPlayers((Player) value);
         return true;
      }

      if (GoalField.PROPERTY_BALL.equalsIgnoreCase(attrName))
      {
         ((GoalField) target).setBall((Ball) value);
         return true;
      }

      if (GoalField.PROPERTY_PITCH.equalsIgnoreCase(attrName))
      {
         ((GoalField) target).setPitch((SoccerPitch) value);
         return true;
      }

      if (Field.PROPERTY_OPPONENTDISTANCE.equalsIgnoreCase(attrName))
      {
         ((Field) target).withOpponentDistance(Integer.parseInt(value.toString()));
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
      ((GoalField) entity).removeYou();
   }
}
