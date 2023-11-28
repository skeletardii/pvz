package Entities.Misc;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import GameUtils.Mouse;
import GameUtils.RenderObj;
import GameUtils.Updater;

public class Sun extends RenderObj implements Updater{
    private int sun_value, posX, posY, frame, fall_max, fall_ctr, frame_ctr=0;
    private Mouse mouse;
    private boolean left_last = false;
    private final int lx = 688;
    private final int ly = 689;
    private double scale = 1.0;
    private static Image sprite = new ImageIcon("assets/projectiles/sun.png").getImage();
    public Sun(int sun_value, int position_X, int position_Y,int fall_frames){
        this.sun_value=sun_value;
        posX=position_X;
        posY=position_Y;
        fall_max=fall_frames;
        fall_ctr = 0;
        frame=0;
        scale = this.sun_value/25;
        scale/=4;
    }
    public int collect(){
        System.out.println("aaqa");
        return sun_value;
    }
    public void update() {
        mouse=game.mouse; 
        
        
        if(fall_ctr++<=fall_max){
            posY+=1;
        }
        if(mouse.left && !left_last && mouseHover()){
            collect();
            this.remove();
        }
        left_last = mouse.left;
    }
    private boolean mouseHover(){
        int cx = posX+(int)Math.round(scale*lx/2);
        int cy = posY+(int)Math.round(scale*ly/2);
        int x1 = (int)Math.round(cx-(lx*scale)/4);
        int y1 = (int)Math.round(cy-(ly*scale)/4);
        int x2 = (int)Math.round(cx+(lx*scale)/4);
        int y2 = (int)Math.round(cy+(ly*scale)/4);
        return(
            mouse.x >= x1 &&
            mouse.x <= x2 &&
            mouse.y >= y1 &&
            mouse.y <= y2
        );
    }
    public void paintComponent(Graphics2D g) {
        int sx = frame * lx; 
        g.drawImage(sprite,
            posX,posY,
            posX+(int)Math.round(lx*scale),posY+(int)Math.round(ly*scale),
            sx,0,
            sx+lx,ly,
            null);
        if(mouse != null && mouseHover())g.drawRect(posX,posY,(int)Math.round(lx*scale),(int)Math.round(ly*scale));
        if(frame_ctr++>1){
            frame_ctr=0;
            frame++;
            if(frame==12) frame = 0;
        }
    }
    
}
