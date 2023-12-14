package Entities.Projectiles;

import Entities.Zombies.Zombie;
import GameUtils.Sound;

public class SnowPea extends Pea {

  public SnowPea(double row, double col) {
    super(row, col);
  }

  @Override
  public void hitZombie(Zombie z) {
    z.takeDamage(this.projectileDamage);
    Sound.play(sndFiles[(int) Math.round(Math.random())]);
    z.setSlowed(360);
    this.remove();
  }
}
