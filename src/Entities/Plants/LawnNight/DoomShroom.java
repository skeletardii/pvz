package Entities.Plants.LawnNight;

import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Entities.Zombies.Zombie.DeathType;
import Main.Constants;
import Main.Global;

@SuppressWarnings("all")
public class DoomShroom extends ShroomInstaKiller {

  protected DoomShroom(PlantBuilder pBuilder) {
    super(pBuilder);
  }

  @Override
  public void activate() {
    super.activate();

    for (int k = 0; k < Constants.PLANT_ROWS_COUNT; ++k) {
      for (Zombie z : Global.zombies[k]) {
        if (Math.abs(z.getCol() - this.getCol()) <= 3) {
          z.kill(DeathType.EXPLODED);
        }
      }
    }
  }
}
