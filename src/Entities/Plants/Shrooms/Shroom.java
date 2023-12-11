package Entities.Plants.Shrooms;

import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import Main.Global;
import Main.Global.GameMode;

public abstract class Shroom extends Plant {

  public boolean isAsleep;

  protected Shroom(PlantBuilder pBuilder) {
    super(pBuilder);
    this.isAsleep =
      Global.gameMode == GameMode.LAWN_DAY ||
      Global.gameMode == GameMode.POOL_DAY ||
      Global.gameMode == GameMode.ROOF_DAY;
  }
}
