package org.sdmlib.ttc2014livecase.soccerpitch.util;

import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.serialization.SDMLibJsonIdMap;

public class CreatorCreator{

   public static JsonIdMap createIdMap(String sessionID)
   {
      JsonIdMap jsonIdMap = (JsonIdMap) new SDMLibJsonIdMap().withSessionId(sessionID);
      
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.FieldCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.PlayerPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.BallCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.BallPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPlayerCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.FieldPlayerPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.GoalKeeperCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.GoalKeeperPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.GoalFieldCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.GoalFieldPOCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchCreator());
      jsonIdMap.withCreator(new org.sdmlib.ttc2014livecase.soccerpitch.util.SoccerPitchPOCreator());

      return jsonIdMap;
   }
}
