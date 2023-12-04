package Entities.Misc;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public abstract class Projectile extends LiveEntity {

  protected double projectileSpeed;
  protected int projectileDamage;

  protected Projectile(
    int row,
    double col,
    double projectileSpeed,
    int projectileDamage,
    String spriteName,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(
      row,
      col,
      new ImageIcon("assets/plants/" + spriteName + ".png").getImage(),
      spriteWidth,
      spriteHeight,
      animRow
    );
    this.projectileSpeed = projectileSpeed;
    this.projectileDamage = projectileDamage;
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
