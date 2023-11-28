package Entities.Misc;

public interface SunProducer {
  default Sun produceSun(int sunValue, int positionX, int positionY, int fall) {
    return new Sun(sunValue, positionX, positionY, fall);
  }
}
