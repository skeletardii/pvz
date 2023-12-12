package Entities.Zombies;

public class DiggerZombie extends Zombie {

  private boolean digging = true;

  public DiggerZombie(int row) {
    super(
      new ZombieBuilder()
        .setMovementSpeed(0.015)
        .setRow(row)
        .setTargetable(false)
    );
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
