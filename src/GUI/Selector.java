package GUI;

import GameUtils.Game;
import GameUtils.Mouse;
import GameUtils.RenderObj;
import GameUtils.Updater;
import java.awt.Color;
import java.awt.Graphics2D;

public class Selector extends RenderObj implements Updater {

  Mouse mouse;

  public Selector(Game game) {
    mouse = game.mouse;
  }

  public void update() {
    mouse = game.mouse;
  }

  public void paintComponent(Graphics2D g) {
    g.setColor(Color.white);
    g.drawOval(mouse.x-5, mouse.y-5, 10, 10);
  }
}
