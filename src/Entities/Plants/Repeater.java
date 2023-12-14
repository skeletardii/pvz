package Entities.Plants;

import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;

public class Repeater extends Peashooter implements Upgradable {

  public Repeater() {
    this(-1, -1);
  }

  public Repeater(double row, double col) {
    super(row, col, 2, 150);
  }

  @Override
  public Upgraded upgrade() {
    return new GatlingPea(getRow(), getCol());
  }
}
