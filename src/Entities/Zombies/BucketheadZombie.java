package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class BucketheadZombie extends NormalZombie {

  protected BucketheadZombie(int row) {
    super(row);
    armor = new Armor.Bucket();
  }
}
