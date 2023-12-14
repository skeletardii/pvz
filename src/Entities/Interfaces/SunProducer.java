package Entities.Interfaces;

import Entities.Misc.Sun;
import Main.Constants;
import Main.Global;

public interface SunProducer {
  default Sun produceSun(
    int sunValue,
    double positionX,
    double positionY,
    int fall
  ) {
    return new Sun(sunValue, positionX, positionY, fall);
  }

  default Sun produceSunGrid(int sunValue, double row, double col, int fall) {
    return produceSun(
      sunValue,
      (row * Constants.ROW_PIXEL_OFFSET),
      (col * Constants.COL_PIXEL_OFFSET),
      fall
    );
  }
}
