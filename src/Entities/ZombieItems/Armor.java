package Entities.ZombieItems;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Armor extends ZombieItem {

  protected boolean fumePassable;

  public Armor(
    int health,
    boolean fumePassable,
    boolean isMetal,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(health, isMetal, sprite, spriteWidth, spriteHeight, animRow);
    this.fumePassable = fumePassable;
  }

  public Armor(
    int health,
    boolean isMetal,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    this(health, false, isMetal, sprite, spriteWidth, spriteHeight, animRow);
  }

  public static class Cone extends Armor {

    public static final Image sprite = new ImageIcon(
      "assets/plants/wallnut.png"
    )
      .getImage();

    public Cone() {
      super(300, false, sprite, 509, 496, 1);
    }
  }

  public static class Bucket extends Armor {

    public static final Image sprite = new ImageIcon(
      "assets/plants/wallnut.png"
    )
      .getImage();

    public Bucket() {
      super(600, false, sprite, 509, 496, 1);
    }
  }

  public static class FootballGear extends Armor {

    public static final Image sprite = new ImageIcon(
      "assets/plants/wallnut.png"
    )
      .getImage();

    public FootballGear() {
      super(300, true, sprite, 509, 496, 1);
    }
  }

  public static class Newspaper extends Armor {

    public static final Image sprite = new ImageIcon(
      "assets/plants/wallnut.png"
    )
      .getImage();

    public Newspaper() {
      super(300, true, sprite, 509, 496, 1);
    }
  }

  public static class Screendoor extends Armor {

    public static final Image sprite = new ImageIcon(
      "assets/plants/wallnut.png"
    )
      .getImage();

    public Screendoor() {
      super(300, true, true, sprite, 509, 496, 1);
    }
  }
}
