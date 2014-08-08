package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.GoalField;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.GoalFieldPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchPO;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;

public class GoalFieldPO extends PatternObject<GoalFieldPO, GoalField>
{

    public GoalFieldSet allMatches()
   {
      this.setDoAllMatches(true);
      
      GoalFieldSet matches = new GoalFieldSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((GoalField) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public GoalFieldPO(){
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public GoalFieldPO(GoalField... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public GoalFieldPO hasTeam(String value)
   {
      new AttributeConstraint()
      .withAttrName(GoalField.PROPERTY_TEAM)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalFieldPO hasTeam(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalField.PROPERTY_TEAM)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalFieldPO createTeam(String value)
   {
      this.startCreate().hasTeam(value).endCreate();
      return this;
   }
   
   public String getTeam()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalField) getCurrentMatch()).getTeam();
      }
      return null;
   }
   
   public GoalFieldPO withTeam(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalField) getCurrentMatch()).setTeam(value);
      }
      return this;
   }
   
   public GoalFieldPO hasXPos(int value)
   {
      new AttributeConstraint()
      .withAttrName(GoalField.PROPERTY_XPOS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalFieldPO hasXPos(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalField.PROPERTY_XPOS)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalFieldPO createXPos(int value)
   {
      this.startCreate().hasXPos(value).endCreate();
      return this;
   }
   
   public int getXPos()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalField) getCurrentMatch()).getXPos();
      }
      return 0;
   }
   
   public GoalFieldPO withXPos(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalField) getCurrentMatch()).setXPos(value);
      }
      return this;
   }
   
   public GoalFieldPO hasYPos(int value)
   {
      new AttributeConstraint()
      .withAttrName(GoalField.PROPERTY_YPOS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalFieldPO hasYPos(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalField.PROPERTY_YPOS)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalFieldPO createYPos(int value)
   {
      this.startCreate().hasYPos(value).endCreate();
      return this;
   }
   
   public int getYPos()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalField) getCurrentMatch()).getYPos();
      }
      return 0;
   }
   
   public GoalFieldPO withYPos(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalField) getCurrentMatch()).setYPos(value);
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

   public GoalFieldPO hasNorth(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_NORTH);
   }

   public GoalFieldPO createNorth(FieldPO tgt)
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

   public GoalFieldPO hasSouth(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_SOUTH);
   }

   public GoalFieldPO createSouth(FieldPO tgt)
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

   public GoalFieldPO hasEast(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_EAST);
   }

   public GoalFieldPO createEast(FieldPO tgt)
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

   public GoalFieldPO hasWest(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_WEST);
   }

   public GoalFieldPO createWest(FieldPO tgt)
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

   public GoalFieldPO hasPlayers(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_PLAYERS);
   }

   public GoalFieldPO createPlayers(PlayerPO tgt)
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

   public GoalFieldPO hasBall(BallPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_BALL);
   }

   public GoalFieldPO createBall(BallPO tgt)
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

   public GoalFieldPO hasPitch(SoccerPitchPO tgt)
   {
      return hasLinkConstraint(tgt, Field.PROPERTY_PITCH);
   }

   public GoalFieldPO createPitch(SoccerPitchPO tgt)
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

   public GoalFieldPO hasOpponentDistance(int value)
   {
      new AttributeConstraint()
      .withAttrName(GoalField.PROPERTY_OPPONENTDISTANCE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalFieldPO hasOpponentDistance(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalField.PROPERTY_OPPONENTDISTANCE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalFieldPO createOpponentDistance(int value)
   {
      this.startCreate().hasOpponentDistance(value).endCreate();
      return this;
   }
   
   public int getOpponentDistance()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalField) getCurrentMatch()).getOpponentDistance();
      }
      return 0;
   }
   
   public GoalFieldPO withOpponentDistance(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalField) getCurrentMatch()).setOpponentDistance(value);
      }
      return this;
   }
   
}
