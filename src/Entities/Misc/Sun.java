package Entities.Misc;

import GameUtils.RenderObj;
import GameUtils.Updater;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Sun extends RenderObj implements Updater {

  private int sun_value, posX, posY, frame, fall_max, fall_ctr, frame_ctr = 0;
  private final int lx = 688;
  private final int ly = 689;
  private double scale = 1.0;
  private static Image sprite = new ImageIcon("assets/projectiles/sun.png")
    .getImage();

  public Sun(int sun_value, int position_X, int position_Y, int fall_frames) {
    this.sun_value = sun_value;
    posX = position_X;
    posY = position_Y;
    fall_max = fall_frames;
    fall_ctr = 0;
    frame = 0;
    scale = this.sun_value / 25;
    scale /= 4;
  }

  public void update() {
    if (fall_ctr++ <= fall_max) {
      posY += 1;
    }
  }

  public void paintComponent(Graphics2D g) {
    int sx = frame * lx;
    g.drawImage(
      sprite,
      posX,
      posY,
      posX + (int) Math.round(lx * scale),
      posY + (int) Math.round(ly * scale),
      sx,
      0,
      sx + lx,
      ly,
      null
    );

    if (frame_ctr++ > 1) {
      frame_ctr = 0;
      frame++;
      if (frame == 12) frame = 0;
    }
  }
}
