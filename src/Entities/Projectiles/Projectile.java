package Entities.Projectiles;

import Entities.Misc.LiveEntity;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Projectile extends LiveEntity {

  protected double projectileSpeed;
  protected int projectileDamage;

  protected Projectile(
    int row,
    double col,
    double projectileSpeed,
    int projectileDamage,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(row, col, sprite, spriteWidth, spriteHeight, animRow);
    this.projectileSpeed = projectileSpeed;
    this.projectileDamage = projectileDamage;
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
