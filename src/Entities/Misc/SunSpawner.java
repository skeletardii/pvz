package Entities.Misc;

import Entities.Interfaces.SunProducer;
import GameUtils.Updater;
import Main.Constants;
import Main.Global;

import java.util.Random;

public class SunSpawner implements Updater, SunProducer {

    private final Random rand = new Random();
    private int sunCtr = 0;
    private static int sunCooldown;

    public SunSpawner() {
        sunCooldown = 1440 / (Global.gameSettings == null ? 1 : Global.gameSettings.sunFallRate);
    }

    public void update() {
        sunCtr++;

        if (sunCtr >= sunCooldown) {
            sunCtr = 0;
            double spawnRow = rand.nextDouble(Constants.PLANT_ROWS_COUNT - 1.5) - 1;
            double spawnColumn = rand.nextDouble(Constants.PLANT_COLS_COUNT) - 0.5;
            Global.game.add(produceSunGrid(25, spawnRow, spawnColumn, 120));
        }
    }
}
