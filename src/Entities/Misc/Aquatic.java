package Entities.Misc;

import java.awt.Graphics2D;

public abstract class Aquatic extends Plant {

  public Aquatic(
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
    // some logic here para dili siya ma create if dili water??
    // or maybe ang logic i implement somewhere
  }
}
