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
import org.sdmlib.ttc2014livecase.soccerpitch.GoalKeeper;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchSet;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import org.sdmlib.models.modelsets.booleanList;

public class GoalKeeperSet extends SDMSet<GoalKeeper>
{


   public GoalKeeperPO hasGoalKeeperPO()
   {
      return new GoalKeeperPO(this.toArray(new GoalKeeper[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.ttc2014livecase.model.GoalKeeper";
   }


   @SuppressWarnings("unchecked")
   public GoalKeeperSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<GoalKeeper>)value);
      }
      else if (value != null)
      {
         this.add((GoalKeeper) value);
      }
      
      return this;
   }
   
   public GoalKeeperSet without(GoalKeeper value)
   {
      this.remove(value);
      return this;
   }

   public StringList getTeam()
   {
      StringList result = new StringList();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.getTeam());
      }
      
      return result;
   }

   public GoalKeeperSet hasTeam(String value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value.equals(obj.getTeam()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet hasTeam(String lower, String upper)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (lower.compareTo(obj.getTeam()) <= 0 && obj.getTeam().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withTeam(String value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setTeam(value);
      }
      
      return this;
   }

   public intList getNumber()
   {
      intList result = new intList();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.getNumber());
      }
      
      return result;
   }

   public GoalKeeperSet hasNumber(int value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.getNumber())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet hasNumber(int lower, int upper)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (lower <= obj.getNumber() && obj.getNumber() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withNumber(int value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setNumber(value);
      }
      
      return this;
   }

   public FieldSet getField()
   {
      FieldSet result = new FieldSet();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.getField());
      }
      
      return result;
   }

   public GoalKeeperSet hasField(Object value)
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
      
      GoalKeeperSet answer = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (neighbors.contains(obj.getField()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public GoalKeeperSet withField(Field value)
   {
      for (GoalKeeper obj : this)
      {
         obj.withField(value);
      }
      
      return this;
   }

   public BallSet getBall()
   {
      BallSet result = new BallSet();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.getBall());
      }
      
      return result;
   }

   public GoalKeeperSet hasBall(Object value)
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
      
      GoalKeeperSet answer = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (neighbors.contains(obj.getBall()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public GoalKeeperSet withBall(Ball value)
   {
      for (GoalKeeper obj : this)
      {
         obj.withBall(value);
      }
      
      return this;
   }

   public SoccerPitchSet getPitch()
   {
      SoccerPitchSet result = new SoccerPitchSet();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.getPitch());
      }
      
      return result;
   }

   public GoalKeeperSet hasPitch(Object value)
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
      
      GoalKeeperSet answer = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (neighbors.contains(obj.getPitch()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public GoalKeeperSet withPitch(SoccerPitch value)
   {
      for (GoalKeeper obj : this)
      {
         obj.withPitch(value);
      }
      
      return this;
   }

   public intList getTackleDistance()
   {
      intList result = new intList();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.getTackleDistance());
      }
      
      return result;
   }

   public GoalKeeperSet hasTackleDistance(int value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.getTackleDistance())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet hasTackleDistance(int lower, int upper)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (lower <= obj.getTackleDistance() && obj.getTackleDistance() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withTackleDistance(int value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setTackleDistance(value);
      }
      
      return this;
   }

   public intList getTgtX()
   {
      intList result = new intList();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.getTgtX());
      }
      
      return result;
   }

   public GoalKeeperSet hasTgtX(int value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.getTgtX())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet hasTgtX(int lower, int upper)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (lower <= obj.getTgtX() && obj.getTgtX() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withTgtX(int value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setTgtX(value);
      }
      
      return this;
   }

   public intList getTgtY()
   {
      intList result = new intList();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.getTgtY());
      }
      
      return result;
   }

   public GoalKeeperSet hasTgtY(int value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.getTgtY())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet hasTgtY(int lower, int upper)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (lower <= obj.getTgtY() && obj.getTgtY() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withTgtY(int value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setTgtY(value);
      }
      
      return this;
   }

   public booleanList getInGoalShootDistance()
   {
      booleanList result = new booleanList();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.isInGoalShootDistance());
      }
      
      return result;
   }

   public GoalKeeperSet hasInGoalShootDistance(boolean value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.isInGoalShootDistance())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withInGoalShootDistance(boolean value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setInGoalShootDistance(value);
      }
      
      return this;
   }

   public booleanList getInPosition()
   {
      booleanList result = new booleanList();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.isInPosition());
      }
      
      return result;
   }

   public GoalKeeperSet hasInPosition(boolean value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.isInPosition())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withInPosition(boolean value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setInPosition(value);
      }
      
      return this;
   }

   public booleanList getOnSaveField()
   {
      booleanList result = new booleanList();
      
      for (GoalKeeper obj : this)
      {
         result.add(obj.isOnSaveField());
      }
      
      return result;
   }

   public GoalKeeperSet hasOnSaveField(boolean value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.isOnSaveField())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withOnSaveField(boolean value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setOnSaveField(value);
      }
      
      return this;
   }

   public FieldSet getShootableFields()
   {
      FieldSet result = new FieldSet();
      
      for (GoalKeeper obj : this)
      {
         result.addAll(obj.getShootableFields());
      }
      
      return result;
   }

   public GoalKeeperSet hasShootableFields(FieldSet value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.getShootableFields())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withShootableFields(FieldSet value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setShootableFields(value);
      }
      
      return this;
   }

   public FieldSet getRunnableFields()
   {
      FieldSet result = new FieldSet();
      
      for (GoalKeeper obj : this)
      {
         result.addAll(obj.getRunnableFields());
      }
      
      return result;
   }

   public GoalKeeperSet hasRunnableFields(FieldSet value)
   {
      GoalKeeperSet result = new GoalKeeperSet();
      
      for (GoalKeeper obj : this)
      {
         if (value == obj.getRunnableFields())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public GoalKeeperSet withRunnableFields(FieldSet value)
   {
      for (GoalKeeper obj : this)
      {
         obj.setRunnableFields(value);
      }
      
      return this;
   }

}
