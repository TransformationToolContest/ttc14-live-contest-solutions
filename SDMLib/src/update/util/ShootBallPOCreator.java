package update.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;

import de.uniks.networkparser.json.JsonIdMap;
import update.ShootBall;

public class ShootBallPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ShootBallPO(new ShootBall[]{});
      } else {
          return new ShootBallPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return update.util.CreatorCreator.createIdMap(sessionID);
   }
}
