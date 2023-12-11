package Entities.Misc;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import GameUtils.RenderObj;

public class Explosion extends RenderObj {
    private double random(double min, double max){
        return min + Math.random() * (max-min);
    }
    public Explosion(int row, double col){
        for(int i=0; i<=5; i++){
            this.add(new ExplosionCloud(1, 60, (int)col*80+140, row*88+164, random(-3, 3), random(-3, 3)));
        }
        for(int i=0; i<=3; i++){
            this.add(new ExplosionCloud(1.5, 60, (int)col*80+140, row*88+164, random(-1, 1), random(-1, 1)));
        }
    }
    public void paintComponent(Graphics2D g) {
        if(getChildren().size()==0) this.remove();
    }
}
class ExplosionCloud extends RenderObj {
    private static final Image cloud = new ImageIcon("assets/projectiles/explosioncloud.png").getImage();
    private static final int side = 80;
    private int life, posX, posY, rot, rotSpeed;
    private double size, velX, velY;
    public ExplosionCloud(double size, int life, int posX, int posY, double velX, double velY){
        this.size=size;
        this.life=life;
        this.posX=posX;
        this.posY=posY;
        this.velX=velX;
        this.velY=velY;
        size*= Math.random()+0.5;
        rot = (int)(Math.random()*360);
        rotSpeed = (int)(Math.random()*10);
    }
    public void paintComponent(Graphics2D g) {
        System.out.println("aaaa");
        AffineTransform og = g.getTransform();
        Composite ogc = g.getComposite();
        life--;
        posX += (int)Math.round(velX);
        posY += (int)Math.round(velY);
        //g.setColor(Color.white); g.fillOval(posX,posY,(int)(size*side), (int)size*side);
        AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(rot),posX,posY);
        if(life<=15)
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)(life/15.0)));
        g.setTransform(at);
        // g.rotate(Math.toRadians(rot));
        g.drawImage(cloud, 
         (int)(posX-size*side/2), (int)(posY-size*side/2), (int)(posX+size*side/2), (int)(posY+size*side/2), 
         0, 0, side, side, null);
        //g.drawImage(op.filter((BufferedImage)cloud,null),posX,posY,null);
        g.setTransform(og);
        g.setComposite(ogc);
        rot+=rotSpeed;
        if(life<=0) this.remove();
    }

}
