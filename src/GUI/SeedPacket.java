package GUI;

import Entities.Plants.InstaKillers.*;
import Entities.Plants.Plant;
import GameUtils.*;
import Main.Constants;
import Main.Global;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class SeedPacket extends RenderObj implements Updater {

  private static final Image card = new ImageIcon("assets/ui/seedpacket.png")
    .getImage();
  private static final File seed_click = new File("assets/sound/seedlift.wav");
  private static final File seed_plant = new File("assets/sound/plant.wav");
  private static final File seed_error = new File("assets/sound/buzzer.wav");
  private int posX, cost, lx, ly, sx;
  private double initZ;
  private int state = 0; //0 = not enough sun, 1 = enough sun, 2 = hovered, 3= dragged
  private int statePrev = 0;
  private int prevX, prevY;
  private double scale = 0.25;
  private int offsetCX;
  private int offsetCY;
  private Class<?> plant;
  private Image sprite;
  private Plant p;

  public SeedPacket(Plant p) {
    this.p = p;
    sprite = p.getPreview();
    sx = p.getSx();
    lx = p.getLx();
    ly = p.getLy();
    cost = p.getSunCost();
    plant = p.getClass();
    initZ = 3;
    scale = p.getScale();
    offsetCX = p.getOffsetOX();
    offsetCY = p.getOffsetOY();
    if (ly > lx) {
      prevY = 40;
      prevX = (int) ((1.0 * lx / ly) * prevY);
    } else {
      prevX = 40;
      prevY = (int) ((1.0 * ly / lx) * prevX);
    }

    if (p instanceof PotatoMine) sx = lx * 30;
  }

  private int getDigits(int num) {
    int ctr = 0;
    while (num > 1) {
      num /= 10;
      ctr++;
    }
    return ctr;
  }

  public void paintComponent(Graphics2D g) {
    g.drawImage(card, posX, 7, posX + 55, 7 + 73, 0, 0, 100, 140, null);
    g.drawImage(
      sprite,
      posX + 30 - 3 - prevX / 2,
      7 + 30 - prevY / 2,
      posX + 30 - 3 + prevX / 2,
      7 + 30 + prevY / 2,
      sx,
      0,
      sx + lx,
      ly,
      null
    );
    g.setColor(Color.black);
    g.drawString("" + cost, posX + 20 - (5 * (getDigits(cost) - 1)), 75);
    if (state == 0) {
      setZindex(initZ);
      return;
    }
    if (state == 3) {
      int dx, dy;

      setZindex(100);
      int row = (Global.mouse.y - 60) / 88;
      int col = (Global.mouse.x - 30) / 80;
      if (row >= Constants.PLANT_ROWS_COUNT) row =
        Constants.PLANT_ROWS_COUNT - 1;
      if (col >= Constants.PLANT_COLS_COUNT) col =
        Constants.PLANT_COLS_COUNT - 1;
      if (row < 0) row = 0;
      if (col < 0) col = 0;
      if (Global.plants[row][col] == null) {
        g.setComposite(makeComposite(0.5f));

        int ox = (col) * 80 + 30 + 45;
        int oy = (row) * 88 + 60 + 84;
        dx = ox - (int) (lx * scale) / 2;
        dy = oy - (int) (ly * scale);
        g.drawImage(
          sprite,
          dx + offsetCX,
          dy + offsetCY,
          dx + offsetCX + (int) (lx * scale),
          dy + offsetCY + (int) (ly * scale),
          sx,
          0,
          sx + lx,
          ly,
          null
        );
        g.setComposite(makeComposite(1f));
      }
      dx = Global.mouse.x - (int) Math.round(lx * scale * 0.5);
      dy = Global.mouse.y - (int) Math.round(ly * scale * 0.5);
      g.drawImage(
        sprite,
        dx,
        dy,
        dx + (int) Math.round(lx * scale),
        dy + (int) Math.round(ly * scale),
        sx,
        0,
        sx + lx,
        ly,
        null
      );
    }
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public void update() {
    // gi addan nako ani para mu change ang sunCost sa mga upgradables
    // pero mu move ang cost tho lol, basta mu increase na
    cost = this.p.getSunCost();

    statePrev = state;
    if (
      Global.mouse.left &&
      !Global.mouse_prev.left &&
      Global.mouse.x > posX &&
      Global.mouse.x < posX + 54 &&
      Global.mouse.y > 8 &&
      Global.mouse.y < 79
    ) {
      state = 3;
      Sound.play(seed_click);
    }
    if (statePrev == 3 && Global.mouse.left && Global.mouse_prev.left) state =
      3;
    if (!Global.mouse.left && state == 3) {
      int row = ((Global.mouse.y - 60) / 88);
      int col = ((Global.mouse.x - 30) / 80);
      if (row >= Constants.PLANT_ROWS_COUNT) row =
        Constants.PLANT_ROWS_COUNT - 1;
      if (col >= Constants.PLANT_COLS_COUNT) col =
        Constants.PLANT_COLS_COUNT - 1;
      if (row < 0) row = 0;
      if (col < 0) col = 0;
      try {
        Object newPlant = plant.getDeclaredConstructor().newInstance();

        try {
          Global.addPlant((Plant) newPlant, row, col);
          Global.sun -= cost;
          Sound.play(seed_plant);
        } catch (ArrayStoreException e) {
          Sound.play(seed_error);
        }

        state = 0;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private AlphaComposite makeComposite(float alpha) {
    int type = AlphaComposite.SRC_OVER;
    return (AlphaComposite.getInstance(type, alpha));
    //AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)
  }
}
