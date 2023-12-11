package Entities.Plants.Aquatic;

import Entities.Plants.PlantBuilder;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Lilypad extends Aquatic {

  private static final Image sprite = new ImageIcon(
    "assets/plants/sunflower.png"
  )
    .getImage();

  public Lilypad(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(25)
        .setHealth(300)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
        .setSprite(sprite)
        .setSpriteWidth(364)
        .setSpriteHeight(365)
    );
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public Lilypad() {
    this(-1, -1);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }
}
