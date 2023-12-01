package Entities.Plants;

import Entities.Misc.Plant;
import java.awt.Graphics2D;

public class Cabbage extends Plant {

  public Cabbage(int row, int col, int sunCost, int health, double packetCooldown, String spriteName, int spriteWidth,
      int spriteHeight, int animRow) {
    super(row, col, sunCost, health, packetCooldown, spriteName, spriteWidth, spriteHeight, animRow);
  }
  @Override
  public void update() {

  }
  @Override
  public void paintComponent(Graphics2D g) {
    renderPlant(g, 0);
  }
}
