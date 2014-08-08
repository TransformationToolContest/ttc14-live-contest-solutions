package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.examples.ludo.model.util.FieldSet;

public class FieldSetPO extends PatternObject<FieldSetPO, FieldSet>
{

    public FieldSetSet allMatches()
   {
      this.setDoAllMatches(true);
      
      FieldSetSet matches = new FieldSetSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((FieldSet) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public FieldSetPO(){
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public FieldSetPO(FieldSet... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
}
