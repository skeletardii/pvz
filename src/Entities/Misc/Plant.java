package Entities.Misc;

import GameUtils.RenderObj;
import GameUtils.Updater;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Plant extends RenderObj implements Updater {

  protected int row;
  protected int col;
  public final int sunCost;
  public final double packetCooldown;
  protected final int offsetX;
  protected final int offsetY;
  private final Image sprite;
  private int lx, ly, frame, frameCtr = 0;
  private static final double scale = 0.25;
  public int[] animStart;
  public int[] animEnd;

  protected Plant(
    int row,
    int col,
    int sun_cost,
    double packet_cooldown,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    this.row = row;
    this.col = col;
    this.sunCost = sun_cost;
    this.packetCooldown = packet_cooldown;
    this.sprite = sprite;
    offsetX = (int) (Math.random() * 10);
    offsetY = (int) (Math.random() * 10);
    lx = spriteWidth;
    ly = spriteHeight;
    animStart = new int[animRow];
    animEnd = new int[animRow];
  }

  protected Plant(
    int row,
    int col,
    int sun_cost,
    double packet_cooldown,
    String sprite_name,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    this(
      row,
      col,
      sun_cost,
      packet_cooldown,
      new ImageIcon("assets/plants/" + sprite_name + ".png").getImage(),
      spriteWidth,
      spriteHeight,
      animRow
    );
  }

  protected Plant() {
    this(0, 0, 25, 1, "_placeholder", 0, 0, 1);
  }

  public void setFrame(int frame) {
    this.frame = frame;
  }

  public void setFrame(int frame, int anim) {
    this.frame = frame + animStart[anim];
  }

  public void renderPlant(Graphics2D g, int anim) {
    int sx, sy, dx, dy;
    sx = frame * lx;
    sy = anim;
    dx = col * 80 + offsetX + 30;
    dy = (row - 1) * 100 + offsetY + 40;
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
    //g.drawString(""+frame_idle,300,300);

    if (frameCtr++ > 1) {
      frameCtr = 0;
      frame++;
      if (frame == animEnd[anim]) frame = animStart[anim];
    }
  }
}
