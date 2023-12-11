package Entities.Plants.InstaKillers;

import Entities.Misc.InstaKiller;
import Entities.Misc.Zombie;
import Entities.Misc.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Squash extends InstaKiller {
  private static final Image sprite = new ImageIcon("assets/plants/sunflower.png").getImage();
  public Squash(int row, int col) {
    super(
      row,
      col,
      25,
      Integer.MAX_VALUE,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      sprite,
      364,
      365,
      1
    );
    this.explodeSpeed = 0;
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public Squash() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();

    // check if zombie is near, if so explode
    for (Zombie z : Global.zombies[row]) {
      if (z.row == this.row && Math.abs(z.col - this.col) <= 1) {
        activate();
        return;
      }
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  @Override
  public void activate() {
    // will add pa ani, dapat mu jump sya
    // also gi "activate" nako kay di mani siya technically mu explode

    for (Zombie z : Global.zombies[row]) {
      if (z.row == this.row && Math.abs(z.col - this.col) <= 1) {
        z.kill(DeathType.NORMAL);
      }
    }

    super.activate();
  }
}
