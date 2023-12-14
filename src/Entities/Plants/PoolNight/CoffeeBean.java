package Entities.Plants.PoolNight;

import Entities.Plants.LawnNight.Shroom;
import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import Main.Global;

public class CoffeeBean extends Plant {

  public CoffeeBean() {
    this(-1, -1);
  }

  protected CoffeeBean(double row, double col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(75)
        .setHealth(300)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
    );
  }

  @Override
  public void update() {
    this.takeDamage(1);
    if (this.getHealth() <= 0) {
      this.setVisible(false);
      ((Shroom) (Global.plants[(int) getRow()][(int) getCol()])).setAsleep(
          false
        );
    }
  }
}
