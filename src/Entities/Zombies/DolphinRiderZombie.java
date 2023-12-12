package Entities.Zombies;

import Entities.Plants.PlantBuilder;

public class DolphinRiderZombie extends PoleVaultingZombie {

  public DolphinRiderZombie(int row) {
    super(
      new ZombieBuilder()
        .setRow(row)
        .setMovementSpeed(ZombieSpeed.VERY_FAST.getValue())
    );
  }
}
