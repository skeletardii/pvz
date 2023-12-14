package Entities.Plants.LawnNight;

import Entities.Plants.PlantBuilder;

public class GloomShroom extends FumeShroom {

  protected GloomShroom(double row, double col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(75)
        .setHealth(300)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
        .setSpriteWidth(364)
        .setSpriteHeight(365),
      4
    );
  }

  public GloomShroom() {
    this(-1, -1);
  }
}
