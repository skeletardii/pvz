package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class ConeheadZombie extends NormalZombie {

  protected ConeheadZombie(int row) {
    super(row);
    armor = new Armor.Cone();
  }
}
