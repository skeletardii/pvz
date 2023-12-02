package Entities.Misc;

public abstract class Shroom extends Plant {

  protected Shroom(
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
}
