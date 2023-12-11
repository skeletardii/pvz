package Entities.Plants;

import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;

public class Repeater extends Peashooter implements Upgradable {

  public Repeater() {
    this(-1, -1);
  }

  public Repeater(int row, double col) {
    super(row, col, 2, 150);
  }

  public Repeater(int row, double col, int shotsPerAttack, int sunCost) {
    super(row, col, shotsPerAttack, sunCost);
  }

  @Override
  public Upgraded upgrade() {
    throw new UnsupportedOperationException("Unimplemented method 'upgrade'");
  }
}
