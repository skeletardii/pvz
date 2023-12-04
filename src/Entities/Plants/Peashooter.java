package Entities.Plants;

import Entities.Interfaces.Attacker;
import Entities.Misc.Plant;
import Entities.Misc.Zombie;
import Entities.Projectiles.Pea;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Peashooter extends Plant implements Attacker {

  private static final Image sprite = new ImageIcon(
    "assets/plants/peashooter.png"
  )
    .getImage();

  protected int attacksLeft = 0;
  protected int shotsPerAttack;

  protected int attackCooldownCtr = 0;
  protected int attackRateCtr = 0;

  public Peashooter() {
    this(-1, -1);
  }

  public Peashooter(double row, double col) {
    this(row, col, 1, 100);
  }

  public Peashooter(double row, double col, int shotsPerAttack, int sunCost) {
    super(row, col, sunCost, 100, 7.5, sprite, 375, 353, 1);
    this.shotsPerAttack = shotsPerAttack;
    anim_start[0] = 79;
    anim_end[0] = 103;
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  @Override
  public void update() {
    for (Zombie z : Global.zombies) {
      if (z.row == this.row && z.col >= this.col) attack();
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
        this.add(new Pea(this.row, this.col));
      }
    } else {
      attackRateCtr--;
      if (attackRateCtr <= 0) {
        attackRateCtr = ATTACK_RATE;
        attacksLeft = shotsPerAttack;
      }
    }
  }
}
