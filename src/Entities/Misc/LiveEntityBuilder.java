package Entities.Misc;

import java.awt.Image;

public class LiveEntityBuilder {

  public double row;
  public double col;
  public int health;
  public boolean targetable = true;
  public int offsetX;
  public int offsetY;
  public Image sprite;
  public int lx, ly, frame;
  public double scale = 0.25 * 3;
  public int[] animStart;
  public int[] animEnd;
  public int offsetOY = (int) Math.random() * 10 - 5;
  public int offsetOX = (int) Math.random() * 10 - 5;
  public int shadowOffsetX = 0;
  public int shadowOffsetY = 0;
  public double shadowScale = 1.0;
  public int animSpeed = 1;
  public int animRow = 1;
  public int spriteWidth;
  public int spriteHeight;

  public LiveEntityBuilder setSpriteWidth(int spriteWidth) {
    this.spriteWidth = spriteWidth;
    return this;
  }

  public LiveEntityBuilder setSpriteHeight(int spriteHeight) {
    this.spriteHeight = spriteHeight;
    return this;
  }

  public LiveEntityBuilder setAnimRow(int animRow) {
    this.animRow = animRow;
    return this;
  }

  public LiveEntityBuilder setRow(double row) {
    this.row = row;
    return this;
  }

  public LiveEntityBuilder setCol(double col) {
    this.col = col;
    return this;
  }

  public LiveEntityBuilder setHealth(int health) {
    this.health = health;
    return this;
  }

  public LiveEntityBuilder setTargetable(boolean targetable) {
    this.targetable = targetable;
    return this;
  }

  public LiveEntityBuilder setOffsetX(int offsetX) {
    this.offsetX = offsetX;
    return this;
  }

  public LiveEntityBuilder setOffsetY(int offsetY) {
    this.offsetY = offsetY;
    return this;
  }

  public LiveEntityBuilder setSprite(Image sprite) {
    this.sprite = sprite;
    return this;
  }

  public LiveEntityBuilder setLx(int lx) {
    this.lx = lx;
    return this;
  }

  public LiveEntityBuilder setLy(int ly) {
    this.ly = ly;
    return this;
  }

  public LiveEntityBuilder setFrame(int frame) {
    this.frame = frame;
    return this;
  }

  public LiveEntityBuilder setScale(double scale) {
    this.scale = scale;
    return this;
  }

  public LiveEntityBuilder setAnimStart(int[] animStart) {
    this.animStart = animStart;
    return this;
  }

  public LiveEntityBuilder setAnimEnd(int[] animEnd) {
    this.animEnd = animEnd;
    return this;
  }

  public LiveEntityBuilder setOffsetOY(int offsetOY) {
    this.offsetOY = offsetOY;
    return this;
  }

  public LiveEntityBuilder setOffsetOX(int offsetOX) {
    this.offsetOX = offsetOX;
    return this;
  }

  public LiveEntityBuilder setShadowOffsetX(int shadowOffsetX) {
    this.shadowOffsetX = shadowOffsetX;
    return this;
  }

  public LiveEntityBuilder setShadowOffsetY(int shadowOffsetY) {
    this.shadowOffsetY = shadowOffsetY;
    return this;
  }

  public LiveEntityBuilder setShadowScale(double shadowScale) {
    this.shadowScale = shadowScale;
    return this;
  }

  public LiveEntityBuilder setAnimSpeed(int animSpeed) {
    this.animSpeed = animSpeed;
    return this;
  }
}
