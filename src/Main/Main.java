package Main;

import Entities.Misc.SunManager;
import Entities.Plants.CabbagePult;
import Entities.Plants.LawnDay.*;
import Entities.Plants.LawnNight.*;
import Entities.Plants.PoolDay.*;
import Entities.Plants.Roof.*;
import Entities.Plants.SunProducers.Sunflower;
import GUI.*;
import GameUtils.*;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  public static void main(String[] args) throws Exception {
    JFrame window = new JFrame("The zombies are cumming");
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setVisible(true);
    window.setResizable(true);
    Game game = new Game(
      window,
      Constants.WINDOW_SIZE_X,
      Constants.WINDOW_SIZE_Y
    );
    preload();

    Global.init();
    Global.game = game;
    Global.mouse = game.mouse;
    Global global = new Global();
    game.setPrintFPS(true);
    game.add(new GameUI(Global.gameMode));
    game.add(global);
    game.start();
    Global.init();
    game.add(new SunManager());
    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; ++i) {
      Global.addLawnMowers(i);
    }
    
    Sound.play(new File("assets/sound/bg0.wav"), -10f);

    Global.addPlant(new Sunflower(), 0, 0);
    Global.addPlant(new Sunflower.TwinSunflower(), 1, 0);
    Global.addPlant(new GatlingPea(), 2, 0);
    Global.addPlant(new Peashooter(), 3, 0);
    Global.addPlant(new Repeater(), 4, 0);
    Global.addPlant(new Snowpea(), 5, 0);
    Global.addPlant(new FumeShroom(), 0, 1);
    Global.addPlant(new CabbagePult(), 1, 1);
    Global.addPlant(new PotatoMine(), 2, 1);
    Global.addPlant(new GloomShroom(), 3, 1);
    Global.addPlant(new Torchwood(), 4, 1);
    Global.addPlant(new Chomper(), 5, 1);
    Global.addPlant(new WallNut(), 0, 2);
    Global.addPlant(new TallNut(), 1, 2);
    Global.addSeedPacket(new SeedPacket(new CherryBomb()));
    Global.addSeedPacket(new SeedPacket(new Jalapeno()));
    Global.addSeedPacket(new SeedPacket(new WallNut()));
    Global.addSeedPacket(new SeedPacket(new IceShroom()));
    Global.addSeedPacket(new SeedPacket(new Squash()));
    Global.addSeedPacket(new SeedPacket(new SpikeWeed()));
    Global.addSeedPacket(new SeedPacket(new Pumpkin()));
    Global.addSeedPacket(new SeedPacket(new CoffeeBean()));
    Global.addSeedPacket(new SeedPacket(new DoomShroom()));
    // Global.addSeedPacket(new SeedPacket(new Repeater()));
    // Global.addSeedPacket(new SeedPacket(new GatlingPea()));
    // Global.addZombie(new NormalZombie(0));
    //game.add(new Selector(game));
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
