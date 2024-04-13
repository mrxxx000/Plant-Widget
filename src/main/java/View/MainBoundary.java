package View;

import Controller.PlantController;

public class MainBoundary {
    private static MainBoundary instance;
    private PlantController plantController;
    private String saveFile;

    public MainBoundary() {
        plantController = new PlantController();
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
}
