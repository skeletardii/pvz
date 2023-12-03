package Entities.Plants;

import Entities.Misc.Plant;
import Main.Global;
import java.awt.Graphics2D;

public class WallNut extends Plant {

  public WallNut(int row, int col) {
    super(
      row,
      col,
      50,
      4000,
      Global.SeedPacketRechargeTime.VERY_SLOW.getValue(),
      "sunflower",
      364,
      365,
      1
    );
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public WallNut(int row, int col, int health, int sunCost, String spriteName) {
    super(
      row,
      col,
      sunCost,
      health,
      Global.SeedPacketRechargeTime.VERY_SLOW.getValue(),
      spriteName,
      364,
      365,
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

    public TallNut(int row, int col) {
      super(row, col, 8000, 125, "sunflower");
    }

    public TallNut() {
      this(-1, -1);
    }
  }
}
