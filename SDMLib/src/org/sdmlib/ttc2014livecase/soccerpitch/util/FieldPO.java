package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchPO;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;

public class FieldPO extends PatternObject<FieldPO, Field>
{

    public FieldSet allMatches()
   {
      this.setDoAllMatches(true);
      
      FieldSet matches = new FieldSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Field) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public FieldPO(){
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public FieldPO(Field... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public FieldPO hasXPos(int value)
   {
      new AttributeConstraint()
      .withAttrName(Field.PROPERTY_XPOS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPO hasXPos(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Field.PROPERTY_XPOS)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPO createXPos(int value)
   {
      this.startCreate().hasXPos(value).endCreate();
      return this;
   }
   
   public int getXPos()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) getCurrentMatch()).getXPos();
      }
      return 0;
   }
   
   public FieldPO withXPos(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Field) getCurrentMatch()).setXPos(value);
      }
      return this;
   }
   
   public FieldPO hasYPos(int value)
   {
      new AttributeConstraint()
      .withAttrName(Field.PROPERTY_YPOS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPO hasYPos(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Field.PROPERTY_YPOS)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPO createYPos(int value)
   {
      this.startCreate().hasYPos(value).endCreate();
      return this;
   }
   
   public int getYPos()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) getCurrentMatch()).getYPos();
      }
      return 0;
   }
   
   public FieldPO withYPos(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Field) getCurrentMatch()).setYPos(value);
      }
      return this;
   }
   
   public FieldPO hasNorth()
   {
      FieldPO result = new FieldPO(new org.sdmlib.ttc2014livecase.soccerpitch.Field[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Field.PROPERTY_NORTH, result);
      
      return result;
   }

   public FieldPO createNorth()
   {
      return this.startCreate().hasNorth().endCreate();
   }

   public FieldPO hasNorth(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_NORTH);
   }

   public FieldPO createNorth(FieldPO tgt)
   {
      return this.startCreate().hasNorth(tgt).endCreate();
   }

   public Field getNorth()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) this.getCurrentMatch()).getNorth();
      }
      return null;
   }

   public FieldPO hasSouth()
   {
      FieldPO result = new FieldPO(new org.sdmlib.ttc2014livecase.soccerpitch.Field[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Field.PROPERTY_SOUTH, result);
      
      return result;
   }

   public FieldPO createSouth()
   {
      return this.startCreate().hasSouth().endCreate();
   }

   public FieldPO hasSouth(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_SOUTH);
   }

   public FieldPO createSouth(FieldPO tgt)
   {
      return this.startCreate().hasSouth(tgt).endCreate();
   }

   public Field getSouth()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) this.getCurrentMatch()).getSouth();
      }
      return null;
   }

   public FieldPO hasEast()
   {
      FieldPO result = new FieldPO(new org.sdmlib.ttc2014livecase.soccerpitch.Field[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Field.PROPERTY_EAST, result);
      
      return result;
   }

   public FieldPO createEast()
   {
      return this.startCreate().hasEast().endCreate();
   }

   public FieldPO hasEast(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_EAST);
   }

   public FieldPO createEast(FieldPO tgt)
   {
      return this.startCreate().hasEast(tgt).endCreate();
   }

   public Field getEast()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) this.getCurrentMatch()).getEast();
      }
      return null;
   }

   public FieldPO hasWest()
   {
      FieldPO result = new FieldPO(new org.sdmlib.ttc2014livecase.soccerpitch.Field[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Field.PROPERTY_WEST, result);
      
      return result;
   }

   public FieldPO createWest()
   {
      return this.startCreate().hasWest().endCreate();
   }

   public FieldPO hasWest(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_WEST);
   }

   public FieldPO createWest(FieldPO tgt)
   {
      return this.startCreate().hasWest(tgt).endCreate();
   }

   public Field getWest()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) this.getCurrentMatch()).getWest();
      }
      return null;
   }

   public PlayerPO hasPlayers()
   {
      PlayerPO result = new PlayerPO(new org.sdmlib.ttc2014livecase.soccerpitch.Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Field.PROPERTY_PLAYERS, result);
      
      return result;
   }

   public PlayerPO createPlayers()
   {
      return this.startCreate().hasPlayers().endCreate();
   }

   public FieldPO hasPlayers(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_PLAYERS);
   }

   public FieldPO createPlayers(PlayerPO tgt)
   {
      return this.startCreate().hasPlayers(tgt).endCreate();
   }

   public PlayerSet getPlayers()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) this.getCurrentMatch()).getPlayers();
      }
      return null;
   }

   public BallPO hasBall()
   {
      BallPO result = new BallPO(new org.sdmlib.ttc2014livecase.soccerpitch.Ball[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Field.PROPERTY_BALL, result);
      
      return result;
   }

   public BallPO createBall()
   {
      return this.startCreate().hasBall().endCreate();
   }

   public FieldPO hasBall(BallPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_BALL);
   }

   public FieldPO createBall(BallPO tgt)
   {
      return this.startCreate().hasBall(tgt).endCreate();
   }

   public Ball getBall()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) this.getCurrentMatch()).getBall();
      }
      return null;
   }

   public SoccerPitchPO hasPitch()
   {
      SoccerPitchPO result = new SoccerPitchPO(new org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Field.PROPERTY_PITCH, result);
      
      return result;
   }

   public SoccerPitchPO createPitch()
   {
      return this.startCreate().hasPitch().endCreate();
   }

   public FieldPO hasPitch(SoccerPitchPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_PITCH);
   }

   public FieldPO createPitch(SoccerPitchPO tgt)
   {
      return this.startCreate().hasPitch(tgt).endCreate();
   }

   public SoccerPitch getPitch()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) this.getCurrentMatch()).getPitch();
      }
      return null;
   }

   public FieldPO hasOpponentDistance(int value)
   {
      new AttributeConstraint()
      .withAttrName(Field.PROPERTY_OPPONENTDISTANCE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPO hasOpponentDistance(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Field.PROPERTY_OPPONENTDISTANCE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPO createOpponentDistance(int value)
   {
      this.startCreate().hasOpponentDistance(value).endCreate();
      return this;
   }
   
   public int getOpponentDistance()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Field) getCurrentMatch()).getOpponentDistance();
      }
      return 0;
   }
   
   public FieldPO withOpponentDistance(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Field) getCurrentMatch()).setOpponentDistance(value);
      }
      return this;
   }
   
}
