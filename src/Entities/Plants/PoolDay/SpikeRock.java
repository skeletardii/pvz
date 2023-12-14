package Entities.Plants.PoolDay;

import Entities.Interfaces.Upgraded;

import javax.swing.*;
import java.awt.*;

public class SpikeRock extends SpikeWeed implements Upgraded {

    private static final Image sprite = new ImageIcon(
            "assets/plants/sunflower.png"
    )
            .getImage();

    public SpikeRock(int row, int col) {
        super(row, col, 9, 125, 40, sprite,137,79);
    }

    public SpikeRock() {
        this(-1, -1);
    }

    @Override
    public int getIncreasingSunCost() {
        return 100;
    }

    @Override
    public Object getLowerClass() {
        return new SpikeWeed();
    }
}
