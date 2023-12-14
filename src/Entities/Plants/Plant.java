package Entities.Plants;

import Entities.Interfaces.Upgraded;
import Entities.Misc.LiveEntity;
import Entities.Plants.PoolNight.Pumpkin;
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
  protected boolean hasLadder = false;
  protected Plant pumpkin = null;

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
  public void takeDamage(double damage) {
    if (Global.gameSettings.plantInvulnerable) return;

    if (pumpkin != null) {
      pumpkin.takeDamage(damage);
    } else {
      super.takeDamage(damage);
    }
  }

  @Override
  public void update() {
    if (this.getHealth() <= 0) {
      Sound.play(gulp, -3f);

      if (this instanceof Pumpkin) {
        this.remove();
      } else {
        Global.removePlant((int) this.getRow(), (int) this.getCol());
      }
    }
  }

  public double getCooldown() {
    if (Global.gameSettings.plantNoCooldown) return 0;

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

  public boolean hasLadder() {
    return hasLadder;
  }

  public void setHasLadder(boolean hasLadder) {
    this.hasLadder = hasLadder;
  }

  public Plant getPumpkin() {
    return pumpkin;
  }

  public void setPumpkin(Plant pumpkin) {
    this.pumpkin = pumpkin;
  }
}
