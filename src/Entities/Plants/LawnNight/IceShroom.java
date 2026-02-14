package Entities.Plants.LawnNight;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Main.Constants;
import Main.Global;

@SuppressWarnings("all")
public class IceShroom extends ShroomInstaKiller {
  private static final Image sprite = new ImageIcon("assets/plants/iceshroom.png").getImage();

  public IceShroom() {
    this(-1, -1);
  }

  protected IceShroom(double row, double col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col).setHealth(300)
        .setSunCost(75)
        .setSprite(sprite)
        .setSpriteWidth(134)
        .setSpriteHeight(123)
        .setPacketCooldown(SeedPacketRechargeTime.VERY_SLOW.getValue())
    );
    animStart[0] = 4;
    animEnd[0] = 20;
    
  }

  @Override
  public void activate() {
    super.activate();

    for (int k = 0; k < Constants.PLANT_ROWS_COUNT; ++k) {
      for (Zombie z : Global.zombies[k]) {
        z.setFrozen(180);
        z.setSlowed(360);
      }
    }
  }
}
