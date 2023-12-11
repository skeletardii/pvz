package Entities.Plants.InstaKillers;

import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Entities.Zombies.Zombie.DeathType;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.text.PlainDocument;

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
    anim_start[0] = 14;
    anim_end[0] = 26;
    anim_start[1] = 0;
    anim_end[1] = 13;
    setFrame(14);
    offsetOY = 10;
  }

  public CherryBomb() {
    this(-1, -1);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    if (explodeTime <= (anim_end[0] - anim_start[0]) * 2) {
      renderSprite(g, 1);
    } else {
      renderSprite(g, 0);
    }
  }

  @Override
  public void activate() {
    for (int k = -1; k < 2; ++k) {
      if (
        this.getRow() + k >= 0 && this.getRow() < Global.PLANT_ROWS_COUNT
      ) return;

      for (Zombie z : Global.zombies[this.getRow() + k]) {
        if (Math.abs(z.getCol() - this.getRow()) <= 1.5) {
          z.kill(DeathType.EXPLODED);
        }
      }
    }

    super.activate();
  }
}
