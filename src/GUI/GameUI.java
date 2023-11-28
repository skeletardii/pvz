package GUI;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import GameUtils.RenderObj;
import GameUtils.Updater;

public class GameUI extends RenderObj implements Updater{
    private static Image sprite;
    public GameUI(int mode){
        sprite = new ImageIcon("assets/ui/background"+mode+".jpg").getImage();
    }
    public void update() {}
    public void paintComponent(Graphics2D g) {//228
        g.drawImage(sprite,0,0,800,600,220,0,220+800,600,null);
    }
    
}
