package Entities.Plants;

import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;
import Entities.Misc.Plant;
import Entities.Misc.Zombie;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class SpikeWeed extends Plant implements Upgradable {
  private static final Image sprite = new ImageIcon("assets/plants/sunflower.png").getImage();
  private int dps;

  public SpikeWeed(int row, int col) {
    this(row, col, 50, 125, 30, sprite);
  }

  public SpikeWeed(
    int row,
    int col,
    int health,
    int sunCost,
    int dps,
    Image sprite
  ) {
    super(
      row,
      col,
      sunCost,
      health,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      sprite,
      364,
      365,
      1
    );
    this.dps = dps;
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
    setTargetable(false);
  }

  public SpikeWeed() {
    this(-1, -1);
  }

  @Override
  public Upgraded upgrade() {
    return new SpikeRock((int) this.row, (int) this.col);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  @Override
  public void update() {
    // adjust damage or maybe deal it in seconds
    for (Zombie z : Global.zombies) {
      if (this.isTouching(z)) {
        z.setHealth(z.getHealth() - dps);
      }
    }
  }

  public static class SpikeRock extends SpikeWeed implements Upgraded {

    private static final Image sprite = new ImageIcon("assets/plants/sunflower.png").getImage();
    public SpikeRock(int row, int col) {
      super(row, col, 9, 125, 40, sprite);
    }

    public SpikeRock() {
      this(-1, -1);
    }
  }
}
