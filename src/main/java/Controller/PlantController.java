
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
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PlantController implements Serializable {
    private Plant[] growingPlants;
    private ArrayList<LegendaryPlant> legendaryPlants;
    private Plant plant;
    private DoubleProperty waterLevelProperty;

    public PlantController() {
        growingPlants = new Plant[2]; // allows the user to have MAX 3 growing plants at a time
        legendaryPlants = new ArrayList<>();
        /* waterLevelProperty = new SimpleDoubleProperty(plant.getWaterLevel());
        startTimer();
        TODO @akmal
        This is not gonna work in the constructor. The user needs to create a plant first.
        Also This needs to be specific to EACH individual plant, so it either needs to be in the Plant model,
        or you need to make it go through all the plants in growingPlants array and do this.
         */
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

    /**
     * This method checks if the growingPlants array is full.
     * Returns true if there is space, false if it is full.
     * @return returns true if there is an empty spot, false if array is full.
     */
    public boolean checkForSpace() {
        for (int i = 0; i < growingPlants.length; i++) {
            if (growingPlants[i] ==null) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method goes through the list to find the first empty spot.
     * Once found, it creates a new plant and adds it to the spot.
     * @param type used to create the right type of plant
     */
    public void plantSeed(PlantTypes type) {
        // TODO Get user input from GUI to know what enum type we need here
        for(int i = 0; i < growingPlants.length; i++) {
            if(growingPlants[i] == null) {
                growingPlants[i] = new Plant(type);
            }
        }
    }

    /**
     * This method increments the plants level by one.
     * It then checks to see if the plants level is equal to three, which means it has reached Legendary stage.
     * If it has, it calls the method to create a LegendaryPlant and sends the Plant object as parameters.
     * @param plantIndex used to find the relevant plant object
     */
    public void levelUp(int plantIndex) {
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
            createLegendary(growingPlants[plantIndex]);
        }
    }

    /**
     * This method creates a new LegendaryPlant based on the plant sent through the parameters.
     * It checks what type the plant is, so it can add the correct Legendary image.
     * It adds it to the legendaryPlants arrayList.
     * @param plant Plant object used to create a Legendary Plant
     */
    private void createLegendary(Plant plant) {
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

    /**
     * This method attempts to delete a plant from the growingPlants list.
     * @param plantIndex index to find the relevant plant
     */
    public void deleteGrowingPlant(int plantIndex) {
        if (plantIndex >= 0 && plantIndex < 3) {
            growingPlants[plantIndex] = null;
        }
    }

    /**
     * This method attempts to delete a plant from the LegendaryPlants list.
     * @param plantIndex index to find the relevant plant
     */
    public void deleteLegendaryPlant(int plantIndex) {
        if (plantIndex >= 0 && plantIndex < legendaryPlants.size()) {
            legendaryPlants.remove(plantIndex);
        }
    }

    /**
     * This method attempts to water the plant.
     * It checks if the water is already full, and decreases the health if it is.
     * If the water is not full, it calls waterThePlant() and check the health.
     * If the health is not full, it calls increaseHealth().
     * @param index index to find the relevant plant.
     */
    public void waterPlant(int index) {
        if(growingPlants[index].getWaterLevel() == 1.0) {
            //if the water is full already, lower health
            growingPlants[index].decreaseHealth();
        } else {
            //fill the water level by x amount
            growingPlants[index].waterThePlant();
            if(growingPlants[index].getHealthLevel() != 1.0) {
                //fill the health bar as well
                growingPlants[index].increaseHealth();
            }
        }
    }

    /**
    This method fetches the plant's water level and sends the double to the GUI.
     */
    public double updateWaterBarGUI(int index) {
        return growingPlants[index].getWaterLevel();
    }

    /**
    This method fetches the plant's health level and sends the double to the GUI.
     */
    public double updateHealthBarGUI(int index) {
        return growingPlants[index].getHealthLevel();
    }

    /**
    This method will save the current state of the PlantController object to a file.
     */
    public void saveProgress(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Progress saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save progress to file. " + e);
        }
    }

    /**
     * This method will load the PlantController object from a save file.
     * @param fileName
     * @return
     */
    public static PlantController loadProgress(String fileName) {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                return new PlantController();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        PlantController plantController = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            plantController = (PlantController) in.readObject();
            System.out.println("Progress loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return plantController;
    }

    public double plantGetWaterLevel(){
        return plant.getWaterLevel();
    }
    public Plant getPlant(int index){
        return growingPlants[index];
    }
    public void skipDay(int index){
        growingPlants[index].skipDayWater();
    }
    public void setPlantName(String name, int index) {
        growingPlants[index].setName(name);
    }
}



