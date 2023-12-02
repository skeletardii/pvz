package Entities.Misc;

import Entities.Zombies.NormalZombie;
import Main.Global;
import java.util.Random;

public class ZombieSpawner {

  // galibog pako ani, mu spawn by wave mana diay ang zombies sa pvz diba? nya each increasing wave kay more rows sila mu spawn until sa final wave where mu spawn nas tanna
  public static final Random RAND = new Random();
  private int zombieSpawnRate = 10;
  private int zombieSpawnCtr = 0;

  public void spawnZombie() {
    zombieSpawnCtr++;

    if (zombieSpawnCtr >= zombieSpawnRate) {
      zombieSpawnCtr = 0;
      Global.addZombie(new NormalZombie());
    }
  }
}
