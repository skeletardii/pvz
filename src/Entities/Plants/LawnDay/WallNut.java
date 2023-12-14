package Entities.Plants.LawnDay;

import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class WallNut extends Plant {

  public static final Image sprite = new ImageIcon("assets/plants/wallnut.png")
    .getImage();

  public WallNut() {
    this(-1, -1);
  }

  public WallNut(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(4000)
        .setSunCost(50)
        .setPacketCooldown(SeedPacketRechargeTime.VERY_SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(169)
        .setSpriteHeight(165)
    );
    animStart[0] = 0;
    animEnd[0] = 16;
    offsetOY = 20;
    animSpeed = 2;
  }

  public WallNut(PlantBuilder pBuilder) {
    super(pBuilder);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
