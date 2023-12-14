package Entities.Plants.LawnDay;

import Entities.Interfaces.Upgraded;
import Entities.Plants.PlantBuilder;
import Main.Global;

import javax.swing.*;
import java.awt.*;

public class TwinSunflower extends Sunflower implements Upgraded {

    private static final Image sprite = new ImageIcon("assets/plants/twinsunflower.png").getImage();

    public TwinSunflower(int row, int col) {
        super(new PlantBuilder().setRow(row).setCol(col).setHealth(150).setSunCost(150).setPacketCooldown(SeedPacketRechargeTime.SLOW.getValue()).setSprite(sprite).setSpriteWidth(422).setSpriteHeight(422));
        animStart[0] = 8;
        animEnd[0] = 33;
        setFrame(4);
    }

    public TwinSunflower() {
        this(-1, -1);
    }

    @Override
    public void selfProduceSun() {
        Global.game.add(produceSunGrid(25, getRow(), getCol(), 60));
        Global.game.add(produceSunGrid(25, getRow(), getCol() - 1, 60));
    }

    @Override
    public int getIncreasingSunCost() {
        return 50;
    }
}
