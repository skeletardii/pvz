package Main;

import Entities.Misc.*;
import Entities.Plants.*;
import GUI.*;
import GameUtils.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  static final int WINDOW_SIZE_X = 800;
  static final int WINDOW_SIZE_Y = 600;

  public enum GAME_MODE {
    EMPTY_LAWN,
    DAY,
    NIGHT,
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

    game.start();
    game.add(new GameUI(GAME_MODE.POOL_DAY));
    game.add(new Sunflower(1, 1));
    game.add(new Sunflower(1, 2));
    game.add(new Sunflower(5, 3));
    game.add(new TwinSunflower(1, 4));
    game.add(new TwinSunflower(2, 5));
  }
}
