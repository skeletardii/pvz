package Entities.Zombies;

import Entities.ZombieItems.Armor;

public class NewspaperZombie extends Zombie {

  protected NewspaperZombie(int row) {
    super(new ZombieBuilder().setRow(row).setArmor(new Armor.Newspaper()));
  }

  @Override
  public void removeArmor() {
    setMovementSpeed(ZombieSpeed.FAST.getValue());
  }
}
