package Entities.Plants;

import java.awt.Graphics2D;

import Entities.Misc.Plant;

public class Wallnut extends Plant{
    public Wallnut(){
        super(-1, -1, 50, 1000, 15, "wallnut", 509, 496, 1);
        anim_start[0]=0;
        anim_end[0]=16;
        offsetOY=20;
    }
    public void paintComponent(Graphics2D g) {
        renderSprite(g, 0);
    }
    
}
