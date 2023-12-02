package GameUtils;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

  public static void play(File sndfile) {
    try {
      AudioInputStream ais = AudioSystem.getAudioInputStream(sndfile);
      Clip clip = AudioSystem.getClip();
      clip.open(ais);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
