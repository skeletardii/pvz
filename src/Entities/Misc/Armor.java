package Entities.Misc;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Armor extends LiveEntity {

  // walay pako sure how to implement this

  // either dili gyud siya existing as an entity since part raman sad siyas sprite then muabot ra siya when naay magnet
  // or naa siya nya hidden??

  public Armor(
    int row,
    double col,
    int health,
    String spriteName,
    int spriteWidth,
    int spriteHeight,
    int animRow
  ) {
    super(
      row,
      col,
      health,
      new ImageIcon("assets/plants/" + spriteName + ".png").getImage(),
      spriteWidth,
      spriteHeight,
      animRow
    );
    this.setVisible(false);
  }

  @Override
  public void update() {
    this.row = ((LiveEntity) (this.getParent())).row;
    this.col = ((LiveEntity) (this.getParent())).col;
  }

  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
