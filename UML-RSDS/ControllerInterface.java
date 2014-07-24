import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

public interface ControllerInterface
{
  public void addBall(Ball oo);
    public Ball createBall(AbstractField fieldx);
  public void killBall(Ball ballxx);
 public void setfield(Ball ballx,AbstractField fieldxx);
 public void setplayer(Ball ballx,List playerxx);
   public void addplayer(Ball ballx,Player playerxx);
   public void removeplayer(Ball ballx,Player playerxx);
    public void addAbstractField(AbstractField oo);
    public void killAbstractField(AbstractField abstractfieldxx);
  public void killAbstractAbstractField(AbstractField abstractfieldxx);

  public void killAbstractAbstractField(List abstractfieldxx);

 public void setball(AbstractField abstractfieldx,List ballxx);
   public void addball(AbstractField abstractfieldx,Ball ballxx);
   public void removeball(AbstractField abstractfieldx,Ball ballxx);
   public void setplayers(AbstractField abstractfieldx,List playersxx);
   public void addplayers(AbstractField abstractfieldx,Player playersxx);
   public void removeplayers(AbstractField abstractfieldx,Player playersxx);
    public void addSoccerPitch(SoccerPitch oo);
    public SoccerPitch createSoccerPitch(Ball ballsx);
  public void killSoccerPitch(SoccerPitch soccerpitchxx);
 public void setplayers(SoccerPitch soccerpitchx,List playersxx);
   public void addplayers(SoccerPitch soccerpitchx,Player playersxx);
   public void removeplayers(SoccerPitch soccerpitchx,Player playersxx);
   public void setballs(SoccerPitch soccerpitchx,Ball ballsxx);
 public void setfields(SoccerPitch soccerpitchx,List fieldsxx);
   public void addfields(SoccerPitch soccerpitchx,AbstractField fieldsxx);
   public void removefields(SoccerPitch soccerpitchx,AbstractField fieldsxx);
    public void addPlayer(Player oo);
    public void killPlayer(Player playerxx);
  public void killAbstractPlayer(Player playerxx);

  public void killAbstractPlayer(List playerxx);

 public void setfield(Player playerx,AbstractField fieldxx);
 public void setball(Player playerx,List ballxx);
   public void addball(Player playerx,Ball ballxx);
   public void removeball(Player playerx,Ball ballxx);
    public void addFieldPlayer(FieldPlayer oo);
    public FieldPlayer createFieldPlayer();
  public void killFieldPlayer(FieldPlayer fieldplayerxx);
  public void addGoalKeeper(GoalKeeper oo);
    public GoalKeeper createGoalKeeper();
  public void killGoalKeeper(GoalKeeper goalkeeperxx);
  public void addGoalField(GoalField oo);
    public GoalField createGoalField();
  public void killGoalField(GoalField goalfieldxx);
  public void addField(Field oo);
    public Field createField();
  public void killField(Field fieldxx);
  public void addUpdate(Update oo);
    public Update createUpdate();
  public void killUpdate(Update updatexx);
 public void setactions(Update updatex,List actionsxx);
   public void addactions(Update updatex,Action actionsxx);
   public void removeactions(Update updatex,Action actionsxx);
    public void addAction(Action oo);
    public void killAction(Action actionxx);
  public void killAbstractAction(Action actionxx);

  public void killAbstractAction(List actionxx);

  public void addMovePlayer(MovePlayer oo);
    public MovePlayer createMovePlayer();
  public void killMovePlayer(MovePlayer moveplayerxx);
  public void addShootBall(ShootBall oo);
    public ShootBall createShootBall();
  public void killShootBall(ShootBall shootballxx);
}

