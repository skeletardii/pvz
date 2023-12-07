package Entities.Projectiles;

import Entities.Misc.Projectile;
import Entities.Misc.Zombie;
import GameUtils.Sound;
import Main.Global;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class Pea extends Projectile {

  private static final File[] sndFiles = {
    new File("assets/sound/splat.wav"),
    new File("assets/sound/splat2.wav"),
  };

  public static final Image sprite1 = new ImageIcon("assets/plants/wallnut.png")
    .getImage();
  public static final Image sprite2 = new ImageIcon("assets/plants/wallnut.png")
    .getImage();

  public Pea(double row, double col) {
    super(row, col, 0.05, 10, sprite1, 364, 365, 1);
  }

  @Override
  public void update() {
    for (Zombie z : Global.zombies) {
      if (this.isTouching(z)) {
        z.takeDamage(this.projectileDamage);
        Sound.play(sndFiles[(int) (Math.random() * 2)]);
        this.remove();
        return;
      }
    }

    this.col += this.projectileSpeed;
  }
}
