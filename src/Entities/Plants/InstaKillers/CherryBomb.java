package Entities.Plants.InstaKillers;

import Entities.Misc.InstaKiller;
import Entities.Misc.Zombie;
import Entities.Misc.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;

public class CherryBomb extends InstaKiller {

  public CherryBomb(int row, int col) {
    super(row, col, 125, 100, 7.5, "sunflower", 364, 365, 1);
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public CherryBomb() {
    this(-1, -1);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  @Override
  public void activate() {
    for (Zombie z : Global.zombies) {
      // if zombie is in a 3x3 ish radius
      if (
        Math.abs(z.row - this.row) <= 1.5 && Math.abs(z.col - this.col) <= 1.5
      ) {
        // if naa nay animations, dapat sad sila ma BLACKED
        z.kill(DeathType.EXPLODED);
      }
    }

    super.activate();
  }
}
