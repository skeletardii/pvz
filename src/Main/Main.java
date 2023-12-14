package Main;

import Entities.Misc.SunManager;
import Entities.Plants.*;
import Entities.Plants.LawnDay.*;
import Entities.Plants.LawnNight.DoomShroom;
import Entities.Plants.LawnNight.FumeShroom;
import Entities.Plants.LawnNight.GloomShroom;
import Entities.Plants.LawnNight.IceShroom;
import Entities.Plants.LawnNight.Shroom;
import Entities.Plants.PoolDay.*;
import Entities.Plants.PoolNight.CoffeeBean;
import Entities.Plants.PoolNight.Pumpkin;
import Entities.Plants.Roof.CabbagePult;
import Entities.Projectiles.Pea;
import Entities.Zombies.*;
import GUI.*;
import GameUtils.*;
import LevelEditor.GameSettings;
import LevelEditor.PVZLevelEditor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
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

//    Map<String, Zombie> zombiesMap = new HashMap<>();
//    zombiesMap.put("Zombie", new Zombie());
//    zombiesMap.put("ConeheadZombie", new ConeheadZombie());
//    zombiesMap.put("BucketheadZombie", new BucketheadZombie());
//    zombiesMap.put("FootballZombie", new FootballZombie());
//    zombiesMap.put("PoleVaultingZombie", new PoleVaultingZombie());
//    zombiesMap.put("NewspaperZombie", cbNewspaperZombie);
//    zombiesMap.put("PogoZombie", cbPogoZombie);
//    zombiesMap.put("ScreendoorZombie", cbScreendoorZombie);
//    zombiesMap.put("GargantuarZombie", cbGargantuar);
//    zombiesMap.put("BungeeZombie", cbBungeeZombie);

    Map<String, Plant> plantsMap = new HashMap<>();

    plantsMap.put("Sunflower", new Sunflower());
    plantsMap.put("Peashooter", new Peashooter());
    plantsMap.put("Repeater", new Repeater());
    plantsMap.put("GatlingPea", new GatlingPea());
    plantsMap.put("PotatoMine", new PotatoMine());
    plantsMap.put("Cherrybomb", new Cherrybomb());
    plantsMap.put("WallNut", new WallNut());
    plantsMap.put("Chomper", new Chomper());
    plantsMap.put("Snowpea", new Snowpea());

    plantsMap.put("FumeShroom", new FumeShroom());
    plantsMap.put("GloomShroom", new GloomShroom());
    plantsMap.put("IceShroom", new IceShroom());
    plantsMap.put("DoomShroom", new DoomShroom());

    plantsMap.put("Threepeater", new Threepeater());
    plantsMap.put("Squash", new Squash());
    plantsMap.put("SpikeWeed", new SpikeWeed());
    plantsMap.put("SpikeRock", new SpikeWeed.SpikeRock());
    plantsMap.put("TallNut", new TallNut());
    plantsMap.put("Jalapeno", new Jalapeno());
    plantsMap.put("Torchwood", new Torchwood());

    plantsMap.put("Pumpkin", new Pumpkin());
    plantsMap.put("CoffeeBean", new CoffeeBean());

    Global.gameSettings = Global.loadFromFile("./data/settings.ser");

      assert Global.gameSettings != null;
      Sound.play(new File("assets/sound/" + Global.gameSettings.music +  ".wav"), -10f);

    for (String p : Global.gameSettings.selectedPlants) {
      Global.addSeedPacket(new SeedPacket(plantsMap.get(p)));
    }

//    Global.addSeedPacket(new SeedPacket(new Cherrybomb()));
//    Global.addSeedPacket(new SeedPacket(new WallNut()));

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
