package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class NewspaperZombie extends NormalZombie {

  protected NewspaperZombie(int row) {
    super(row);
    armor = new Armor.Newspaper();
  }

  @Override
  public void removeArmor() {
    setMovementSpeed(getMovementSpeed() * 2);
  }
}
