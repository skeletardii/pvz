package Entities.Misc;

import Main.Global;
import Main.Global.GameMode;

public abstract class Shroom extends Plant {

  public boolean isAsleep;

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
    this.isAsleep =
      Global.gameMode == GameMode.LAWN_DAY ||
      Global.gameMode == GameMode.POOL_DAY ||
      Global.gameMode == GameMode.ROOF_DAY;
  }
}
