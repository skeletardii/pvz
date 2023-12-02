package Entities.Misc;

import Main.Global;
import javax.swing.ImageIcon;

public abstract class Zombie extends LiveEntity {

  protected double movementSpeed = 0.01;
  protected int dps = 1;
  protected Armor armor = null;

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
      new ImageIcon("assets/plants/" + spriteName + ".png").getImage(),
      spriteWidth,
      spriteHeight,
      animRow
    );
    this.movementSpeed = movementSpeed;
    this.dps = dps;
  }

  @Override
  public void update() {
    super.update();

    int col = (int) Math.round(this.col);

    // zombie moves
    if (
      col >= Global.PLANT_COLS_COUNT ||
      col < 0 ||
      Global.plants[row][col] == null
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
}
