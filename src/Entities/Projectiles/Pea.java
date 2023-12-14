package Entities.Projectiles;

import Entities.Zombies.Zombie;
import GameUtils.Sound;
import Main.Constants;
import Main.Global;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class Pea extends Projectile {

  protected static final File[] sndFiles = {
    new File("assets/sound/splat.wav"),
    new File("assets/sound/splat2.wav"),
  };

  public static final Image sprite1 = new ImageIcon(
    "assets/projectiles/pea.png"
  )
    .getImage();

  public Pea(double row, double col) {
    //super(row, col, 0.05, 10, sprite1, 28, 28, 1);
    this(row,col,sprite1,28,28);
    animStart[0] = 0;
    animEnd[0] = 0;
    scale = 1.0;
    offsetOY = -50;
    shadowScale = 0.0;
  }
  public Pea(double row, double col, Image sprite, int spriteWidth, int spriteHeight){
    super(row, col, 0.05, 10, sprite, spriteWidth, spriteHeight, 1);
    animStart[0] = 0;
    animEnd[0] = 0;
    scale = 1.0;
    offsetOY = -50;
    shadowScale = 0.0;
  }

  @Override
  public void update() {
    if (this.getRow() < 0 || this.getRow() >= Constants.PLANT_ROWS_COUNT) {
      this.remove();
      return;
    }

    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (this.isTouchingClose(z)) {
        hitZombie(z);
        return;
      }
    }

    this.moveCol(this.projectileSpeed);
  }

  public void hitZombie(Zombie z) {
    z.takeDamage(this.projectileDamage);
    Sound.play(sndFiles[(int) Math.round(Math.random())]);
    this.remove();
  }
}
