package Entities.Plants;

import Entities.Interfaces.Upgraded;
import Entities.Misc.LiveEntity;
import GameUtils.Sound;
import Main.Global;
import java.awt.Graphics2D;
import java.io.File;

public class Plant extends LiveEntity {

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

  protected int actionSpeed = -1;
  protected int actionCtr = 0;
  protected int previewFrame = 0;
  public final int sunCost;
  public final double packetCooldown;
  private static final File gulp = new File("assets/sound/gulp.wav");

  protected Plant(PlantBuilder pBuilder) {
    super(
      pBuilder.row,
      pBuilder.col,
      pBuilder.health,
      pBuilder.sprite,
      pBuilder.spriteWidth,
      pBuilder.spriteHeight,
      pBuilder.animRow
    );
    this.sunCost = pBuilder.sunCost;
    this.packetCooldown = pBuilder.packetCooldown;
  }

  @Override
  public void update() {
    if (this.getHealth() <= 0) {
      Sound.play(gulp, -3f);
      Global.removePlant(this.getRow(), (int) this.getCol());
    }
  }

  public double getCooldown() {
    return packetCooldown;
  }

  public int getSunCost() {
    int currentSunCost = sunCost;
    if (this instanceof Upgraded) {
      currentSunCost += ((Upgraded) this).concurrentSunCost(this.getClass());
    }
    return currentSunCost;
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
