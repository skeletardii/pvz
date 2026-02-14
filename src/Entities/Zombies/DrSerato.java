package Entities.Zombies;

import Entities.Misc.LiveEntity;
import Entities.Misc.LiveEntityBuilder;
import Entities.Misc.ZombieSpawner;
import Main.Constants;
import Main.Global;

import java.awt.Graphics2D;

public class DrSerato extends LiveEntity {

  // and a shit ton of shit to implement lol

  public DrSerato() {
    super(new LiveEntityBuilder().setHealth(30000));
  }

  protected void abstractionAttack() {

    for (int k = 0; k < Constants.PLANT_ROWS_COUNT; ++k) {
      for (Zombie z : Global.zombies[k]) {
        z.setVisible(false);
      }
    }

  }

  protected void encapsulationAttack() {

  }

  protected void inheritanceAttack() {

  }

  protected void polymorphismAttack() {

  }

  protected void coolAndNormal() {

//    for (int i = 0; i < Constants.PLANT_ROWS_COUNT; ++i) {
//      for (int j = 0; j < Constants.PLANT_COLS_COUNT; ++j) {
//        Global.plants[i][j]
//      }
//    }

  }



  @Override
  public void paintComponent(Graphics2D g) {
    renderSprite(g, 0);
  }
}
