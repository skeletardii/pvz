


package Entities.Plants;

import Entities.Misc.InstaKiller;
import Entities.Misc.Plant;
import Main.Global;

import java.awt.Graphics2D;

public class CherryBomb extends Plant implements InstaKiller  {

  public CherryBomb(int row, int col) {
    super(
      row,
      col,
      500,
      100,
      7.5,
      "sunflower",
      364,
      365,
      1
    );
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public CherryBomb(){
    this(-1,-1);
  }

  public void update() {
    this.health -= explodeTime;

    if (health <= 0) {
      Global.removePlant(row, (int)(col));
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderPlant(g, 0);
  }
}
