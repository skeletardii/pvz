package Main;

import Entities.Misc.LawnMower;
import Entities.Misc.Plant;
import Entities.Misc.Zombie;
import Entities.Misc.ZombieSpawner;
import GUI.SeedPacket;
import GameUtils.Game;
import GameUtils.Mouse;
import GameUtils.Updater;
import java.util.ArrayList;

public class Global implements Updater {

  public static Game game;
  public static Mouse mouse;
  public static Mouse mouse_prev = new Mouse();
  public static int sun = 0;
  public static int mode = 0;
  public static final int PLANT_ROWS_COUNT = 6;
  public static final int PLANT_COLS_COUNT = 9;
  public static final int ROW_PIXEL_OFFSET = 80;
  public static final int COL_PIXEL_OFFSET = 100;
  public static Plant[][] plants = new Plant[PLANT_ROWS_COUNT][PLANT_COLS_COUNT];
  public static ArrayList<Zombie> zombies = new ArrayList<>();
  public static LawnMower[] lawnMowers = new LawnMower[PLANT_ROWS_COUNT];
  public static ZombieSpawner zombieSpawner = new ZombieSpawner();

  // temp numbers rani
  public enum SeedPacketRechargeTime {
    VERY_SLOW(20),
    SLOW(15),
    FAST(7.5);

    private final double value;

    SeedPacketRechargeTime(double value) {
      this.value = value;
    }

    public double getValue() {
      return value;
    }
  }

  public static void init() {
    // if(mode==2 || mode==3){
    //     PLANT_ROWS_COUNT = 6;
    // }
  }

  public void update() {
    updateMouse();
    checkZombiesToRemove();
    zombieSpawner.spawnZombie();
  }

  private void updateMouse() {
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

  public static void addPlant(Plant p, int row, int col) throws ArrayStoreException{
    if (plants[row][col] != null) {
      throw new ArrayStoreException("Plant already in plot");
    }
    plants[row][col] = p;
    p.setRow(row);
    p.setCol(col);
    game.add(p);
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
    z.setZindex(6 + z.row);
    zombies.add(z);
    game.add(z);
  }

  public static void checkZombiesToRemove() {
    ArrayList<Zombie> updatedZombies = new ArrayList<>();
    for (Zombie z : zombies) {
      if (z.getHealth() <= 0) {
        z.remove();
      } else {
        updatedZombies.add(z);
      }
    }
    zombies = updatedZombies;
  }

  public static void addLawnMowers(int row) {
    LawnMower l = new LawnMower(row);
    lawnMowers[row] = l;
    game.add(l);
  }

  public static SeedPacket[] seeds = new SeedPacket[10];
  public static int seedsNum = 0;

  public static void addSeedPacket(SeedPacket sp) {
    seeds[seedsNum++] = sp;
    game.add(sp);
    sp.setZindex(3);
    sp.setPosX((seedsNum - 1) * 55 + 77);
  }
}
