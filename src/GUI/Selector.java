package GUI;

import GameUtils.Game;
import GameUtils.Mouse;
import GameUtils.RenderObj;
import GameUtils.Updater;
import java.awt.Color;
import java.awt.Graphics2D;

public class Selector extends RenderObj implements Updater {

  Mouse mouse;
  Mouse mouse_prev;

  public Selector(Game game) {
    mouse = game.mouse;
    mouse_prev = mouse;
  }

  public void update() {
    mouse_prev = mouse;
    mouse = game.mouse;
  }

  public void paintComponent(Graphics2D g) {
    g.setColor(Color.white);
    g.drawLine(mouse.x, mouse.y, mouse_prev.x, mouse_prev.y);
  }
}
