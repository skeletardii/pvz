package Entities.Misc;

import java.awt.Image;
import javax.swing.ImageIcon;

public class LiveEntityBuilder {

  int row;
  double col;
  int health;
  boolean targetable = true;
  int offsetX;
  int offsetY;
  Image sprite;
  int lx, ly, frame;
  double scale = 0.25;
  int[] animStart;
  int[] animEnd;
  Image shadow = new ImageIcon("assets/ui/shadow.png").getImage();
  int offsetOY = (int) Math.random() * 10;
  int offsetOX = (int) Math.random() * 10;
  int shadowOffsetX = 0;
  int shadowOffsetY = 0;
  double shadowScale = 1.0;
  int animSpeed = 1;

  public void setRow(int row) {
    this.row = row;
  }

  public void setCol(double col) {
    this.col = col;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setTargetable(boolean targetable) {
    this.targetable = targetable;
  }

  public void setOffsetX(int offsetX) {
    this.offsetX = offsetX;
  }

  public void setOffsetY(int offsetY) {
    this.offsetY = offsetY;
  }

  public void setSprite(Image sprite) {
    this.sprite = sprite;
  }

  public void setLx(int lx) {
    this.lx = lx;
  }

  public void setLy(int ly) {
    this.ly = ly;
  }

  public void setFrame(int frame) {
    this.frame = frame;
  }

  public void setScale(double scale) {
    this.scale = scale;
  }

  public void setAnimStart(int[] animStart) {
    this.animStart = animStart;
  }

  public void setAnimEnd(int[] animEnd) {
    this.animEnd = animEnd;
  }

  public void setShadow(Image shadow) {
    this.shadow = shadow;
  }

  public void setOffsetOY(int offsetOY) {
    this.offsetOY = offsetOY;
  }

  public void setOffsetOX(int offsetOX) {
    this.offsetOX = offsetOX;
  }

  public void setShadowOffsetX(int shadowOffsetX) {
    this.shadowOffsetX = shadowOffsetX;
  }

  public void setShadowOffsetY(int shadowOffsetY) {
    this.shadowOffsetY = shadowOffsetY;
  }

  public void setShadowScale(double shadowScale) {
    this.shadowScale = shadowScale;
  }

  public void setAnimSpeed(int animSpeed) {
    this.animSpeed = animSpeed;
  }
}
