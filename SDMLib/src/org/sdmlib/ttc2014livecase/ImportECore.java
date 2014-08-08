package org.sdmlib.ttc2014livecase;

import org.sdmlib.models.classes.ClassModel;
import org.sdmlib.storyboards.Kanban;
import org.sdmlib.storyboards.Storyboard;
import org.sdmlib.tools.EMFTool;
import org.sdmlib.ttc2014livecase.soccerpitch.util.FieldSet;
import org.sdmlib.models.classes.Clazz;
import org.sdmlib.models.classes.Association;
import org.sdmlib.models.classes.Card;
import org.sdmlib.models.classes.Attribute;
import org.sdmlib.models.classes.DataType;

public class ImportECore
{
   public static void main(String[] args)
   {
      Storyboard story = new Storyboard();
      
      loadSoccerPitch(story);

      loadUpdateModel(story);
      
      story.addToDo("Load ecore models and generate SDMLib implementation", Kanban.BACKLOG, "christoph&albert", "05.07.2014 10:00:00 GMT", 0, 2);
      story.addToDo("Connect to server", Kanban.BACKLOG, "christoph&albert", "05.07.2014 10:01:00 GMT", 0, 2);
      story.addToDo("Load soccer pitch from server", Kanban.BACKLOG, "christoph&albert", "05.07.2014 10:02:00 GMT", 0, 2);
      story.addToDo("Send updates to server", Kanban.BACKLOG, "christoph&albert", "05.07.2014 10:03:00 GMT", 0, 2);
      story.addToDo("Defense Strategy", Kanban.BACKLOG, "christoph&albert", "05.07.2014 10:04:00 GMT", 0, 8);
      story.addToDo("Offense Strategy", Kanban.BACKLOG, "christoph&albert", "05.07.2014 10:05:00 GMT", 0, 8);
      story.addToDo("Beat Tassilo Strategy", Kanban.BACKLOG, "christoph&albert", "05.07.2014 10:06:00 GMT", 0, 8);
      
      story.addToDo("Load ecore models and generate SDMLib implementation", Kanban.DONE, "christoph&albert", "05.07.2014 12:00:00 GMT", 2, 0);
      story.addToDo("Connect to server", Kanban.BACKLOG, "christoph&albert", "05.07.2014 12:01:00 GMT", 1.5, 0);
      
      story.addToDo("Load soccer pitch from server", Kanban.IMPLEMENTATION, "christoph&albert", "01.08.2014 12:00:00 CEST", 0, 2);
      story.addToDo("Load soccer pitch from server", Kanban.DONE, "christoph&albert", "01.08.2014 14:26:00 CEST", 2.4, 0);
      
      story.addToDo("Send updates to server", Kanban.IMPLEMENTATION, "christoph&albert", "01.08.2014 15:43:00 CEST", 0, 2);
      story.addToDo("Send updates to server", Kanban.IMPLEMENTATION, "christoph&albert", "01.08.2014 19:13:00 CEST", 1, 1);
      story.addToDo("Send updates to server", Kanban.DONE, "christoph&albert", "01.08.2014 22:33:00 CEST", 1, 0);
      story.addToDo("Defense Strategy", Kanban.DONE, "christoph&albert", "02.08.2014 23:00:00 CEST", 6, 0);
      story.addToDo("Offense Strategy", Kanban.DONE, "christoph&albert", "05.08.2014 18:00:00 CEST", 8, 0);
      story.addToDo("Beat Tassilo Strategy", Kanban.DONE, "christoph&albert", "06.08.2014 04:00:00 CEST", 6, 0);
      
      
      story.dumpHTML();

      System.out.println("done");
   }

   private static void loadUpdateModel(Storyboard story)
   {
      EMFTool emfTool = new EMFTool();
      
      // ClassModel model = emfTool.ecoreModelToClassModel("update", "update.ecore");

      ClassModel model = new ClassModel("update");
      
      Clazz updateClass = model.createClazz("update.Update")
      .with(new Attribute("actions", DataType.ref("ActionSet")) );

      Clazz actionClass = model.createClazz("update.Action")
      .with(new Attribute("playerNumber", DataType.INT) )
      .with(new Attribute("xDist", DataType.INT) )
      .with(new Attribute("yDist", DataType.INT) );

      Clazz movePlayerClass = model.createClazz("update.MovePlayer")
      .withSuperClazz(actionClass);

      Clazz shootBallClass = model.createClazz("update.ShootBall")
      .withSuperClazz(actionClass);


      // model.getGenerator().insertModelCreationCodeHere("src");
      
      story.addClassDiagram(model);
      
      model.generate("src");
   }

   private static void loadSoccerPitch(Storyboard story)
   {
      EMFTool emfTool = new EMFTool();
      
      // ClassModel model = emfTool.ecoreModelToClassModel("org.sdmlib.ttc2014livecase.soccerpitch", "soccerpitch.ecore");

      ClassModel model = new ClassModel("org.sdmlib.ttc2014livecase.soccerpitch");
      
      Clazz fieldClass = model.createClazz("org.sdmlib.ttc2014livecase.soccerpitch.Field")
      .with(new Attribute("xPos", DataType.INT) )
      .with(new Attribute("yPos", DataType.INT) )
      .withAttribute("opponentDistance", DataType.INT);

      fieldClass.withAssoc(fieldClass, "north", Card.ONE, "south", Card.ONE);

      fieldClass.withAssoc(fieldClass, "east", Card.ONE, "west", Card.ONE);

      Clazz playerClass = model.createClazz("org.sdmlib.ttc2014livecase.soccerpitch.Player")
      .with(new Attribute("team", DataType.STRING) )
      .with(new Attribute("number", DataType.INT) )
      .withAttribute("tackleDistance", DataType.INT, "Integer.MAX_VALUE")
      .withAttribute("tgtX", DataType.INT)
      .withAttribute("tgtY", DataType.INT)
      .withAttribute("inGoalShootDistance", DataType.BOOLEAN)
      .withAttribute("inPosition", DataType.BOOLEAN)
      .withAttribute("onSaveField", DataType.BOOLEAN)
      .withAttribute("shootableFields", DataType.ref(FieldSet.class.getName()))
      .withAttribute("runnableFields", DataType.ref(FieldSet.class.getName()))
      ;

      fieldClass.withAssoc(playerClass, "players", Card.MANY, "field", Card.ONE);

      Clazz ballClass = model.createClazz("org.sdmlib.ttc2014livecase.soccerpitch.Ball");

      fieldClass.withAssoc(ballClass, "ball", Card.ONE, "field", Card.ONE);

      playerClass.withAssoc(ballClass, "ball", Card.ONE, "player", Card.ONE);

      Clazz fieldPlayerClass = model.createClazz("org.sdmlib.ttc2014livecase.soccerpitch.FieldPlayer")
      .withSuperClazz(playerClass);

      Clazz goalKeeperClass = model.createClazz("org.sdmlib.ttc2014livecase.soccerpitch.GoalKeeper")
      .withSuperClazz(playerClass);

      Clazz goalFieldClass = model.createClazz("org.sdmlib.ttc2014livecase.soccerpitch.GoalField")
      .withSuperClazz(fieldClass)
      .with(new Attribute("team", DataType.STRING) );

      Clazz soccerPitchClass = model.createClazz("org.sdmlib.ttc2014livecase.soccerpitch.SoccerPitch");
      
      soccerPitchClass.withAssoc(fieldClass, "fields", Card.MANY, "pitch", Card.ONE);
      soccerPitchClass.withAssoc(ballClass, "ball", Card.ONE, "pitch", Card.ONE);
      soccerPitchClass.withAssoc(playerClass, "players", Card.MANY, "pitch", Card.ONE);
      
      story.addClassDiagram(model);
      
      model.getGenerator().insertModelCreationCodeHere("src");
      
      model.generate("src");
   }
}
