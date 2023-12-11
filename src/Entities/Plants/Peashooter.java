package Entities.Plants;

import Entities.Interfaces.Attacker;
import Entities.Projectiles.Pea;
import Entities.Zombies.Zombie;
import Main.Global;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Peashooter extends Plant implements Attacker {

  protected int attacksLeft = 0;
  protected int shotsPerAttack;

  protected int attackCooldownCtr = 0;
  protected int attackRateCtr = 0;

  public Peashooter() {
    this(-1, -1);
  }

  public Peashooter(int row, double col) {
    this(row, col, 1, 100);
  }

  public Peashooter(int row, double col, int shotsPerAttack, int sunCost) {
    super(
      new PlantBuilder()
        .setHealth(100)
        .setRow(row)
        .setCol(col)
        .setSunCost(sunCost)
        .setSpriteWidth(375)
        .setSpriteHeight(353)
    );
    this.shotsPerAttack = shotsPerAttack;
    anim_start[0] = 79;
    anim_end[0] = 103;
    sprite = new ImageIcon("assets/plants/peashooter.png").getImage();
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }

  @Override
  public void update() {
    for (Zombie z : Global.zombies[this.getRow()]) {
      if (z.getCol() >= this.getCol()) attack();
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
        this.add(new Pea(this.getRow(), this.getCol()));
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
