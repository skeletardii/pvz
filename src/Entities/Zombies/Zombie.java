package Entities.Zombies;

import Entities.Misc.LiveEntity;
import Entities.ZombieItems.Armor;
import GameUtils.Sound;
import Main.Global;
import java.awt.Graphics2D;
import java.io.File;

public class Zombie extends LiveEntity {

  protected Armor armor = null;
  protected double movementSpeed = 0.01;
  protected int dps = 1;

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

  protected Zombie() {
    this(new ZombieBuilder());
  }

  public Zombie(int row) {
    this(new ZombieBuilder().setRow(row));
  }

  protected Zombie(ZombieBuilder zBuilder) {
    super(
      zBuilder.row,
      zBuilder.col,
      zBuilder.health,
      zBuilder.sprite,
      zBuilder.spriteWidth,
      zBuilder.spriteHeight,
      zBuilder.animRow
    );
    this.armor = zBuilder.armor;
    this.movementSpeed = zBuilder.movementSpeed;
    this.dps = zBuilder.dps;

    this.offsetOX = -50;
    this.offsetOY = 10;
    this.scale = 0.225;

    anim_start[0] = 0;
    anim_end[0] = 98;
    anim_start[1] = 99;
    anim_end[1] = 138;
  }

  @Override
  public void update() {
    super.update();

    int row = this.getRow();
    int col = (int) Math.round(this.getCol());

    if (
      col >= Global.PLANT_COLS_COUNT ||
      col < 0 ||
      Global.plants[row][col] == null ||
      !Global.plants[row][col].isTargetable()
    ) {
      this.moveCol(-this.movementSpeed);
      isEating = false;
      anim_speed = 1;
      eatFrame = -10;
      return;
    }

    // zombie attacks
    if (this.armor != null) {
      this.takeDamage(row);
    } else {
      if (Global.plants[row][col] != null) {
        isEating = true;
        anim_speed = 0;
        Global.plants[row][col].takeDamage(this.dps);
        if (eatFrame++ >= 45) eatFrame = 0;
        if (eatFrame == 0) Sound.play(eat_snd[(int) Math.round(Math.random())]);
      }
    }
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
