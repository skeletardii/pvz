package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class ConeheadZombie extends Zombie {

  protected ConeheadZombie(int row) {
    super(new ZombieBuilder().setRow(row).setArmor(new Armor.Cone()));
  }
}
