package Entities.Zombies;

import Entities.Misc.Plant;
import Main.Global;

public class PoleVaultingZombie extends NormalZombie {

  private boolean jumped = false;

  protected PoleVaultingZombie(int row) {
    super(row);
  }

  // fucking shitty as implementation
  @Override
  public void update() {
    if (!this.jumped) {
      for (Plant p : Global.plants[(int) this.row]) {
        if (this.isTouching(p)) {
          this.col -= 1;
          this.jumped = true;
        }
      }
    }
  }
}
