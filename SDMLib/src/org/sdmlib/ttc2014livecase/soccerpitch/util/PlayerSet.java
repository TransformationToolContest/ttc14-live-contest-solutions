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

import org.sdmlib.models.modelsets.SDMSet;

import java.util.Collection;

import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchSet;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import org.sdmlib.models.modelsets.booleanList;

public class PlayerSet extends SDMSet<Player>
{


   public PlayerPO hasPlayerPO()
   {
      return new PlayerPO(this.toArray(new Player[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.ttc2014livecase.model.Player";
   }


   @SuppressWarnings("unchecked")
   public PlayerSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Player>)value);
      }
      else if (value != null)
      {
         this.add((Player) value);
      }
      
      return this;
   }
   
   public PlayerSet without(Player value)
   {
      this.remove(value);
      return this;
   }

   public StringList getTeam()
   {
      StringList result = new StringList();
      
      for (Player obj : this)
      {
         result.add(obj.getTeam());
      }
      
      return result;
   }

   public PlayerSet hasTeam(String value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value.equals(obj.getTeam()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet hasTeam(String lower, String upper)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (lower.compareTo(obj.getTeam()) <= 0 && obj.getTeam().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withTeam(String value)
   {
      for (Player obj : this)
      {
         obj.setTeam(value);
      }
      
      return this;
   }

   public intList getNumber()
   {
      intList result = new intList();
      
      for (Player obj : this)
      {
         result.add(obj.getNumber());
      }
      
      return result;
   }

   public PlayerSet hasNumber(int value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.getNumber())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet hasNumber(int lower, int upper)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (lower <= obj.getNumber() && obj.getNumber() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withNumber(int value)
   {
      for (Player obj : this)
      {
         obj.setNumber(value);
      }
      
      return this;
   }

   public FieldSet getField()
   {
      FieldSet result = new FieldSet();
      
      for (Player obj : this)
      {
         result.add(obj.getField());
      }
      
      return result;
   }

   public PlayerSet hasField(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getField()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public PlayerSet withField(Field value)
   {
      for (Player obj : this)
      {
         obj.withField(value);
      }
      
      return this;
   }

   public BallSet getBall()
   {
      BallSet result = new BallSet();
      
      for (Player obj : this)
      {
         result.add(obj.getBall());
      }
      
      return result;
   }

   public PlayerSet hasBall(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getBall()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public PlayerSet withBall(Ball value)
   {
      for (Player obj : this)
      {
         obj.withBall(value);
      }
      
      return this;
   }

   public SoccerPitchSet getPitch()
   {
      SoccerPitchSet result = new SoccerPitchSet();
      
      for (Player obj : this)
      {
         result.add(obj.getPitch());
      }
      
      return result;
   }

   public PlayerSet hasPitch(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getPitch()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public PlayerSet withPitch(SoccerPitch value)
   {
      for (Player obj : this)
      {
         obj.withPitch(value);
      }
      
      return this;
   }

   public intList getTackleDistance()
   {
      intList result = new intList();
      
      for (Player obj : this)
      {
         result.add(obj.getTackleDistance());
      }
      
      return result;
   }

   public PlayerSet hasTackleDistance(int value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.getTackleDistance())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet hasTackleDistance(int lower, int upper)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (lower <= obj.getTackleDistance() && obj.getTackleDistance() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withTackleDistance(int value)
   {
      for (Player obj : this)
      {
         obj.setTackleDistance(value);
      }
      
      return this;
   }

   public intList getTgtX()
   {
      intList result = new intList();
      
      for (Player obj : this)
      {
         result.add(obj.getTgtX());
      }
      
      return result;
   }

   public PlayerSet hasTgtX(int value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.getTgtX())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet hasTgtX(int lower, int upper)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (lower <= obj.getTgtX() && obj.getTgtX() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withTgtX(int value)
   {
      for (Player obj : this)
      {
         obj.setTgtX(value);
      }
      
      return this;
   }

   public intList getTgtY()
   {
      intList result = new intList();
      
      for (Player obj : this)
      {
         result.add(obj.getTgtY());
      }
      
      return result;
   }

   public PlayerSet hasTgtY(int value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.getTgtY())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet hasTgtY(int lower, int upper)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (lower <= obj.getTgtY() && obj.getTgtY() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withTgtY(int value)
   {
      for (Player obj : this)
      {
         obj.setTgtY(value);
      }
      
      return this;
   }

   public booleanList getInGoalShootDistance()
   {
      booleanList result = new booleanList();
      
      for (Player obj : this)
      {
         result.add(obj.isInGoalShootDistance());
      }
      
      return result;
   }

   public PlayerSet hasInGoalShootDistance(boolean value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.isInGoalShootDistance())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withInGoalShootDistance(boolean value)
   {
      for (Player obj : this)
      {
         obj.setInGoalShootDistance(value);
      }
      
      return this;
   }

   public booleanList getInPosition()
   {
      booleanList result = new booleanList();
      
      for (Player obj : this)
      {
         result.add(obj.isInPosition());
      }
      
      return result;
   }

   public PlayerSet hasInPosition(boolean value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.isInPosition())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withInPosition(boolean value)
   {
      for (Player obj : this)
      {
         obj.setInPosition(value);
      }
      
      return this;
   }

   public booleanList getOnSaveField()
   {
      booleanList result = new booleanList();
      
      for (Player obj : this)
      {
         result.add(obj.isOnSaveField());
      }
      
      return result;
   }

   public PlayerSet hasOnSaveField(boolean value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.isOnSaveField())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withOnSaveField(boolean value)
   {
      for (Player obj : this)
      {
         obj.setOnSaveField(value);
      }
      
      return this;
   }

   public FieldSet getShootableFields()
   {
      FieldSet result = new FieldSet();
      
      for (Player obj : this)
      {
         result.addAll(obj.getShootableFields());
      }
      
      return result;
   }

   public PlayerSet hasShootableFields(FieldSet value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.getShootableFields())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withShootableFields(FieldSet value)
   {
      for (Player obj : this)
      {
         obj.setShootableFields(value);
      }
      
      return this;
   }

   public FieldSet getRunnableFields()
   {
      FieldSet result = new FieldSet();
      
      for (Player obj : this)
      {
         result.addAll(obj.getRunnableFields());
      }
      
      return result;
   }

   public PlayerSet hasRunnableFields(FieldSet value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value == obj.getRunnableFields())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public PlayerSet withRunnableFields(FieldSet value)
   {
      for (Player obj : this)
      {
         obj.setRunnableFields(value);
      }
      
      return this;
   }

}
