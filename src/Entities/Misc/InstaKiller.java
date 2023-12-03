package Entities.Misc;

import GameUtils.Sound;
import Main.Global;
import java.io.File;

public abstract class InstaKiller extends Plant {

  protected static final int EXPLODE_TIME = 1;
  private static final File explodeSnd = new File("assets/sound/explosion.wav");

  public InstaKiller(
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

  public void explode() {
    this.health = 0;
    Sound.play(explodeSnd);
  }
}
