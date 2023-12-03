package Entities.Misc;

import GameUtils.Mouse;
import GameUtils.RenderObj;
import GameUtils.Updater;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Sun extends RenderObj implements Updater {

  private static final int maxStep = 10;
  private int stepCtr = 0;
  private int sunValue, posX, posY, distInitX, distInitY, frame, fallCtr, frameCtr =
    0;
  private final int lx = 688;
  private final int ly = 689;
  private boolean leftLast = false;
  private double scale = 1.0;
  private Mouse mouse;
  private boolean goingCorner = false;
  private static final Image sprite = new ImageIcon(
    "assets/projectiles/sun.png"
  )
    .getImage();

  public Sun(
    int sunValue,
    double position_Y,
    double position_X,
    int fall_frames
  ) {
    this.sunValue = sunValue;
    posX = (int) Math.round(position_X);
    posY = (int) position_Y;
    fallCtr = fall_frames;
    frame = 0;
    scale = this.sunValue / 25.0;
    scale /= 4;
    setZindex(30);
  }

  public void update() {
    if (goingCorner) {
      if ((posX < 0 && posY < 0) || stepCtr > maxStep) {
        Global.sun += sunValue;
        this.remove();
      } else {
        posX -= distInitX / maxStep;
        posY -= distInitY / maxStep;
        stepCtr++;
      }
      return;
    }
    mouse = game.mouse;

    if (fallCtr-- >= 0 && posY < 500) {
      posY += 1;
      if (fallCtr == 0) setZindex(31);
    }
    if (mouse.left && !leftLast && mouseHover()) {
      //   collect();
      distInitX = posX + 30;
      distInitY = posY;
      goingCorner = true;
      SunManager.playSound();
    }
    leftLast = mouse.left;
  }

  private boolean mouseHover() {
    int cx = posX + (int) Math.round(scale * lx / 2);
    int cy = posY + (int) Math.round(scale * ly / 2);
    int x1 = (int) Math.round(cx - (lx * scale) / 4);
    int y1 = (int) Math.round(cy - (ly * scale) / 4);
    int x2 = (int) Math.round(cx + (lx * scale) / 4);
    int y2 = (int) Math.round(cy + (ly * scale) / 4);
    return ( //check the mpuose spdao wds
      mouse.x >= x1 && mouse.x <= x2 && mouse.y >= y1 && mouse.y <= y2
    );
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
    if (frameCtr++ > 1) {
      frameCtr = 0;
      frame++;
      if (frame == 12) frame = 0;
    }
  }
}
