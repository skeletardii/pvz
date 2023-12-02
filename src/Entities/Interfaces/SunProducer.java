package Entities.Interfaces;

import Entities.Misc.Sun;
import Main.Global;

public interface SunProducer {
  default Sun produceSun(
    int sunValue,
    double positionX,
    int positionY,
    int fall
  ) {
    return new Sun(sunValue, positionX, positionY, fall);
  }

  default Sun produceSunGrid(int sunValue, double row, double col, int fall) {
    return produceSun(
      sunValue,
      (int) Math.round(row * Global.ROW_PIXEL_OFFSET),
      (int) Math.round(col * Global.COL_PIXEL_OFFSET),
      fall
    );
  }
}
