package Entities.Zombies;

public class Imp extends Zombie {

  protected Imp(double row, double d) {
    // need  to add sprite
    super(new ZombieBuilder().setRow(row).setHealth(181).setCol(d));
  }
}
