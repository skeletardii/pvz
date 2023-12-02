package Entities.Misc;

import Main.Global;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class LawnMower extends LiveEntity {

  protected boolean isActivated = false;
  protected static final double MOVEMENT_SPEED = 0.2;

  public LawnMower(int row) {
    this(row, "sunflower");
  }

  public LawnMower(int row, String spriteName) {
    super(
      row,
      -1,
      new ImageIcon("assets/plants/" + spriteName + ".png").getImage(),
      364,
      365,
      1
    );
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  @Override
  public void update() {
    // make shit move

    if (!isActivated) {
      // may possibly implement as a more general case??
      for (Zombie z : Global.zombies) {
        if (z.row == this.row && this.isTouching(z)) {
          isActivated = true;
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
    renderSprite(g, 0);
  }

  public static class PoolCleaner extends LawnMower {

    public PoolCleaner(int row) {
      // replace to poolcleaner.png
      super(row, "sunflower");
    }
  }
}
