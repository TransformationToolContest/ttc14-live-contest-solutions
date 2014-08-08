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

import org.sdmlib.models.modelsets.SDMSet;

import update.ShootBall;

import java.util.Collection;

import org.sdmlib.models.modelsets.intList;

public class ShootBallSet extends SDMSet<ShootBall>
{


   public ShootBallPO hasShootBallPO()
   {
      return new ShootBallPO(this.toArray(new ShootBall[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "updatemodel.ShootBall";
   }


   @SuppressWarnings("unchecked")
   public ShootBallSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<ShootBall>)value);
      }
      else if (value != null)
      {
         this.add((ShootBall) value);
      }
      
      return this;
   }
   
   public ShootBallSet without(ShootBall value)
   {
      this.remove(value);
      return this;
   }

   public intList getPlayerNumber()
   {
      intList result = new intList();
      
      for (ShootBall obj : this)
      {
         result.add(obj.getPlayerNumber());
      }
      
      return result;
   }

   public ShootBallSet hasPlayerNumber(int value)
   {
      ShootBallSet result = new ShootBallSet();
      
      for (ShootBall obj : this)
      {
         if (value == obj.getPlayerNumber())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ShootBallSet hasPlayerNumber(int lower, int upper)
   {
      ShootBallSet result = new ShootBallSet();
      
      for (ShootBall obj : this)
      {
         if (lower <= obj.getPlayerNumber() && obj.getPlayerNumber() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ShootBallSet withPlayerNumber(int value)
   {
      for (ShootBall obj : this)
      {
         obj.setPlayerNumber(value);
      }
      
      return this;
   }

   public intList getXDist()
   {
      intList result = new intList();
      
      for (ShootBall obj : this)
      {
         result.add(obj.getXDist());
      }
      
      return result;
   }

   public ShootBallSet hasXDist(int value)
   {
      ShootBallSet result = new ShootBallSet();
      
      for (ShootBall obj : this)
      {
         if (value == obj.getXDist())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ShootBallSet hasXDist(int lower, int upper)
   {
      ShootBallSet result = new ShootBallSet();
      
      for (ShootBall obj : this)
      {
         if (lower <= obj.getXDist() && obj.getXDist() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ShootBallSet withXDist(int value)
   {
      for (ShootBall obj : this)
      {
         obj.setXDist(value);
      }
      
      return this;
   }

   public intList getYDist()
   {
      intList result = new intList();
      
      for (ShootBall obj : this)
      {
         result.add(obj.getYDist());
      }
      
      return result;
   }

   public ShootBallSet hasYDist(int value)
   {
      ShootBallSet result = new ShootBallSet();
      
      for (ShootBall obj : this)
      {
         if (value == obj.getYDist())
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ShootBallSet hasYDist(int lower, int upper)
   {
      ShootBallSet result = new ShootBallSet();
      
      for (ShootBall obj : this)
      {
         if (lower <= obj.getYDist() && obj.getYDist() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }

   public ShootBallSet withYDist(int value)
   {
      for (ShootBall obj : this)
      {
         obj.setYDist(value);
      }
      
      return this;
   }

}