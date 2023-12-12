package Entities.Zombies;

import Main.Global;

public class Gargantuar extends Zombie {

  private boolean impPresent = true;
  private static final int MAX_HEALTH = 1500;

  public Gargantuar(int row) {
    super(
      new ZombieBuilder()
        .setRow(row)
        .setHealth(MAX_HEALTH)
        .setMovementSpeed(ZombieSpeed.VERY_SLOW.getValue())
    );
  }

  @Override
  public void update() {
    super.update();
    if (impPresent && getHealth() <= MAX_HEALTH / 2.0) {
      impPresent = false;
      Global.addZombie(new Imp(getRow(), getCol()));
    }
  }
}
