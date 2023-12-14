package Entities.Plants.LawnNight;

import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Main.Constants;
import Main.Global;

@SuppressWarnings("all")
public class IceShroom extends ShroomInstaKiller {

  protected IceShroom(PlantBuilder pBuilder) {
    super(pBuilder);
  }

  @Override
  public void activate() {
    super.activate();

    for (int k = 0; k < Constants.PLANT_ROWS_COUNT; ++k) {
      for (Zombie z : Global.zombies[k]) {
        z.setFrozen(180);
        z.setSlowed(360);
      }
    }
  }
}
