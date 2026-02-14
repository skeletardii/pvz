package Entities.Misc;

import GameUtils.RenderObj;
import GameUtils.Updater;
import Main.Constants;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public abstract class LiveEntity extends RenderObj implements Updater {

  private double row;
  private double col;
  private double health;
  private boolean targetable = true;
  private int damageFlashCooldown =20;
  private int lastDamaged = 0;

  protected final int offsetX;
  protected final int offsetY;
  protected Image sprite;
  protected int lx, ly, frame, frameCtr = 0;
  protected double scale = 0.25 * 3;
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
    double row,
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
    double row,
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
  public boolean isTouchingClose(LiveEntity e) {
    return this.row == e.row && Math.abs(this.col - e.col) <= 0.5;
  }

  public void takeDamage(double damage) {
    this.health -= damage;
    lastDamaged = damageFlashCooldown;
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
  @SuppressWarnings("all")
  private BufferedImage colorImage(BufferedImage loadImg, int red, int green, int blue) {
    BufferedImage img = new BufferedImage(loadImg.getWidth(), loadImg.getHeight(),
        BufferedImage.TRANSLUCENT);
    Graphics2D graphics = img.createGraphics(); 
    Color newColor = new Color(red, green, blue, 0 /* alpha needs to be zero */);
    graphics.setXORMode(newColor);
    graphics.drawImage(loadImg, null, 0, 0);
    graphics.dispose();
    return img;
}
  public int renderSprite(Graphics2D g, int anim) {
    Image spriteToDraw = sprite;
    
    if (frame < animStart[anim] || frame > animEnd[anim]) frame =
      animStart[anim];
    int ox = (int) Math.round(
      (col) * Constants.COL_PIXEL_OFFSET + offsetX + Constants.GRID_OFFSET_X
    );
    int oy = (int) Math.round(
      (row) * Constants.ROW_PIXEL_OFFSET + offsetY + Constants.GRID_OFFSET_Y
    );
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
      spriteToDraw,
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
    if (lastDamaged==0){
      lastDamaged = damageFlashCooldown;
      g.drawImage(
        spriteToDraw,
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
    } else if (lastDamaged>1){
      lastDamaged--;
    }
    if (frameCtr++ > animSpeed) {
      frameCtr = 0;
      frame++;
      if (frame == animEnd[anim]) frame = animStart[anim];
    }
    return frame;
    //g.setColor(Color.white);
    //g.drawOval(ox-5,oy-5,10,10);
  }

  public void update() {

  }

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

  public double getHealth() {
    return health;
  }

  public void setHealth(double health) {
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

  public double getRow() {
    return row;
  }

  public double getCol() {
    return col;
  }

  public void setCol(double col) {
    this.col = col;
  }

  public void moveRow(double deltaRow) {
    this.row += deltaRow;
  }

  public void moveCol(double deltaCol) {
    this.col += deltaCol;
  }
}
