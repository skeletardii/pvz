package Entities.Plants.PoolDay;

import Entities.Plants.InstaKiller;
import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Entities.Zombies.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Jalapeno extends InstaKiller {

  private static final Image sprite = new ImageIcon(
    "assets/plants/jalapeno.png"
  )
    .getImage();

  public Jalapeno(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(125)
        .setHealth(100)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(117)
        .setSpriteHeight(156)
    );
    animStart[0] = 0;
    animEnd[0] = 24;
    animSpeed = 2;
  }

  public Jalapeno() {
    this(-1, -1);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  @Override
  public void activate() {
    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (z.getRow() == this.getRow()) {
        z.kill(DeathType.EXPLODED);
      }
    }

    super.activate();
  }
}
