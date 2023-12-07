package Entities.ZombieItems;

import java.awt.Image;

public class Weapon extends ZombieItem {

  protected Weapon(
    boolean isMetal,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(
      Integer.MAX_VALUE,
      isMetal,
      sprite,
      spriteWidth,
      spriteHeight,
      animRow
    );
  }
}
