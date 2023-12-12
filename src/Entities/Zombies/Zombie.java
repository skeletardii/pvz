package Entities.Zombies;

import Entities.Misc.LiveEntity;
import Entities.Misc.LiveEntityBuilder;
import Entities.Plants.Plant;
import Entities.ZombieItems.Armor;
import GameUtils.Game;
import GameUtils.Sound;
import Main.Global;
import java.awt.Graphics2D;
import java.io.File;

public class Zombie extends LiveEntity {

  protected Armor armor;
  protected double movementSpeed;
  protected int dps;

  private int eatFrame = 0;
  private boolean isEating = false;

  private static final File[] eat_snd = {
    new File("assets/sound/chomp0.wav"),
    new File("assets/sound/chomp1.wav"),
  };

  public enum DeathType {
    NORMAL,
    EXPLODED,
  }

  public enum ZombieSpeed {
    VERY_SLOW(0.1),
    SLOW(0.2),
    NORMAL(0.3),
    FAST(0.4),
    VERY_FAST(0.5);

    private final double value;

    ZombieSpeed(double value) {
      this.value = value;
    }

    public double getValue() {
      return value / Game.TARGET_FPS;
    }
  }

  protected Zombie() {
    this(new ZombieBuilder());
  }

  public Zombie(int row) {
    this(new ZombieBuilder().setRow(row));
  }

  protected Zombie(ZombieBuilder zBuilder) {
    super(
      new LiveEntityBuilder()
        .setRow(zBuilder.row)
        .setCol(zBuilder.col)
        .setHealth(zBuilder.health)
        .setSprite(zBuilder.sprite)
        .setSpriteWidth(zBuilder.spriteWidth)
        .setSpriteHeight(zBuilder.spriteHeight)
        .setAnimRow(zBuilder.animRow)
        .setTargetable(zBuilder.targetable)
    );
    this.armor = zBuilder.armor;
    this.movementSpeed = zBuilder.movementSpeed;
    this.dps = zBuilder.dps;

    this.offsetOX = -50;
    this.offsetOY = 10;
    this.scale = 0.225;

    animStart[0] = 0;
    animEnd[0] = 98;
    animStart[1] = 99;
    animEnd[1] = 138;
  }

  @Override
  public void update() {
    super.update();

    int row = (int) this.getRow();
    int col = (int) Math.round(this.getCol());
    Plant p = row < Global.PLANT_ROWS_COUNT && col < Global.PLANT_COLS_COUNT
      ? Global.plants[row][col]
      : null;

    // zombie attacks
    if (
      isTargetable() &&
      row >= 0 &&
      col >= 0 &&
      p != null &&
      p.isTargetable() &&
      !p.hasLadder()
    ) {
      isEating = true;
      animSpeed = 0;
      p.takeDamage(this.dps);
      if (eatFrame++ >= 45) eatFrame = 0;
      if (eatFrame == 0) Sound.play(eat_snd[(int) Math.round(Math.random())]);
      return;
    }

    // zombie moves
    this.moveCol(-this.movementSpeed);

    // if (p != null) {
    //   double high = -(0.5 - this.getCol() + col);
    //   this.moveRow(high);
    // }

    isEating = false;
    animSpeed = 1;
    eatFrame = -10;
  }

  public void kill(DeathType type) {
    setHealth(0);
  }

  @Override
  public void takeDamage(int projectileDamage) {
    if (this.armor != null) {
      this.armor.setHealth(Math.max(0, getHealth() - projectileDamage));
    } else {
      setHealth(Math.max(0, getHealth() - projectileDamage));
    }
  }

  public void removeArmor() {
    armor = null;
  }

  public double getMovementSpeed() {
    return movementSpeed;
  }

  public void setMovementSpeed(double movementSpeed) {
    this.movementSpeed = movementSpeed;
  }

  public boolean isEating() {
    return isEating;
  }

  public void setEating(boolean isEating) {
    this.isEating = isEating;
  }

  @Override
  public void paintComponent(Graphics2D g) {
    if (isEating) renderSprite(g, 1); else renderSprite(g, 0);
  }
}
