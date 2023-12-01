package GUI;

import java.awt.Graphics2D;
import java.awt.Image;

import Entities.Misc.Plant;
import GameUtils.*;

public class SeedPacket extends RenderObj{
    private int posX;
    private int cost;
    private int lx;
    private int ly;
    private int sx;
    private Image sprite;
    public SeedPacket(Plant p){
        sprite=p.getPreview();
        sx=p.getSx();
        lx=p.getLx();
        ly=p.getLy();
    }
    public void paintComponent(Graphics2D g) {
        g.drawImage(sprite,posX,3,50,50,null);
        g.drawImage(
            sprite,
            posX,
            3,
            50,
            53,
            sx,
            0,
            sx + lx,
            ly,
            null
            );
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
}
