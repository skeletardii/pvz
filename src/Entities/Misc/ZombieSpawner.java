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

  private final ArrayList<Zombie> zombiesToSpawn = new ArrayList<>();
  private double difficultyMultiplier = 1;

  public ZombieSpawner() {
    zombieSpawnRate = 240 / (Global.gameSettings == null ? 1 : Global.gameSettings.zombieSpawnRateMultiplier);
    zombieSpawnCtr = 0;
  }

  public void init() {
    zombiesToSpawn.clear();
    for (String s : Global.gameSettings.selectedZombies) {
      zombiesToSpawn.add(Constants.zombiesMap.get(s));
    }
  }

  public void spawnZombie() {
    int zombieCount = 0;
    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; ++i) {
      zombieCount += Global.zombies[i].size();
    }

    if (zombieCount > 0) {
      return;
    }

    try {
      int n = zombiesToSpawn.size();
      if (n == 0) return;

      for (int i = 0; i < (int)difficultyMultiplier; ++i) {
        int spawnRow = RAND.nextInt(Constants.PLANT_ROWS_COUNT);
        int spawnIndex = RAND.nextInt(n);

        Zombie z = zombiesToSpawn.get(spawnIndex).getClass().getDeclaredConstructor().newInstance();
        z.setRow(spawnRow);
        Global.addZombie(z);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update() {
    zombieSpawnCtr++;
    difficultyMultiplier += 0.001;

    if (zombieSpawnCtr >= zombieSpawnRate) {
      zombieSpawnCtr = 0;
      spawnZombie();
    }
  }
}
