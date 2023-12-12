package Entities.Zombies;

import Entities.Plants.Plant;
import Main.Global;

public class PogoZombie extends Zombie {

  private int jumpingCtr = 0;
  private int aboutToJumpCtr = 0;

  public PogoZombie(int row) {
    super(row);
  }

  @Override
  public void update() {
    double dist;

    if (jumpingCtr == 0) {
      super.update();
      for (Plant p : Global.plants[(int) this.getRow()]) {
        if (
          p != null && (dist = this.getCol() - p.getCol()) <= 1 && dist >= 0
        ) {
          aboutToJumpCtr = 100;
          jumpingCtr = 100;
        }
      }
    } else if (aboutToJumpCtr-- <= 0) {
      jumpingCtr--;

      if (jumpingCtr == 0) {
        this.moveCol(-1.5);
      }
    }
  }
}
