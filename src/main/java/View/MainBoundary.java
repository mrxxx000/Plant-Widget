package View;

import Controller.PlantController;

public class MainBoundary {
    private PlantController plantController;
    // TODO We need to have an instance of come class from the GUI to communicate with

    public MainBoundary() {
        this.plantController = new PlantController();
    }

    public void setPlantName(String name, int index) {
        plantController.setPlantName(name,index);
    }
}
