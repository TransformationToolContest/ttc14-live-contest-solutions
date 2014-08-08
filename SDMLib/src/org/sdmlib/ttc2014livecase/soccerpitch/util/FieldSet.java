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

import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.modelsets.ObjectSet;

import java.util.Collections;

import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchSet;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;

public class FieldSet extends SDMSet<Field>
{


   public FieldPO hasFieldPO()
   {
      return new FieldPO(this.toArray(new Field[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.ttc2014livecase.model.Field";
   }


   @SuppressWarnings("unchecked")
   public FieldSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Field>)value);
      }
      else if (value != null)
      {
         this.add((Field) value);
      }
      
      return this;
   }
   
   public FieldSet without(Field value)
   {
      this.remove(value);
      return this;
   }

   public intList getXPos()
   {
      intList result = new intList();
      
      for (Field obj : this)
      {
         result.add(obj.getXPos());
      }
      
      return result;
   }

   public FieldSet hasXPos(int value)
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         if (value == obj.getXPos())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldSet hasXPos(int lower, int upper)
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         if (lower <= obj.getXPos() && obj.getXPos() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldSet withXPos(int value)
   {
      for (Field obj : this)
      {
         obj.setXPos(value);
      }
      
      return this;
   }

   public intList getYPos()
   {
      intList result = new intList();
      
      for (Field obj : this)
      {
         result.add(obj.getYPos());
      }
      
      return result;
   }

   public FieldSet hasYPos(int value)
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         if (value == obj.getYPos())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldSet hasYPos(int lower, int upper)
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         if (lower <= obj.getYPos() && obj.getYPos() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldSet withYPos(int value)
   {
      for (Field obj : this)
      {
         obj.setYPos(value);
      }
      
      return this;
   }

   public FieldSet getNorth()
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         result.add(obj.getNorth());
      }
      
      return result;
   }

   public FieldSet hasNorth(Object value)
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
      
      FieldSet answer = new FieldSet();
      
      for (Field obj : this)
      {
         if (neighbors.contains(obj.getNorth()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }


   public FieldSet getNorthTransitive()
   {
      FieldSet todo = new FieldSet().with(this);
      
      FieldSet result = new FieldSet();
      
      while ( ! todo.isEmpty())
      {
         Field current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getNorth()))
            {
               todo.with(current.getNorth());
            }
         }
      }
      
      return result;
   }

   public FieldSet withNorth(Field value)
   {
      for (Field obj : this)
      {
         obj.withNorth(value);
      }
      
      return this;
   }

   public FieldSet getSouth()
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         result.add(obj.getSouth());
      }
      
      return result;
   }

   public FieldSet hasSouth(Object value)
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
      
      FieldSet answer = new FieldSet();
      
      for (Field obj : this)
      {
         if (neighbors.contains(obj.getSouth()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }


   public FieldSet getSouthTransitive()
   {
      FieldSet todo = new FieldSet().with(this);
      
      FieldSet result = new FieldSet();
      
      while ( ! todo.isEmpty())
      {
         Field current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getSouth()))
            {
               todo.with(current.getSouth());
            }
         }
      }
      
      return result;
   }

   public FieldSet withSouth(Field value)
   {
      for (Field obj : this)
      {
         obj.withSouth(value);
      }
      
      return this;
   }

   public FieldSet getEast()
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         result.add(obj.getEast());
      }
      
      return result;
   }

   public FieldSet hasEast(Object value)
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
      
      FieldSet answer = new FieldSet();
      
      for (Field obj : this)
      {
         if (neighbors.contains(obj.getEast()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }


   public FieldSet getEastTransitive()
   {
      FieldSet todo = new FieldSet().with(this);
      
      FieldSet result = new FieldSet();
      
      while ( ! todo.isEmpty())
      {
         Field current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getEast()))
            {
               todo.with(current.getEast());
            }
         }
      }
      
      return result;
   }

   public FieldSet withEast(Field value)
   {
      for (Field obj : this)
      {
         obj.withEast(value);
      }
      
      return this;
   }

   public FieldSet getWest()
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         result.add(obj.getWest());
      }
      
      return result;
   }

   public FieldSet hasWest(Object value)
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
      
      FieldSet answer = new FieldSet();
      
      for (Field obj : this)
      {
         if (neighbors.contains(obj.getWest()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }


   public FieldSet getWestTransitive()
   {
      FieldSet todo = new FieldSet().with(this);
      
      FieldSet result = new FieldSet();
      
      while ( ! todo.isEmpty())
      {
         Field current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getWest()))
            {
               todo.with(current.getWest());
            }
         }
      }
      
      return result;
   }

   public FieldSet withWest(Field value)
   {
      for (Field obj : this)
      {
         obj.withWest(value);
      }
      
      return this;
   }

   public PlayerSet getPlayers()
   {
      PlayerSet result = new PlayerSet();
      
      for (Field obj : this)
      {
         result.addAll(obj.getPlayers());
      }
      
      return result;
   }

   public FieldSet hasPlayers(Object value)
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
      
      FieldSet answer = new FieldSet();
      
      for (Field obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPlayers()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public FieldSet withPlayers(Player value)
   {
      for (Field obj : this)
      {
         obj.withPlayers(value);
      }
      
      return this;
   }

   public FieldSet withoutPlayers(Player value)
   {
      for (Field obj : this)
      {
         obj.withoutPlayers(value);
      }
      
      return this;
   }

   public BallSet getBall()
   {
      BallSet result = new BallSet();
      
      for (Field obj : this)
      {
         result.add(obj.getBall());
      }
      
      return result;
   }

   public FieldSet hasBall(Object value)
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
      
      FieldSet answer = new FieldSet();
      
      for (Field obj : this)
      {
         if (neighbors.contains(obj.getBall()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public FieldSet withBall(Ball value)
   {
      for (Field obj : this)
      {
         obj.withBall(value);
      }
      
      return this;
   }

   public SoccerPitchSet getPitch()
   {
      SoccerPitchSet result = new SoccerPitchSet();
      
      for (Field obj : this)
      {
         result.add(obj.getPitch());
      }
      
      return result;
   }

   public FieldSet hasPitch(Object value)
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
      
      FieldSet answer = new FieldSet();
      
      for (Field obj : this)
      {
         if (neighbors.contains(obj.getPitch()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   public FieldSet withPitch(SoccerPitch value)
   {
      for (Field obj : this)
      {
         obj.withPitch(value);
      }
      
      return this;
   }

   public intList getOpponentDistance()
   {
      intList result = new intList();
      
      for (Field obj : this)
      {
         result.add(obj.getOpponentDistance());
      }
      
      return result;
   }

   public FieldSet hasOpponentDistance(int value)
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         if (value == obj.getOpponentDistance())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldSet hasOpponentDistance(int lower, int upper)
   {
      FieldSet result = new FieldSet();
      
      for (Field obj : this)
      {
         if (lower <= obj.getOpponentDistance() && obj.getOpponentDistance() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public FieldSet withOpponentDistance(int value)
   {
      for (Field obj : this)
      {
         obj.setOpponentDistance(value);
      }
      
      return this;
   }

}
