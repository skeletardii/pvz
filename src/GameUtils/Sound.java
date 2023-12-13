package GameUtils;

import java.io.File;
import java.io.Serializable;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound implements Serializable {

  private static final long serialVersionUID = 1L; // Ensure compatibility during serialization

  public static void play(File sndfile) {
    play(sndfile, 1f);
  }

  public static void play(File sndfile, float volume) {
    try {
      AudioInputStream ais = AudioSystem.getAudioInputStream(sndfile);
      Clip clip = AudioSystem.getClip();
      clip.open(ais);
      FloatControl gainControl = (FloatControl) clip.getControl(
        FloatControl.Type.MASTER_GAIN
      );
      gainControl.setValue(volume);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
