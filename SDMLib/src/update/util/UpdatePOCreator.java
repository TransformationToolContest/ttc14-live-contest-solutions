package update.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;

import de.uniks.networkparser.json.JsonIdMap;
import update.Update;

public class UpdatePOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new UpdatePO(new Update[]{});
      } else {
          return new UpdatePO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return update.util.CreatorCreator.createIdMap(sessionID);
   }
}
