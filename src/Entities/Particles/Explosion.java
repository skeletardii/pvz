package Entities.Particles;

import GameUtils.RenderObj;
import Main.Constants;
import Main.Global;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

public class Explosion extends RenderObj {
  private double random(double min, double max) {
    return min + Math.random() * (max - min);
  }

  public Explosion(int row, double col) {
    setZindex(20);
    int ox = (int) Math.round((col) * Constants.COL_PIXEL_OFFSET + Constants.GRID_OFFSET_X);
    int oy = (int) Math.round((row) * Constants.ROW_PIXEL_OFFSET + Constants.GRID_OFFSET_Y);
    for (int i = 0; i <= 10; i++) {
      this.add(
          new ExplosionCloud(
            1,
            60,
            ox,
            oy,
            random(-4, 4),
            random(-4, 4)
          )
        );
    }
    for (int i = 0; i <= 3; i++) {
      this.add(
          new ExplosionCloud(
            2.1,
            60,
            ox,
            oy,
            random(-2, 2),
            random(-2, 2)
          )
        );
    }
  }

  public void paintComponent(Graphics2D g) {
    if (getChildren().size() == 0) {
      Global.particles.remove(this);
      this.remove();
    }
  }
}

class ExplosionCloud extends RenderObj {

  private static final Image cloud = new ImageIcon(
    "assets/projectiles/explosioncloud.png"
  )
    .getImage();
  private static final int side = 80;
  private int life, posX, posY, rot, rotSpeed;
  private double size, velX, velY;

  public ExplosionCloud(
    double size,
    int life,
    int posX,
    int posY,
    double velX,
    double velY
  ) {
    this.size = size;
    this.life = life;
    this.posX = posX;
    this.posY = posY;
    this.velX = velX;
    this.velY = velY;
    size *= Math.random() + 0.5;
    rot = (int) (Math.random() * 360);
    rotSpeed = (int) (Math.random() * 10);
  }

  public void paintComponent(Graphics2D g) {
    Composite ogc = g.getComposite();
    life--;
    posX += (int) Math.round(velX);
    posY += (int) Math.round(velY);

    AffineTransform og = g.getTransform();
    AffineTransform at = (AffineTransform)(og.clone());
    at.rotate(
      Math.toRadians(rot),
      posX,
      posY
    );
    g.setTransform(at);
    if (life <= 15) g.setComposite(
      AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (life / 15.0))
    );
    else g.setComposite(
      AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f)
    );
    //at.scale(0.7, 0.7);
    g.drawImage(
      cloud,
      (int) (posX - size * side / 2),
      (int) (posY - size * side / 2),
      (int) (posX + size * side / 2),
      (int) (posY + size * side / 2),
      0,
      0,
      side,
      side,
      null
    );
    //g.drawImage(op.filter((BufferedImage)cloud,null),posX,posY,null);
    g.setTransform(og);
    g.setComposite(ogc);
    rot += rotSpeed;
    if (life <= 0) this.remove();
  }
}
