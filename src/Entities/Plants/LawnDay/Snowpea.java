package Entities.Plants.LawnDay;

import Entities.Plants.PlantBuilder;
import Entities.Projectiles.SnowPea;

public class Snowpea extends Peashooter {

  public Snowpea() {
    this(-1, -1);
  }

  public Snowpea(double row, double col) {
    super(new PlantBuilder().setRow(row).setCol(col).setHealth(300).setSunCost(175).setSunCost(125), 1);
  }

  @Override
  public void shoot() {
    this.add(new SnowPea(this.getRow(), this.getCol()));
  }
}
