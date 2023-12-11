package Entities.Plants;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Torchwood extends Plant {

  public static final Image sprite = new ImageIcon("assets/plants/wallnut.png")
    .getImage();

  public Torchwood(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(100)
        .setSunCost(150)
        .setPacketCooldown(SeedPacketRechargeTime.VERY_SLOW.getValue())
        .setSprite(sprite)
    );
    anim_start[0] = 0;
    anim_end[0] = 16;
    offsetOY = 20;
  }

  public Torchwood() {
    this(-1, -1);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
