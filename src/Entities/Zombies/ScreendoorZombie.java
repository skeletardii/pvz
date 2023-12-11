package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class ScreendoorZombie extends NormalZombie {

  public ScreendoorZombie(int row) {
    super(row);
    armor = new Armor.Screendoor();
  }
}
