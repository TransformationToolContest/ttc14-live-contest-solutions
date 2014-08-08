package update.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;

import de.uniks.networkparser.json.JsonIdMap;
import update.MovePlayer;

public class MovePlayerPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new MovePlayerPO(new MovePlayer[]{});
      } else {
          return new MovePlayerPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return update.util.CreatorCreator.createIdMap(sessionID);
   }
}
