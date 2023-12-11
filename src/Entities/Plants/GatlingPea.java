package Entities.Plants;

import Entities.Interfaces.Upgraded;

public class GatlingPea extends Repeater implements Upgraded {

  public GatlingPea() {
    this(-1, -1);
  }

  public GatlingPea(int row, double col) {
    super(row, col, 4, 250);
  }

  @Override
  public int getIncreasingSunCost() {
    return 250;
  }
}
