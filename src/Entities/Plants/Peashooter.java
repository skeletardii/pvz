package Entities.Plants;

import Entities.Misc.Plant;
import java.awt.Graphics2D;

public class Peashooter extends Plant {
  public Peashooter(){
    this(
      -1,
      -1,
      100,
      100,
      7.5,
      "peashooter",
      375, 
      353, 
      1
    );
    anim_start[0]=79;
    anim_end[0]=103;
  }
  public Peashooter(
    int row,
    int col,
    int sunCost,
    int health,
    double packetCooldown,
    String spriteName,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(
      row,
      col,
      sunCost,
      health,
      packetCooldown,
      spriteName,
      spriteWidth,
      spriteHeight,
      animRow
    );
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
