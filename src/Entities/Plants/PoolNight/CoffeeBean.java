package Entities.Plants.PoolNight;

import Entities.Plants.LawnNight.Shroom;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import Main.Global;

public class CoffeeBean extends Plant {
  private static final Image sprite = new ImageIcon("assets/plants/coffeebean.png").getImage();
  public CoffeeBean() {
    this(-1, -1);
  }

  protected CoffeeBean(double row, double col) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(75)
        .setHealth(110)
        .setSprite(sprite)
        .setSpriteWidth(78)
        .setSpriteHeight(235)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
    );
    animStart[0]=0;
    animEnd[0]=29;
    animSpeed=2;
  }

  @Override
  public void update() {
    this.takeDamage(1);
    if (this.getHealth() <= 0) {
      this.setVisible(false);
      ((Shroom) (Global.plants[(int) getRow()][(int) getCol()])).setAsleep(
          false
        );
    }
  }
  public void paintComponent(Graphics2D g){
    renderSprite(g, 0);
  }
}
