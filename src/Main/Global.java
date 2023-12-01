package Main;

import java.util.ArrayList;

import Entities.Misc.Plant;
import Entities.Misc.Zombie;
import GUI.SeedPacket;
import GameUtils.Game;
import GameUtils.Mouse;
import GameUtils.Updater;

public class Global implements Updater{
    

    public static Game game;
    public static Mouse mouse;
    public static Mouse mouse_prev;
    public static int sun = 0;
    public static Plant[][] plants = new Plant[6][9]; 
    public static ArrayList<Zombie> zombies = new ArrayList<>();
    
    public void update() {
        mouse_prev=mouse;
        mouse=game.mouse;
    }

    public static void addPlant(Plant p, int row, int col){
        plants[row][col]=p;
        p.setRow(row);
        p.setCol(col);
        game.add(p);
        p.zIndex = 5;
    }

    public void addZombie(Zombie z) {
        zombies.add(z);
        game.add(z);
        z.zIndex = 5;
    }

    public static SeedPacket[] seeds = new SeedPacket[10];
    public static int seeds_num = 0;
    public void addSeedPacket(SeedPacket sp){
        seeds[seeds_num++]=sp;
        game.add(sp);
        sp.zIndex = 3;
        sp.setPosX((seeds_num-1)*55 + 77);
    }
}
