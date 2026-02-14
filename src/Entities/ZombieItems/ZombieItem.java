package Entities.ZombieItems;

import Entities.Misc.LiveEntity;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class ZombieItem extends LiveEntity {

  private boolean isMetal = false;

  public boolean isMetal() {
    return isMetal;
  }

  public void setMetal(boolean isMetal) {
    this.isMetal = isMetal;
  }

  // fuck maypa mag builder ani da

  // main constructor
  protected ZombieItem(
    int health,
    boolean isMetal,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(-1, -1, health, sprite, spriteWidth, spriteHeight, animRow);
    this.isMetal = isMetal;
    this.setVisible(false);
  }

  // maybe other constructors

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
