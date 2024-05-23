package Controller;

import Model.*;
import View.MainBoundary;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PlantController implements Serializable {
    private Plant[] growingPlants;
    private ArrayList<LegendaryPlant> legendaryPlants;
    private DoubleProperty waterLevelProperty;
    private Timeline timeline;
    private LocalDate dateNow;
    private static PlantController instance = new PlantController();
    private ImageController imageController;


    public PlantController() {
        growingPlants = new Plant[3];
        legendaryPlants = new ArrayList<>();
        initializeWaterLevelProperty();
        imageController = new ImageController(this);
        timeTrackReader();

        // This is just for testing purposes can remove later
        Plant catPlant = new Plant(PlantTypes.PUMPKIN);
        InputStream inputStream = getClass().getResourceAsStream("/images/testCat.jpg");
        Image image = new Image(inputStream);
        catPlant.setImage(image);
    }

    /**
     * This method returns the array of growing plants.
     *
     * @return The array of growing plants
     * @author Yrja Mai Hoang && Emre
     */
    public Plant[] getGrowingPlants() {
        return growingPlants;
    }

    /**
     * This method initializes the water level property and sets up a timeline to periodically update
     * the water level of growing plants and update the GUI accordingly.
     * The method creates a timeline with a duration of 1 second, which triggers actions
     * to decrease the water level of each growing plant based on its watering needs,
     * updates the water level property, and refreshes the GUI to reflect the changes.
     * It sets the timeline to run indefinitely, with keyframes corresponding to the
     * watering intervals of each plant type, and triggers watering actions accordingly.
     *
     * @author Akmal Safi
     * @author Emre Mengütay
     */
    public void initializeWaterLevelProperty() {
        waterLevelProperty = new SimpleDoubleProperty();
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            for (int i = 0; i < growingPlants.length; i++) {
                Plant growingPlant = growingPlants[i];
                if (growingPlant != null) {
                    // Decrease water level based on the plant's watering needs
                    growingPlant.decreaseWaterOverTime(1);
                    waterLevelProperty.set(growingPlant.getWaterLevel());
                    updateWaterBarGUI(i);
                    updateHealthBarGUI(i); // Update health bar GUI
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Start the timeline with the appropriate interval for each plant type
        for (Plant growingPlant : growingPlants) {
            if (growingPlant != null) {
                double wateringInterval = growingPlant.getWateringIntervalForPlantType(growingPlant.getType());
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(wateringInterval), event -> {
                    // Water the plant after the watering interval
                    growingPlant.waterThePlant();
                    // Update GUI after watering
                    updateWaterBarGUI(indexOfPlant(growingPlant));
                    updateHealthBarGUI(indexOfPlant(growingPlant));
                });
                timeline.getKeyFrames().add(keyFrame);
            }
        }
    }

    /**
     * This method finds the index of a specified plant in the array of growing plants.
     * Iterates through the array and checks each element to find the specified plant.
     * If the plant is found, returns its index in the array; otherwise, returns -1
     * to indicate that the plant was not found in the array.
     *
     * @param plant The plant to find the index of
     * @return The index of the specified plant in the array, or -1 if not found
     * @author Akmal Safi
     */
    private int indexOfPlant(Plant plant) {
        for (int i = 0; i < growingPlants.length; i++) {
            if (growingPlants[i] == plant) {
                return i;
            }
        }
        return -1; // Plant not found
    }

    /**
     * This method start the timer for updating water levels.
     * Stops the timeline to pause the periodic updates of water levels for growing plants.
     *
     * @author Emre Mengütay
     */
    public void startTheTimer() {
        timeline.play();
    }

    /**
     * This method stops the timer for updating water levels.
     * Stops the timeline to pause the periodic updates of water levels for growing plants.
     *
     * @author Emre Mengütay
     */
    public void stopTheTimer() {
        timeline.stop();
    }

    /**
     * Method to start the timer for updating water levels
     * Loops through each element of the growingPlants array
     * to update water level property for each plant
     * Checks if the element is not null
     * Decreasing water level for the plant
     *
     * @author Akmal Safi
     */
    public void startTimer() {
        timeline.play();
    }

    /**
     * This method checks if the growingPlants array is full.
     * Returns true if there is space, false if it is full.
     *
     * @return returns true if there is an empty spot, false if array is full.
     * @author Yrja Mai Hoang
     */
    public boolean checkForSpace() {
        for (Plant growingPlant : growingPlants) {
            if (growingPlant == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for returning the specific plant controller instance, part of the singleton pattern.
     *
     * @return : This specific plant controller instance
     * @author Emre Mengütay, does not say correct on GitHub.
     */
    public static PlantController getInstance() {
        return instance;
    }

    /**
     * This method plants a seed in the first available spot in the growingPlants array.
     * It creates a new plant object with the specified type and name, and adds it to the array.
     * If a name is provided, it sets the name for the plant.
     *
     * @param type The type of plant to plant
     * @param name The name of the plant to set, or null if no name is provided
     */
    public void plantSeed(PlantTypes type, String name) {
        // Loop through each spot in the growingPlants array
        for (int i = 0; i < growingPlants.length; i++) {
            // Check if the spot is empty
            if (growingPlants[i] == null) {
                // Create a new plant in the current spot
                growingPlants[i] = new Plant(type);
                // If a name is provided, set the name for the plant
                if (name != null) {
                    growingPlants[i].setName(name);
                }
                // Exit the loop after creating one seed
                break;
            }
        }
    }


    /**
     * This method creates a new LegendaryPlant based on the plant sent through the parameters.
     * It checks what type the plant is, so it can add the correct Legendary image.
     * It adds it to the legendaryPlants arrayList.
     *
     * @param plant Plant object used to create a Legendary Plant
     * @author Yrja Mai Hoang
     */
    public void createLegendary(Plant plant) {
        PlantTypes type = plant.getType();
        LegendaryPlant legendaryPlant = new LegendaryPlant();
        legendaryPlant.setName(plant.getName());
        legendaryPlant.setTypes(type);
        legendaryPlant.setPotType(plant.getPotType());
        setPlantImage(legendaryPlant);
        legendaryPlants.add(legendaryPlant);
    }

    /**
     * This method attempts to delete a plant from the growingPlants list.
     *
     * @param plantIndex index to find the relevant plant
     * @author Emre Mengutay and Yrja Mai Hoang and Akmal Safi
     */
    public void deleteGrowingPlant(int plantIndex) {
        if (plantIndex >= 0 && plantIndex <= 3) {
            String plantName = growingPlants[plantIndex].getName();
            System.out.println("Plant name: " + plantName);

            // Shift remaining plants to fill the gap
            for (int i = plantIndex; i < growingPlants.length - 1; i++) {
                growingPlants[i] = growingPlants[i + 1];
            }

            // Set the last element to null
            growingPlants[growingPlants.length - 1] = null;

            // Print remaining plant names
            for (int i = 0; i < growingPlants.length; i++) {
                if (growingPlants[i] != null) {
                    System.out.println("Plant name: " + growingPlants[i].getName());
                }
            }
        }
    }


    /**
     * This method attempts to water the plant.
     * It checks if the water is already full, and decreases the health if it is.
     * If the water is not full, it calls waterThePlant() and check the health.
     * If the health is not full, it calls increaseHealth().
     *
     * @param index index to find the relevant plant.
     * @author Yrja Mai Hoang and Emre
     */
    public void waterPlant(int index) {
        if (growingPlants[index] == null) {
            System.out.println("No plant found at index " + index);
            return;// Exit the method if the plant is null
        }
        if (this.growingPlants[index].getWaterLevel() >= 1.0) {
            //if the water is full already, lower health
            if (growingPlants[index].getHealthLevel() > 0) {
                MainBoundary.getInstance().getMusic().healthSound();
                growingPlants[index].decreaseHealth();

            } else {
                killPlant(index);
            }
        } else if (growingPlants[index].getWaterLevel() < 1.0) {
            //fill the water level by x amount
            boolean shouldItLevelUp = growingPlants[index].waterThePlant();
            if (growingPlants[index].getHealthLevel() != 1.0) {
                //increase the health bar as well
                growingPlants[index].increaseHealth();
            }
            /*if(shouldItLevelUp){
                levelUp(index);
            }*/
        }
    }

    /**
     * This method kills a plant, it then sets the health and water level to 0 and removes the plant from the list.
     * It also replaces the image of the plant with a dead plant image.
     *
     * @author Emre Mengütay
     */
    public void killPlant(int index) {
        //if the health is already 0, remove the plant
        InputStream inputStream = getClass().getResourceAsStream("/images/deademoji.png");
        Image image = new Image(inputStream);

        growingPlants[index].setImage(image); // could be like a big X image or sumn
        //growingPlants[index].setPlantDead(); // this or the line under this
        getPlant(index).setImage(image);
        growingPlants[index].setWaterLevel(0.0);
        growingPlants[index].setHealthLevel(0.0);
        deleteGrowingPlant(index);
        System.out.println("Plant is dead");
    }

    /**
     * This method fetches the plant's water level and sends the double to the GUI.
     *
     * @author Yrja Mai Hoang
     */
    public double updateWaterBarGUI(int index) {
        return growingPlants[index].getWaterLevel();
    }

    /**
     * This method fetches the plant's health level and sends the double to the GUI.
     *
     * @author Yrja Mai Hoang
     */
    public double updateHealthBarGUI(int index) {
        return growingPlants[index].getHealthLevel();
    }

    /**
     * This method returns the plant at the specified index.
     *
     * @param index The index of the plant to return
     * @return The plant at the specified index, or null if no plant is found
     * @author Yrja Mai Hoang
     */
    public Plant getPlant(int index) {
        if (growingPlants[index] != null) {
            return growingPlants[index];
        }
        return null;
    }

    public void skipDay(int index) {
        if (growingPlants[index] != null) {
            growingPlants[index].skipDayWater();
            growingPlants[index].setLevelSkip();
        }
    }

    /**
     * Sets the name of the plant at the specified index.
     *
     * @param name  The name to set
     * @param index The index of the plant to set the name for
     * @author Yrja Mai Hoang
     */
    public void setPlantName(String name, int index) {
        growingPlants[index].setName(name);
    }


    /**
     * This keeps track of the time the plant has been alive. It saves the date when the plant was last saved.
     *
     * @author Emre Mengütay
     */
    public void timeTrackWriter() { // need to specifgy how we write the progress for three plants
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("dd/MM-yy");

        System.out.println("The date is: " + formatedDate.format(date));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saveFile.txt", false))) {

            for (int i = 0; i < growingPlants.length; i++) {
                if (growingPlants[i] != null) {
                    writer.write(growingPlants[i].getName() + ": ");
                    writer.write(growingPlants[i].getLevel() + ": "); // days alive
                    writer.write(formatedDate.format(date)); // last saved date.
                    writer.newLine();
                }
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            throw new RuntimeException(e);
        }
    }

    /**
     * This method reads the time track from the file and updates the plant's level and water level.
     *
     * @author Emre Mengutay
     */
    public void timeTrackReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader("saveFile.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(": ");
                if (parts.length != 3) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
                String plantName = parts[0];
                String daysAliveStr = parts[1];
                String lastSavedDateStr = parts[2];

                try {
                    for (int i = 0; i < growingPlants.length; i++) {
                        if (i == 0 && growingPlants[i] != null) {
                            int daysAlive = Integer.parseInt(daysAliveStr);
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM-yy");
                            LocalDate lastSavedDate = LocalDate.parse(lastSavedDateStr, formatter);
                            dateNow = LocalDate.now();

                            long daysDifference = ChronoUnit.DAYS.between(lastSavedDate, dateNow);

                            growingPlants[i].setLevel((int) (daysAlive + daysDifference));
                            double waterLoss = daysDifference * 0.3;

                            double newWaterLevel = growingPlants[i].getWaterLevel() - waterLoss;
                            growingPlants[i].setWaterLevel(newWaterLevel);
                        }

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format in line: " + line);
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves the list of growing plants and legendary plants to a file.
     * The file is created if it does not exist.
     * Each plant's details including water level, health level, and level are written to the file.
     * Legendary plants are also saved.
     *
     * @author Akmal Safi
     * @author Emre Mengutay
     */
    public void SavePlantToFile() {
        String filename = "src/main/resources/SaveFile/PlantSaveFile.dat";
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed to create file " + e.getMessage());
            }
        }
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Plant plant : growingPlants) {
                if (plant != null) {
                    oss.writeObject(plant);
                    oss.writeDouble(plant.getWaterLevel());
                    oss.writeDouble(plant.getHealthLevel());
                    oss.writeInt(plant.getLevel());
                }
            }
            for (LegendaryPlant legendaryPlant : legendaryPlants) {
                oss.writeObject(legendaryPlant);
            }
            System.out.println("Plant info saved successfully");
        } catch (IOException e) {
            System.out.println("Failed to save plants" + e.getMessage());
        }
    }

    /**
     * Loads plant data from a file and populates the growingPlants array and legendaryPlants set.
     * If the file does not exist, it is created.
     * For each plant in the file, its details including water level,
     * health level, and level are read and assigned.
     * Legendary plants are also loaded and added to the legendaryPlants set.
     *
     * @author Akmal Safi
     * @author Emre Mengutay
     */
    public void LoadPlantsFromFile() {
        String filename = "src/main/resources/SaveFile/PlantSaveFile.dat";
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed to create file " + e.getMessage());
            }
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                int index = 0;
                growingPlants = new Plant[3];
                legendaryPlants = new ArrayList<>();
                Object obj;
                try {
                    while (true) {
                        obj = ois.readObject();
                        if (obj instanceof Plant) {
                            Plant plant = (Plant) obj;
                            double waterLevel = ois.readDouble();
                            double healthLevel = ois.readDouble();
                            int level = ois.readInt();
                            plant.setWaterLevel(waterLevel);
                            plant.setHealthLevel(healthLevel);
                            plant.setLevel(level);
                            setPlantImage(plant);
                            growingPlants[index++] = plant;
                        } else if (obj instanceof LegendaryPlant) {
                            LegendaryPlant legendaryPlant = (LegendaryPlant) obj;
                            legendaryPlants.add(legendaryPlant);
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Failed to load plants " + e.getMessage());
                }
            } catch (EOFException e) {
                // End of file reached
            } catch (IOException e) {
                System.out.println("Failed to load plants " + e.getMessage());
            }
        }
    }

    /**
     * This method sets the image of the plant based on the plant type, pot type, and level.
     * It calls the appropriate method based on the plant type to get the image.
     *
     * @param plant The plant object to get the image for.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    public void setPlantImage(Plant plant) {
        PlantTypes plantType = plant.getType();
        PotType potType = plant.getPotType();
        int levelCategory = getLevelCategory(plant.getLevel());
        String imagePath = null;
        switch (plantType) {
            case CACTUS -> imagePath = imageController.getCactusPotImagePath(potType, levelCategory);
            case MONSTERA -> imagePath = imageController.getMonsteraPotImagePath(potType, levelCategory);
            case PUMPKIN -> imagePath = imageController.getPumpkinPotImagePath(potType, levelCategory);
            case SNAKEPLANT -> imagePath = imageController.getSnakePlantPotImagePath(potType, levelCategory);
            case SUNFLOWER -> imagePath = imageController.getSunflowerPotImagePath(potType, levelCategory);
            default -> System.out.println("Invalid plant type");
        }
        if (imagePath != null) {
            plant.setImagePath(imagePath);
        }
    }


    /**
     * Sets the image path for the given legendary plant based on its type, pot type, and a predefined level category.
     *
     * @param plant The legendary plant for which the image path is to be set.
     * @author Akmal Safi
     * @author Yrja Mai Hoang
     */
    public void setPlantImage(LegendaryPlant plant) {
        PlantTypes plantType = plant.getType();
        PotType potType = plant.getPotType();
        int levelCategory = 5;
        String imagePath = null;
        switch (plantType) {
            case CACTUS -> imagePath = imageController.getCactusPotImagePath(potType, levelCategory);
            case MONSTERA -> imagePath = imageController.getMonsteraPotImagePath(potType, levelCategory);
            case PUMPKIN -> imagePath = imageController.getPumpkinPotImagePath(potType, levelCategory);
            case SNAKEPLANT -> imagePath = imageController.getSnakePlantPotImagePath(potType, levelCategory);
            case SUNFLOWER -> imagePath = imageController.getSunflowerPotImagePath(potType, levelCategory);
            default -> System.out.println("Invalid plant type");
        }
        if (imagePath != null) {
            plant.setImagePath(imagePath);
        }
    }


    /**
     * This method returns the level of a plant in relation to the images.
     * Plant level is divided into 4 categories, each corresponding to a different image.
     *
     * @param level The level of the plant
     * @return The level category of the plant, from 1 to 4, based on the plant's level
     * @author Yrja Mai Hoang
     */
    public int getLevelCategory(int level) {
        if (level < 25) {
            return 1;
        } else if (level < 50) {
            return 2;
        } else if (level < 75) {
            return 3;
        } else if (level < 100) {
            return 4;
        }
        return 0;
    }

    public ArrayList<LegendaryPlant> getLegendaryPlants() {
        return legendaryPlants;
    }

    /**
     * Method to discard the first plant
     *
     * @author Akmal Safi
     * @author Yrja Mai Hoang
     */
    public void discardPlant1() {
        deleteGrowingPlant(0);
    }

    /**
     * Method to discard the second plant
     *
     * @author Akmal Safi
     * @author Yrja Mai Hoang
     */
    public void discardPlant2() {
        deleteGrowingPlant(1);
    }

    /**
     * Method to discard the third plant
     *
     * @author Akmal Safi
     * @author Yrja Mai Hoang
     */
    public void discardPlant3() {
        deleteGrowingPlant(2);
    }

    /**
     * Sets the pot type of all growing plants to Hello Kitty
     *
     * @author Yrja Mai Hoang
     */
    public void setPotHelloKitty() {
        for (Plant growingPlant : growingPlants) {
            if (growingPlant != null) {
                growingPlant.setPotType(PotType.HelloKitty);
            }
        }
        System.out.println("Hello Kitty");
    }

    /**
     * Sets the pot type of all growing plants to Mort
     *
     * @author Yrja Mai Hoang
     */
    public void setPotMort() {
        for (Plant growingPlant : growingPlants) {
            if (growingPlant != null) {
                growingPlant.setPotType(PotType.Mort);
            }
        }
        System.out.println("Mort");
    }

    /**
     * Sets the pot type of all growing plants to Peter
     *
     * @author Yrja Mai Hoang
     */
    public void setPotPeter() {
        for (Plant growingPlant : growingPlants) {
            if (growingPlant != null) {
                growingPlant.setPotType(PotType.Peter);
            }
        }
        System.out.println("Peter");
    }

    /**
     * Sets the pot type of all growing plants Roblox
     *
     * @author Yrja Mai Hoang
     */
    public void setPotRoblox() {
        for (Plant growingPlant : growingPlants) {
            if (growingPlant != null) {
                growingPlant.setPotType(PotType.Roblox);
            }
        }
        System.out.println("Roblox");
    }

    /**
     * Sets the pot type of all growing plants to Smile
     *
     * @author Yrja Mai Hoang
     */
    public void setPotSmile() {
        for (Plant growingPlant : growingPlants) {
            if (growingPlant != null) {
                growingPlant.setPotType(PotType.Smile);
            }
        }
        System.out.println("Smile");
    }

    /**
     * Sets the pot type of all growing plants to Sponge
     *
     * @author Yrja Mai Hoang
     */
    public void setPotSponge() {
        for (Plant growingPlant : growingPlants) {
            if (growingPlant != null) {
                growingPlant.setPotType(PotType.Sponge);
            }
        }
        System.out.println("Sponge");
    }
}