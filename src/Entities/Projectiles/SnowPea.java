package Entities.Projectiles;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Zombies.Zombie;
import GameUtils.Sound;

public class SnowPea extends Pea {
  public static final Image sprite = new ImageIcon(
    "assets/projectiles/snowpea.png"
  ).getImage();
  public SnowPea(double row, double col) {
    super(row, col,sprite,28,28);
  }

  @Override
  public void hitZombie(Zombie z) {
    z.takeDamage(this.projectileDamage);
    Sound.play(sndFiles[(int) Math.round(Math.random())]);
    z.setSlowed(360);
    this.remove();
  }
}
