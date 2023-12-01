package Main;

import Entities.Misc.Plant;
import GUI.SeedPacket;
import GameUtils.Game;
import GameUtils.Updater;

public class Global implements Updater{
    public static Game game;
    public static int sun = 0;
    public static Plant[][] plants = new Plant[6][9]; 
    public void update() {

    }
    public void addPlant(Plant p, int row, int col){
        plants[row][col]=p;
        p.setRow(row);
        p.setCol(col);
        game.add(p);
    }
    public static SeedPacket[] seeds = new SeedPacket[10];
    public static int seeds_num = 0;
    public void addSeedPacket(SeedPacket sp){
        seeds[seeds_num++]=sp;
        game.add(sp);
        sp.zIndex = 3;
    }
}
