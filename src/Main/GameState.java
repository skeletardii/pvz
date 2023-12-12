package Main;

import Entities.Misc.LawnMower;
import Entities.Misc.ZombieSpawner;
import Entities.Plants.Plant;
import Entities.Zombies.Zombie;
import GUI.SeedPacket;
import GameUtils.Game;
import GameUtils.Mouse;
import Main.Constants.GameMode;
import java.util.ArrayList;

public class GameState {

  protected Game game;
  protected Mouse mouse;
  protected Mouse mousePrev = new Mouse();
  protected int sun = 0;
  protected int mode = 0;

  @SuppressWarnings("unchecked")
  protected ArrayList<Zombie>[] zombies = new ArrayList[Constants.PLANT_ROWS_COUNT];

  protected Plant[][] plants = new Plant[Constants.PLANT_ROWS_COUNT][Constants.PLANT_COLS_COUNT];
  protected LawnMower[] lawnMowers = new LawnMower[Constants.PLANT_ROWS_COUNT];
  protected ZombieSpawner zombieSpawner = new ZombieSpawner();
  protected ArrayList<Object> particles = new ArrayList<>();
  protected GameMode gameMode = GameMode.LAWN_DAY;
  protected SeedPacket[] seeds = new SeedPacket[20];
  protected int seedsNum = 0;
}
