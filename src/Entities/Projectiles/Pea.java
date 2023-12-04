package Entities.Projectiles;

import Entities.Misc.Projectile;
import Entities.Misc.Zombie;
import Main.Global;
import java.awt.Image;

public class Pea extends Projectile {

  protected Pea(int row, double col) {
    super(row, col, 0.01, 10, "sunflower", 364, 365, 1);
  }

  @Override
  public void update() {
    for (Zombie z : Global.zombies) {
      if (this.isTouching(z)) {
        z.takeDamage(this.projectileDamage);
        this.remove();
        return;
      }
    }

    this.col += this.projectileSpeed;
  }
}
