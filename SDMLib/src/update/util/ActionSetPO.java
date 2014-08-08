package update.util;

import org.sdmlib.models.pattern.PatternObject;

public class ActionSetPO extends PatternObject<ActionSetPO, ActionSet>
{

    public ActionSetSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ActionSetSet matches = new ActionSetSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((ActionSet) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public ActionSetPO(){
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public ActionSetPO(ActionSet... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
}
