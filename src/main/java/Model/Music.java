package Model;

/**
 * This class provides functionality to play audio file in a continuous loop.
 */

import com.example.plantwidget_g18_gui.HelloController;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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

    /**
     * This method generates and plays sounds effect.
     * If the sound file is found, it plays the sound in a continuous loop.
     * If the sound file is not found, it prints an error message.
     */

    public void playSound(String soundFilePath) {
        try {
            InputStream inputStream = HelloController.class.getResourceAsStream(soundFilePath);
            if (inputStream != null) {
                InputStream bufferedIn = new BufferedInputStream(inputStream);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } else {
                System.out.println("InputStream is null");
                System.out.println("Resource Path: " + HelloController.class.getResource(soundFilePath));
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void deathSoundGenerator() {
        playSound("/deathsound/funnydeathsoundeffect.wav");
    }

    public void wateringSound() {
        playSound("/deathsound/watersound.wav");
    }
    public void pumpkinSound() {
        playSound("/deathsound/Pumpkinsoundeffect.wav");
    }
    public void cactusSound() {
        playSound("/deathsound/cactussound.wav");
    }

    public void monsteraSound() {
        playSound("/deathsound/Monsterasound.wav");
    }

    public void sunflowerSound() {
        playSound("/deathsound/sunflowersound.wav");
    }
    public void snakeplantSound() {
        playSound("/deathsound/snakeplantsound.wav");
    }
}
