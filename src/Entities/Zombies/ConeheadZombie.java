package Entities.Zombies;

import Entities.Misc.Armor;

public class ConeheadZombie extends NormalZombie {

  protected ConeheadZombie(int row) {
    super(row);
    Armor a = new Armor(row, 10, 181, "sunflower", 364, 365, 1);
    this.add(a);
  }
}
