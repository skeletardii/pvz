package Entities.Plants.Shrooms;

import Entities.Misc.Shroom;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class FumeShroom extends Shroom {
private static final Image sprite = new ImageIcon("assets/plants/sunflower.png").getImage();
  protected FumeShroom(int row, int col) {
    super(
      row,
      col,
      75,
      300,
      SeedPacketRechargeTime.FAST.getValue(),
      sprite,
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
