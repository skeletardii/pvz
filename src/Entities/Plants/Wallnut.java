package Entities.Plants;

import Entities.Misc.Plant;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class WallNut extends Plant {
  public static final Image sprite = new ImageIcon("assets/plants/wallnut.png").getImage();
  public WallNut(int row, int col) {
    super(
      row,
      col,
      50,
      4000,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      sprite,
      509,
      496,
      1
    );
    anim_start[0] = 0;
    anim_end[0] = 16;
    offsetOY = 20;
    
    anim_speed=2;
  }

  public WallNut(int row, int col, int health, int sunCost, Image sprite, int sw, int sh) {
    super(
      row,
      col,
      sunCost,
      health,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      sprite,
      sw,
      sh,
      1
    );
  }

  public WallNut() {
    this(-1, -1);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  public static class TallNut extends WallNut {
    private static final Image sprite2 = new ImageIcon("assets/plants/tallnut.png").getImage();
    public TallNut(int row, int col) {
      super(row, col, 8000, 125, sprite2, 414, 584);
      anim_start[0] = 20;
      anim_end[0] = 36;
      scale = 0.2;
      shadowScale=1.25;
      shadowOffsetY=15;
      offsetOY=10;
      anim_speed=2;
    }

    public TallNut() {
      this(-1, -1);
    }
  }
}
