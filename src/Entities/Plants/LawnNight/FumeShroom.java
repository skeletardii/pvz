package Entities.Plants.LawnNight;

import Entities.Interfaces.Attacker;
import Entities.Plants.PlantBuilder;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FumeShroom extends Shroom implements Attacker {

  private static final Image sprite = new ImageIcon(
    "assets/plants/sunflower.png"
  )
    .getImage();

  protected FumeShroom(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(75)
        .setHealth(300)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
        .setSprite(sprite)
        .setSpriteWidth(364)
        .setSpriteHeight(365)
    );
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  @Override
  public void update() {}

  @Override
  public void attack() {}
}
