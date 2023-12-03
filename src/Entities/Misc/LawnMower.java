package Entities.Misc;

import Main.Global;
import java.awt.Graphics2D;
import java.io.File;

import javax.swing.ImageIcon;

import GameUtils.Sound;

public class LawnMower extends LiveEntity {

  protected boolean isActivated = false;
  protected static final double MOVEMENT_SPEED = 0.1;
    private static final File sndfile = new File("assets/sound/lawnmower.wav");

  public LawnMower(int row) {
    this(row, "lawnmower");
  }

  public LawnMower(int row, String spriteName) {
    super(
      row,
      -1,
      new ImageIcon("assets/plants/" + spriteName + ".png").getImage(),
      450,
      364,
      1
    );
    anim_start[0] = 0;
    anim_end[0] = 16;
    offsetOY=20;
    scale=0.20;
  }

  @Override
  public void update() {
    // make shit move

    if (!isActivated) {
      // may possibly implement as a more general case??
      for (Zombie z : Global.zombies) {
        if (z.row == this.row && this.isTouching(z)) {
          isActivated = true;
          Sound.play(sndfile);
        }
      }
    }

    if (isActivated) {
      this.col += LawnMower.MOVEMENT_SPEED;

      // hmm murag mu break ni if i remove sila while running pani
      for (Zombie z : Global.zombies) {
        if (z.row == this.row && this.isTouching(z)) {
          z.health = 0;
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
      super(row, "sunflower");
    }
  }
}
