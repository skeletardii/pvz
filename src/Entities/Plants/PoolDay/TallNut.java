package Entities.Plants.PoolDay;

import Entities.Plants.LawnDay.WallNut;
import Entities.Plants.PlantBuilder;
import java.awt.Image;
import javax.swing.ImageIcon;

public class TallNut extends WallNut {

  private static final Image sprite = new ImageIcon("assets/plants/tallnut.png")
    .getImage();

  public TallNut(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(8000)
        .setSunCost(50)
        .setPacketCooldown(SeedPacketRechargeTime.VERY_SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(414)
        .setSpriteHeight(584)
    );
    animStart[0] = 20;
    animEnd[0] = 36;
    scale = 0.2;
    shadowScale = 1.25;
    shadowOffsetY = 15;
    offsetOY = 10;
    animSpeed = 2;
  }

  public TallNut() {
    this(-1, -1);
  }
}
