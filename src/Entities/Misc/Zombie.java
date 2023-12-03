package Entities.Misc;

import Main.Global;
import javax.swing.ImageIcon;

public abstract class Zombie extends LiveEntity {

  protected double movementSpeed = 0.01;
  protected int dps = 1;
  protected Armor armor = null;

  public enum DeathType {
    NORMAL,
    EXPLODED,
  }

  protected Zombie(
    int row,
    int health,
    double movementSpeed,
    int dps,
    String spriteName,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(
      row,
      10,
      health,
      new ImageIcon("assets/zombies/" + spriteName + ".png").getImage(),
      spriteWidth,
      spriteHeight,
      animRow
    );
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
      return;
    }

    // zombie attacks
    if (this.armor != null) {
      this.armor.health -= this.dps;
    } else {
      Global.plants[row][col].health -= this.dps;
    }
  }

  public void kill(DeathType type) {
    this.health = 0;
  }
}
