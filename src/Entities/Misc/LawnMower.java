package Entities.Misc;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class LawnMower extends LiveEntity {

  protected boolean isActivated = false;

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
