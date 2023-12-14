package Entities.Plants.LawnDay;

import Entities.Plants.InstaKiller;
import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Entities.Zombies.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PotatoMine extends InstaKiller {

  // 14 seconds
  private int timeTillActivation = 14 * 60;

  private static final Image sprite = new ImageIcon(
    "assets/plants/potatomine.png"
  )
    .getImage();

  public PotatoMine(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(25)
        .setHealth(300)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(155)
        .setSpriteHeight(127)
        .setAnimRow(3)
    );
    this.explodeSpeed = 0;
    animStart[0] = 0;
    animEnd[0] = 0;
    animStart[1] = 1;
    animEnd[1] = 19;
    animStart[2] = 20;
    animEnd[2] = 35;
    scale = 0.6;
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
      for (Zombie z : Global.zombies[(int) this.getRow()]) {
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
    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (isTouching(z)) {
        z.kill(DeathType.EXPLODED);
      }
    }

    super.activate();
  }
}
