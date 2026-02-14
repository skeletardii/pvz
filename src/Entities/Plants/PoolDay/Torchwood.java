package Entities.Plants.PoolDay;

import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Torchwood extends Plant {

  public static final Image sprite = new ImageIcon("assets/plants/torchwood.png")
    .getImage();

  public Torchwood(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(300)
        .setSunCost(175)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
        .setSprite(sprite)
        .setSpriteWidth(115)
        .setSpriteHeight(152)
    );
    animStart[0] = 4;
    animEnd[0] = 24;
    offsetOY = 0;
    animSpeed=3;
  }

  public Torchwood() {
    this(-1, -1);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
