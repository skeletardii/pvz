package Entities.Plants;

import Entities.Misc.Plant;
import Entities.Misc.SunProducer;
import java.awt.Graphics2D;

public class TwinSunflower extends Plant implements SunProducer {

  int sunCooldown = 60;
  int sunCtr = 0;

  public TwinSunflower(int row, int col) {
    super(row, col, 150, 7.5, "twinsunflower", 422, 422, 1);
    animStart[0] = 8;
    animEnd[0] = 33;
  }

  public void update() {
    sunCtr++;
    if (sunCtr >= sunCooldown) {
      sunCtr = 0;
      this.add(produceSun(25, col * 80, row * 100 - 100, 60));
      this.add(produceSun(25, col * 75, row * 100 - 100, 60));
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderPlant(g, 0);
  }
}
