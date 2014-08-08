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

import org.sdmlib.models.modelsets.ObjectSet;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchSet;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;

public class BallSet extends SDMSet<Ball>
{


   public BallPO hasBallPO()
   {
      return new BallPO(this.toArray(new Ball[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.ttc2014livecase.model.Ball";
   }


   @SuppressWarnings("unchecked")
   public BallSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Ball>)value);
      }
      else if (value != null)
      {
         this.add((Ball) value);
      }
      
      return this;
   }
   
   public BallSet without(Ball value)
   {
      this.remove(value);
      return this;
   }

   public FieldSet getField()
   {
      FieldSet result = new FieldSet();
      
      for (Ball obj : this)
      {
         result.add(obj.getField());
      }
      
      return result;
   }

   public BallSet hasField(Object value)
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
      
      BallSet answer = new BallSet();
      
      for (Ball obj : this)
      {
         if (neighbors.contains(obj.getField()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public BallSet withField(Field value)
   {
      for (Ball obj : this)
      {
         obj.withField(value);
      }
      
      return this;
   }

   public PlayerSet getPlayer()
   {
      PlayerSet result = new PlayerSet();
      
      for (Ball obj : this)
      {
         result.add(obj.getPlayer());
      }
      
      return result;
   }

   public BallSet hasPlayer(Object value)
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
      
      BallSet answer = new BallSet();
      
      for (Ball obj : this)
      {
         if (neighbors.contains(obj.getPlayer()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public BallSet withPlayer(Player value)
   {
      for (Ball obj : this)
      {
         obj.withPlayer(value);
      }
      
      return this;
   }

   public SoccerPitchSet getPitch()
   {
      SoccerPitchSet result = new SoccerPitchSet();
      
      for (Ball obj : this)
      {
         result.add(obj.getPitch());
      }
      
      return result;
   }

   public BallSet hasPitch(Object value)
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
      
      BallSet answer = new BallSet();
      
      for (Ball obj : this)
      {
         if (neighbors.contains(obj.getPitch()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public BallSet withPitch(SoccerPitch value)
   {
      for (Ball obj : this)
      {
         obj.withPitch(value);
      }
      
      return this;
   }

}
