package Entities.Misc;

import java.awt.Image;

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
    Image sprite,
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
      sprite,
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
