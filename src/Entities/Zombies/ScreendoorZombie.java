package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class ScreendoorZombie extends Zombie {

  public ScreendoorZombie(int row) {
    super(new ZombieBuilder().setRow(row).setArmor(new Armor.Screendoor()));
  }

  public ScreendoorZombie() {
    this(-1);
  }
}
