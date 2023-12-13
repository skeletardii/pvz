package Main;

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
}
