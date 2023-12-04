package Entities.Plants;

import Entities.Misc.Plant;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Cabbage extends Plant {

  private static final Image sprite = new ImageIcon("assets/plants/sunflower.png").getImage();
  int attack_cooldown = 60;
  int attack_ctr = 0;
  public Cabbage(
    int row,
    int col,
    int sunCost,
    int health,
    double packetCooldown,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(
      row,
      col,
      sunCost,
      health,
      packetCooldown,
      sprite,
      spriteWidth,
      spriteHeight,
      animRow
    );
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
