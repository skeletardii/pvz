package Entities.Plants.InstaKillers;

import Entities.Misc.InstaKiller;
import Entities.Misc.Zombie;
import Entities.Misc.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PotatoMine extends InstaKiller {

  // 14 seconds
  private int timeTillActivation = 14 * 60;

  private static final Image sprite = new ImageIcon("assets/plants/potatomine.png").getImage();
  public PotatoMine(int row, int col) {
    super(
      row,
      col,
      25,
      300,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      sprite,
      467,
      381,
      3
    );
    this.explodeSpeed = 0;
    anim_start[0] = 0;
    anim_end[0] = 0;
    anim_start[1] = 1;
    anim_end[1] = 19;
    anim_start[2] = 20;
    anim_end[2] = 35;
    scale = 0.2;
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
        if (isTouching(z)) {
          activate();
          return;
        }
      }
    }
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    if (timeTillActivation == 0) renderSprite(g, 2); else if (
      timeTillActivation <= 38
    ) renderSprite(g, 1); else renderSprite(g, 0);
  }

  @Override
  public void activate() {
    for (Zombie z : Global.zombies) {
      // if zombie is in a 1x1 ish radius
      if (isTouching(z)) {
        z.kill(DeathType.EXPLODED);
      }
    }

    super.activate();
  }
}
