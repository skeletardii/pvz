package Entities.Plants.LawnDay;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Repeater extends Peashooter {
  private static final Image sprite = new ImageIcon("assets/plants/repeater.png").getImage();

  public Repeater() {
    this(-1, -1);
  }

  public Repeater(double row, double col) {
    super(row, col, 2, 150,sprite,126,117);
  }

}
