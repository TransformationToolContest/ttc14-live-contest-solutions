package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.GoalKeeper;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.GoalKeeperPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchPO;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;

public class GoalKeeperPO extends PatternObject<GoalKeeperPO, GoalKeeper>
{

    public GoalKeeperSet allMatches()
   {
      this.setDoAllMatches(true);
      
      GoalKeeperSet matches = new GoalKeeperSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((GoalKeeper) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public GoalKeeperPO(){
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public GoalKeeperPO(GoalKeeper... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public GoalKeeperPO hasTeam(String value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_TEAM)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO hasTeam(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_TEAM)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createTeam(String value)
   {
      this.startCreate().hasTeam(value).endCreate();
      return this;
   }
   
   public String getTeam()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).getTeam();
      }
      return null;
   }
   
   public GoalKeeperPO withTeam(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setTeam(value);
      }
      return this;
   }
   
   public GoalKeeperPO hasNumber(int value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_NUMBER)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO hasNumber(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_NUMBER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createNumber(int value)
   {
      this.startCreate().hasNumber(value).endCreate();
      return this;
   }
   
   public int getNumber()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).getNumber();
      }
      return 0;
   }
   
   public GoalKeeperPO withNumber(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setNumber(value);
      }
      return this;
   }
   
   public FieldPO hasField()
   {
      FieldPO result = new FieldPO(new org.sdmlib.ttc2014livecase.soccerpitch.Field[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_FIELD, result);
      
      return result;
   }

   public FieldPO createField()
   {
      return this.startCreate().hasField().endCreate();
   }

   public GoalKeeperPO hasField(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_FIELD);
   }

   public GoalKeeperPO createField(FieldPO tgt)
   {
      return this.startCreate().hasField(tgt).endCreate();
   }

   public Field getField()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getField();
      }
      return null;
   }

   public BallPO hasBall()
   {
      BallPO result = new BallPO(new org.sdmlib.ttc2014livecase.soccerpitch.Ball[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_BALL, result);
      
      return result;
   }

   public BallPO createBall()
   {
      return this.startCreate().hasBall().endCreate();
   }

   public GoalKeeperPO hasBall(BallPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_BALL);
   }

   public GoalKeeperPO createBall(BallPO tgt)
   {
      return this.startCreate().hasBall(tgt).endCreate();
   }

   public Ball getBall()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getBall();
      }
      return null;
   }

   public SoccerPitchPO hasPitch()
   {
      SoccerPitchPO result = new SoccerPitchPO(new org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_PITCH, result);
      
      return result;
   }

   public SoccerPitchPO createPitch()
   {
      return this.startCreate().hasPitch().endCreate();
   }

   public GoalKeeperPO hasPitch(SoccerPitchPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_PITCH);
   }

   public GoalKeeperPO createPitch(SoccerPitchPO tgt)
   {
      return this.startCreate().hasPitch(tgt).endCreate();
   }

   public SoccerPitch getPitch()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getPitch();
      }
      return null;
   }

   public GoalKeeperPO hasTackleDistance(int value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_TACKLEDISTANCE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO hasTackleDistance(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_TACKLEDISTANCE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createTackleDistance(int value)
   {
      this.startCreate().hasTackleDistance(value).endCreate();
      return this;
   }
   
   public int getTackleDistance()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).getTackleDistance();
      }
      return 0;
   }
   
   public GoalKeeperPO withTackleDistance(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setTackleDistance(value);
      }
      return this;
   }
   
   public GoalKeeperPO hasTgtX(int value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_TGTX)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO hasTgtX(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_TGTX)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createTgtX(int value)
   {
      this.startCreate().hasTgtX(value).endCreate();
      return this;
   }
   
   public int getTgtX()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).getTgtX();
      }
      return 0;
   }
   
   public GoalKeeperPO withTgtX(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setTgtX(value);
      }
      return this;
   }
   
   public GoalKeeperPO hasTgtY(int value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_TGTY)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO hasTgtY(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_TGTY)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createTgtY(int value)
   {
      this.startCreate().hasTgtY(value).endCreate();
      return this;
   }
   
   public int getTgtY()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).getTgtY();
      }
      return 0;
   }
   
   public GoalKeeperPO withTgtY(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setTgtY(value);
      }
      return this;
   }
   
   public GoalKeeperPO hasInGoalShootDistance(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_INGOALSHOOTDISTANCE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createInGoalShootDistance(boolean value)
   {
      this.startCreate().hasInGoalShootDistance(value).endCreate();
      return this;
   }
   
   public boolean getInGoalShootDistance()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).isInGoalShootDistance();
      }
      return false;
   }
   
   public GoalKeeperPO withInGoalShootDistance(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setInGoalShootDistance(value);
      }
      return this;
   }
   
   public GoalKeeperPO hasInPosition(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_INPOSITION)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createInPosition(boolean value)
   {
      this.startCreate().hasInPosition(value).endCreate();
      return this;
   }
   
   public boolean getInPosition()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).isInPosition();
      }
      return false;
   }
   
   public GoalKeeperPO withInPosition(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setInPosition(value);
      }
      return this;
   }
   
   public GoalKeeperPO hasOnSaveField(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_ONSAVEFIELD)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createOnSaveField(boolean value)
   {
      this.startCreate().hasOnSaveField(value).endCreate();
      return this;
   }
   
   public boolean getOnSaveField()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).isOnSaveField();
      }
      return false;
   }
   
   public GoalKeeperPO withOnSaveField(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setOnSaveField(value);
      }
      return this;
   }
   
   public GoalKeeperPO hasShootableFields(FieldSet value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_SHOOTABLEFIELDS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createShootableFields(FieldSet value)
   {
      this.startCreate().hasShootableFields(value).endCreate();
      return this;
   }
   
   public FieldSet getShootableFields()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).getShootableFields();
      }
      return null;
   }
   
   public GoalKeeperPO withShootableFields(FieldSet value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setShootableFields(value);
      }
      return this;
   }
   
   public GoalKeeperPO hasRunnableFields(FieldSet value)
   {
      new AttributeConstraint()
      .withAttrName(GoalKeeper.PROPERTY_RUNNABLEFIELDS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public GoalKeeperPO createRunnableFields(FieldSet value)
   {
      this.startCreate().hasRunnableFields(value).endCreate();
      return this;
   }
   
   public FieldSet getRunnableFields()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((GoalKeeper) getCurrentMatch()).getRunnableFields();
      }
      return null;
   }
   
   public GoalKeeperPO withRunnableFields(FieldSet value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((GoalKeeper) getCurrentMatch()).setRunnableFields(value);
      }
      return this;
   }
   
}
