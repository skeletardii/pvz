package Entities.Plants;

import Entities.Misc.Plant;
import Entities.Misc.SunProducer;
import java.awt.Graphics2D;

public class Sunflower extends Plant implements SunProducer {

  int sunCooldown = 60;//1440;
  int sunCtr = 0;

  public Sunflower(int row, int col) {
    super(row, col, 50, 100, 7.5, "sunflower", 364, 365, 1);
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public Sunflower() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();

    sunCtr++;
    if (sunCtr >= sunCooldown) {
      sunCtr = 0;
      this.add(produceSunGrid(25, col, row, 60));
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }
}
