package Entities.Zombies;

import Entities.Misc.ZombieSpawner;

public class DiggerZombie extends Zombie {

  private boolean digging = true;

  public DiggerZombie(int row) {
    super(
      new ZombieBuilder()
        .setMovementSpeed(ZombieSpeed.FAST.getValue())
        .setRow(row)
        .setTargetable(false)
    );
  }

    public DiggerZombie() {
        this(-1);
    }

    @Override
  public void update() {
    super.update();
    if (this.digging && this.getCol() <= 0) {
      this.digging = false;
      setTargetable(true);
      setMovementSpeed(-ZombieSpeed.SLOW.getValue());
    }
  }
}
