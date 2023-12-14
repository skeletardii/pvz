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
        super(row, col, 9, 125, 40, sprite);
    }

    public SpikeRock() {
        this(-1, -1);
    }

    @Override
    public int getIncreasingSunCost() {
        return 100;
    }
}
