package Main;

import Entities.Misc.Plant;
import Entities.Misc.Zombie;
import GUI.SeedPacket;
import GameUtils.Game;
import GameUtils.Mouse;
import GameUtils.Updater;
import java.util.ArrayList;

public class Global implements Updater {

  public static int PLANT_ROWS_COUNT = 6;
  public static int PLANT_COLS_COUNT = 9;

  public static Game game;
  public static Mouse mouse;
  public static Mouse mouse_prev;
  public static int sun = 0;
  public static Plant[][] plants = new Plant[PLANT_ROWS_COUNT][PLANT_COLS_COUNT];
  public static ArrayList<Zombie> zombies = new ArrayList<>();

  public void update() {
    mouse_prev = mouse;
    mouse = game.mouse;
  }

  public static void addPlant(Plant p, int row, int col) {
    plants[row][col] = p;
    p.setRow(row);
    p.setCol(col);
    game.add(p);
    p.zIndex = 5;
  }

  public void addZombie(Zombie z) {
    zombies.add(z);
    game.add(z);
    z.zIndex = 5;
  }

  public static SeedPacket[] seeds = new SeedPacket[10];
  public static int seedsNum = 0;

  public void addSeedPacket(SeedPacket sp) {
    seeds[seedsNum++] = sp;
    game.add(sp);
    sp.zIndex = 3;
    sp.setPosX((seedsNum - 1) * 55 + 77);
  }
}
