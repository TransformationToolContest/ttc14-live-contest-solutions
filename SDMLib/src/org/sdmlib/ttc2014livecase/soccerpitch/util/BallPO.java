package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.PatternObject;
import org.sdmlib.ttc2014livecase.soccerpitch.Ball;
import org.sdmlib.ttc2014livecase.soccerpitch.Field;
import org.sdmlib.ttc2014livecase.soccerpitch.Player;
import org.sdmlib.ttc2014livecase.soccerpitch.util.BallPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerPO;
import org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchPO;
import org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch;

public class BallPO extends PatternObject<BallPO, Ball>
{

    public BallSet allMatches()
   {
      this.setDoAllMatches(true);
      
      BallSet matches = new BallSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Ball) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public BallPO(){
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public BallPO(Ball... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public FieldPO hasField()
   {
      FieldPO result = new FieldPO(new org.sdmlib.ttc2014livecase.soccerpitch.Field[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Ball.PROPERTY_FIELD, result);
      
      return result;
   }

   public FieldPO createField()
   {
      return this.startCreate().hasField().endCreate();
   }

   public BallPO hasField(FieldPO tgt)
   {
      return hasLinkConstraint(tgt, Ball.PROPERTY_FIELD);
   }

   public BallPO createField(FieldPO tgt)
   {
      return this.startCreate().hasField(tgt).endCreate();
   }

   public Field getField()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Ball) this.getCurrentMatch()).getField();
      }
      return null;
   }

   public PlayerPO hasPlayer()
   {
      PlayerPO result = new PlayerPO(new org.sdmlib.ttc2014livecase.soccerpitch.Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Ball.PROPERTY_PLAYER, result);
      
      return result;
   }

   public PlayerPO createPlayer()
   {
      return this.startCreate().hasPlayer().endCreate();
   }

   public BallPO hasPlayer(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Ball.PROPERTY_PLAYER);
   }

   public BallPO createPlayer(PlayerPO tgt)
   {
      return this.startCreate().hasPlayer(tgt).endCreate();
   }

   public Player getPlayer()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Ball) this.getCurrentMatch()).getPlayer();
      }
      return null;
   }

   public SoccerPitchPO hasPitch()
   {
      SoccerPitchPO result = new SoccerPitchPO(new org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Ball.PROPERTY_PITCH, result);
      
      return result;
   }

   public SoccerPitchPO createPitch()
   {
      return this.startCreate().hasPitch().endCreate();
   }

   public BallPO hasPitch(SoccerPitchPO tgt)
   {
      return hasLinkConstraint(tgt, Ball.PROPERTY_PITCH);
   }

   public BallPO createPitch(SoccerPitchPO tgt)
   {
      return this.startCreate().hasPitch(tgt).endCreate();
   }

   public SoccerPitch getPitch()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Ball) this.getCurrentMatch()).getPitch();
      }
      return null;
   }

}
