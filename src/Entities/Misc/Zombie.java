package Entities.Misc;

import Entities.ZombieItems.Armor;
import GameUtils.Sound;
import Main.Global;
import java.awt.Image;
import java.io.File;

public abstract class Zombie extends LiveEntity {

  protected double movementSpeed = 0.01;
  protected int dps = 1;
  protected Armor armor = null;
  protected boolean isEating = false;
  private int eat_frame = 0;
  private static final File[] eat_snd = {
    new File("assets/sound/chomp0.wav"),
    new File("assets/sound/chomp1.wav"),
  };

  public enum DeathType {
    NORMAL,
    EXPLODED,
  }

  protected Zombie(
    int row,
    int health,
    Armor armor,
    double movementSpeed,
    int dps,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(row, 10, health, sprite, spriteWidth, spriteHeight, animRow);
    this.armor = armor;
    this.movementSpeed = movementSpeed;
    this.dps = dps;
    offsetOX = -50;
    offsetOY = 10;
    scale = 0.225;
  }

  @Override
  public void update() {
    super.update();

    int row = (int) Math.round(this.row);
    int col = (int) Math.round(this.col);

    // zombie moves
    if (
      col >= Global.PLANT_COLS_COUNT ||
      col < 0 ||
      Global.plants[row][col] == null ||
      !Global.plants[row][col].targetable
    ) {
      this.col -= this.movementSpeed;
      isEating = false;
      anim_speed = 1;
      eat_frame = -10;
      return;
    }

    // zombie attacks
    if (this.armor != null) {
      this.armor.health -= this.dps;
    } else {
      if (Global.plants[row][col] != null) {
        isEating = true;
        anim_speed = 0;
        Global.plants[row][col].health -= this.dps;
        if (eat_frame++ >= 45) eat_frame = 0;
        if (eat_frame == 0) Sound.play(
          eat_snd[(int) Math.round(Math.random())]
        );
      }
    }
  }

  public void kill(DeathType type) {
    this.health = 0;
  }

  public void takeDamage(int projectileDamage) {
    this.health = Math.max(0, this.health - projectileDamage);
  }
}
