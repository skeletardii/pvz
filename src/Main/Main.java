package Main;

import Entities.Misc.SunManager;
import Entities.Misc.SunSpawner;
import Entities.Misc.ZombieSpawner;
import GUI.*;
import GameUtils.*;
import Main.Constants;
import java.io.File;
import javax.swing.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Global.init();
    new Constants();
    Global.gameSettings = Global.loadFromFile();

    if (Global.gameSettings == null) {
      System.out.println("No game settings :(");
      return;
    }

    JFrame window = new JFrame("The zombies are coming (sfw)");
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
    game.add(new SunManager());
    game.add(new SunSpawner());
    ZombieSpawner zombieSpawner = new ZombieSpawner();
    game.add(zombieSpawner);
    Global.zombieSpawner = zombieSpawner;
    zombieSpawner.init();

    if (!Global.gameSettings.noLawnmower) {
      for (int i = 0; i < Constants.PLANT_ROWS_COUNT; ++i) {
        Global.addLawnMowers(i);
      }
    }

    for (String s : Global.gameSettings.selectedPlants) {
      Global.addSeedPacket(new SeedPacket(Constants.plantsMap.get(s)));
    }

    game.start();

    Sound.play(
      new File("assets/sound/" + Global.gameSettings.music + ".wav"),
      -10f
    );

    Sound.play(
      new File("assets/sound/readysetplant.wav"),
      0f
    );
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
