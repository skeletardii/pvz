package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class FootballZombie extends NormalZombie {

  protected FootballZombie(int row) {
    super(row);
    armor = new Armor.FootballGear();
  }
}
