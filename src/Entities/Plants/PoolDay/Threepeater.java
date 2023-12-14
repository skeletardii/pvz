package Entities.Plants.PoolDay;

import Entities.Plants.LawnDay.Peashooter;
import Entities.Plants.PlantBuilder;

public class Threepeater extends Peashooter {

  public Threepeater() {
    this(-1, -1);
  }

  public Threepeater(double row, double col) {
    super(row, col, 1, 125);
  }
}
