package Entities.Plants.LawnDay;

import Entities.Interfaces.SunProducer;
import Entities.Interfaces.Upgraded;
import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Sunflower extends Plant implements SunProducer {
  private static final Image sprite = new ImageIcon(
    "assets/plants/sunflower.png"
  )
    .getImage();
  int sunCooldown = 900 * Global.gameSettings.sunFallRate;
  int sunCtr = 0;

  public Sunflower(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(50)
        .setHealth(300)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
        .setSprite(sprite)
        .setSpriteWidth(121)
        .setSpriteHeight(121)
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
}
