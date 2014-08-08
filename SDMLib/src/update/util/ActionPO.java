package update.util;

import org.sdmlib.models.pattern.PatternObject;

import update.Action;

import org.sdmlib.models.pattern.AttributeConstraint;

public class ActionPO extends PatternObject<ActionPO, Action>
{

    public ActionSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ActionSet matches = new ActionSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Action) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public ActionPO(){
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public ActionPO(Action... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public ActionPO hasPlayerNumber(int value)
   {
      new AttributeConstraint()
      .withAttrName(Action.PROPERTY_PLAYERNUMBER)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ActionPO hasPlayerNumber(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Action.PROPERTY_PLAYERNUMBER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ActionPO createPlayerNumber(int value)
   {
      this.startCreate().hasPlayerNumber(value).endCreate();
      return this;
   }
   
   public int getPlayerNumber()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Action) getCurrentMatch()).getPlayerNumber();
      }
      return 0;
   }
   
   public ActionPO withPlayerNumber(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Action) getCurrentMatch()).setPlayerNumber(value);
      }
      return this;
   }
   
   public ActionPO hasXDist(int value)
   {
      new AttributeConstraint()
      .withAttrName(Action.PROPERTY_XDIST)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ActionPO hasXDist(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Action.PROPERTY_XDIST)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ActionPO createXDist(int value)
   {
      this.startCreate().hasXDist(value).endCreate();
      return this;
   }
   
   public int getXDist()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Action) getCurrentMatch()).getXDist();
      }
      return 0;
   }
   
   public ActionPO withXDist(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Action) getCurrentMatch()).setXDist(value);
      }
      return this;
   }
   
   public ActionPO hasYDist(int value)
   {
      new AttributeConstraint()
      .withAttrName(Action.PROPERTY_YDIST)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ActionPO hasYDist(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Action.PROPERTY_YDIST)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ActionPO createYDist(int value)
   {
      this.startCreate().hasYDist(value).endCreate();
      return this;
   }
   
   public int getYDist()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Action) getCurrentMatch()).getYDist();
      }
      return 0;
   }
   
   public ActionPO withYDist(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Action) getCurrentMatch()).setYDist(value);
      }
      return this;
   }
   
}
