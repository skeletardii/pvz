package Entities.Interfaces;

import Entities.Plants.Plant;
import Main.Constants;
import Main.Global;

public interface Upgraded {
  abstract int getIncreasingSunCost();

  default int concurrentSunCost(Class<? extends Plant> plantClass) {
    int similarPlantCount = 0;

    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; ++i) {
      for (int j = 0; j < Constants.PLANT_COLS_COUNT; ++j) {
        if (plantClass.isInstance(Global.plants[i][j])) {
          ++similarPlantCount;
        }
      }
    }

    return getIncreasingSunCost() * similarPlantCount;
  }
}
