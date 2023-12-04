package Entities.Misc;

import GameUtils.Sound;
import Main.Global;
import Main.Global;
import java.awt.Image;
import java.io.File;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;

public abstract class Plant extends LiveEntity {

  // temp numbers rani
  public enum SeedPacketRechargeTime {
    VERY_SLOW(20),
    SLOW(15),
    FAST(7.5);

    private final double value;

    SeedPacketRechargeTime(double value) {
      this.value = value;
    }

    public double getValue() {
      return value;
    }
  }

  public final int sunCost;
  public final double packetCooldown;
  private static final File gulp = new File("assets/sound/gulp.wav");

  public Plant(
    int row,
    int col,
    int sunCost,
    int health,
    double packetCooldown,
    Image sprite,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(row, col, health, sprite, spriteWidth, spriteHeight, animRow);
    this.sunCost = sunCost;
    this.packetCooldown = packetCooldown;
  }

  @Override
  public void update() {
    if (this.health <= 0) {
      Sound.play(gulp, -3f);
      Global.removePlant((int) this.row, (int) this.col);
    }
  }

  public double getCooldown() {
    return packetCooldown;
  }

  public int getSunCost() {
    return sunCost;
  }
}
