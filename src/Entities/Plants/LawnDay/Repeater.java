package Entities.Plants.LawnDay;

import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;
import Entities.Plants.PlantBuilder;

public class Repeater extends Peashooter implements Upgradable {

  public Repeater() {
    this(-1, -1);
  }

  public Repeater(double row, double col) {
    super(new PlantBuilder().setRow(row).setCol(col).setSunCost(200), 2);
  }

  @Override
  public Upgraded upgrade() {
    return new GatlingPea(getRow(), getCol());
  }
}
