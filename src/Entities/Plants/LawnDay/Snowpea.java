package Entities.Plants.LawnDay;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Projectiles.SnowPea;

public class Snowpea extends Peashooter {
  private static final Image sprite = new ImageIcon("assets/plants/snowpea.png").getImage();

  public Snowpea() {
    this(-1, -1);
  }

  public Snowpea(double row, double col) {
    super(row, col, 1, 125,sprite,122,117);
  }

  @Override
  public void shoot() {
    this.add(new SnowPea(this.getRow(), this.getCol()));
  }
}
