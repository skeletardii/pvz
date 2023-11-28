package Entities.Plants;

import Entities.Misc.Plant;
import Entities.Misc.SunProducer;
import java.awt.Graphics2D;

public class Sunflower extends Plant implements SunProducer {

  int sun_cooldown = 60;
  int sun_ctr = 0;

  public Sunflower(int row, int col) {
    super(
      row,
      col,
      50,
      100,
      7.5,
      "sunflower",
      //new ImageIcon("PvZ/assets/plants/twinsunflower.png").getImage(),
      364,
      365,
      1
    );
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public void update() {
    sun_ctr++;
    if (sun_ctr >= sun_cooldown) {
      sun_ctr = 0;
      this.add(produceSun(25, (col + 1) * 80, (row - 1) * 100, 60));
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderPlant(g, 0);
  }
}
