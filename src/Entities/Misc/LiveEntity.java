package Entities.Misc;

import GameUtils.RenderObj;
import GameUtils.Updater;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class LiveEntity extends RenderObj implements Updater {

  protected int row;
  protected double col;
  protected int health;
  protected final int offsetX;
  protected final int offsetY;
  protected boolean targetable = false;
  protected Image sprite;
  protected int lx, ly, frame, frameCtr = 0;
  protected final double scale = 0.25;
  public int[] anim_start;
  public int[] anim_end;

  protected LiveEntity(
    int row,
    double col,
    int health,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    this.row = row;
    this.col = col;
    this.health = health;
    this.sprite = sprite;

    offsetX = (int) (Math.random() * 10);
    offsetY = (int) (Math.random() * 10);
    lx = spriteWidth;
    ly = spriteHeight;
    anim_start = new int[animRow];
    anim_end = new int[animRow];
  }

  protected LiveEntity(
    int row,
    double col,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    this(
      row,
      col,
      Integer.MAX_VALUE,
      sprite,
      spriteWidth,
      spriteHeight,
      animRow
    );
  }

  // rough function implementation
  public boolean isTouching(LiveEntity e) {
    return this.col >= e.col && this.col - 1 <= e.col;
  }

  public void setFrame(int frame) {
    this.frame = frame;
  }

  public void setFrame(int frame, int anim) {
    this.frame = frame + anim_start[anim];
  }

  public void setRow(int row) {
    this.row = row;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public void renderSprite(Graphics2D g, int anim) {
    int sx, sy, dx, dy;
    sx = frame * lx;
    sy = anim;
    dx = (int) Math.round((col) * 80 + offsetX + 30);
    dy = (row) * 88 + offsetY + 60;
    g.drawImage(
      sprite,
      dx,
      dy,
      dx + (int) Math.round(lx * scale),
      dy + (int) Math.round(ly * scale),
      sx,
      sy,
      sx + lx,
      sy + ly,
      null
    );

    if (frameCtr++ > 1) {
      frameCtr = 0;
      frame++;
      if (frame == anim_end[anim]) frame = anim_start[anim];
    }
  }

  public void update() {}

  public Image getPreview() {
    return sprite;
  }

  public int getSx() {
    return anim_start[0] * lx;
  }

  public int getLx() {
    return lx;
  }

  public int getLy() {
    return ly;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
