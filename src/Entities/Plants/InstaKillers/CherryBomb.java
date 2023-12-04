package Entities.Plants.InstaKillers;

import Entities.Misc.InstaKiller;
import Entities.Misc.Zombie;
import Entities.Misc.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class CherryBomb extends InstaKiller {

  private static final Image sprite = new ImageIcon("assets/plants/cherrybomb.png").getImage();
  public CherryBomb(int row, int col) {
    super(row, col, 125, 100, 7.5, sprite, 625, 458, 2);
    anim_start[0] = 14;
    anim_end[0] = 26;
    anim_start[1] = 0;
    anim_end[1] = 13;
    setFrame(14);
    offsetOY = 10;
  }

  public CherryBomb() {
    this(-1, -1);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    if (health <= (anim_end[0] - anim_start[0]) * 2) {
      //setFrame((anim_end[0]-anim_start[0])-health);
      renderSprite(g, 1);
    } else {
      renderSprite(g, 0);
    }
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
