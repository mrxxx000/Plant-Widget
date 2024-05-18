package Model;

/**
 * This class provides functionality to play audio file in a continuous loop.
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Plays the specified audio file in a continuous loop.
 */
public class Music {
    public static void playMusic(String path) {
        try {
            File file = new File(path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error with playing sound.");
            e.printStackTrace();
        }
    }
}
