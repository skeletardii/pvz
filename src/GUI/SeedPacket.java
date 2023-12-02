package GUI;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.Misc.Plant;
import GameUtils.*;
import Main.Global;

public class SeedPacket extends RenderObj implements Updater{
    private static final Image card = new ImageIcon("assets/ui/seedpacket.png").getImage();
    private int posX,cost,lx,ly,sx;
    private int state=0; //0 = not enough sun, 1 = enough sun, 2 = hovered, 3= dragged
    private int state_prev=0;
    private Class<?> plant;
    private Image sprite;
    public SeedPacket(Plant p){
        sprite=p.getPreview();
        sx=p.getSx();
        lx=p.getLx();
        ly=p.getLy();
        cost = p.getSunCost();
        plant = p.getClass();
    }
    public void paintComponent(Graphics2D g) {
        //g.drawImage(sprite,posX,3,50,50,null);
        g.drawImage(
            card,
            posX,
            7,
            posX+55,
            7+73,
            0,
            0,
            100,
            140,
            null
            );
        g.drawImage(
            sprite,
            posX,
            7,
            posX+55,
            7+75,
            sx,
            0,
            sx + lx,
            ly,
            null
            );
        if(state==0) return;
        if(state==3){
            int dx,dy;
            
            int row = (int)Math.round((Global.mouse.y-60)/88);
            int col = (int)Math.round((Global.mouse.x-30)/80);
            if(Global.plants[row][col]==null){
                g.setComposite(makeComposite(0.5f));
                dx = col*80 + 30;
                dy = row*88 + 60;
                g.drawImage(
                    sprite,
                    dx,
                    dy,
                    dx + (int) Math.round(lx * 0.25),
                    dy + (int) Math.round(ly * 0.25),
                    sx,
                    0,
                    sx + lx,
                    ly,
                    null
                    );
                g.setComposite(makeComposite(1f));
            }
            dx = Global.mouse.x - (int) Math.round(lx * 0.25 * 0.5);
            dy = Global.mouse.y - (int) Math.round(ly * 0.25 * 0.5);
            g.drawImage(
                    sprite,
                    dx,
                    dy,
                    dx + (int) Math.round(lx * 0.25),
                    dy + (int) Math.round(ly * 0.25),
                    sx,
                    0,
                    sx + lx,
                    ly,
                    null
                    );
            
        }
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
    public void update(){
        state_prev=state;
        if(
            Global.mouse.left &&
            !Global.mouse_prev.left &&
            Global.mouse.x > posX &&
            Global.mouse.x < posX +54 &&
            Global.mouse.y > 8 &&
            Global.mouse.y < 79){
                state=3;
            }
        if(state_prev==3 && Global.mouse.left && Global.mouse_prev.left) state = 3;
        if(!Global.mouse.left && state==3) {
            int row = (int)Math.round((Global.mouse.y-60)/88);
            int col = (int)Math.round((Global.mouse.x-30)/80);
            try{
                Object newPlant = plant.getDeclaredConstructor().newInstance();
                Global.addPlant((Plant)newPlant,row,col);
                Global.sun -= cost;

                state=0; 
                
            } catch (Exception e ){
                System.out.println("aaa");
            }
        }
    }
    private AlphaComposite makeComposite(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
       }
}
