package Entities.Misc;

import Entities.Zombies.Zombie;
import GameUtils.Sound;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class LawnMower extends LiveEntity {

  protected boolean isActivated = false;
  protected static final double MOVEMENT_SPEED = 0.1;
  private static final File sndfile = new File("assets/sound/lawnmower.wav");
  private static final Image sprite = new ImageIcon(
    "assets/plants/lawnmower.png"
  )
    .getImage();

  public LawnMower(int row) {
    super(row, -1, sprite, 450, 364, 1);
    animStart[0] = 0;
    animEnd[0] = 16;
    offsetOY = 20;
    scale = 0.20;
  }

  @Override
  public void update() {
    // make shit move

    if (!isActivated) {
      // may possibly implement as a more general case??
      for (Zombie z : Global.zombies[this.getRow()]) {
        if (this.isTouching(z)) {
          isActivated = true;
          Sound.play(sndfile);
        }
      }
    }

    if (isActivated) {
      this.moveCol(LawnMower.MOVEMENT_SPEED);

      for (Zombie z : Global.zombies[this.getRow()]) {
        if (this.isTouching(z)) {
          z.kill(null);
        }
      }
    }
  }

  @Override
  public void paintComponent(Graphics2D g) {
    if (isActivated) {
      renderSprite(g, 0);
    } else {
      setFrame(0);
      renderSprite(g, 0);
    }
  }

  public static class PoolCleaner extends LawnMower {

    public PoolCleaner(int row) {
      // replace to poolcleaner.png
      super(row);
    }
  }
}
