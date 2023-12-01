

package Entities.Misc;

import javax.swing.ImageIcon;

public abstract class Zombie extends LiveEntity {

  protected final double movementSpeed;
  protected final int attackSpeed;

  protected int movementCtr = 0;
  protected int attackSpeedCtr = 0;

  public Zombie(
    int row,
    int health,
    double movementSpeed,
    int attackSpeed,
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
    this.attackSpeed  = attackSpeed;
  }

  public void update() {
    this.col -=movementSpeed;
  }

}
