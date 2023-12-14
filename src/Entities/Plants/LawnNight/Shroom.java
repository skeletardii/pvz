package Entities.Plants.LawnNight;

import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import Main.Constants.GameMode;
import Main.Global;

public abstract class Shroom extends Plant {

  private boolean isAsleep;

  protected Shroom(PlantBuilder pBuilder) {
    super(pBuilder);
    this.isAsleep =
      Global.gameMode == GameMode.LAWN_DAY ||
      Global.gameMode == GameMode.POOL_DAY ||
      Global.gameMode == GameMode.ROOF_DAY;
  }

  @Override
  public void update() {
    if (!isAsleep) {
      super.update();
      shroomUpdate();
    }
  }

  public abstract void shroomUpdate();

  public boolean isAsleep() {
    return isAsleep;
  }

  public void setAsleep(boolean isAsleep) {
    this.isAsleep = isAsleep;
  }
}
