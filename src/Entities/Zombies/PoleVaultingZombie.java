package Entities.Zombies;

import Entities.Plants.Plant;
import Main.Global;

public class PoleVaultingZombie extends Zombie {

  private boolean jumped = false;

  protected PoleVaultingZombie(int row) {
    super(
      new ZombieBuilder()
        .setRow(row)
        .setMovementSpeed(ZombieSpeed.FAST.getValue())
    );
  }

  protected PoleVaultingZombie(ZombieBuilder zBuilder) {
    super(zBuilder);
  }

  // fucking shitty ass implementation
  @Override
  public void update() {
    super.update();

    if (!this.jumped) {
      for (Plant p : Global.plants[this.getRow()]) {
        if (p != null && this.isTouching(p)) {
          this.moveCol(-1.5);
          this.jumped = true;
        }
      }
    }
  }
}
