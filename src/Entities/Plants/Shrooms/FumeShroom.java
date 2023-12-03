package Entities.Plants.Shrooms;

import Entities.Misc.Shroom;
import java.awt.Graphics2D;

public class FumeShroom extends Shroom {

  protected FumeShroom(int row, int col) {
    super(
      row,
      col,
      75,
      300,
      SeedPacketRechargeTime.FAST.getValue(),
      "sunflower",
      364,
      365,
      1
    );
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  @Override
  public void update() {}
}
