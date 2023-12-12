package Entities.Misc;

import Entities.Zombies.DiggerZombie;
import Entities.Zombies.DolphinRiderZombie;
import Entities.Zombies.Gargantuar;
import Entities.Zombies.LadderZombie;
import Entities.Zombies.PogoZombie;
import Entities.Zombies.Zombie;
import Main.Constants;
import Main.Global;
import java.io.Serializable;
import java.util.Random;

public class ZombieSpawner implements Serializable {

  private static final long serialVersionUID = 1L;

  // galibog pako ani, mu spawn by wave mana diay ang zombies sa pvz diba? nya each increasing wave kay more rows sila mu spawn until sa final wave where mu spawn nas tanna
  public static final Random RAND = new Random();
  private int zombieSpawnRate = 240;
  private int zombieSpawnCtr = 0;

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
      Global.addZombie(new LadderZombie(spawnRow));
    }
  }
}
