package Main;

import Entities.Interfaces.Upgraded;
import Entities.Misc.LawnMower;
import Entities.Misc.ZombieSpawner;
import Entities.Plants.LawnNight.Shroom;
import Entities.Plants.Plant;
import Entities.Plants.PoolNight.CoffeeBean;
import Entities.Plants.PoolNight.Pumpkin;
import Entities.Zombies.Zombie;
import GUI.SeedPacket;
import GameUtils.Game;
import GameUtils.Mouse;
import GameUtils.Updater;
import LevelEditor.GameSettings;
import Main.Constants.GameMode;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("CallToPrintStackTrace")
public class Global implements Updater {

  @Serial
  private static final long serialVersionUID = 1L;

  public static Game game;
  public static Mouse mouse;
  public static Mouse mouse_prev = new Mouse();
  public static int mode = 0;
  public static int sun = 0;

  public static final GameMode gameMode = GameMode.LAWN_DAY;

  public static GameSettings gameSettings = new GameSettings();
  @SuppressWarnings("unchecked")
  public static ArrayList<Zombie>[] zombies = new ArrayList[Constants.PLANT_ROWS_COUNT];

  public static Plant[][] plants = new Plant[Constants.PLANT_ROWS_COUNT][Constants.PLANT_COLS_COUNT];

  public static LawnMower[] lawnMowers = new LawnMower[Constants.PLANT_ROWS_COUNT];
  public static ZombieSpawner zombieSpawner = new ZombieSpawner();
  public static ArrayList<Object> particles = new ArrayList<>();

  public static SeedPacket[] seeds = new SeedPacket[20];
  public static int seedsNum = 0;

  public static void init() {
    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; i++) {
      zombies[i] = new ArrayList<>();
    }
  }

  public void update() {
    updateMouse();
    checkZombiesToRemove();
  }

  // changed to static
  private static void updateMouse() {
    mouse_prev.left = mouse.left;
    mouse_prev.right = mouse.right;
    mouse_prev.middle = mouse.middle;
    mouse_prev.x = mouse.x;
    mouse_prev.y = mouse.y;
    mouse = game.mouse;

  }

  public static void addParticle(Object particle) {
    particles.add(particle);
    game.add(particle);
  }

  public static void addPlant(Plant p, int row, int col) throws Exception {
    if (p instanceof CoffeeBean) {
      if (plants[row][col] == null) {
        throw new Exception("No plants in the cell for coffee bean");
      }
      if (
        !(plants[row][col] instanceof Shroom) ||
        !((Shroom) plants[row][col]).isAsleep()
      ) {
        throw new Exception("Plant is not asleep");
      }
      Global.plants[row][col].add(p);
    } else if (p instanceof Pumpkin) {
      if (plants[row][col] == null) {
        throw new Exception("No plants in the cell for Pumpkin");
      }
      plants[row][col].setPumpkin(p);
      plants[row][col].add(p);
    } else if (p instanceof Upgraded) {
      if (plants[row][col] != null && plants[row][col].getClass() == ((Upgraded) p).getLowerClass().getClass()) {
        Global.removePlant(row, col);
        plants[row][col] = p;
        game.add(p);
      } else {
        throw new Exception(("Plant is not its upgradable counterpart"));
      }
    } else {
      if (plants[row][col] != null) {
        throw new IllegalStateException("Plant already in plot");
      }
      plants[row][col] = p;
      game.add(p);
    }
    p.setRow(row);
    p.setCol(col);
    p.setZindex(5 + row + (Constants.PLANT_COLS_COUNT-col) * 0.1);
  }

  public static void removePlant(int row, int col) {
    if (plants[row][col] == null) {
      System.out.println("NO PLANT HERE!");
      return;
    }
    plants[row][col].remove();
    plants[row][col] = null;
  }

  public static void addZombie(Zombie z) {
    z.setZindex(6.0 + z.getRow());
    zombies[(int) z.getRow()].add(z);
    game.add(z);
  }

  public static void checkZombiesToRemove() {
    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; i++) {
      Iterator<Zombie> it = zombies[i].iterator();
      while (it.hasNext()) {
        Zombie z = it.next();
        if (z.getHealth() <= 0) {
          z.remove();
          it.remove();
        }
      }
    }
  }

  public static void addLawnMowers(int row) {
    LawnMower l = new LawnMower(row);
    lawnMowers[row] = l;
    game.add(l);
  }

  public static void addSeedPacket(SeedPacket sp) {
    seeds[seedsNum++] = sp;
    game.add(sp);
    sp.setZindex(3);
    sp.setPosX((seedsNum - 1) * 55 + 77);
  }



  protected static GameSettings loadFromFile() {
    try (
      ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("./data/settings.ser")
      )
    ) {
      GameSettings settings = (GameSettings) ois.readObject();
      System.out.println("Game settings loaded from file successfully.");
      return settings;
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}
