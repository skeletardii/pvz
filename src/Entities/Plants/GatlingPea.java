package Entities.Plants;

import Entities.Interfaces.Upgraded;

public class GatlingPea extends Peashooter implements Upgraded {

  public GatlingPea() {
    this(-1, -1);
  }

  public GatlingPea(double row, double col) {
    super(row, col, 4, 250);
  }

  @Override
  public int getIncreasingSunCost() {
    return 250;
  }
}
