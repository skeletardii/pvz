package Entities.Plants.InstaKillers;

import Entities.Misc.InstaKiller;
import Entities.Misc.Zombie;
import Entities.Misc.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Jalapeno extends InstaKiller {

  private static final Image sprite = new ImageIcon("assets/plants/jalapeno.png").getImage();
  public Jalapeno(int row, int col) {
    super(
      row,
      col,
      125,
      100,
      SeedPacketRechargeTime.SLOW.getValue(),
      sprite,
      351,
      468,
      1
    );
    anim_start[0] = 0;
    anim_end[0] = 24;
    anim_speed=2;
  }

  public Jalapeno() {
    this(-1, -1);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  @Override
  public void activate() {
    for (Zombie z : Global.zombies) {
      if (z.row == this.row) {
        z.kill(DeathType.EXPLODED);
      }
    }

    super.activate();
  }
}
