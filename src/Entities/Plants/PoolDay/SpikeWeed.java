package Entities.Plants.PoolDay;

import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;
import Entities.Plants.Plant;
import Entities.Plants.Plant.SeedPacketRechargeTime;
import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class SpikeWeed extends Plant implements Upgradable {

  private static final Image sprite = new ImageIcon(
    "assets/plants/spikeweed.png"
  )
    .getImage();
  private int dps;

  public SpikeWeed() {
    this(-1, -1);
  }

  public SpikeWeed(int row, int col) {
    this(row, col, 50, 125, 30, sprite,135,70);
  }

  public SpikeWeed(
    int row,
    int col,
    int health,
    int sunCost,
    int dps,
    Image sprite,
    int spriteWidth,
    int spriteHeight
  ) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(sunCost)
        .setHealth(health)
        .setPacketCooldown(SeedPacketRechargeTime.VERY_SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(spriteWidth)
        .setSpriteHeight(spriteHeight)
    );
    this.dps = dps;
    animStart[0] = 4;
    animEnd[0] = 22;
    offsetOY=10;
    shadowScale=0.2;
    setFrame(4);
    setTargetable(false);
  }

  @Override
  public Upgraded upgrade() {
    return new SpikeRock((int) this.getRow(), (int) this.getCol());
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  @Override
  public void update() {
    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (this.isTouching(z) && z.isTargetable()) {
        z.takeDamage(dps);
      }
    }
  }

  public static class SpikeRock extends SpikeWeed implements Upgraded {

    private static final Image sprite = new ImageIcon(
      "assets/plants/spikerock.png"
    )
      .getImage();

    public SpikeRock(int row, int col) {
      super(row, col, 9, 125, 40, sprite,137,79);
    }

    public SpikeRock() {
      this(-1, -1);
    }

    @Override
    public int getIncreasingSunCost() {
      return 100;
    }
  }
}
