package Entities.Projectiles;

import Entities.Zombies.Zombie;
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

  public static final Image sprite1 = new ImageIcon(
    "assets/projectiles/pea.png"
  )
    .getImage();
  public static final Image sprite2 = new ImageIcon("assets/plants/wallnut.png")
    .getImage();

  public Pea(int row, double col) {
    super(row, col, 0.05, 10, sprite1, 28, 28, 1);
    animStart[0] = 0;
    animEnd[0] = 0;
    scale = 1.0;
    offsetOY = -50;
    shadowScale = 0.0;
  }

  @Override
  public void update() {
    for (Zombie z : Global.zombies[this.getRow()]) {
      if (this.isTouching(z)) {
        z.takeDamage(this.projectileDamage);
        Sound.play(sndFiles[(int)Math.round(Math.random())]);
        this.remove();
        return;
      }
    }

    this.moveCol(this.projectileSpeed);
  }
}
