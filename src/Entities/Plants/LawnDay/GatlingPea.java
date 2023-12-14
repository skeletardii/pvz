package Entities.Plants.LawnDay;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Interfaces.Upgraded;

public class GatlingPea extends Peashooter implements Upgraded {
  private static final Image sprite = new ImageIcon("assets/plants/gatlingpea.png").getImage();
  private int frame1 = 0;
  private int frame2 = 0;
  public GatlingPea() {
    this(-1, -1);
  }
//sprite width: 149 sprite hight 140
  public GatlingPea(double row, double col) {
    super(row, col, 4, 250,sprite,149,140);
    animStart[0]=4;
    animEnd[0]=28;
    animStart[1]=29;
    animEnd[1]=39;
  }

  @Override
  public int getIncreasingSunCost() {
    return 250;
  }
  public void paintComponent(Graphics2D g){
    setFrame(frame1);
    frame1=renderSprite(g, 0);
    setFrame(frame2);
    frame2=renderSprite(g, 1);
  }
}
