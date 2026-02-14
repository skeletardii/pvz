package Entities.Zombies;

import Main.Constants;
import Main.Global;

public class CatapultZombie extends Zombie {

  public CatapultZombie(int row) {
    super(new ZombieBuilder().setRow(row).setHealth(651));
  }

  @Override
  public void update() {
    if (this.getCol() < Constants.PLANT_COLS_COUNT - 2) {
      this.moveCol(this.getMovementSpeed());
    } else {
      // attacks instead

      for (int i = 0; i < Constants.PLANT_COLS_COUNT; ++i) if (
        Global.plants[(int) getRow()][i] != null
      ) {
        // more like lob projectile mani i think

        // Global.plants[(int)getRow()][i].takeDamage();
      }
    }
  }
}
