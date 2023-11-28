package GUI;

import GameUtils.RenderObj;
import GameUtils.Updater;
import Main.Main.GAME_MODE;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GameUI extends RenderObj implements Updater {

  private static Image sprite;

  public GameUI(GAME_MODE mode) {
    sprite =
      new ImageIcon("assets/ui/background" + mode.ordinal() + ".jpg")
        .getImage();
  }

  public void update() {}

  public void paintComponent(Graphics2D g) { //228
    g.drawImage(sprite, 0, 0, 800, 600, 220, 0, 220 + 800, 600, null);
  }
}
