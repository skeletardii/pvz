package Entities.Plants;

import Entities.Misc.InstaKiller;
import Entities.Misc.Plant;
import Entities.Misc.Zombie;
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

  @Override
  public void update() {
    this.health -= EXPLODE_TIME;
    super.update();
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  @Override
  public void explode() {
    for (Zombie z : Global.zombies) {
      // if zombie is in a 3x3 ish radius
      if (
        Math.abs(z.row - this.row) <= 1.5 && Math.abs(z.col - this.col) <= 1.5
      ) {
        z.setHealth(0);
      }
    }
  }
}
