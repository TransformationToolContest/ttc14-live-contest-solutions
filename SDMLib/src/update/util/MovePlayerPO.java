package update.util;

import org.sdmlib.models.pattern.PatternObject;

import update.MovePlayer;

import org.sdmlib.models.pattern.AttributeConstraint;

public class MovePlayerPO extends PatternObject<MovePlayerPO, MovePlayer>
{

    public MovePlayerSet allMatches()
   {
      this.setDoAllMatches(true);
      
      MovePlayerSet matches = new MovePlayerSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((MovePlayer) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public MovePlayerPO(){
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public MovePlayerPO(MovePlayer... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(update.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public MovePlayerPO hasPlayerNumber(int value)
   {
      new AttributeConstraint()
      .withAttrName(MovePlayer.PROPERTY_PLAYERNUMBER)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MovePlayerPO hasPlayerNumber(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(MovePlayer.PROPERTY_PLAYERNUMBER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MovePlayerPO createPlayerNumber(int value)
   {
      this.startCreate().hasPlayerNumber(value).endCreate();
      return this;
   }
   
   public int getPlayerNumber()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MovePlayer) getCurrentMatch()).getPlayerNumber();
      }
      return 0;
   }
   
   public MovePlayerPO withPlayerNumber(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((MovePlayer) getCurrentMatch()).setPlayerNumber(value);
      }
      return this;
   }
   
   public MovePlayerPO hasXDist(int value)
   {
      new AttributeConstraint()
      .withAttrName(MovePlayer.PROPERTY_XDIST)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MovePlayerPO hasXDist(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(MovePlayer.PROPERTY_XDIST)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MovePlayerPO createXDist(int value)
   {
      this.startCreate().hasXDist(value).endCreate();
      return this;
   }
   
   public int getXDist()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MovePlayer) getCurrentMatch()).getXDist();
      }
      return 0;
   }
   
   public MovePlayerPO withXDist(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((MovePlayer) getCurrentMatch()).setXDist(value);
      }
      return this;
   }
   
   public MovePlayerPO hasYDist(int value)
   {
      new AttributeConstraint()
      .withAttrName(MovePlayer.PROPERTY_YDIST)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MovePlayerPO hasYDist(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(MovePlayer.PROPERTY_YDIST)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public MovePlayerPO createYDist(int value)
   {
      this.startCreate().hasYDist(value).endCreate();
      return this;
   }
   
   public int getYDist()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((MovePlayer) getCurrentMatch()).getYDist();
      }
      return 0;
   }
   
   public MovePlayerPO withYDist(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((MovePlayer) getCurrentMatch()).setYDist(value);
      }
      return this;
   }
   
}
