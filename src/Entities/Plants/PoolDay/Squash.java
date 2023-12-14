package Entities.Plants.PoolDay;

import Entities.Plants.InstaKiller;
import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Entities.Zombies.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Squash extends InstaKiller {

  private static final Image sprite = new ImageIcon(
    "assets/plants/squash.png"
  )
    .getImage();

  public Squash(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(50)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(153)
        .setSpriteHeight(162)
    );
    this.explodeSpeed = 0;
    animStart[0] = 4;
    animEnd[0] = 28;
    setFrame(4);
  }

  public Squash() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();

    // check if zombie is near, if so explode
    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (Math.abs(z.getCol() - this.getCol()) <= 1) {
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

    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (Math.abs(z.getCol() - this.getCol()) <= 1) {
        z.kill(DeathType.NORMAL);
      }
    }

    super.activate();
  }
}
