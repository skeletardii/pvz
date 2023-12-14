package Entities.Plants.LawnDay;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;

public class Repeater extends Peashooter implements Upgradable {
  private static final Image sprite = new ImageIcon("assets/plants/repeater.png").getImage();

  public Repeater() {
    this(-1, -1);
  }

  public Repeater(double row, double col) {
    super(row, col, 2, 150,sprite,126,117);
  }

  @Override
  public Upgraded upgrade() {
    return new GatlingPea(getRow(), getCol());
  }
}
