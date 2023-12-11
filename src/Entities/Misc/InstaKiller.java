package Entities.Misc;

import GameUtils.Sound;

import java.awt.Image;
import java.io.File;

public abstract class InstaKiller extends Plant {

  protected int explodeTime = 100;
  protected int explodeSpeed = 1;
  private static final File explodeSnd = new File("assets/sound/cherrybomb.wav");

  protected InstaKiller(
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
    this.targetable = false;
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
