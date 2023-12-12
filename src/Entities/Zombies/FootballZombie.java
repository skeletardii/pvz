package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class FootballZombie extends Zombie {

  protected FootballZombie(int row) {
    super(
      new ZombieBuilder()
        .setRow(row)
        .setArmor(new Armor.FootballGear())
        .setMovementSpeed(ZombieSpeed.FAST.getValue())
    );
  }
}
