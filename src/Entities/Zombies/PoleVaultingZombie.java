package Entities.Zombies;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Plants.Plant;
import Main.Global;

public class PoleVaultingZombie extends Zombie {

  private boolean jumped = false;
  private static final Image sprite = new ImageIcon("assets/zombies/polevaulter.png").getImage();
  public PoleVaultingZombie(int row) {
    super(
      new ZombieBuilder()
        .setRow(row)
        .setMovementSpeed(ZombieSpeed.FAST.getValue())
        .setSprite(sprite)
        .setSpriteWidth(686)
        .setSpriteHeight(431));
    animStart[0]=14;
    animEnd[0]=50;
    animSpeed=0;
    offsetOX=-120;
  }

  public PoleVaultingZombie(ZombieBuilder zBuilder) {
    super(zBuilder);
  }

  @Override
  public void update() {
    super.update();

    if (!this.jumped) {
      for (Plant p : Global.plants[(int) this.getRow()]) {
        if (p != null && this.isTouching(p)) {
          this.moveCol(-1.5);
          this.jumped = true;
        }
      }
    }
  }
}
