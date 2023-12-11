package Entities.Zombies;

import Entities.Plants.Plant;
import Main.Global;

public class PoleVaultingZombie extends Zombie {

  private boolean jumped = false;

  protected PoleVaultingZombie(int row) {
    super(row);
  }

  protected PoleVaultingZombie(ZombieBuilder zBuilder) {
    super(zBuilder);
  }

  // fucking shitty ass implementation
  @Override
  public void update() {
    if (!this.jumped) {
      for (Plant p : Global.plants[this.getRow()]) {
        if (this.isTouching(p)) {
          this.moveCol(-1);
          this.jumped = true;
        }
      }
    }
  }
}
