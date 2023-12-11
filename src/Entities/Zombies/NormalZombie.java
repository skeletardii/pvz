package Entities.Zombies;

import Entities.Misc.Zombie;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class NormalZombie extends Zombie {

  private static final Image sprite = new ImageIcon("assets/zombies/zombie.png")
    .getImage();

  public NormalZombie(int row) {
    super(row, 181, null, 0.01, 30, sprite, 961, 723, 2);
    anim_start[0] = 0;L
    anim_end[0] = 98;
    anim_start[1] = 99;
    anim_end[1] = 138;
  }

  public NormalZombie() {
    this(-1);
  }

  public void paintComponent(Graphics2D g) { // px 364 py 365
    if (isEating) renderSprite(g, 1); else renderSprite(g, 0);
  }
}
