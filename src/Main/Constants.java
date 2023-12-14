package Main;

import Entities.Plants.LawnDay.*;
import Entities.Plants.LawnNight.DoomShroom;
import Entities.Plants.LawnNight.FumeShroom;
import Entities.Plants.LawnNight.GloomShroom;
import Entities.Plants.LawnNight.IceShroom;
import Entities.Plants.Plant;
import Entities.Plants.PoolDay.*;
import Entities.Plants.PoolNight.CoffeeBean;
import Entities.Plants.PoolNight.Pumpkin;
import Entities.Zombies.*;

import java.util.HashMap;
import java.util.Map;

public class Constants {

  public static final int WINDOW_SIZE_X = 800;
  public static final int WINDOW_SIZE_Y = 600;

  public enum GameMode {
    LAWN_EMPTY,
    LAWN_DAY,
    LAWN_NIGHT,
    POOL_DAY,
    POOL_NIGHT,
    ROOF_DAY,
    ROOF_NIGHT,
    LAKE_DAY,
  }

  public static final int PLANT_ROWS_COUNT = 6;
  public static final int PLANT_COLS_COUNT = 9;
  public static final int ROW_PIXEL_OFFSET = 84;
  public static final int COL_PIXEL_OFFSET = 80;
  public static final int GRID_OFFSET_X = 80;
  public static final int GRID_OFFSET_Y = 174;

  public static Map<String, Plant> plantsMap;
  public static Map<String, Zombie> zombiesMap;

  public Constants() {
    zombiesMap = new HashMap<>();

    zombiesMap.put("Zombie", new Zombie());
    zombiesMap.put("ConeheadZombie", new ConeheadZombie());
    zombiesMap.put("BucketheadZombie", new BucketheadZombie());
    zombiesMap.put("FootballZombie", new FootballZombie());
    zombiesMap.put("PoleVaultingZombie", new PoleVaultingZombie());
    zombiesMap.put("NewspaperZombie", new NewspaperZombie());
    zombiesMap.put("PogoZombie", new PogoZombie());
    zombiesMap.put("ScreendoorZombie", new ScreendoorZombie());
    zombiesMap.put("Gargantuar", new Gargantuar());
    zombiesMap.put("BungeeZombie", new BungeeZombie());

    plantsMap = new HashMap<>();

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
  }
}
