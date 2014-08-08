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
import org.sdmlib.examples.ludo.model.util.FieldSet;
import java.util.Collection;

public class FieldSetSet extends SDMSet<FieldSet>
{


   public FieldSetPO hasFieldSetPO()
   {
      return new FieldSetPO(this.toArray(new FieldSet[this.size()]));
   }


   @Override
   public String getEntryType()
   {
      return "org.sdmlib.examples.ludo.model.util.FieldSet";
   }


   @SuppressWarnings("unchecked")
   public FieldSetSet with(Object value)
   {
      if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<FieldSet>)value);
      }
      else if (value != null)
      {
         this.add((FieldSet) value);
      }
      
      return this;
   }
   
   public FieldSetSet without(FieldSet value)
   {
      this.remove(value);
      return this;
   }

}
