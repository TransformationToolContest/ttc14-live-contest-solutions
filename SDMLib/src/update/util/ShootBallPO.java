package update.util;

import org.sdmlib.models.pattern.PatternObject;

import update.ShootBall;

import org.sdmlib.models.pattern.AttributeConstraint;

public class ShootBallPO extends PatternObject<ShootBallPO, ShootBall>
{

    public ShootBallSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ShootBallSet matches = new ShootBallSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((ShootBall) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public ShootBallPO(){
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public ShootBallPO(ShootBall... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public ShootBallPO hasPlayerNumber(int value)
   {
      new AttributeConstraint()
      .withAttrName(ShootBall.PROPERTY_PLAYERNUMBER)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ShootBallPO hasPlayerNumber(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(ShootBall.PROPERTY_PLAYERNUMBER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ShootBallPO createPlayerNumber(int value)
   {
      this.startCreate().hasPlayerNumber(value).endCreate();
      return this;
   }
   
   public int getPlayerNumber()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShootBall) getCurrentMatch()).getPlayerNumber();
      }
      return 0;
   }
   
   public ShootBallPO withPlayerNumber(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShootBall) getCurrentMatch()).setPlayerNumber(value);
      }
      return this;
   }
   
   public ShootBallPO hasXDist(int value)
   {
      new AttributeConstraint()
      .withAttrName(ShootBall.PROPERTY_XDIST)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ShootBallPO hasXDist(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(ShootBall.PROPERTY_XDIST)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ShootBallPO createXDist(int value)
   {
      this.startCreate().hasXDist(value).endCreate();
      return this;
   }
   
   public int getXDist()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShootBall) getCurrentMatch()).getXDist();
      }
      return 0;
   }
   
   public ShootBallPO withXDist(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShootBall) getCurrentMatch()).setXDist(value);
      }
      return this;
   }
   
   public ShootBallPO hasYDist(int value)
   {
      new AttributeConstraint()
      .withAttrName(ShootBall.PROPERTY_YDIST)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ShootBallPO hasYDist(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(ShootBall.PROPERTY_YDIST)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public ShootBallPO createYDist(int value)
   {
      this.startCreate().hasYDist(value).endCreate();
      return this;
   }
   
   public int getYDist()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShootBall) getCurrentMatch()).getYDist();
      }
      return 0;
   }
   
   public ShootBallPO withYDist(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShootBall) getCurrentMatch()).setYDist(value);
      }
      return this;
   }
   
}
