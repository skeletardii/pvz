package Entities.Zombies;

import Main.Global;

public class BungeeZombie extends Zombie {

  public int xMarkCtr = 100;
  public int goingUpCtr = 100;

  public BungeeZombie(int row) {
    super(new ZombieBuilder().setRow(row));
  }

  @Override
  public void update() {
    if (xMarkCtr > 0) {
      xMarkCtr--;
    } else if (goingUpCtr > 0) {
      goingUpCtr--;
    } else {
      // might be dangerous
      Global.plants[(int) this.getRow()][(int) this.getCol()] = null;
    }
  }
}
