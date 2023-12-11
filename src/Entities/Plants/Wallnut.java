package Entities.Plants;

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
        .setSpriteWidth(509)
        .setSpriteHeight(496)
    );
    anim_start[0] = 0;
    anim_end[0] = 16;
    offsetOY = 20;
    anim_speed = 2;
  }

  public WallNut(PlantBuilder pBuilder) {
    super(pBuilder);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  public static class TallNut extends WallNut {

    private static final Image sprite = new ImageIcon(
      "assets/plants/tallnut.png"
    )
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
      anim_start[0] = 20;
      anim_end[0] = 36;
      scale = 0.2;
      shadowScale = 1.25;
      shadowOffsetY = 15;
      offsetOY = 10;
      anim_speed = 2;
    }

    public TallNut() {
      this(-1, -1);
    }
  }
}
