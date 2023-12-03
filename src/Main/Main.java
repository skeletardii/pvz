package Main;

import Entities.Misc.SunManager;
import Entities.Plants.*;
import Entities.Plants.InstaKillers.*;
import Entities.Plants.SunProducers.*;
import Entities.Zombies.*;
import GUI.*;
import GameUtils.*;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  static final int WINDOW_SIZE_X = 800;
  static final int WINDOW_SIZE_Y = 600;

  public static void main(String[] args) throws Exception {
    preload();
    JFrame window = new JFrame("The zombies are cumming");
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setVisible(true);
    window.setResizable(false);
    Game game = new Game(window, WINDOW_SIZE_X, WINDOW_SIZE_Y);
    Global.game = game;
    Global.mouse = game.mouse;
    Global global = new Global();
    game.add(global);
    game.start();
    game.add(new GameUI(Global.gameMode));
    Global.init();
    game.add(new SunManager());

    Sound.play(new File("assets/sound/bg0.wav"), -10f);

    Global.addPlant(new Sunflower(), 0, 0);
    Global.addPlant(new Sunflower.TwinSunflower(), 1, 4);

    Global.addSeedPacket(new SeedPacket(new Sunflower()));
    Global.addSeedPacket(new SeedPacket(new Sunflower.TwinSunflower()));
    Global.addSeedPacket(new SeedPacket(new CherryBomb()));
    Global.addSeedPacket(new SeedPacket(new WallNut()));
    Global.addSeedPacket(new SeedPacket(new Peashooter()));
    Global.addSeedPacket(new SeedPacket(new PotatoMine()));
    Global.addSeedPacket(new SeedPacket(new Chomper()));
    Global.addSeedPacket(new SeedPacket(new Jalapeno()));

    Global.addZombie(new NormalZombie(0));

    for (int i = 0; i < Global.PLANT_ROWS_COUNT; ++i) {
      Global.addLawnMowers(i);
    }
  }
  private static void preload(){
    String[] classes = {
      "Main.Global",
      "GameUtils.Game",
      "GameUtils.Mouse",
      "GameUtils.RenderObj",
      "GameUtils.Updater",
      "GameUtils.Sound",
      "Entities.Misc.LiveEntity",
      "Entities.Misc.Plant",
      "Entities.Misc.Zombie",
      "Entities.Misc.LawnMower",
      "Entities.Misc.Sun",
      "Entities.Zombies.NormalZombie",
      "Entities.Plants.Cabbage",
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
      "GUI.Selector"
    };
    for(String c : classes){
      try{
        Class.forName(c);
      } catch (Exception e){
        e.printStackTrace();
      }
    }
  }
}
