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

    public MainBoundary() {
        plantController = new PlantController();
        music = new Music();
        //plantController = PlantController.loadProgress(saveFile);
    }

    public void setPlantName(String name, int index) {
        plantController.setPlantName(name,index);
    }

    /**
     * This method returns the instance of the MainBoundary class, there is only one instance.
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

    public Music getMusic() {
        return music;
    }
}
