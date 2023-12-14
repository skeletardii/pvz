package Entities.Plants.LawnNight;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Interfaces.Upgraded;
import Entities.Plants.PlantBuilder;

public class GloomShroom extends FumeShroom implements Upgraded {
  private static final Image sprite = new ImageIcon("assets/plants/gloomshroom.png").getImage();

  protected GloomShroom(double row, double col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(75)
        .setHealth(300)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
        .setSprite(sprite)
        .setSpriteWidth(161)
        .setSpriteHeight(138),
      4
    );
    animStart[0]=4;
    animEnd[0]=16;
  }

  public GloomShroom() {
    this(-1, -1);
  }

  @Override
  public int getIncreasingSunCost() {
    return 75;
  }

  @Override
  public Object getLowerClass() {
    return new FumeShroom();
  }
}
