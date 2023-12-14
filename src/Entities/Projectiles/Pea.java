package Entities.Projectiles;

import Entities.Misc.LiveEntityBuilder;
import Entities.Plants.Plant;
import Entities.Plants.PoolDay.Torchwood;
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

  public static final Image sprite = new ImageIcon(
    "assets/projectiles/pea.png"
  )
    .getImage();

  public Pea(double row, double col) {
    this(new LiveEntityBuilder().setRow(row).setCol(col).setSprite(sprite).setSpriteWidth(28).setSpriteHeight(28).setAnimRow(1), 10, 0.05);
  }

  public Pea(LiveEntityBuilder leBuilder, int projectileDamage, double projectileSpeed) {
    super(leBuilder, projectileDamage, projectileSpeed);

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

    if (!(this instanceof BurningPea)) {
      for (Plant p : Global.plants[(int) this.getRow()]) {
        if (p != null && this.isTouching(p) && p instanceof Torchwood) {
          this.transformToBurningPea();
        }
      }
    }

    this.moveCol(this.projectileSpeed);
  }

  private void transformToBurningPea() {
    Global.game.add(new BurningPea(this.getRow(), this.getCol()));
    this.remove();
  }

  public void hitZombie(Zombie z) {
    z.takeDamage(this.projectileDamage);
    Sound.play(sndFiles[(int) Math.round(Math.random())]);
    this.remove();
  }
}
