package update.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;

import de.uniks.networkparser.json.JsonIdMap;
import update.Action;

public class ActionPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ActionPO(new Action[]{});
      } else {
          return new ActionPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return update.util.CreatorCreator.createIdMap(sessionID);
   }
}
