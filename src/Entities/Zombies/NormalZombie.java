package Entities.Zombies;

import Entities.Misc.Zombie;
import java.awt.Graphics2D;

public class NormalZombie extends Zombie {

  public NormalZombie(int row) {
    super(row, 10, 0.01, 1, "basiczombie0001", 961, 723, 1);
    anim_start[0] = 0;
    anim_end[0] = 0;
    setFrame(0);
  }

  public NormalZombie() {
    this(-1);
  }

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderSprite(g, 0);
  }
}
