package Entities.Plants.InstaKillers;

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
        .setSpriteWidth(351)
        .setSpriteHeight(468)
    );
    anim_start[0] = 0;
    anim_end[0] = 24;
    anim_speed = 2;
  }

  public Jalapeno() {
    this(-1, -1);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  @Override
  public void activate() {
    for (Zombie z : Global.zombies[this.getRow()]) {
      if (z.getRow() == this.getRow()) {
        z.kill(DeathType.EXPLODED);
      }
    }

    super.activate();
  }
}
