package Entities.Misc;

import Entities.Zombies.*;
import Main.Constants;
import Main.Global;
import java.util.Random;

public class ZombieSpawner {

  public static final Random RAND = new Random();

  private final int zombieSpawnRate;
  private int zombieSpawnCtr;

  public ZombieSpawner() {
    zombieSpawnRate = 240 / (Global.gameSettings == null ? 1 : Global.gameSettings.zombieSpawnRateMultiplier);
    zombieSpawnCtr = 0;
  }

  public void spawnZombie() {
    // makeshift spawner pani
    zombieSpawnCtr++;

    if (zombieSpawnCtr >= zombieSpawnRate) {
      zombieSpawnCtr = 0;
      int spawnRow = RAND.nextInt(Constants.PLANT_ROWS_COUNT);
      // Global.addZombie(new DolphinRiderZombie(spawnRow));
      // Global.addZombie(new DiggerZombie(spawnRow));
      // Global.addZombie(new Gargantuar(spawnRow));
      // Global.addZombie(new PogoZombie(spawnRow));
      // Global.addZombie(new LadderZombie(spawnRow));
      Global.addZombie(new Zombie(spawnRow));
    }
  }
}
