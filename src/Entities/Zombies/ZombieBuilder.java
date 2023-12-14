package Entities.Zombies;

import Entities.ZombieItems.Armor;
import Entities.Zombies.Zombie.ZombieSpeed;
import Main.Constants;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ZombieBuilder {

  double row = 0;
  double col = Constants.PLANT_COLS_COUNT + 2.0;
  int health = 181;
  Armor armor = null;
  double movementSpeed = ZombieSpeed.NORMAL.getValue();
  double dps = 100;
  Image sprite = new ImageIcon("assets/zombies/zombie.png").getImage();
  // int spriteWidth = 961;
  // int spriteHeight = 723;
  int spriteWidth = 961/3;
  int spriteHeight = 723/3;
  int animRow = 2;
  boolean targetable = true;

  public ZombieBuilder setTargetable(boolean targetable) {
    this.targetable = targetable;
    return this;
  }

  public ZombieBuilder setRow(double row) {
    this.row = row;
    return this;
  }

  public ZombieBuilder setCol(double col) {
    this.col = col;
    return this;
  }

  public ZombieBuilder setHealth(int health) {
    this.health = health;
    return this;
  }

  public ZombieBuilder setArmor(Armor armor) {
    this.armor = armor;
    return this;
  }

  public ZombieBuilder setMovementSpeed(double movementSpeed) {
    this.movementSpeed = movementSpeed;
    return this;
  }

  public ZombieBuilder setDps(double dps) {
    this.dps = dps;
    return this;
  }

  public ZombieBuilder setSprite(Image sprite) {
    this.sprite = sprite;
    return this;
  }

  public ZombieBuilder setSpriteWidth(int spriteWidth) {
    this.spriteWidth = spriteWidth;
    return this;
  }

  public ZombieBuilder setSpriteHeight(int spriteHeight) {
    this.spriteHeight = spriteHeight;
    return this;
  }

  public ZombieBuilder setAnimRow(int animRow) {
    this.animRow = animRow;
    return this;
  }

  public Zombie build() {
    return new Zombie(this);
  }
}
