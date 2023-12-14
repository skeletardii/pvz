package Main;

import Entities.Misc.LawnMower;
import Entities.Misc.ZombieSpawner;
import Entities.Plants.Plant;
import Entities.Zombies.Zombie;
import GUI.SeedPacket;
import GameUtils.Game;
import GameUtils.Mouse;
import Main.Constants.GameMode;
import java.io.Serializable;
import java.util.ArrayList;

public class GameState implements Serializable {

  private static final long serialVersionUID = 1L;

  protected Game game;
  protected Mouse mouse;
  protected Mouse mouse_prev = new Mouse();
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

  public GameState() {
    game = Global.game;
    mouse = Global.mouse;
    mouse_prev = Global.mouse_prev;
    sun = Global.sun;
    mode = Global.mode;
    zombies = Global.zombies;
    plants = Global.plants;
    lawnMowers = Global.lawnMowers;
    zombieSpawner = Global.zombieSpawner;
    particles = Global.particles;
    gameMode = Global.gameMode;
    seeds = Global.seeds;
    seedsNum = Global.seedsNum;
  }
}
