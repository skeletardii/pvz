package Entities.Misc;

import GameUtils.RenderObj;
import GameUtils.Updater;
import Main.Global;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class LiveEntity extends RenderObj implements Updater {

  private int row;
  private double col;
  private int health;
  private boolean targetable = true;

  protected final int offsetX;
  protected final int offsetY;
  protected Image sprite;
  protected int lx, ly, frame, frameCtr = 0;
  protected double scale = 0.25;
  protected int[] animStart;
  protected int[] animEnd;
  private static final Image shadow = new ImageIcon("assets/ui/shadow.png")
    .getImage();
  protected int offsetOY = 0;
  protected int offsetOX = 0;
  protected int shadowOffsetX = 0;
  protected int shadowOffsetY = 0;
  protected double shadowScale = 1.0;
  protected int animSpeed = 1;

  protected LiveEntity(LiveEntityBuilder leBuilder) {
    this.row = leBuilder.row;
    this.col = leBuilder.col;
    this.health = leBuilder.health;
    this.targetable = leBuilder.targetable;
    this.offsetX = leBuilder.offsetX;
    this.offsetY = leBuilder.offsetY;
    this.sprite = leBuilder.sprite;

    this.lx = leBuilder.lx;
    this.ly = leBuilder.ly;
    this.frame = leBuilder.frame;

    this.scale = leBuilder.scale;

    this.offsetOX = leBuilder.offsetOX;
    this.offsetOY = leBuilder.offsetOY;
    this.shadowOffsetX = leBuilder.shadowOffsetX;
    this.shadowOffsetY = leBuilder.shadowOffsetY;
    this.shadowScale = leBuilder.shadowScale;

    this.animSpeed = leBuilder.animSpeed;

    animStart = new int[leBuilder.animRow];
    animEnd = new int[leBuilder.animRow];
    lx = leBuilder.spriteWidth;
    ly = leBuilder.spriteHeight;
  }

  protected LiveEntity(
    int row,
    double col,
    int health,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    this(
      new LiveEntityBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(health)
        .setSprite(sprite)
        .setSpriteWidth(spriteWidth)
        .setSpriteHeight(spriteHeight)
        .setAnimRow(animRow)
    );
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
      new LiveEntityBuilder()
        .setRow(row)
        .setCol(col)
        .setHealth(Integer.MAX_VALUE)
        .setSprite(sprite)
        .setSpriteWidth(spriteWidth)
        .setSpriteHeight(spriteHeight)
        .setAnimRow(animRow)
    );
  }

  public boolean isTouching(LiveEntity e) {
    return this.row == e.row && Math.abs(this.col - e.col) <= 1;
  }

  public void takeDamage(int damage) {
    this.health -= damage;
  }

  public void setFrame(int frame) {
    this.frame = frame;
  }

  public void setFrame(int frame, int anim) {
    this.frame = frame + animStart[anim];
  }

  public void setRow(int row) {
    this.row = row;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public void renderSprite(Graphics2D g, int anim) {
    if (frame < animStart[anim] || frame > animEnd[anim]) frame =
      animStart[anim];
    int ox = (int) Math.round((col) * Global.COL_PIXEL_OFFSET + offsetX + Global.GRID_OFFSET_X);
    int oy = (int) Math.round((row) * Global.ROW_PIXEL_OFFSET + offsetY + Global.GRID_OFFSET_Y);
    int sx, sy, dx, dy;
    sx = frame * lx;
    sy = 0;
    dx = ox - (int) (lx * scale) / 2;
    dy = oy - (int) (ly * scale);
    g.drawImage(
      shadow,
      ox + shadowOffsetX - (int) (35.0 * shadowScale), //dx1
      oy + shadowOffsetY - (int) (20.0 * shadowScale), //dy1
      ox + shadowOffsetX + (int) (35.0 * shadowScale), //dx2
      oy + shadowOffsetY, //dy2
      0,
      0,
      73,
      49,
      null
    );
    g.drawImage(
      sprite,
      dx + offsetOX, //dx1
      dy + offsetOY, //dy1
      dx + offsetOX + (int) (lx * scale), //dx2
      dy + offsetOY + (int) (ly * scale), //dy2
      sx, //sx1 source
      sy,
      sx + lx,
      sy + ly,
      null
    );
    if (frameCtr++ > animSpeed) {
      frameCtr = 0;
      frame++;
      if (frame == animEnd[anim]) frame = animStart[anim];
    }
    //g.setColor(Color.white);
    //g.drawOval(ox-5,oy-5,10,10);
  }

  public void update() {}

  public Image getPreview() {
    return sprite;
  }

  public int getSx() {
    return animStart[0] * lx;
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

  public int getRow() {
    return row;
  }

  public double getCol() {
    return col;
  }

  public void setCol(double col) {
    this.col = col;
  }

  public void moveCol(double deltaCol) {
    this.col += deltaCol;
  }
}
