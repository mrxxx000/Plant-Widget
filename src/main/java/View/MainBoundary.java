package View;

import Controller.PlantController;
import Model.Music;

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

    public static MainBoundary getInstance() {
        if(instance == null) {
            instance = new MainBoundary();
        }
        return instance;
    }

    public PlantController getPlantController() {
        return plantController;
    }

    public Music getMusic() {
        return music;
    }
}
