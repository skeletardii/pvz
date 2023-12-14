package Entities.Zombies;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.ZombieItems.Armor;

public class ConeheadZombie extends Zombie {
  private static final Image sprite = new ImageIcon("assets/zombies/conehead.png").getImage();
  public ConeheadZombie(int row) {
    super(new ZombieBuilder().setRow(row)
    .setSprite(sprite)
    .setArmor(new Armor.Cone())
    .setSpriteHeight(274)
    .setSpriteWidth(320));
  }

  public ConeheadZombie() {
    this(-1);
  }
}
