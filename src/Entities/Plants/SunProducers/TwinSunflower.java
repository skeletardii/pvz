package Entities.Plants.SunProducers;

import Entities.Interfaces.SunProducer;
import Entities.Misc.Plant;
import java.awt.Graphics2D;

public class TwinSunflower extends Plant implements SunProducer {

  int sunCooldown = 1440;
  int sunCtr = 0;

  public TwinSunflower(int row, int col) {
    super(row, col, 150, 100, 7.5, "twinsunflower", 422, 422, 1);
    anim_start[0] = 8;
    anim_end[0] = 33;
  }

  public TwinSunflower() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();

    sunCtr++;
    if (sunCtr >= sunCooldown) {
      sunCtr = 0;
      this.add(produceSunGrid(25, col, row, 60));
      this.add(produceSunGrid(25, col, row, 60));
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }
}
