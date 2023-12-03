package Entities.Plants;

import Entities.Interfaces.Upgradable;
import Entities.Interfaces.Upgraded;
import Entities.Misc.Plant;
import java.awt.Graphics2D;

public class SpikeWeed extends Plant implements Upgradable {

  public SpikeWeed(int row, int col) {
    super(
      row,
      col,
      50,
      4000,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      "sunflower",
      364,
      365,
      1
    );
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
    this.targetable = false;
  }

  public SpikeWeed(
    int row,
    int col,
    int health,
    int sunCost,
    String spriteName
  ) {
    super(
      row,
      col,
      sunCost,
      health,
      SeedPacketRechargeTime.VERY_SLOW.getValue(),
      spriteName,
      364,
      365,
      1
    );
  }

  public SpikeWeed() {
    this(-1, -1);
  }

  @Override
  public Upgraded upgrade() {
    return new SpikeRock();
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  public static class SpikeRock extends SpikeWeed implements Upgraded {}
}
