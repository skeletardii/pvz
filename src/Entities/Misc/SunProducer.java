package Entities.Misc;

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
      (int) Math.round(row * 80),
      (int) Math.round(col * 100),
      fall
    );
  }
}
