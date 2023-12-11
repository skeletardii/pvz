package Entities.Plants.InstaKillers;

import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import GameUtils.Sound;
import java.io.File;

public abstract class InstaKiller extends Plant {

  protected int explodeTime = 100;
  protected int explodeSpeed = 1;
  private static final File explodeSnd = new File(
    "assets/sound/cherrybomb.wav"
  );

  protected InstaKiller(PlantBuilder pBuilder) {
    super(pBuilder.setHealth(Integer.MAX_VALUE));
    setTargetable(false);
  }

  @Override
  public void update() {
    this.explodeTime -= this.explodeSpeed;
    if (this.explodeTime <= 0) activate();
    super.update();
  }

  public void activate() {
    setHealth(0);
    Sound.play(explodeSnd);
  }
}
