package Entities.Projectiles;

import Entities.Misc.LiveEntity;
import Entities.Misc.LiveEntityBuilder;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Projectile extends LiveEntity {

  protected double projectileSpeed;
  protected int projectileDamage;

  protected  Projectile(LiveEntityBuilder leBuilder, int projectileDamage, double projectileSpeed) {
    super(leBuilder.row, leBuilder.col, leBuilder.sprite, leBuilder.spriteWidth, leBuilder.spriteHeight, leBuilder.animRow);

    this.projectileSpeed = projectileSpeed;
    this.projectileDamage = projectileDamage;
  }



  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
