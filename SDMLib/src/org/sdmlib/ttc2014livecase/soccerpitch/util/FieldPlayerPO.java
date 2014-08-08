package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.ttc2014livecase.soccerpitch.FieldPlayer;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPO;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPlayerPO;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallPO;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchPO;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;

public class FieldPlayerPO extends PatternObject<FieldPlayerPO, FieldPlayer>
{

    public FieldPlayerSet allMatches()
   {
      this.setDoAllMatches(true);
      
      FieldPlayerSet matches = new FieldPlayerSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((FieldPlayer) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public FieldPlayerPO(){
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public FieldPlayerPO(FieldPlayer... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public FieldPlayerPO hasTeam(String value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_TEAM)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO hasTeam(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_TEAM)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createTeam(String value)
   {
      this.startCreate().hasTeam(value).endCreate();
      return this;
   }
   
   public String getTeam()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).getTeam();
      }
      return null;
   }
   
   public FieldPlayerPO withTeam(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setTeam(value);
      }
      return this;
   }
   
   public FieldPlayerPO hasNumber(int value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_NUMBER)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO hasNumber(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_NUMBER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createNumber(int value)
   {
      this.startCreate().hasNumber(value).endCreate();
      return this;
   }
   
   public int getNumber()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).getNumber();
      }
      return 0;
   }
   
   public FieldPlayerPO withNumber(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setNumber(value);
      }
      return this;
   }
   
   public FieldPlayerPO hasTackleDistance(int value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_TACKLEDISTANCE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO hasTackleDistance(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_TACKLEDISTANCE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createTackleDistance(int value)
   {
      this.startCreate().hasTackleDistance(value).endCreate();
      return this;
   }
   
   public int getTackleDistance()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).getTackleDistance();
      }
      return 0;
   }
   
   public FieldPlayerPO withTackleDistance(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setTackleDistance(value);
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

   public FieldPlayerPO hasField(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_FIELD);
   }

   public FieldPlayerPO createField(FieldPO tgt)
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

   public FieldPlayerPO hasBall(BallPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_BALL);
   }

   public FieldPlayerPO createBall(BallPO tgt)
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

   public FieldPlayerPO hasPitch(SoccerPitchPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_PITCH);
   }

   public FieldPlayerPO createPitch(SoccerPitchPO tgt)
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

   public FieldPlayerPO hasTgtX(int value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_TGTX)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO hasTgtX(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_TGTX)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createTgtX(int value)
   {
      this.startCreate().hasTgtX(value).endCreate();
      return this;
   }
   
   public int getTgtX()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).getTgtX();
      }
      return 0;
   }
   
   public FieldPlayerPO withTgtX(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setTgtX(value);
      }
      return this;
   }
   
   public FieldPlayerPO hasTgtY(int value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_TGTY)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO hasTgtY(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_TGTY)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createTgtY(int value)
   {
      this.startCreate().hasTgtY(value).endCreate();
      return this;
   }
   
   public int getTgtY()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).getTgtY();
      }
      return 0;
   }
   
   public FieldPlayerPO withTgtY(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setTgtY(value);
      }
      return this;
   }
   
   public FieldPlayerPO hasInGoalShootDistance(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_INGOALSHOOTDISTANCE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createInGoalShootDistance(boolean value)
   {
      this.startCreate().hasInGoalShootDistance(value).endCreate();
      return this;
   }
   
   public boolean getInGoalShootDistance()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).isInGoalShootDistance();
      }
      return false;
   }
   
   public FieldPlayerPO withInGoalShootDistance(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setInGoalShootDistance(value);
      }
      return this;
   }
   
   public FieldPlayerPO hasInPosition(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_INPOSITION)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createInPosition(boolean value)
   {
      this.startCreate().hasInPosition(value).endCreate();
      return this;
   }
   
   public boolean getInPosition()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).isInPosition();
      }
      return false;
   }
   
   public FieldPlayerPO withInPosition(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setInPosition(value);
      }
      return this;
   }
   
   public FieldPlayerPO hasOnSaveField(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_ONSAVEFIELD)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createOnSaveField(boolean value)
   {
      this.startCreate().hasOnSaveField(value).endCreate();
      return this;
   }
   
   public boolean getOnSaveField()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).isOnSaveField();
      }
      return false;
   }
   
   public FieldPlayerPO withOnSaveField(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setOnSaveField(value);
      }
      return this;
   }
   
   public FieldPlayerPO hasShootableFields(FieldSet value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_SHOOTABLEFIELDS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createShootableFields(FieldSet value)
   {
      this.startCreate().hasShootableFields(value).endCreate();
      return this;
   }
   
   public FieldSet getShootableFields()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).getShootableFields();
      }
      return null;
   }
   
   public FieldPlayerPO withShootableFields(FieldSet value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setShootableFields(value);
      }
      return this;
   }
   
   public FieldPlayerPO hasRunnableFields(FieldSet value)
   {
      new AttributeConstraint()
      .withAttrName(FieldPlayer.PROPERTY_RUNNABLEFIELDS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public FieldPlayerPO createRunnableFields(FieldSet value)
   {
      this.startCreate().hasRunnableFields(value).endCreate();
      return this;
   }
   
   public FieldSet getRunnableFields()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((FieldPlayer) getCurrentMatch()).getRunnableFields();
      }
      return null;
   }
   
   public FieldPlayerPO withRunnableFields(FieldSet value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((FieldPlayer) getCurrentMatch()).setRunnableFields(value);
      }
      return this;
   }
   
}
