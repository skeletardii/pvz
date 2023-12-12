package Entities.Zombies;

import Main.Global;

public class Gargantuar extends Zombie {

  private boolean impPresent = true;
  private static final int HALF_HEALTH = 1500;

  public Gargantuar(int row) {
    super(
      new ZombieBuilder()
        .setRow(row)
        .setHealth(3000)
        .setMovementSpeed(ZombieSpeed.VERY_SLOW.getValue())
    );
  }

  @Override
  public void update() {
    super.update();
    if (impPresent && getHealth() <= HALF_HEALTH) {
      impPresent = false;
      Global.addZombie(new Imp(getRow(), getCol()));
    }
  }
}
