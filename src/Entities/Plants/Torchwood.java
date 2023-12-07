package Entities.Plants;

import Entities.Misc.Plant;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Torchwood extends Plant {

  public static final Image sprite = new ImageIcon("assets/plants/wallnut.png")
    .getImage();

  public Torchwood(int row, int col) {
    super(
      row,
      col,
      100,
      400300,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      sprite,
      509,
      496,
      1
    );
    anim_start[0] = 0;
    anim_end[0] = 16;
    offsetOY = 20;
  }

  public Torchwood(int row, int col, int health, int sunCost, Image sprite) {
    super(
      row,
      col,
      sunCost,
      health,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      sprite,
      364,
      365,
      1
    );
  }

  public Torchwood() {
    this(-1, -1);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
