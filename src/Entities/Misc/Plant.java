package Entities.Misc;

import GameUtils.RenderObj;
import GameUtils.Updater;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Plant extends RenderObj implements Updater {

  protected int row;
  protected int col;
  public final int sun_cost;
  public final double packet_cooldown;
  protected final int offsetX;
  protected final int offsetY;
  private final Image sprite;
  private int lx, ly, frame, frame_ctr = 0;
  private final double scale = 0.25;
  private int health;
  public int[] anim_start;
  public int[] anim_end;

  public Plant(
    int row,
    int col,
    int sun_cost,
    int health,
    double packet_cooldown,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    this.row = row;
    this.col = col;
    this.sun_cost = sun_cost;
    this.health = health;
    this.packet_cooldown = packet_cooldown;
    this.sprite = sprite;
    offsetX = (int) (Math.random() * 10);
    offsetY = (int) (Math.random() * 10);
    lx = spriteWidth;
    ly = spriteHeight;
    anim_start = new int[animRow];
    anim_end = new int[animRow];
  }

  public Plant(
    int row,
    int col,
    int sun_cost,
    int health,
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
      health,
      packet_cooldown,
      new ImageIcon("assets/plants/" + sprite_name + ".png").getImage(),
      spriteWidth,
      spriteHeight,
      animRow
    );
  }

  public Plant() {
    this(0, 0, 25, 10, 1, "_placeholder", 0, 0, 1);
  }

  public void setFrame(int frame) {
    this.frame = frame;
  }

  public void setFrame(int frame, int anim) {
    this.frame = frame + anim_start[anim];
  }

  public void renderPlant(Graphics2D g, int anim) {
    int sx, sy, dx, dy;
    sx = frame * lx;
    sy = anim;
    dx = (col + 1) * 80 + offsetX + 30;
    dy = (row - 1) * 88 + offsetY + 60;
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

    if (frame_ctr++ > 1) {
      frame_ctr = 0;
      frame++;
      if (frame == anim_end[anim]) frame = anim_start[anim];
    }
  }
}
