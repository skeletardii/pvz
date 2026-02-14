package Entities.Plants.PoolDay;

import Entities.Plants.LawnDay.Peashooter;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Projectiles.Pea;
import Entities.Zombies.Zombie;
import Main.Constants;
import Main.Global;

public class Threepeater extends Peashooter {
  private static final Image sprite = new ImageIcon("assets/plants/threepeater.png").getImage();

  public Threepeater() {
    this(-1, -1);
  }

  public Threepeater(double row, double col) {
    super(row, col, 1, 125,sprite,128,132);
  }

  @Override
  public void update() {
    for (int k = (int) this.getRow() - 1; k <= (int) this.getRow() + 1; ++k) {
      if (k < 0 || k > Constants.PLANT_ROWS_COUNT) continue;
      for (Zombie z : Global.zombies[k]) {
        if (z.getCol() >= this.getCol() && z.isTargetable()) {
          super.update();
          attack();
          return;
        }
      }
    }
    super.update();
  }

  @Override
  public void shoot() {
    this.add(new Pea(this.getRow() - 1, this.getCol()));
    this.add(new Pea(this.getRow(), this.getCol()));
    this.add(new Pea(this.getRow() + 1, this.getCol()));
  }
}
