package Main;

import Entities.Misc.SunManager;
import Entities.Plants.*;
import Entities.Plants.InstaKillers.*;
import Entities.Zombies.Zombie;
import GUI.*;
import GameUtils.*;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  static final int WINDOW_SIZE_X = 800;
  static final int WINDOW_SIZE_Y = 600;

  public static void main(String[] args) throws Exception {
    JFrame window = new JFrame("The zombies are cumming");
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setVisible(true);
    window.setResizable(true);
    Game game = new Game(window, WINDOW_SIZE_X, WINDOW_SIZE_Y);
    preload();

    Global.init();
    Global.game = game;
    Global.mouse = game.mouse;
    Global global = new Global();
    game.add(global);
    game.start();
    game.add(new GameUI(Global.gameMode));
    Global.init();
    game.add(new SunManager());
    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; ++i) {
      Global.addLawnMowers(i);
    }

    Sound.play(new File("assets/sound/bg0.wav"), -10f);

    // Global.addPlant(new CabbagePult(), 0, 0);
    Global.addSeedPacket(new SeedPacket(new CherryBomb()));
    Global.addSeedPacket(new SeedPacket(new CabbagePult()));
    Global.addSeedPacket(new SeedPacket(new WallNut()));

    Global.addSeedPacket(new SeedPacket(new Peashooter()));
    Global.addSeedPacket(new SeedPacket(new Repeater()));
    Global.addSeedPacket(new SeedPacket(new GatlingPea()));

    // Global.addZombie(new Zombie(0));
    // Global.addZombie(new Zombie(0));
    // Global.addZombie(new Zombie(0));
    // Global.addZombie(new Zombie(0));
    // Global.addZombie(new Zombie(0));
    // Global.addZombie(new Zombie(0));
    // Global.addZombie(new Zombie(0));
    // Global.addZombie(new Zombie(0));
    // Global.addZombie(new Zombie(0));

    // Global.addPlant(new Peashooter(), 0, 1);
    // Global.addPlant(new Peashooter(), 0, 2);
    // Global.addPlant(new Peashooter(), 0, 3);
    // Global.addPlant(new Peashooter(), 1, 1);
    // Global.addPlant(new Peashooter(), 1, 2);
    // Global.addPlant(new Peashooter(), 1, 3);

    game.add(new Selector(game));
    // Global.saveToFile("./testing.ser");

    System.out.println(Global.plants[0][1]);
  }

  private static void preload() {
    double percent = 0;
    String[] classes = {
      "Main.Global",
      "GameUtils.Game",
      "GameUtils.Mouse",
      "GameUtils.RenderObj",
      "GameUtils.Updater",
      "GameUtils.Sound",
      "Entities.Misc.LiveEntity",
      "Entities.Plants.Plant",
      "Entities.Misc.LawnMower",
      "Entities.Misc.Sun",
      "Entities.Zombies.Zombie",
      "Entities.Zombies.ZombieBuilder",
      "Entities.Particles.Explosion",
      "Entities.Plants.PlantBuilder",
      "Entities.Plants.CabbagePult",
      "Entities.Plants.Chomper",
      "Entities.Plants.Peashooter",
      "Entities.Plants.SpikeWeed",
      "Entities.Plants.WallNut",
      "Entities.Plants.SunProducers.Sunflower",
      "Entities.Plants.InstaKillers.CherryBomb",
      "Entities.Plants.InstaKillers.Jalapeno",
      "Entities.Plants.InstaKillers.PotatoMine",
      "Entities.Plants.InstaKillers.Squash",
      "GUI.SeedPacket",
      "GUI.GameUI",
      "GUI.Selector",
    };
    for (int i = 0; i < classes.length; i++) {
      percent = 100.0 * i / classes.length;
      System.out.println("Loading: " + percent + "%");
      try {
        Class.forName(classes[i]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    System.out.println("Loading: " + 100 + "%");
  }
}
