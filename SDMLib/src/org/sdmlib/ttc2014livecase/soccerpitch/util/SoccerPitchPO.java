package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallPO;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerSet;

public class SoccerPitchPO extends PatternObject<SoccerPitchPO, SoccerPitch>
{

    public SoccerPitchSet allMatches()
   {
      this.setDoAllMatches(true);
      
      SoccerPitchSet matches = new SoccerPitchSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((SoccerPitch) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public SoccerPitchPO(){
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public SoccerPitchPO(SoccerPitch... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public FieldPO hasFields()
   {
      FieldPO result = new FieldPO(new org.sdmlib.ttc2014livecase.soccerpitch.Field[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(SoccerPitch.PROPERTY_FIELDS, result);
      
      return result;
   }

   public FieldPO createFields()
   {
      return this.startCreate().hasFields().endCreate();
   }

   public SoccerPitchPO hasFields(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, SoccerPitch.PROPERTY_FIELDS);
   }

   public SoccerPitchPO createFields(FieldPO tgt)
   {
      return this.startCreate().hasFields(tgt).endCreate();
   }

   public FieldSet getFields()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((SoccerPitch) this.getCurrentMatch()).getFields();
      }
      return null;
   }

   public BallPO hasBall()
   {
      BallPO result = new BallPO(new org.sdmlib.ttc2014livecase.soccerpitch.Ball[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(SoccerPitch.PROPERTY_BALL, result);
      
      return result;
   }

   public BallPO createBall()
   {
      return this.startCreate().hasBall().endCreate();
   }

   public SoccerPitchPO hasBall(BallPO tgt)
   {
      return hasLinkConstraint(tgt, SoccerPitch.PROPERTY_BALL);
   }

   public SoccerPitchPO createBall(BallPO tgt)
   {
      return this.startCreate().hasBall(tgt).endCreate();
   }

   public Ball getBall()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((SoccerPitch) this.getCurrentMatch()).getBall();
      }
      return null;
   }

   public PlayerPO hasPlayers()
   {
      PlayerPO result = new PlayerPO(new org.sdmlib.ttc2014livecase.soccerpitch.Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(SoccerPitch.PROPERTY_PLAYERS, result);
      
      return result;
   }

   public PlayerPO createPlayers()
   {
      return this.startCreate().hasPlayers().endCreate();
   }

   public SoccerPitchPO hasPlayers(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, SoccerPitch.PROPERTY_PLAYERS);
   }

   public SoccerPitchPO createPlayers(PlayerPO tgt)
   {
      return this.startCreate().hasPlayers(tgt).endCreate();
   }

   public PlayerSet getPlayers()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((SoccerPitch) this.getCurrentMatch()).getPlayers();
      }
      return null;
   }

}
