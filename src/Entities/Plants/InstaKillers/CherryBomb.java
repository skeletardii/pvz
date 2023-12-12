package Entities.Plants.InstaKillers;

import Entities.Misc.Explosion;
import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Entities.Zombies.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class CherryBomb extends InstaKiller {

  private static final Image sprite = new ImageIcon(
    "assets/plants/cherrybomb.png"
  )
    .getImage();

  public CherryBomb(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(125)
        .setHealth(100)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(625)
        .setSpriteHeight(458)
        .setAnimRow(2)
    );
    animStart[0] = 14;
    animEnd[0] = 26;
    animStart[1] = 0;
    animEnd[1] = 13;
    offsetOY = 10;
    setFrame(14);
  }

  public CherryBomb() {
    this(-1, -1);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    if (explodeTime <= (animEnd[0] - animStart[0]) * 2) {
      renderSprite(g, 1);
    } else {
      renderSprite(g, 0);
    }
  }

  @Override
  public void activate() {
    for (int k = -1; k < 2; ++k) {
      if (
        this.getRow() + k < 0 || this.getRow() >= Global.PLANT_ROWS_COUNT
      ) break;

      for (Zombie z : Global.zombies[(int) this.getRow() + k]) {
        if (Math.abs(z.getCol() - this.getCol()) <= 1.5) {
          z.kill(DeathType.EXPLODED);
        }
      }
    }
    Global.game.add(new Explosion((int) getRow(), getCol()));
    super.activate();
  }
}
