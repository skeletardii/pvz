package Entities.Plants.InstaKillers;

import Entities.Misc.InstaKiller;
import Entities.Misc.Zombie;
import Entities.Misc.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;

public class PotatoMine extends InstaKiller {

  // 14 seconds
  private int timeTillActivation = 14 * 60;

  public PotatoMine(int row, int col) {
    super(
      row,
      col,
      25,
      300,
      Global.SeedPacketRechargeTime.VERY_SLOW.getValue(),
      "sunflower",
      364,
      365,
      1
    );
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public PotatoMine() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();

    if (timeTillActivation > 0) {
      timeTillActivation -= 1;
    } else {
      // check if zombie is touching, if so explode
      for (Zombie z : Global.zombies) {
        if (z.row == this.row && isTouching(z)) {
          explode();
          return;
        }
      }
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  @Override
  public void explode() {
    for (Zombie z : Global.zombies) {
      // if zombie is in a 1x1 ish radius
      if (z.row == this.row && isTouching(z)) {
        z.kill(DeathType.EXPLODED);
      }
    }

    super.explode();
  }
}
