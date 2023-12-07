package Entities.Plants;

import Entities.Interfaces.SunProducer;
import Entities.Misc.Plant;
import Entities.Misc.Zombie;
import Entities.Misc.Zombie.DeathType;
import GameUtils.Sound;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Chomper extends Plant implements SunProducer {
  private static final Image sprite = new ImageIcon("assets/plants/chomper.png").getImage();
  private static final File chomp = new File("assets/sound/bigchomp.wav");
  private int eatingTime = 0;
  private int untilRefresh;
  private int untilEat;
  public Chomper(int row, int col) {
    super(
      row,
      col,
      150,
      300,
      SeedPacketRechargeTime.SLOW.getValue(),
      sprite,
      690,
      694,
      4
    );
    // 0 17
    // 18 40
    // 41 57
    // 58 93
    scale =0.23;
    offsetOX=30;
    offsetOY=10;
    shadowOffsetY=10;
    anim_start[0] = 0;
    anim_end[0] = 25;
    anim_start[1] = 26;
    anim_end[1] = 50;
    anim_start[2] = 51;
    anim_end[2] = 65;
    anim_start[3] = 66;
    anim_end[3] = 93;
    untilEat=(anim_end[1]-anim_start[1])*2;
    untilRefresh=(anim_end[3]-anim_start[3])*2;
  }

  public Chomper() {
    this(-1, -1);
  }

  @Override
  public void update() {
    super.update();
    if(eatingTime>0) eatingTime--;
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
    if(eatingTime > untilRefresh) renderSprite(g, 2);
    else if (eatingTime==0) renderSprite(g, 0);
    else {
      setFrame(66 + ((untilRefresh-eatingTime)/2));
      renderSprite(g, 3);
    }
  }

  public boolean isEating() {
    return eatingTime > 0;
  }
}
