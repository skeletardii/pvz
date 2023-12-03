package Entities.Misc;

import GameUtils.RenderObj;
import GameUtils.Updater;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class LiveEntity extends RenderObj implements Updater {

  // gi public rasa nako oi, maybe i change rani to setters later
  public double row;
  public double col;
  protected int health;
  protected final int offsetX;
  protected final int offsetY;
  protected boolean targetable = true;
  protected Image sprite;
  protected int lx, ly, frame, frameCtr = 0;
  protected double scale = 0.25;
  public int[] anim_start;
  public int[] anim_end;
  private static final Image shadow = new ImageIcon("assets/ui/shadow.png")
    .getImage();
  protected int offsetOY = 0;
  protected int offsetOX = 0;
  protected int anim_speed = 1;

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
    return this.row == e.row && Math.abs(this.col - e.col) <= 1;
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
    if (frame < anim_start[anim] || frame > anim_end[anim]) frame =
      anim_start[anim];
    int ox = (int) Math.round((col) * 80 + offsetX + 30 + 45);
    int oy = (int) Math.round((row) * 88 + offsetY + 60 + 84);
    int sx, sy, dx, dy;
    sx = frame * lx;
    sy = anim;
    dx = ox - (int) (lx * scale) / 2;
    dy = oy - (int) (ly * scale);
    g.drawImage(shadow, ox - 35, oy - 20, ox + 35, oy, 0, 0, 73, 49, null);
    g.drawImage(
      sprite,
      dx + offsetOX,
      dy + offsetOY,
      dx + offsetOX + (int) (lx * scale),
      dy + offsetOY + (int) (ly * scale),
      sx,
      sy,
      sx + lx,
      sy + ly,
      null
    );
    if (frameCtr++ > anim_speed) {
      frameCtr = 0;
      frame++;
      if (frame == anim_end[anim]) frame = anim_start[anim];
    }
    //g.setColor(Color.white);
    //g.drawOval(ox-5,oy-5,10,10);
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

  public double getScale() {
    return scale;
  }

  public int getOffsetOX() {
    return offsetOX;
  }

  public int getOffsetOY() {
    return offsetOY;
  }

  public boolean isTargetable() {
    return targetable;
  }

  public void setTargetable(boolean targetable) {
    this.targetable = targetable;
  }
}
