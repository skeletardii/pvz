package Entities.Plants;

import Entities.Interfaces.SunProducer;
import Entities.Misc.Plant;
import Entities.Misc.Zombie;
import Entities.Misc.Zombie.DeathType;
import GameUtils.Sound;
import Main.Global;
import java.awt.Graphics2D;
import java.io.File;

public class Chomper extends Plant implements SunProducer {

  private static final File chomp = new File("assets/sound/bigchomp.wav");
  private int eatingTime = 0;

  public Chomper(int row, int col) {
    super(
      row,
      col,
      150,
      300,
      Global.SeedPacketRechargeTime.SLOW.getValue(),
      "sunflower",
      364,
      365,
      1
    );
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public Chomper() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();
    this.eatingTime = Math.max(0, this.eatingTime - 1);

    // add logic sad para dili instant ang pag eat

    Zombie chosenZombie = null;

    for (Zombie z : Global.zombies) {
      if (
        !isEating() &&
        z.row == this.row &&
        z.col - this.col <= 2 &&
        (chosenZombie == null || chosenZombie.col > z.col)
      ) chosenZombie = z;
    }

    if (chosenZombie != null) eatZombie(chosenZombie);
  }

  public void eatZombie(Zombie z) {
    z.kill(DeathType.NORMAL);
    this.eatingTime = 1000;
    Sound.play(chomp);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }

  public boolean isEating() {
    return eatingTime > 0;
  }
}
