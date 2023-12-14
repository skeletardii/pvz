package Entities.Plants.LawnNight;

import Entities.Interfaces.Attacker;
import Entities.Plants.Plant;
import Entities.Plants.PlantBuilder;
import Entities.Projectiles.Pea;
import Entities.Zombies.Zombie;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FumeShroom extends Shroom implements Attacker {

  protected int attacksLeft = 0;
  protected int shotsPerAttack;

  protected int attackCooldownCtr = 0;
  protected int attackRateCtr = 0;

  protected FumeShroom(PlantBuilder pBuilder, int shotsPerAttack) {
    super(pBuilder);
    this.shotsPerAttack = shotsPerAttack;
    animStart[0] = 79;
    animEnd[0] = 103;
  }

  protected FumeShroom(double row, double col, int shotsPerAttack) {
    this(
      new PlantBuilder()
        .setRow(row)
        .setCol(col)
        .setSunCost(75)
        .setHealth(300)
        .setPacketCooldown(SeedPacketRechargeTime.FAST.getValue())
        .setSpriteWidth(364)
        .setSpriteHeight(365),
      shotsPerAttack
    );
  }

  public FumeShroom() {
    this(-1, -1, 1);
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  public void shroomUpdate() {
    for (Zombie z : Global.zombies[(int) this.getRow()]) {
      if (z.getCol() >= this.getCol() && z.isTargetable()) {
        attack();
        break;
      }
    }
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

  @Override
  public void shoot() {
    this.add(new Pea(this.getRow(), this.getCol()));
  }
}
