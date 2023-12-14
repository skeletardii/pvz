package LevelEditor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class GameSettings implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public boolean plantInvulnerable = false;
    public  boolean plantNoCooldown = false;
    public  boolean plantDoubleSpeed = false;
    public  boolean noLawnmower = false;

    public  int sunFallRate = 1;
    public  int sunSunValue = 26;
    public  int startingSun = 50;

    public boolean zombieInvisighoul = false;
    public  int zombieHealthMultiplier  = 1;
    public  int zombieDamageMultiplier = 1;
    public  int zombieMovementSpeedMultiplier = 1;
    public  int zombieSpawnRateMultiplier = 1;

    public  String music = "bg0";

    public  ArrayList<String> selectedPlants;
    public  ArrayList<String> selectedZombies;

    public String window = "Fullscreen";
    public String background = "LawnDay";
    public boolean isBossFight = false;

    public GameSettings() {
        selectedPlants = new ArrayList<String>();
        selectedZombies = new ArrayList<String>();
    }




}
