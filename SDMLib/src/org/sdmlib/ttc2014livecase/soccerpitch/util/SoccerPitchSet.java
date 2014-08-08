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
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import java.util.Collection;
import org.sdmlib.models.modelsets.ObjectSet;
import java.util.Collections;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallSet;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;

public class SoccerPitchSet extends SDMSet<SoccerPitch>
{


   public SoccerPitchPO hasSoccerPitchPO()
   {
      return new SoccerPitchPO(this.toArray(new SoccerPitch[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch";
   }


   @SuppressWarnings("unchecked")
   public SoccerPitchSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<SoccerPitch>)value);
      }
      else if (value != null)
      {
         this.add((SoccerPitch) value);
      }
      
      return this;
   }
   
   public SoccerPitchSet without(SoccerPitch value)
   {
      this.remove(value);
      return this;
   }

   public FieldSet getFields()
   {
      FieldSet result = new FieldSet();
      
      for (SoccerPitch obj : this)
      {
         result.addAll(obj.getFields());
      }
      
      return result;
   }

   public SoccerPitchSet hasFields(Object value)
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
      
      SoccerPitchSet answer = new SoccerPitchSet();
      
      for (SoccerPitch obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getFields()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public SoccerPitchSet withFields(Field value)
   {
      for (SoccerPitch obj : this)
      {
         obj.withFields(value);
      }
      
      return this;
   }

   public SoccerPitchSet withoutFields(Field value)
   {
      for (SoccerPitch obj : this)
      {
         obj.withoutFields(value);
      }
      
      return this;
   }

   public BallSet getBall()
   {
      BallSet result = new BallSet();
      
      for (SoccerPitch obj : this)
      {
         result.add(obj.getBall());
      }
      
      return result;
   }

   public SoccerPitchSet hasBall(Object value)
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
      
      SoccerPitchSet answer = new SoccerPitchSet();
      
      for (SoccerPitch obj : this)
      {
         if (neighbors.contains(obj.getBall()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public SoccerPitchSet withBall(Ball value)
   {
      for (SoccerPitch obj : this)
      {
         obj.withBall(value);
      }
      
      return this;
   }

   public PlayerSet getPlayers()
   {
      PlayerSet result = new PlayerSet();
      
      for (SoccerPitch obj : this)
      {
         result.addAll(obj.getPlayers());
      }
      
      return result;
   }

   public SoccerPitchSet hasPlayers(Object value)
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
      
      SoccerPitchSet answer = new SoccerPitchSet();
      
      for (SoccerPitch obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPlayers()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public SoccerPitchSet withPlayers(Player value)
   {
      for (SoccerPitch obj : this)
      {
         obj.withPlayers(value);
      }
      
      return this;
   }

   public SoccerPitchSet withoutPlayers(Player value)
   {
      for (SoccerPitch obj : this)
      {
         obj.withoutPlayers(value);
      }
      
      return this;
   }

}
