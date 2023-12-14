package Entities.Zombies;

import Entities.Misc.LiveEntity;
import Entities.Misc.LiveEntityBuilder;
import java.awt.Graphics2D;

public class DrSerato extends LiveEntity {

  // and a shit ton of shit to implement lol

  public DrSerato() {
    super(new LiveEntityBuilder());
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
