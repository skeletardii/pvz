package Entities.Misc;

import GameUtils.Sound;
import Main.Global;
import java.io.File;

public abstract class InstaKiller extends Plant {

  protected int explodeTime = 100;
  protected int explodeSpeed = 1;
  private static final File explodeSnd = new File("assets/sound/explosion.wav");

  protected InstaKiller(
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
  public void update() {
    this.explodeTime -= this.explodeSpeed;
    if (this.explodeTime <= 0) activate();

    super.update();
  }

  public void activate() {
    this.health = 0;
    Sound.play(explodeSnd);
  }
}
