package Entities.Zombies;

import Entities.Plants.Plant;
import Main.Global;

public class LadderZombie extends Zombie {

  private boolean hasLadder = true;

  public LadderZombie(int row) {
    super(
      new ZombieBuilder()
        .setRow(row)
        .setMovementSpeed(ZombieSpeed.FAST.getValue())
    );
  }

  @Override
  public void update() {
    super.update();

    Plant p;

    int row = (int) this.getRow();
    int col = (int) this.getCol();

    if (
      hasLadder &&
      col >= 0 &&
      col < Global.PLANT_COLS_COUNT &&
      (p = Global.plants[row][col]) != null
    ) {
      hasLadder = false;
      p.setHasLadder(true);
      setMovementSpeed(ZombieSpeed.NORMAL.getValue());
    }
  }
}
