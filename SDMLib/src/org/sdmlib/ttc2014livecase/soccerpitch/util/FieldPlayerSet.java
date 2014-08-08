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
import org.sdmlib.ttc2014livecase.soccerpitch.FieldPlayer;
import java.util.Collection;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallSet;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchSet;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import org.sdmlib.models.modelsets.booleanList;

public class FieldPlayerSet extends SDMSet<FieldPlayer>
{


   public FieldPlayerPO hasFieldPlayerPO()
   {
      return new FieldPlayerPO(this.toArray(new FieldPlayer[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.ttc2014livecase.soccerpitch.FieldPlayer";
   }


   @SuppressWarnings("unchecked")
   public FieldPlayerSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<FieldPlayer>)value);
      }
      else if (value != null)
      {
         this.add((FieldPlayer) value);
      }
      
      return this;
   }
   
   public FieldPlayerSet without(FieldPlayer value)
   {
      this.remove(value);
      return this;
   }

   public StringList getTeam()
   {
      StringList result = new StringList();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.getTeam());
      }
      
      return result;
   }

   public FieldPlayerSet hasTeam(String value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value.equals(obj.getTeam()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet hasTeam(String lower, String upper)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (lower.compareTo(obj.getTeam()) <= 0 && obj.getTeam().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withTeam(String value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setTeam(value);
      }
      
      return this;
   }

   public intList getNumber()
   {
      intList result = new intList();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.getNumber());
      }
      
      return result;
   }

   public FieldPlayerSet hasNumber(int value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.getNumber())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet hasNumber(int lower, int upper)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (lower <= obj.getNumber() && obj.getNumber() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withNumber(int value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setNumber(value);
      }
      
      return this;
   }

   public intList getTackleDistance()
   {
      intList result = new intList();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.getTackleDistance());
      }
      
      return result;
   }

   public FieldPlayerSet hasTackleDistance(int value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.getTackleDistance())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet hasTackleDistance(int lower, int upper)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (lower <= obj.getTackleDistance() && obj.getTackleDistance() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withTackleDistance(int value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setTackleDistance(value);
      }
      
      return this;
   }

   public FieldSet getField()
   {
      FieldSet result = new FieldSet();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.getField());
      }
      
      return result;
   }

   public FieldPlayerSet hasField(Object value)
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
      
      FieldPlayerSet answer = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (neighbors.contains(obj.getField()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public FieldPlayerSet withField(Field value)
   {
      for (FieldPlayer obj : this)
      {
         obj.withField(value);
      }
      
      return this;
   }

   public BallSet getBall()
   {
      BallSet result = new BallSet();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.getBall());
      }
      
      return result;
   }

   public FieldPlayerSet hasBall(Object value)
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
      
      FieldPlayerSet answer = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (neighbors.contains(obj.getBall()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public FieldPlayerSet withBall(Ball value)
   {
      for (FieldPlayer obj : this)
      {
         obj.withBall(value);
      }
      
      return this;
   }

   public SoccerPitchSet getPitch()
   {
      SoccerPitchSet result = new SoccerPitchSet();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.getPitch());
      }
      
      return result;
   }

   public FieldPlayerSet hasPitch(Object value)
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
      
      FieldPlayerSet answer = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (neighbors.contains(obj.getPitch()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public FieldPlayerSet withPitch(SoccerPitch value)
   {
      for (FieldPlayer obj : this)
      {
         obj.withPitch(value);
      }
      
      return this;
   }

   public intList getTgtX()
   {
      intList result = new intList();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.getTgtX());
      }
      
      return result;
   }

   public FieldPlayerSet hasTgtX(int value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.getTgtX())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet hasTgtX(int lower, int upper)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (lower <= obj.getTgtX() && obj.getTgtX() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withTgtX(int value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setTgtX(value);
      }
      
      return this;
   }

   public intList getTgtY()
   {
      intList result = new intList();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.getTgtY());
      }
      
      return result;
   }

   public FieldPlayerSet hasTgtY(int value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.getTgtY())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet hasTgtY(int lower, int upper)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (lower <= obj.getTgtY() && obj.getTgtY() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withTgtY(int value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setTgtY(value);
      }
      
      return this;
   }

   public booleanList getInGoalShootDistance()
   {
      booleanList result = new booleanList();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.isInGoalShootDistance());
      }
      
      return result;
   }

   public FieldPlayerSet hasInGoalShootDistance(boolean value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.isInGoalShootDistance())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withInGoalShootDistance(boolean value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setInGoalShootDistance(value);
      }
      
      return this;
   }

   public booleanList getInPosition()
   {
      booleanList result = new booleanList();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.isInPosition());
      }
      
      return result;
   }

   public FieldPlayerSet hasInPosition(boolean value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.isInPosition())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withInPosition(boolean value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setInPosition(value);
      }
      
      return this;
   }

   public booleanList getOnSaveField()
   {
      booleanList result = new booleanList();
      
      for (FieldPlayer obj : this)
      {
         result.add(obj.isOnSaveField());
      }
      
      return result;
   }

   public FieldPlayerSet hasOnSaveField(boolean value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.isOnSaveField())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withOnSaveField(boolean value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setOnSaveField(value);
      }
      
      return this;
   }

   public FieldSet getShootableFields()
   {
      FieldSet result = new FieldSet();
      
      for (FieldPlayer obj : this)
      {
         result.addAll(obj.getShootableFields());
      }
      
      return result;
   }

   public FieldPlayerSet hasShootableFields(FieldSet value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.getShootableFields())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withShootableFields(FieldSet value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setShootableFields(value);
      }
      
      return this;
   }

   public FieldSet getRunnableFields()
   {
      FieldSet result = new FieldSet();
      
      for (FieldPlayer obj : this)
      {
         result.addAll(obj.getRunnableFields());
      }
      
      return result;
   }

   public FieldPlayerSet hasRunnableFields(FieldSet value)
   {
      FieldPlayerSet result = new FieldPlayerSet();
      
      for (FieldPlayer obj : this)
      {
         if (value == obj.getRunnableFields())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldPlayerSet withRunnableFields(FieldSet value)
   {
      for (FieldPlayer obj : this)
      {
         obj.setRunnableFields(value);
      }
      
      return this;
   }

}
