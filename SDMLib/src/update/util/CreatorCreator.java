package update.util;

import de.uniks.networkparser.json.JsonIdMap;
import org.sdmlib.serialization.SDMLibJsonIdMap;

public class CreatorCreator{

   public static JsonIdMap createIdMap(String sessionID)
   {
      JsonIdMap jsonIdMap = (JsonIdMap) new SDMLibJsonIdMap().withSessionId(sessionID);
      
      jsonIdMap.withCreator(new update.util.UpdateCreator());
      jsonIdMap.withCreator(new update.util.UpdatePOCreator());
      jsonIdMap.withCreator(new update.util.ActionCreator());
      jsonIdMap.withCreator(new update.util.ActionPOCreator());
      jsonIdMap.withCreator(new update.util.MovePlayerCreator());
      jsonIdMap.withCreator(new update.util.MovePlayerPOCreator());
      jsonIdMap.withCreator(new update.util.ShootBallCreator());
      jsonIdMap.withCreator(new update.util.ShootBallPOCreator());
      jsonIdMap.withCreator(new update.util.ActionSetCreator());
      jsonIdMap.withCreator(new update.util.ActionSetPOCreator());

      return jsonIdMap;
   }
}
