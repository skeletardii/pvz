package GUI;

import GameUtils.Game;
import GameUtils.Mouse;
import GameUtils.RenderObj;
import GameUtils.Updater;
import java.awt.Color;
import java.awt.Graphics2D;

public class Selector extends RenderObj implements Updater {

  Mouse mouse;
  Mouse mousePrev;

  public Selector(Game game) {
    mouse = game.mouse;
    mousePrev = mouse;
  }

  public void update() {
    mousePrev = mouse;
    mouse = game.mouse;
  }

  public void paintComponent(Graphics2D g) {
    g.setColor(Color.white);
    g.drawLine(mouse.x, mouse.y, mousePrev.x, mousePrev.y);
  }
}
