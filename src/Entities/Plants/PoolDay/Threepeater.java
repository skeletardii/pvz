package Entities.Plants.PoolDay;

import Entities.Plants.LawnDay.Peashooter;
import Entities.Plants.PlantBuilder;
import Entities.Projectiles.Pea;
import Entities.Zombies.Zombie;
import Main.Constants;
import Main.Global;

public class Threepeater extends Peashooter {

  public Threepeater() {
    this(-1, -1);
  }

  public Threepeater(double row, double col) {
    super(row, col, 1, 125);
  }

  @Override
  public void update() {
    for (int k = (int) this.getRow() - 1; k < (int) this.getRow() + 1; ++k) {
      if (k < 0 || k > Constants.PLANT_ROWS_COUNT) continue;
      for (Zombie z : Global.zombies[k]) {
        if (z.getCol() >= this.getCol() && z.isTargetable()) {
          attack();
          break;
        }
      }
    }
    super.update();
  }

  @Override
  public void attack() {
    this.add(new Pea(this.getRow() - 1, this.getCol()));
    this.add(new Pea(this.getRow(), this.getCol()));
    this.add(new Pea(this.getRow() + 1, this.getCol()));
  }
}
