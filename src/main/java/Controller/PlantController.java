
package Controller;
import Model.LegendaryPlant;
import Model.Plant;
import Model.PlantTypes;
import View.MainBoundary;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.util.Duration;

import java.util.ArrayList;

public class PlantController {
    private Plant[] growingPlants; //This is where we store the growing Plants. MAX 3, see constructor
    private ArrayList<LegendaryPlant> legendaryPlants; //This is where we store the Legendary Plants
    private Plant plant;
    private DoubleProperty waterLevelProperty;
    private MainBoundary boundary; //This is what we use to communicate with the GUI
    private int growingPlantsCounter = 0; //This is a counter to keep track of how many plants are currently growing

    public PlantController() {
        growingPlants = new Plant[3]; // allows the user to have MAX 3 growing plants at a time
        plant = new Plant(PlantTypes.CACTUS); //we can't have this in the controller constructor, a new plant is only created ONCE the user has selected a seed.
        growingPlants[growingPlantsCounter] = plant; //This is where we store the growing Plants. MAX 3, see constructor
        growingPlantsCounter++;
        waterLevelProperty = new SimpleDoubleProperty(plant.getWaterLevel());
        startTimer();
    }

    //My suggestion of a constructor
    public PlantController(MainBoundary boundary) {
        this.boundary = boundary;
        growingPlants = new Plant[2]; // allows the user to have MAX 3 growing plants at a time
        legendaryPlants = new ArrayList<>();
    }

    private void startTimer() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.minutes(1), actionEvent -> {
            plant.decreaseWaterOverTime(1);
            waterLevelProperty.set(plant.getWaterLevel());
        }));


        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }

    public DoubleProperty waterLevelProperty() {
        return waterLevelProperty;
    }
    /*
    This method checks if there is space for a new plant.
    If there is, it creates a new one using the PlantTypes enum, adds it to the list and returns true.
    If there isn't it returns false, logic/error message for that should be handled in the GUI.
     */
    public boolean plantSeed(PlantTypes type) {
        // TODO Get user input from GUI to know what enum type we need here
        boolean spaceForNewPlant = false;
        for(int i = 0; i < growingPlants.length; i++) {
            if(growingPlants[i] == null) {
                growingPlants[i] = new Plant(type);
                spaceForNewPlant = true;
                return spaceForNewPlant;
            }
        }
        return spaceForNewPlant;
    }
    /*
    This method increments the plants level by one.
    It then checks to see if the plants level is equal to three, which means it has reached Legendary stage.
    If it has, it calls the method to create a LegendaryPlant and sends the Plant object as parameters.
     */
    public void levelUp(int plantIndex) { // TODO maybe sending in the plant object is easier?
        growingPlants[plantIndex].incrementLevel();
        Plant plantCopy = growingPlants[plantIndex];
        PlantTypes typeCopy = plantCopy.getType();
        if(plantCopy.getLevel() == 30) {
            if (typeCopy == PlantTypes.CACTUS) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the CACTUS sprout
            } else if (typeCopy == PlantTypes.PUMPKIN) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the PUMPKIN sprout
            } else if (typeCopy == PlantTypes.MONSTERA) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the MONSTER sprout
            } else if (typeCopy == PlantTypes.SUNFLOWER) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the SUNFLOWER sprout
            } else if (typeCopy == PlantTypes.SNAKEPLANT) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the SNAKEPLANT sprout
            }
        } else if (plantCopy.getLevel() == 60) {
            if (typeCopy == PlantTypes.CACTUS) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the CACTUS plant
            } else if (typeCopy == PlantTypes.PUMPKIN) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the PUMPKIN plant
            } else if (typeCopy == PlantTypes.MONSTERA) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the MONSTER plant
            } else if (typeCopy == PlantTypes.SUNFLOWER) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the SUNFLOWER plant
            } else if (typeCopy == PlantTypes.SNAKEPLANT) {
                //growingPlants[plantIndex].setImage(); //TODO set the image to be the SNAKEPLANT plant
            }
        } else if (plantCopy.getLevel() == 100) {
            //call method to create a legendary plant from this plant
            createLegendary(growingPlants[plantIndex]);
        }
    }

    /*
    This method creates a new LegendaryPlant based on the plant sent through the parameters.
    It checks what type the plant is, so it can add the correct Legendary image.
    It adds it to the legendaryPlants arrayList.
     */
    public void createLegendary(Plant plant) {
        LegendaryPlant legendaryPlant = new LegendaryPlant();
        legendaryPlant.setName(plant.getName());
        PlantTypes type = plant.getType();
        legendaryPlant.setTypes(type);
        if (type == PlantTypes.CACTUS) {
            // set legendaryPlant image to CACTUS LEGENDARY image
        } else if (type == PlantTypes.PUMPKIN) {
            // set legendaryPlant image to PUMPKIN LEGENDARY image
        } else if (type == PlantTypes.MONSTERA) {
            // set legendaryPlant image to MONSTERA LEGENDARY image
        } else if (type == PlantTypes.SUNFLOWER) {
            // set legendaryPlant image to SUNFLOWER LEGENDARY image
        } else if (type == PlantTypes.SNAKEPLANT) {
            // set legendaryPlant image to SNAKEPLANT LEGENDARY image
        }
        legendaryPlants.add(legendaryPlant);
    }
    /*
    This method attempts to delete a plant from the growingPlants list.
    If it is successful it returns true, otherwise it returns false.
     */
    public boolean deleteGrowingPlant(int plantIndex) { // TODO maybe sending in the plant object is easier?
        if (plantIndex >= 0 && plantIndex < 3) {
            growingPlants[plantIndex] = null;
            return true;
        }
        else {
            return false;
        }
    }
    /*
    This method attempts to delete a plant from the LegendaryPlants list.
    If it is successful it returns true, otherwise it returns false.
     */
    public boolean deleteLegendaryPlant(int plantIndex) { // TODO maybe sending in the plant object is easier?
        if (plantIndex >= 0 && plantIndex < legendaryPlants.size()) {
            legendaryPlants.remove(plantIndex);
            return true;
        }
        else {
            return false;
        }
    }
    /*
    This method fetches the plant's water level and sends the double to the GUI.
     */
    public double updateWaterBarGUI(Plant plant) {
        return plant.getWaterLevel();
    }
    /*
    This method fetches the plant's health level and sends the double to the GUI.
     */
    public double updateHealthBarGUI(Plant plant) {
        return plant.getHealthLevel();
    }

    /*
    This method will save all progress to a file and return true if it succeeds.
     */
    public boolean saveProgress() {
        // TODO implement a save to file method
        return true;
    }

    /*
    This method will load all progress from a file, or create a new one if there is none.
     */
    public void loadProgress() {
        /*
        TODO
        Check if there is a save file in the program.
        If yes, load it.
        If no, create one.
         */
    }
    public double plantGetWaterLevel(){
        return plant.getWaterLevel();
    }
    public Plant getPlant1(){
        return growingPlants[0];
    }
    public Plant getPlant2(){
        return growingPlants[1];
    }
    public Plant getPlant3(){
        return growingPlants[2];
    }
    public void skipDay(Plant plant){

    }
}



