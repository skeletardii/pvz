package GUI;

import Entities.Interfaces.SunProducer;
import GameUtils.RenderObj;
import GameUtils.Updater;
import Main.Constants;
import Main.Global;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.lang.invoke.ConstantCallSite;
import java.util.Random;
import javax.swing.ImageIcon;

public class GameUI extends RenderObj implements Updater {

  private static Image sprite;

  public GameUI(Constants.GameMode mode) {
    sprite =
      new ImageIcon("assets/ui/background" + mode.ordinal() + ".jpg")
        .getImage();
    Navbar navbar = new Navbar();
    this.add(navbar);
  }

  public void paintComponent(Graphics2D g) { //228
    g.drawImage(
      sprite,
      0,
      0,
      Constants.WINDOW_SIZE_X,
      Constants.WINDOW_SIZE_Y,
      220,
      0,
      220 + 800,
      600,
      null
    );
  }

  @Override
  public void update() {

  }
}

class Navbar extends RenderObj implements Updater {

  private double initZ;
  private static final Image sprite = new ImageIcon("assets/ui/SeedBank.png")
    .getImage();

  public void paintComponent(Graphics2D g) {
    g.drawImage(sprite, 0, 0, null);
    g.setColor(Color.black);
    g.drawString("" + Global.sun, 27, 76);
  }

  @Override
  public void update() {
    if (Global.mouse.y < 80 && getZindex() != 29) {
      initZ = getZindex();
      this.setZindex(29);
    } else if (getZindex() != initZ) {
      this.setZindex(initZ);
    }
  }
}
