package Main;

import Entities.Interfaces.Upgradable;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Global implements Updater, Serializable {

  private static final long serialVersionUID = 1L;
  private static final Global instance = new Global();

  public static Game game;
  public static Mouse mouse;
  public static Mouse mouse_prev = new Mouse();
  public static int mode = 0;
  public static int sun = 0;

  public static final GameMode gameMode = GameMode.LAWN_DAY;

  @SuppressWarnings("unchecked")
  public static ArrayList<Zombie>[] zombies = new ArrayList[Constants.PLANT_ROWS_COUNT];

  public static Plant[][] plants = new Plant[Constants.PLANT_ROWS_COUNT][Constants.PLANT_COLS_COUNT];

  public static LawnMower[] lawnMowers = new LawnMower[Constants.PLANT_ROWS_COUNT];
  public static ZombieSpawner zombieSpawner = new ZombieSpawner();
  public static ArrayList<Object> particles = new ArrayList<>();

  public static SeedPacket[] seeds = new SeedPacket[20];
  public static int seedsNum = 0;
  public static GameSettings gameSettings = null;

  public Global() {
    // ayaw lang sa ni i mind

    try {
      GameState state = null;
      // GameState state = loadFromFile("./data/testing.ser");

      if (state == null) throw new NullPointerException("State is missing");

      Global.game = state.game;
      Global.mode = state.mode;
      Global.sun = state.sun;
      Global.zombies = state.zombies;
      Global.plants = state.plants;
      Global.lawnMowers = state.lawnMowers;
      Global.zombieSpawner = state.zombieSpawner;
      Global.particles = state.particles;
      Global.seeds = state.seeds;
      Global.seedsNum = state.seedsNum;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void init() {
    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; i++) {
      zombies[i] = new ArrayList<>();
    }
  }

  public void update() {
    updateMouse();
    checkZombiesToRemove();
    zombieSpawner.spawnZombie();
  }

  // changed to static
  private static void updateMouse() {
    mouse_prev.left = mouse.left;
    mouse_prev.right = mouse.right;
    mouse_prev.middle = mouse.middle;
    mouse_prev.x = mouse.x;
    mouse_prev.y = mouse.y;
    mouse = game.mouse;

    if (mouse.x >= 800) mouse.x = 799;
    if (mouse.x <= 0) mouse.x = 0;
    if (mouse.y >= 600) mouse.y = 599;
    if (mouse.y <= 0) mouse.x = 0;
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
        throw new Exception("Plant is not alseep");
      }
      Global.plants[row][col].add(p);
    } else if (p instanceof Pumpkin) {
      if (plants[row][col] == null) {
        throw new Exception("No plants in the cell for pumpking");
      }
      plants[row][col].setPumpkin(p);
    } else {
      if (plants[row][col] != null) {
        throw new ArrayStoreException("Plant already in plot");
      }
      plants[row][col] = p;
    }

    game.add(p);
    p.setRow(row);
    p.setCol(col);
    p.setZindex(5 + row + col * 0.1);
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

  public static void checkZombiesToRemove() { //wtf is this bro
    @SuppressWarnings("unchecked")
    ArrayList<Zombie>[] updatedZombies = new ArrayList[Constants.PLANT_ROWS_COUNT];
    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; i++) {
      updatedZombies[i] = new ArrayList<>();
    }

    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; i++) {
      for (Zombie z : zombies[i]) {
        if (z.getHealth() <= 0) {
          z.remove();
        } else {
          updatedZombies[i].add(z);
        }
      }
    }
    zombies = updatedZombies;
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

  protected static void saveToFile(String filePath) {
    try (
      ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream(filePath)
      )
    ) {
      GameState state = new GameState();
      oos.writeObject(state);
      System.out.println("Game state saved to file successfully.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected static GameSettings loadFromFile(String filePath) {
    try (
      ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream(filePath)
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
