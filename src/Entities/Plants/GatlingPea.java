package Entities.Plants;

import Entities.Interfaces.Upgraded;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GatlingPea extends Repeater implements Upgraded {

  private static final Image sprite = new ImageIcon(
    "assets/plants/peashooter.png"
  )
    .getImage();

  public GatlingPea() {
    this(-1, -1);
  }

  public GatlingPea(int row, double col) {
    super(row, col, 4, 250);
  }

  @Override
  public int getIncreasingSunCost() {
    return 250;
  }
}
