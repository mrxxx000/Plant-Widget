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
    private Clip clipMusic;
    private Clip backgroundMusic;
    public  void playMusic(String path) {
        try {
            File file = new File(path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file.toURI().toURL());
            backgroundMusic= AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error with playing sound.");
            e.printStackTrace();
        }
    }
    public Clip getClipMusic() {
        return backgroundMusic;
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
                this.clipMusic = AudioSystem.getClip();
                this.clipMusic.open(audioStream);
                this.clipMusic.start();
            } else {
                System.out.println("InputStream is null");
                System.out.println("Resource Path: " + HelloController.class.getResource(soundFilePath));
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void deathSoundGenerator() {
        playSound("/sounds/oof_death.wav");
    }
    public void stopMusic(){
        backgroundMusic.stop();
    }
    public void startMusic(){
        clipMusic.start();
    }

    public void buttonClickSound() {
        playSound("/sounds/button_click.wav");
    }
    public void closeProgramSound() {
        playSound("/sounds/close.wav");
    }
    public void playSadSound() {
        playSound("/sounds/sad.wav");
    }
    public void wateringSound() {
        playSound("/sounds/roblox_drink.wav");
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
