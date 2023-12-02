package Entities.Plants;

import Entities.Misc.Plant;
import java.awt.Graphics2D;

public class Cabbage extends Plant {

  int attack_cooldown = 60;
  int attack_ctr = 0;

  @Override
  public void update() {
    ++attack_ctr;
    if (attack_ctr >= attack_cooldown) {
      attack_ctr = 0;
      // handle attack here
    }
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderPlant(g, 0);
  }
}
