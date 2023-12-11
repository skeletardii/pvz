package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class BucketheadZombie extends Zombie {

  protected BucketheadZombie(int row) {
    super(new ZombieBuilder().setRow(row).setArmor(new Armor.Bucket()));
  }
}
