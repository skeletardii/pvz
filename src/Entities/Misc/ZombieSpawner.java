package Entities.Misc;

import Entities.Zombies.*;
import GameUtils.Updater;
import Main.Constants;
import Main.Global;

import java.util.ArrayList;
import java.util.Random;

public class ZombieSpawner implements Updater {

  public static final Random RAND = new Random();

  private final int zombieSpawnRate;
  private int zombieSpawnCtr;

  private static ArrayList<Zombie> zombiesToSpawn;

  public ZombieSpawner() {
    zombieSpawnRate = 240 / (Global.gameSettings == null ? 1 : Global.gameSettings.zombieSpawnRateMultiplier);
    zombieSpawnCtr = 0;
    zombiesToSpawn = new ArrayList<>();
  }

  public void init() {
    for (String s : Global.gameSettings.selectedZombies) {
      zombiesToSpawn.add(Constants.zombiesMap.get(s));
    }
    System.out.println(zombiesToSpawn);
  }

  public void spawnZombie() {
    try {
      int spawnRow = RAND.nextInt(Constants.PLANT_ROWS_COUNT);
      int spawnIndex = RAND.nextInt(zombiesToSpawn.size() - 1);
      Zombie z = zombiesToSpawn.get(spawnIndex).getClass().getDeclaredConstructor().newInstance();
      z.setRow(spawnRow);
      Global.addZombie(z);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update() {
    zombieSpawnCtr++;

    if (zombieSpawnCtr >= zombieSpawnRate) {
      zombieSpawnCtr = 0;
      spawnZombie();
    }
  }
}
