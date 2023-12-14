package Entities.Plants.LawnDay;

import Entities.Interfaces.SunProducer;
import Entities.Plants.Plant;
import Entities.Plants.Plant.SeedPacketRechargeTime;
import Entities.Plants.PlantBuilder;
import Entities.Zombies.Zombie;
import Entities.Zombies.Zombie.DeathType;
import GameUtils.Sound;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class Chomper extends Plant implements SunProducer {

  private static final Image sprite = new ImageIcon("assets/plants/chomper.png")
    .getImage();
  private static final File chomp = new File("assets/sound/bigchomp.wav");
  private int eatingTime = 0;
  private int untilRefresh;
  private int untilEat;

  public Chomper(int row, int col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(150)
        .setSunCost(300)
        .setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue())
        .setSprite(sprite)
        .setSpriteWidth(690)
        .setSpriteHeight(694)
        .setAnimRow(4)
    );
    scale = 0.23;
    offsetOX = 30;
    offsetOY = 10;
    shadowOffsetY = 10;
    animStart[0] = 0;
    animEnd[0] = 25;
    animStart[1] = 26;
    animEnd[1] = 50;
    animStart[2] = 51;
    animEnd[2] = 65;
    animStart[3] = 66;
    animEnd[3] = 93;
    untilEat = (animEnd[1] - animStart[1]) * 2;
    untilRefresh = (animEnd[3] - animStart[3]) * 2;
  }

  public Chomper() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();
    if (eatingTime > 0) eatingTime--;
    // add logic sad para dili instant ang pag eat

    Zombie chosenZombie = null;

    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (
        !isEating() &&
        z.getRow() == this.getRow() &&
        z.getCol() - this.getCol() <= 2 &&
        (chosenZombie == null || chosenZombie.getCol() > z.getCol()) &&
        z.isTargetable()
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
    if (eatingTime > untilRefresh) renderSprite(g, 2); else if (
      eatingTime == 0
    ) renderSprite(g, 0); else {
      setFrame(66 + ((untilRefresh - eatingTime) / 2));
      renderSprite(g, 3);
    }
  }

  public boolean isEating() {
    return eatingTime > 0;
  }
}
