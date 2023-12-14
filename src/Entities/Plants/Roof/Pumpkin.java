package Entities.Plants.Roof;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;

public class Pumpkin extends Plant {

  private static final Image sprite = new ImageIcon("assets/plants/pumpkin.png").getImage();
  public Pumpkin() {
    this(-1, -1);
  }

  protected Pumpkin(double row, double col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(4000)
        .setSunCost(125)
        .setSprite(sprite)
        .setSpriteWidth(164)
        .setSpriteHeight(110)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
    );
    animStart[0] = 0;
    animEnd[0] = 42;
    offsetOY=20;
  }
  public void paintComponent(Graphics2D g){
    Composite og = g.getComposite();
    g.setComposite((AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f)));
    renderSprite(g, 0);
    g.setComposite(og);
  }
}
