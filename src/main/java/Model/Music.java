package Model;

import com.example.plantwidget_g18_gui.HelloController;
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class provides functionality to play audio file in a continuous loop.
 * Plays the specified audio file in a continuous loop.
 * @author Akmal Safi
 */

public class Music {
    private Clip clipMusic;
    private Clip backgroundMusic;
    private Clip clipWater;
    private boolean isWateringSoundPlaying = false;

    /**
     * This method plays the background music in a continuous loop.
     * @author Akmal Safi & Emre
     * @param path The path of the audio file to be played.
     */
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

    /**
     * This method returns the clip object of the background music.
     * @return Clip object of the background music.
     */
    public Clip getClipMusic() {
        return backgroundMusic;
    }

    /**
     * This method generates and plays sounds effect.
     * If the sound file is found, it plays the sound in a continuous loop.
     * If the sound file is not found, it prints an error message.
     * @author: Akmal Safi
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

    /**
     * This method generates and plays the death sound effect.
     */
    public void deathSoundGenerator() {
        playSound("/sounds/oof_death.wav");
    }

    /**
     * This method stops the background music.
     */
    public void stopMusic(){
        backgroundMusic.stop();
    }

    public void buttonClickSound() {
        playSound("/sounds/button_click.wav");
    }
    /**
     * This method generates and plays the button sound effect.
     * @author Emre Mengütay
     */
    public void closeProgramSound() {
        playSound("/sounds/close.wav");
    }

    /**
     * This method generates and plays a sad violin sound effect..
     * @author Emre Mengütay
     */
    public void playSadSound() {
        playSound("/sounds/sad.wav");
    }

    /**
     * This method generates and plays the watering sound effect when the plant is watered.
     * @author Emre  & Mojtaba
     */
    public void wateringSound() {
        //checks if there is a watering sound playing already
        if (isWateringSoundPlaying) {
            return;
        }
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/sounds/roblox_drink.wav"));
            clipWater = AudioSystem.getClip();
            clipWater.open(audioInputStream);
            clipWater.start();
            isWateringSoundPlaying = true;

            //this just adds a listener to set the soundPlaying to false when done playing
            clipWater.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        isWateringSoundPlaying = false;
                    }
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
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

    /**
     * This method generates and plays the sound effect when the plant loses health.
     * @author Emre Mengütay
     */
    public void healthSound() {
        playSound("/sounds/oof_MC.wav");
    }
}
