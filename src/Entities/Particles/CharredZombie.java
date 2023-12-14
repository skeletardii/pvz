package Entities.Particles;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import GameUtils.RenderObj;
import Main.Constants;

public class CharredZombie extends RenderObj{
    private static final Image sprite = new ImageIcon("assets/projectiles/charredzombie.png").getImage();
    private int ox,oy,frame=0,lx=140,ly=193,offsetOX=-5,offsetOY=0,frameCtr=0,animSpeed=1;
    private double scale=0.7;
    public CharredZombie(double row, double col){
        ox = (int) Math.round((col) * Constants.COL_PIXEL_OFFSET + Constants.GRID_OFFSET_X);
        oy = (int) Math.round((row) * Constants.ROW_PIXEL_OFFSET + Constants.GRID_OFFSET_Y);
    }
    public void paintComponent(Graphics2D g) {
        
        int sx, sy, dx, dy;
        sx = frame * lx;
        sy = 0;
        dx = ox - (int) (lx * scale) / 2;
        dy = oy - (int) (ly * scale);
        g.drawImage(
            sprite,
            dx + offsetOX, //dx1
            dy + offsetOY, //dy1
            dx + offsetOX + (int) (lx * scale), //dx2
            dy + offsetOY + (int) (ly * scale), //dy2
            sx, //sx1 source
            sy,
            sx + lx,
            sy + ly,
            null
        );
        
        if (frameCtr++ > animSpeed) {
            frameCtr = 0;
            frame++;
        }
        if (frame >= 43) this.remove();
    }
}
