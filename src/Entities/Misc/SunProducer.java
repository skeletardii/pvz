package Entities.Misc;

public interface SunProducer {
    default Sun produceSun(int sun_value, int position_X, int position_Y, int fall) {
        return new Sun(sun_value, position_X, position_Y, fall);
    }
}
