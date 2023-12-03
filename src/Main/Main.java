package Main;

import Entities.Misc.SunManager;
import Entities.Plants.Chomper;
import Entities.Plants.InstaKillers.CherryBomb;
import Entities.Plants.InstaKillers.Jalapeno;
import Entities.Plants.InstaKillers.PotatoMine;
import Entities.Plants.SunProducers.Sunflower;
import Entities.Plants.SunProducers.Sunflower.TwinSunflower;
import Entities.Plants.WallNut;
import Entities.Zombies.NormalZombie;
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
    // window.setResizable(false);
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
    Global.addSeedPacket(new SeedPacket(new WallNut.TallNut()));
    Global.addSeedPacket(new SeedPacket(new PotatoMine()));
    Global.addSeedPacket(new SeedPacket(new Chomper()));
    Global.addSeedPacket(new SeedPacket(new Jalapeno()));

    Global.addZombie(new NormalZombie(0));

    for (int i = 0; i < Global.PLANT_ROWS_COUNT; ++i) {
      Global.addLawnMowers(i);
    }
  }
}
