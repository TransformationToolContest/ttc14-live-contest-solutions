package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchPO;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;

public class PlayerPO extends PatternObject<PlayerPO, Player>
{

    public PlayerSet allMatches()
   {
      this.setDoAllMatches(true);
      
      PlayerSet matches = new PlayerSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Player) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public PlayerPO(){
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public PlayerPO(Player... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public PlayerPO hasTeam(String value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_TEAM)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO hasTeam(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_TEAM)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createTeam(String value)
   {
      this.startCreate().hasTeam(value).endCreate();
      return this;
   }
   
   public String getTeam()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).getTeam();
      }
      return null;
   }
   
   public PlayerPO withTeam(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setTeam(value);
      }
      return this;
   }
   
   public PlayerPO hasNumber(int value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_NUMBER)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO hasNumber(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_NUMBER)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createNumber(int value)
   {
      this.startCreate().hasNumber(value).endCreate();
      return this;
   }
   
   public int getNumber()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).getNumber();
      }
      return 0;
   }
   
   public PlayerPO withNumber(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setNumber(value);
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

   public PlayerPO hasField(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_FIELD);
   }

   public PlayerPO createField(FieldPO tgt)
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

   public PlayerPO hasBall(BallPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_BALL);
   }

   public PlayerPO createBall(BallPO tgt)
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

   public PlayerPO hasPitch(SoccerPitchPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_PITCH);
   }

   public PlayerPO createPitch(SoccerPitchPO tgt)
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

   public PlayerPO hasTackleDistance(int value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_TACKLEDISTANCE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO hasTackleDistance(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_TACKLEDISTANCE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createTackleDistance(int value)
   {
      this.startCreate().hasTackleDistance(value).endCreate();
      return this;
   }
   
   public int getTackleDistance()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).getTackleDistance();
      }
      return 0;
   }
   
   public PlayerPO withTackleDistance(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setTackleDistance(value);
      }
      return this;
   }
   
   public PlayerPO hasTgtX(int value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_TGTX)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO hasTgtX(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_TGTX)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createTgtX(int value)
   {
      this.startCreate().hasTgtX(value).endCreate();
      return this;
   }
   
   public int getTgtX()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).getTgtX();
      }
      return 0;
   }
   
   public PlayerPO withTgtX(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setTgtX(value);
      }
      return this;
   }
   
   public PlayerPO hasTgtY(int value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_TGTY)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO hasTgtY(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_TGTY)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createTgtY(int value)
   {
      this.startCreate().hasTgtY(value).endCreate();
      return this;
   }
   
   public int getTgtY()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).getTgtY();
      }
      return 0;
   }
   
   public PlayerPO withTgtY(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setTgtY(value);
      }
      return this;
   }
   
   public PlayerPO hasInGoalShootDistance(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_INGOALSHOOTDISTANCE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createInGoalShootDistance(boolean value)
   {
      this.startCreate().hasInGoalShootDistance(value).endCreate();
      return this;
   }
   
   public boolean getInGoalShootDistance()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).isInGoalShootDistance();
      }
      return false;
   }
   
   public PlayerPO withInGoalShootDistance(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setInGoalShootDistance(value);
      }
      return this;
   }
   
   public PlayerPO hasInPosition(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_INPOSITION)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createInPosition(boolean value)
   {
      this.startCreate().hasInPosition(value).endCreate();
      return this;
   }
   
   public boolean getInPosition()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).isInPosition();
      }
      return false;
   }
   
   public PlayerPO withInPosition(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setInPosition(value);
      }
      return this;
   }
   
   public PlayerPO hasOnSaveField(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_ONSAVEFIELD)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createOnSaveField(boolean value)
   {
      this.startCreate().hasOnSaveField(value).endCreate();
      return this;
   }
   
   public boolean getOnSaveField()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).isOnSaveField();
      }
      return false;
   }
   
   public PlayerPO withOnSaveField(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setOnSaveField(value);
      }
      return this;
   }
   
   public PlayerPO hasShootableFields(FieldSet value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_SHOOTABLEFIELDS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createShootableFields(FieldSet value)
   {
      this.startCreate().hasShootableFields(value).endCreate();
      return this;
   }
   
   public FieldSet getShootableFields()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).getShootableFields();
      }
      return null;
   }
   
   public PlayerPO withShootableFields(FieldSet value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setShootableFields(value);
      }
      return this;
   }
   
   public PlayerPO hasRunnableFields(FieldSet value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_RUNNABLEFIELDS)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      this.getPattern().findMatch();
      
      return this;
   }
   
   public PlayerPO createRunnableFields(FieldSet value)
   {
      this.startCreate().hasRunnableFields(value).endCreate();
      return this;
   }
   
   public FieldSet getRunnableFields()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).getRunnableFields();
      }
      return null;
   }
   
   public PlayerPO withRunnableFields(FieldSet value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setRunnableFields(value);
      }
      return this;
   }
   
}
