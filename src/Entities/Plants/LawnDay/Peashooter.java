package Entities.Plants.LawnDay;

import Entities.Interfaces.Attacker;
import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import Entities.Projectiles.Pea;
import Entities.Zombies.Zombie;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Peashooter extends Plant implements Attacker {
  private static final Image sprite = new ImageIcon("assets/plants/peashooter.png").getImage();

  protected int attacksLeft = 0;
  protected int shotsPerAttack;

  protected int attackCooldownCtr = 0;
  protected int attackRateCtr = 0;

  public Peashooter() {
    this(-1, -1);
  }

  public Peashooter(double row, double col) {
    this(row, col, 1, 100,sprite,125,117);
  }

  public Peashooter(double row, double col, int shotsPerAttack, int sunCost, Image sprite, int spriteWidth, int spriteHeight) {
    super(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(sunCost)
        .setSprite(sprite)
        .setSpriteWidth(spriteWidth)
        .setSpriteHeight(spriteHeight)
        .setAnimRow(5)
    );
    this.shotsPerAttack = shotsPerAttack;
    animStart[0] = 79;
    animEnd[0] = 103;
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  @Override
  public void update() {
    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (z.getCol() >= this.getCol() && z.isTargetable()) {
        attack();
        break;
      }
    }
    super.update();
  }

  @Override
  public void attack() {
    if (attacksLeft > 0) {
      attackCooldownCtr--;
      if (attackCooldownCtr <= 0) {
        attacksLeft--;
        attackCooldownCtr = ATTACK_COOLDOWN;
        shoot();
      }
    } else {
      attackRateCtr--;
      if (attackRateCtr <= 0) {
        attackRateCtr = ATTACK_RATE;
        attacksLeft = shotsPerAttack;
      }
    }
  }

  public void shoot() {
    this.add(new Pea(this.getRow(), this.getCol()));
  }
}
