package Entities.Projectiles;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Misc.LiveEntityBuilder;
import Entities.Zombies.Zombie;
import GameUtils.Sound;

public class SnowPea extends Pea {
  public static final Image sprite = new ImageIcon(
    "assets/projectiles/snowpea.png"
  ).getImage();
  public SnowPea(double row, double col) {
    super(new LiveEntityBuilder().setRow(row).setCol(col).setSprite(sprite).setSpriteWidth(28).setSpriteHeight(28).setAnimRow(1), 10, 0.05);
  }

  @Override
  public void hitZombie(Zombie z) {
    z.takeDamage(this.projectileDamage);
    Sound.play(sndFiles[(int) Math.round(Math.random())]);
    z.setSlowed(360);
    this.remove();
  }
}
