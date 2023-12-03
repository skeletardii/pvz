package Entities.Misc;

import GameUtils.Sound;
import GameUtils.Updater;
import java.io.File;

public class SunManager implements Updater {

  private static int sun_streak = 0;
  private static final int SOUND_COOLDOWN_MAX = 10;
  private static int sound_cooldown = SOUND_COOLDOWN_MAX;
  private static final File[] sndfiles = {
    new File("assets/sound/sun0.wav"),
    new File("assets/sound/sun1.wav"),
    new File("assets/sound/sun2.wav"),
    new File("assets/sound/sun3.wav"),
    new File("assets/sound/sun4.wav"),
    new File("assets/sound/sun5.wav"),
    new File("assets/sound/sun6.wav"),
  };

  static void playSound() {
    if (sound_cooldown <= 0) {
      Sound.play(sndfiles[sun_streak/2]);
      sound_cooldown = SOUND_COOLDOWN_MAX;
      if (sun_streak < 12) sun_streak++;
    }
  }

  public void update() {
    if (sound_cooldown > -30) sound_cooldown--; 
    else sun_streak = 1;
  }
}
