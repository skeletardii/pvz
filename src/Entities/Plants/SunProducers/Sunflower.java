package Entities.Plants.SunProducers;

import Entities.Interfaces.SunProducer;
import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;
import Entities.Misc.Plant;
import java.awt.Graphics2D;

public class Sunflower extends Plant implements SunProducer, Upgradable {

  int sunCooldown = 1440;
  int sunCtr = 0;

  public Sunflower(
    int row,
    int col,
    int sunCost,
    int health,
    double packetCooldown,
    String spriteName,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(
      row,
      col,
      sunCost,
      health,
      packetCooldown,
      spriteName,
      spriteWidth,
      spriteHeight,
      animRow
    );
  }

  public Sunflower(int row, int col) {
    this(row, col, 50, 100, 7.5, "sunflower", 364, 365, 1);
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public Sunflower() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();

    sunCtr++;
    if (sunCtr >= sunCooldown) {
      sunCtr = 0;
      this.selfProduceSun();
    }
  }

  public void selfProduceSun() {
    this.add(produceSunGrid(25, row, col, 60));
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  @Override
  public Upgraded upgrade() {
    return new TwinSunflower();
  }

  public static class TwinSunflower extends Sunflower implements Upgraded {

    public TwinSunflower(int row, int col) {
      super(
        row,
        col,
        150,
        150,
        SeedPacketRechargeTime.SLOW.getValue(),
        "twinsunflower",
        422,
        422,
        1
      );
      anim_start[0] = 8;
      anim_end[0] = 33;
      setFrame(4);
    }

    public TwinSunflower() {
      this(-1, -1);
    }

    @Override
    public void selfProduceSun() {
      this.add(produceSunGrid(25, row, col, 60));
      this.add(produceSunGrid(25, row, col - 1, 60));
    }
  }
}
