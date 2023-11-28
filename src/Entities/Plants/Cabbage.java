package Entities.Plants;

import Entities.Misc.Plant;
import java.awt.Graphics2D;

public class Cabbage extends Plant {

  @Override
  public void update() {}

  @Override
  public void paintComponent(Graphics2D g) {
    renderPlant(g, 0);
  }
}
