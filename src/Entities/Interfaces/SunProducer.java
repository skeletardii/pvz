package Entities.Interfaces;

import Entities.Misc.Sun;
import Main.Global;

public interface SunProducer {
  default Sun produceSun(
    int sunValue,
    double positionY,
    double positionX,
    int fall
  ) {
    return new Sun(sunValue, positionY, positionX, fall);
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
