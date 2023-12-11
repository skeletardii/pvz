package Entities.Zombies;

import Entities.ZombieItems.Armor;
import Main.Global;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ZombieBuilder {

  int row = 0;
  double col = Global.PLANT_COLS_COUNT + 2;
  int health = 181;
  Armor armor = null;
  double movementSpeed = 0.01;
  int dps = 30;
  Image sprite = new ImageIcon("assets/zombies/zombie.png").getImage();
  int spriteWidth = 961;
  int spriteHeight = 723;
  int animRow = 2;

  public ZombieBuilder setRow(int row) {
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

  public ZombieBuilder setDps(int dps) {
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
