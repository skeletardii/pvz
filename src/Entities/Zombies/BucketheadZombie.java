package Entities.Zombies;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.ZombieItems.Armor;

public class BucketheadZombie extends Zombie {
  private static final Image sprite = new ImageIcon("assets/zombies/buckethead.png").getImage();
  protected BucketheadZombie(int row) {
    super(new ZombieBuilder().setRow(row)
    .setSprite(sprite)
    .setArmor(new Armor.Bucket()));
  }
}
