package update.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;

import de.uniks.networkparser.json.JsonIdMap;

public class ActionSetPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ActionSetPO(new ActionSet[]{});
      } else {
          return new ActionSetPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return update.util.CreatorCreator.createIdMap(sessionID);
   }
}
