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

    // Global.addSeedPacket(new SeedPacket(new Sunflower()));
    // Global.addSeedPacket(new SeedPacket(new Sunflower.TwinSunflower()));
    // Global.addSeedPacket(new SeedPacket(new CherryBomb()));
    // Global.addSeedPacket(new SeedPacket(new WallNut()));
    // Global.addSeedPacket(new SeedPacket(new Peashooter()));
    // Global.addSeedPacket(new SeedPacket(new PotatoMine()));
    // Global.addSeedPacket(new SeedPacket(new Chomper()));
    // Global.addSeedPacket(new SeedPacket(new Jalapeno()));
    Global.addSeedPacket(new SeedPacket(new SpikeWeed()));
    Global.addSeedPacket(new SeedPacket(new SpikeWeed.SpikeRock()));

    Global.addZombie(new NormalZombie(0));

    for (int i = 0; i < Global.PLANT_ROWS_COUNT; ++i) {
      Global.addLawnMowers(i);
    }
  }
}
