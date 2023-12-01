
package Entities.Zombies;

import Entities.Misc.Zombie;
import java.awt.Graphics2D;

public class NormalZombie extends Zombie {

  public NormalZombie(int row) {

    super(row, 10, 0.01, 60, "sunflower", 364, 365, 1);
    
    anim_start[0] = 4;
    anim_end[0] = 28;
    setFrame(4);
  }

  public NormalZombie(){
    this(-1);
  }
  

  public void paintComponent(Graphics2D g) { //px 364 py 365
    renderPlant(g, 0);
  }
}

