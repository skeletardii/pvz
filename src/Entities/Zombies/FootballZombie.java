package Entities.Zombies;

import Entities.ZombieItems.Armor;

import javax.swing.*;

public class FootballZombie extends Zombie {

  public FootballZombie(int row) {
    super(
      new ZombieBuilder()
        .setRow(row)
        .setArmor(new Armor.FootballGear())
        .setMovementSpeed(ZombieSpeed.FAST.getValue()).setSprite(new ImageIcon("assets/zombies/football.png").getImage())
              .setSpriteWidth(420).setSpriteHeight(323)
    );

  }


  public FootballZombie() { this(-1);
  }
}
