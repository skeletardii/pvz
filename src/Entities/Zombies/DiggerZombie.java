package Entities.Zombies;

public class DiggerZombie extends Zombie {

  private boolean digging = true;

  public DiggerZombie(int row) {
    super(new ZombieBuilder().setRow(row).setTargetable(false));
  }
}
