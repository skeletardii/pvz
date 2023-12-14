package Main;

import Entities.Misc.SunManager;
import Entities.Misc.SunSpawner;
import Entities.Plants.*;
import Entities.Plants.LawnDay.*;
import Entities.Plants.LawnNight.*;
import Entities.Plants.PoolDay.*;
import Entities.Plants.PoolNight.*;
import Entities.Plants.Roof.*;
import GUI.*;
import GameUtils.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  public static void main(String[] args) throws Exception {

    Global.init();
    Global.gameSettings = Global.loadFromFile();

    if (Global.gameSettings == null) {
      System.out.println("No game settings :(");
      return;
    }

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


    Global.sun = Global.gameSettings.startingSun;
    Global.game = game;
    Global.mouse = game.mouse;
    Global global = new Global();

    game.setPrintFPS(true);
    game.add(new GameUI(Global.gameMode));
    game.add(global);
    game.start();

    Global.init();

    game.add(new SunManager());
    game.add(new SunSpawner());

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
    plantsMap.put("TwinSunflower", new TwinSunflower());
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
    plantsMap.put("SpikeRock", new SpikeRock());
    plantsMap.put("TallNut", new TallNut());
    plantsMap.put("Jalapeno", new Jalapeno());
    plantsMap.put("Torchwood", new Torchwood());

    plantsMap.put("Pumpkin", new Pumpkin());
    plantsMap.put("CoffeeBean", new CoffeeBean());


    Sound.play(new File("assets/sound/" + Global.gameSettings.music +  ".wav"), -10f);

    if (!Global.gameSettings.noLawnmower) {
      for (int i = 0; i < Constants.PLANT_ROWS_COUNT; ++i) {
        Global.addLawnMowers(i);
      }
    }
    
    Global.addPlant(new Sunflower(), 0, 0);
    Global.addPlant(new Peashooter(), 3, 0);
    Global.addPlant(new Repeater(), 4, 0);
    Global.addPlant(new Snowpea(), 5, 0);
    Global.addPlant(new FumeShroom(), 0, 1);
    Global.addPlant(new CabbagePult(), 1, 1);
    Global.addPlant(new PotatoMine(), 2, 1);
    Global.addPlant(new Torchwood(), 4, 1);
    Global.addPlant(new Chomper(), 5, 1);
    Global.addPlant(new WallNut(), 0, 2);
    Global.addPlant(new TallNut(), 1, 2);

//    Global.addSeedPacket(new SeedPacket(new Cherrybomb()));
//    Global.addSeedPacket(new SeedPacket(new Jalapeno()));
//    Global.addSeedPacket(new SeedPacket(new WallNut()));
//    Global.addSeedPacket(new SeedPacket(new IceShroom()));
//    Global.addSeedPacket(new SeedPacket(new Squash()));
//    Global.addSeedPacket(new SeedPacket(new SpikeWeed()));
//    Global.addSeedPacket(new SeedPacket(new Pumpkin()));
//    Global.addSeedPacket(new SeedPacket(new CoffeeBean()));
//    Global.addSeedPacket(new SeedPacket(new DoomShroom()));
     Global.addSeedPacket(new SeedPacket(new Repeater()));
     Global.addSeedPacket(new SeedPacket(new GatlingPea()));

    Global.addSeedPacket(new SeedPacket(new Sunflower()));
    Global.addSeedPacket(new SeedPacket(new TwinSunflower()));

    Global.addSeedPacket(new SeedPacket(new FumeShroom()));
    Global.addSeedPacket(new SeedPacket(new GloomShroom()));
    // Global.addZombie(new NormalZombie(0));

    //game.add(new Selector(game));
  }

  private static void preload() {
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
      "Entities.Plants.Roof.CabbagePult",
      "Entities.Plants.LawnDay.Chomper",
      "Entities.Plants.LawnDay.Peashooter",
      "Entities.Plants.LawnDay.WallNut",
      "Entities.Plants.LawnDay.Sunflower",
      "Entities.Plants.LawnDay.Repeater",
      "Entities.Plants.LawnDay.GatlingPea",
      "Entities.Plants.LawnDay.Snowpea",
      "Entities.Plants.LawnDay.PotatoMine",
      "Entities.Plants.LawnDay.Cherrybomb",
      "Entities.Plants.LawnNight.FumeShroom",
      "Entities.Plants.LawnNight.DoomShroom",
      "Entities.Plants.LawnNight.IceShroom",
      "Entities.Plants.PoolDay.SpikeWeed",
      "Entities.Plants.PoolDay.Jalapeno",
      "Entities.Plants.PoolDay.Torchwood",
      "Entities.Plants.PoolDay.Threepeater",
      "Entities.Plants.PoolDay.SpikeRock",
      "Entities.Plants.PoolDay.Squash",
      "Entities.Plants.PoolDay.TallNut",
      "Entities.Plants.PoolNight.CoffeeBean",
      "Entities.Plants.PoolNight.Pumpkin",
      "GUI.SeedPacket",
      "GUI.GameUI",
      "GUI.Selector",
    };
    for (int i = 0; i < classes.length; i++) {
      double percent = 100.0 * i / classes.length;
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
