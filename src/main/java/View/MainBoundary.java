package View;

import Controller.PlantController;
import Model.Music;
/**
 * This is a boundary class that acts as the boudnary between the view and the controllers/models.  The class follows
 * the singleton design pattern.
 * @Author Emre Mengütay ---
 */
public class MainBoundary {
    private static MainBoundary instance;
    private PlantController plantController;
    private Music music;
    private String saveFile;

    /**
     * The constructor of the MainBoundary class, it initializes the plant controller and the music.
     * @Author Emre Mengütay
     */
    public MainBoundary() {
        plantController = new PlantController();
        music = new Music();
        //plantController = PlantController.loadProgress(saveFile);
    }

    /**
     * This method returns the instance of the MainBoundary class, there is only one instance. Singleton design pattern.
     * @Author Emre Mengütay
     */
    public static MainBoundary getInstance() {
        if(instance == null) {
            instance = new MainBoundary();
        }
        return instance;
    }
    /**
     * This method returns the plant controller, in order to access its methods in the view.
     * @Author Emre Mengütay
     */
    public PlantController getPlantController() {
        return plantController;
    }

    /**
     * This method returns the music object, in order to access its methods in the view.
     * @Author Akmal Safi
     * @return music object
     */
    public Music getMusic() {
        return music;
    }
}
