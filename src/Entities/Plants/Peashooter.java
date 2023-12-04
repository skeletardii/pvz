package Entities.Plants;

import Entities.Misc.Plant;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Peashooter extends Plant {

  private static final Image sprite = new ImageIcon(
    "assets/plants/peashooter.png"
  )
    .getImage();

  public Peashooter() {
    this(-1, -1, 100, 100, 7.5, sprite, 375, 353, 1);
    anim_start[0] = 79;
    anim_end[0] = 103;
  }

  public Peashooter(
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

  @Override
  public void update() {
    // if (shotsLeft > 0) {
    //   shoot();
    // } else {}
    super.update();
  }

  public void shoot() {
    // tuon sa ko lisod ko ani
  }
}
