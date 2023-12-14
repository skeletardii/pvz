package Entities.Plants.Roof;

import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;

public class Pumpkin extends Plant {

  public Pumpkin() {
    this(-1, -1);
  }

  protected Pumpkin(double row, double col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(4000)
        .setSunCost(125)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
    );
    animStart[0] = 79;
    animEnd[0] = 103;
  }
}
