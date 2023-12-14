package Entities.Zombies;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.ZombieItems.Armor;

public class NewspaperZombie extends Zombie {
  private static final Image sprite = new ImageIcon("assets/zombies/newspaper.png").getImage();
  public NewspaperZombie(int row) {
    super(new ZombieBuilder()
    .setRow(row)
    .setArmor(new Armor.Newspaper())
    .setSprite(sprite)
    .setSpriteWidth(253)
    .setSpriteHeight(270));
    animStart[0]=28;
    animEnd[0]=68;
  }

  @Override
  public void removeArmor() {
    setMovementSpeed(ZombieSpeed.FAST.getValue());
  }
}
