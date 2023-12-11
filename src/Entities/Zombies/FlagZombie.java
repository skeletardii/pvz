package Entities.Zombies;

public class FlagZombie extends Zombie {

  public FlagZombie(int row) {
    super(new ZombieBuilder().setRow(row));
  }
}
