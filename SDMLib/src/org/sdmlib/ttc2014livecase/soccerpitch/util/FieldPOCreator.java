package org.sdmlib.ttc2014livecase.soccerpitch.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;

import de.uniks.networkparser.json.JsonIdMap;

import org.sdmlib.ttc2014livecase.soccerpitch.Field;

public class FieldPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new FieldPO(new Field[]{});
      } else {
          return new FieldPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return org.sdmlib.ttc2014livecase.soccerpitch.util.CreatorCreator.createIdMap(sessionID);
   }
}
