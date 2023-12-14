package Entities.Plants.LawnNight;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Entities.Zombies.Zombie.DeathType;
import Main.Constants;
import Main.Global;

@SuppressWarnings("all")
public class DoomShroom extends ShroomInstaKiller {
  private static final Image sprite = new ImageIcon("assets/plants/doomshroom.png").getImage();

  public DoomShroom() {
    this(-1, -1);
  }

  protected DoomShroom(double row, double col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col).setHealth(300)
        .setSunCost(125)
        .setSprite(sprite)
        .setSpriteWidth(202)
        .setSpriteHeight(171)
        .setPacketCooldown(SeedPacketRechargeTime.VERY_SLOW.getValue())
    );
    animStart[0] = 0;
    animEnd[0] = 52;
  }

  @Override
  public void activate() {
    super.activate();

    for (int k = 0; k < Constants.PLANT_ROWS_COUNT; ++k) {
      for (Zombie z : Global.zombies[k]) {
        if (Math.abs(z.getCol() - this.getCol()) <= 3) {
          z.kill(DeathType.EXPLODED);
        }
      }
    }
  }
}
