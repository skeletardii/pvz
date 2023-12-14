package Entities.Plants;

import java.awt.Image;
import javax.swing.ImageIcon;

public class PlantBuilder {

  protected double row = 0;
  protected double col = 0;
  protected int sunCost = 100;
  protected int health = 100;
  protected double packetCooldown = 7.5;
  protected Image sprite = new ImageIcon("assets/plants/peashooter.png")
    .getImage();
  protected int spriteWidth = 0;
  protected int spriteHeight = 0;
  protected int animRow = 1;

  public PlantBuilder setRow(double row) {
    this.row = row;
    return this;
  }

  public PlantBuilder setCol(double col) {
    this.col = col;
    return this;
  }

  public PlantBuilder setSunCost(int sunCost) {
    this.sunCost = sunCost;
    return this;
  }

  public PlantBuilder setHealth(int health) {
    this.health = health;
    return this;
  }

  public PlantBuilder setPacketCooldown(double packetCooldown) {
    this.packetCooldown = packetCooldown;
    return this;
  }

  public PlantBuilder setSprite(Image sprite) {
    this.sprite = sprite;
    return this;
  }

  public PlantBuilder setSpriteWidth(int spriteWidth) {
    this.spriteWidth = spriteWidth;
    return this;
  }

  public PlantBuilder setSpriteHeight(int spriteHeight) {
    this.spriteHeight = spriteHeight;
    return this;
  }

  public PlantBuilder setAnimRow(int animRow) {
    this.animRow = animRow;
    return this;
  }

  public Plant build() {
    return new Plant(this);
  }
}
