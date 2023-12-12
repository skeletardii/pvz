package Entities.Plants;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class CabbagePult extends Plant {

  private static final Image sprite = new ImageIcon(
    "assets/plants/cabbagepult.png"
  )
    .getImage();

  private int state = 0;

  public CabbagePult() {
    this(-1, -1);
  }

  public CabbagePult(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(100)
        .setSunCost(100)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(496)
        .setSpriteHeight(527)
        .setAnimRow(2)
    );
    animStart[0] = 4;
    animEnd[0] = 35;
    animStart[1] = 36;
    animEnd[1] = 73;
    actionSpeed = 100;
    offsetOX = -30;
  }

  @Override
  public void update() {
    if (actionCtr-- <= 0) {
      actionCtr = actionSpeed;
    }
    if (actionCtr <= 37) {
      state = 1;
      animSpeed = 0;
    } else {
      state = 0;
      animSpeed = 1;
    }
  }

  public void paintComponent(Graphics2D g) {
    renderSprite(g, state);
  }
}
