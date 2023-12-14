package Entities.Plants.LawnDay;

import Entities.Interfaces.Upgraded;
import Entities.Plants.PlantBuilder;

public class GatlingPea extends Peashooter implements Upgraded {

  public GatlingPea() {
    this(-1, -1);
  }

  public GatlingPea(double row, double col) {
    super(new PlantBuilder().setRow(row).setCol(col).setSunCost(250), 4);
  }

  @Override
  public int getIncreasingSunCost() {
    return 250;
  }
}
