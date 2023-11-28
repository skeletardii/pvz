package Entities.Plants;

import Entities.Misc.Plant;
import Entities.Misc.SunProducer;
import java.awt.Graphics2D;

public class Sunflower extends Plant implements SunProducer {

  int sunCooldown = 60;
  int sunCtr = 0;

  public Sunflower(int row, int col) {
    super(
      row,
      col,
      50,
      7.5,
      "sunflower",
      //new ImageIcon("PvZ/assets/plants/twinsunflower.png").getImage(),
      364,
      365,
      1
    );
    animStart[0] = 4;
    animEnd[0] = 28;
  }

  public void update() {
    sunCtr++;
    if (sunCtr >= sunCooldown) {
      sunCtr = 0;
      this.add(produceSun(25, col * 80, row * 100 - 100, 60));
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderPlant(g, 0);
  }
}
