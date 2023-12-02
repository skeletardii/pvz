package GUI;

import Entities.Interfaces.SunProducer;
import GameUtils.RenderObj;
import GameUtils.Updater;
import Main.Global;
import Main.Main.GAME_MODE;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class GameUI extends RenderObj implements Updater, SunProducer {

  private static Image sprite;
  private Random rand = new Random();
  private int sunCooldown = 200;
  private int sunCtr = 0;
  
  public GameUI(GAME_MODE mode) {
    sprite =
      new ImageIcon("assets/ui/background" + mode.ordinal() + ".jpg")
        .getImage();
    Navbar navbar = new Navbar();
    this.add(navbar);
  }

  // sakto raba na naa ni diri?
  public void update() {
    sunCtr++;

    if (sunCtr >= sunCooldown) {
      sunCtr = 0;
      double spawnRow = rand.nextDouble(Global.PLANT_ROWS_COUNT);
      double spawnColumn = rand.nextDouble(Global.PLANT_COLS_COUNT);
      Global.game.add(produceSunGrid(25, spawnRow, spawnColumn, 120));
    }
  }

  public void paintComponent(Graphics2D g) { //228
    g.drawImage(sprite, 0, 0, 800, 600, 220, 0, 220 + 800, 600, null);
  }
}

class Navbar extends RenderObj implements Updater {

  private static final Image sprite = new ImageIcon("assets/ui/SeedBank.png")
    .getImage();

  public void paintComponent(Graphics2D g) {
    g.drawImage(sprite, 0, 0, null);
    g.setColor(Color.black);
    g.drawString("" + Global.sun, 27, 76);
  }

  @Override
  public void update() {}
}
