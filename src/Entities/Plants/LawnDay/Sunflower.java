package Entities.Plants.LawnDay;

import Entities.Interfaces.SunProducer;
import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;
import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Sunflower extends Plant implements SunProducer, Upgradable {

  private static final Image sprite = new ImageIcon(
    "assets/plants/sunflower.png"
  )
    .getImage();
  int sunCooldown = 1440;
  int sunCtr = 0;

  public Sunflower(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(50)
        .setHealth(100)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(364)
        .setSpriteHeight(365)
    );
    animStart[0] = 4;
    animEnd[0] = 28;
    setFrame(4);
  }

  public Sunflower(PlantBuilder pBuilder) {
    super(pBuilder);
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
    Global.game.add(produceSunGrid(25, getRow(), getCol(), 60));
  }

  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  @Override
  public Upgraded upgrade() {
    return new TwinSunflower();
  }

  public static class TwinSunflower extends Sunflower implements Upgraded {

    private static final Image sprite = new ImageIcon(
      "assets/plants/twinsunflower.png"
    )
      .getImage();

    public TwinSunflower(int row, int col) {
      super(
        new PlantBuilder()
          .setRow(row)
          .setCol(col)
          .setHealth(150)
          .setSunCost(150)
          .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
          .setSprite(sprite)
          .setSpriteWidth(422)
          .setSpriteHeight(422)
      );
      animStart[0] = 8;
      animEnd[0] = 33;
      setFrame(4);
    }

    public TwinSunflower() {
      this(-1, -1);
    }

    @Override
    public void selfProduceSun() {
      Global.game.add(produceSunGrid(25, getRow(), getCol(), 60));
      Global.game.add(produceSunGrid(25, getRow(), getCol() - 1, 60));
    }

    @Override
    public int getIncreasingSunCost() {
      return 50;
    }
  }
}
