package update.util;

import org.sdmlib.models.pattern.PatternObject;

import update.Update;

import org.sdmlib.models.pattern.AttributeConstraint;

public class UpdatePO extends PatternObject<UpdatePO, Update>
{

    public UpdateSet allMatches()
   {
      this.setDoAllMatches(true);
      
      UpdateSet matches = new UpdateSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Update) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public UpdatePO(){
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public UpdatePO(Update... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public UpdatePO hasActions(ActionSet value)
   {
      new AttributeConstraint()
      .withAttrName(Update.PROPERTY_ACTIONS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public UpdatePO createActions(ActionSet value)
   {
      this.startCreate().hasActions(value).endCreate();
      return this;
   }
   
   public ActionSet getActions()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Update) getCurrentMatch()).getActions();
      }
      return null;
   }
   
   public UpdatePO withActions(ActionSet value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Update) getCurrentMatch()).setActions(value);
      }
      return this;
   }
   
}
