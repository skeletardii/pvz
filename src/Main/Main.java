package Main;

import Entities.Misc.SunManager;
import Entities.Plants.*;
import Entities.Plants.LawnDay.CherryBomb;
import Entities.Plants.LawnDay.GatlingPea;
import Entities.Plants.LawnDay.Peashooter;
import Entities.Plants.LawnDay.Repeater;
import Entities.Plants.LawnDay.Snowpea;
import Entities.Plants.LawnDay.WallNut;
import Entities.Plants.PoolDay.Threepeater;
import Entities.Zombies.Zombie;
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
    /*
     * Plant:  coffeebean
Sprite Width: 261 Sprite Height: 70 Sprites: 30 New Width: 7830 New Height: 70
Plant:  doomshroom
Sprite Width: 202 Sprite Height: 171 Sprites: 81 New Width: 16362 New Height: 171
Plant:  fumeshroom
Sprite Width: 151 Sprite Height: 209 Sprites: 70 New Width: 10570 New Height: 209
Plant:  garlic
Sprite Width: 147 Sprite Height: 117 Sprites: 24 New Width: 3528 New Height: 117
Plant:  garlic_1
Sprite Width: 147 Sprite Height: 117 Sprites: 24 New Width: 3528 New Height: 117
Plant:  garlic_2
Sprite Width: 147 Sprite Height: 117 Sprites: 24 New Width: 3528 New Height: 117
Plant:  gatlingpea
Sprite Width: 149 Sprite Height: 140 Sprites: 100 New Width: 14900 New Height: 140
Plant:  gloomshroom
Sprite Width: 143 Sprite Height: 155 Sprites: 72 New Width: 10296 New Height: 155
Plant:  iceshroom
Sprite Width: 115 Sprite Height: 143 Sprites: 42 New Width: 4830 New Height: 143
Plant:  kernelpult
Sprite Width: 222 Sprite Height: 167 Sprites: 80 New Width: 17760 New Height: 167
Plant:  kernelpult_butter
Sprite Width: 264 Sprite Height: 182 Sprites: 80 New Width: 21120 New Height: 182
Plant:  magnetshroom
Sprite Width: 172 Sprite Height: 161 Sprites: 132 New Width: 22704 New Height: 161
Plant:  melonpult
Sprite Width: 229 Sprite Height: 238 Sprites: 81 New Width: 18549 New Height: 238
Plant:  puffshroom
Sprite Width: 59 Sprite Height: 70 Sprites: 56 New Width: 3304 New Height: 70
Plant:  pumpkin
Sprite Width: 140 Sprite Height: 128 Sprites: 42 New Width: 5880 New Height: 128
Plant:  pumpkin_1
Sprite Width: 140 Sprite Height: 128 Sprites: 42 New Width: 5880 New Height: 128
Plant:  pumpkin_2
Sprite Width: 140 Sprite Height: 128 Sprites: 42 New Width: 5880 New Height: 128
Plant:  pumpkin_3
Sprite Width: 109 Sprite Height: 165 Sprites: 24 New Width: 2616 New Height: 165
Plant:  repeater
Sprite Width: 114 Sprite Height: 129 Sprites: 110 New Width: 12540 New Height: 129
Plant:  scaredyshroom
Sprite Width: 149 Sprite Height: 132 Sprites: 90 New Width: 13410 New Height: 132
Plant:  snowpea
Sprite Width: 134 Sprite Height: 106 Sprites: 110 New Width: 14740 New Height: 106
Plant:  spikerock
Sprite Width: 97 Sprite Height: 110 Sprites: 35 New Width: 3395 New Height: 110
Plant:  spikeweed
Sprite Width: 84 Sprite Height: 113 Sprites: 40 New Width: 3360 New Height: 113
Plant:  squash
Sprite Width: 153 Sprite Height: 162 Sprites: 81 New Width: 12393 New Height: 162
Plant:  starfruit
Sprite Width: 110 Sprite Height: 137 Sprites: 42 New Width: 4620 New Height: 137
Plant:  sunshroom
Sprite Width: 95 Sprite Height: 95 Sprites: 64 New Width: 6080 New Height: 95
Plant:  tallnut_1
Sprite Width: 138 Sprite Height: 194 Sprites: 40 New Width: 5520 New Height: 194
Plant:  tallnut_2
Sprite Width: 138 Sprite Height: 191 Sprites: 40 New Width: 5520 New Height: 191
Plant:  threepeater
Sprite Width: 139 Sprite Height: 122 Sprites: 156 New Width: 21684 New Height: 122
Plant:  torchwood
Sprite Width: 138 Sprite Height: 127 Sprites: 30 New Width: 4140 New Height: 127
Plant:  wallnut_1
Sprite Width: 169 Sprite Height: 165 Sprites: 56 New Width: 9464 New Height: 165
Plant:  wallnut_2
Sprite Width: 169 Sprite Height: 165 Sprites: 56 New Width: 9464 New Height: 165
Plant:  wintermelon
Sprite Width: 247 Sprite Height: 242 Sprites: 81 New Width: 20007 New Height: 242 
     */
    Sound.play(new File("assets/sound/bg0.wav"), -10f);

    // Global.addPlant(new CabbagePult(), 0, 0);
    Global.addSeedPacket(new SeedPacket(new CherryBomb()));
    Global.addSeedPacket(new SeedPacket(new CabbagePult()));
    Global.addSeedPacket(new SeedPacket(new WallNut()));

    Global.addSeedPacket(new SeedPacket(new Peashooter()));
    Global.addSeedPacket(new SeedPacket(new Snowpea()));
    Global.addSeedPacket(new SeedPacket(new Threepeater()));
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
