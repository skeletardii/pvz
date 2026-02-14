package Entities.Projectiles;

import Entities.Misc.LiveEntityBuilder;

import javax.swing.*;
import java.awt.*;

public class BurningPea extends Pea {
    public static final Image sprite = new ImageIcon(
            "assets/plants/wallnut.png"
    )
            .getImage();

    public BurningPea(double row, double col) {
        super(new LiveEntityBuilder().setRow(row).setCol(col).setSprite(sprite).setSpriteWidth(28).setSpriteHeight(28).setAnimRow(1), 40, 0.05);
    }
}
