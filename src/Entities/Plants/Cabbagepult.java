package Entities.Plants;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Misc.Plant;

public class Cabbagepult extends Plant{
    private static final Image sprite = new ImageIcon("assets/plants/cabbagepult.png").getImage();
    private int state = 0;
    public Cabbagepult() {
        super(-1, -1, 100, 100, 7.5, sprite, 496, 527, 2);
        anim_start[0]=4;
        anim_end[0]=35;
        anim_start[1]=36;
        anim_end[1]=73;
        actionSpeed=100;
        offsetOX=-30;
    }
    public void update(){
        if(actionCtr--<=0) {
            actionCtr = actionSpeed;
        }
        if(actionCtr<=37) {
            state = 1;
            anim_speed=0;
        }
        else {
            state = 0;
            anim_speed=1;
        }
        
    }
    public void paintComponent(Graphics2D g) {
        renderSprite(g, state);
    }
    
}
