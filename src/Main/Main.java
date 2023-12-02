package Main;

import Entities.Misc.SunManager;
import Entities.Plants.*;
import Entities.Zombies.*;
import GUI.*;
import GameUtils.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  static final int WINDOW_SIZE_X = 800;
  static final int WINDOW_SIZE_Y = 600;

  public enum GAME_MODE {
    EMPTY_LAWN,
    LAWN_DAY,
    LAWN_NIGHT,
    POOL_DAY,
    POOL_NIGHT,
    ROOF_DAY,
    ROOF_NIGHT,
  }

  public static void main(String[] args) throws Exception {
    JFrame window = new JFrame("The zombies are cumming");
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);

    Game game = new Game(window, WINDOW_SIZE_X, WINDOW_SIZE_Y);
    Global.game=game;
    Global.mouse=game.mouse;
    Global global = new Global();
    game.add(global);
    game.start();
    game.add(new GameUI(GAME_MODE.POOL_DAY));
    game.add(new SunManager());
    
    Global.addPlant(new Sunflower(), 0, 0);
    Global.addPlant(new CherryBomb(), 1, 2);
    Global.addPlant(new Sunflower(), 5, 3);
    Global.addPlant(new TwinSunflower(), 1, 4);
    Global.addPlant(new TwinSunflower(), 2, 7);

    Global.addZombie(new NormalZombie(2));

    Global.addSeedPacket(new SeedPacket(new Sunflower()));
    Global.addSeedPacket(new SeedPacket(new TwinSunflower()));
    Global.addSeedPacket(new SeedPacket(new Sunflower()));

    for (int i = 0; i < Global.PLANT_ROWS_COUNT; ++i) {
      Global.addLawnMowers(i);
    }
  }
}
