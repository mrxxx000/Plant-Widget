package Controller;

import Model.LegendaryPlant;
import Model.Plant;
import Model.PlantTypes;
import View.MainBoundary;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.util.Duration;

import javax.imageio.stream.ImageInputStream;
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
    private Plant plant;
    private DoubleProperty waterLevelProperty;
    private Timeline timeline;
    private LocalDate dateNow;
    private LocalDate lastDateSaved;
    private static PlantController instance = new PlantController();


    public PlantController() {
        growingPlants = new Plant[3]; // allows the user to have MAX 3 growing plants at a time
        legendaryPlants = new ArrayList<>();
        initializeWaterLevelProperty();

        timeTrackReader();

        // This is just for testing purposes can remove later
        Plant catPlant = new Plant(PlantTypes.PUMPKIN);
        InputStream inputStream = getClass().getResourceAsStream("/images/testCat.jpg");
        Image image = new Image(inputStream);
        catPlant.setImage(image);
        //growingPlants[1] = catPlant;
    }

    /**
     * This method returns the array of growing plants.
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
     * @author Akmal Safi & Emre Mengütay
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
     * @Author Emre Mengütay
     */
    public void startTheTimer() {
        timeline.play();
    }
    /**
     * This method stops the timer for updating water levels.
     * Stops the timeline to pause the periodic updates of water levels for growing plants.
     * @Author Emre Mengütay
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
     * @Author Akmal Safi
     */
    public void startTimer() {

        timeline.play();
    }

    /**
     *
     * @return : the water level property
     * @author Akmal Safi
     */
    public DoubleProperty waterLevelProperty() {
        return waterLevelProperty;
    }

    /**
     * This method checks if the growingPlants array is full.
     * Returns true if there is space, false if it is full.
     * @return returns true if there is an empty spot, false if array is full.
     * @author Yrja Mai Hoang
     */
    public boolean checkForSpace() {
        for (int i = 0; i < growingPlants.length; i++) {
            if (growingPlants[i] == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for returning the specific plant controller instance, part of the singleton pattern.
     * @return : This specific plant controller instance
     * @author Emre Mengütay, does not say correct on Github.
     */
    public static PlantController getInstance(){
        return instance;
    }
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
     * @param plant Plant object used to create a Legendary Plant
     * @author Yrja Mai Hoang
     */
    public void createLegendary(Plant plant) {
        LegendaryPlant legendaryPlant = new LegendaryPlant();
        legendaryPlant.setName(plant.getName());
        PlantTypes type = plant.getType();
        legendaryPlant.setTypes(type);
        if (type == PlantTypes.CACTUS) {
            //legendaryPlant.setImage(image);
        } else if (type == PlantTypes.PUMPKIN) {
            //legendaryPlant.setImage(image);
        } else if (type == PlantTypes.MONSTERA) {
            //legendaryPlant.setImage(image);
        } else if (type == PlantTypes.SUNFLOWER) {
            //legendaryPlant.setImage(image);
        } else if (type == PlantTypes.SNAKEPLANT) {
            //legendaryPlant.setImage(image);
        }
        legendaryPlants.add(legendaryPlant);
    }

    /**
     * This method attempts to delete a plant from the growingPlants list.
     * @param plantIndex index to find the relevant plant
     * @Author Emre Mengutay and Yrja Mai Hoang and Akmal Safi
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
     * @param index index to find the relevant plant.
     * @author Yrja Mai Hoang and Emre
     */
    public void waterPlant(int index) {
        if (growingPlants[index] == null) {
            System.out.println("No plant found at index " + index);
            return;// Exit the method if the plant is null
        }
        if(this.growingPlants[index].getWaterLevel() >= 1.0) {
            //if the water is full already, lower health
            if(growingPlants[index].getHealthLevel()>0) {
                MainBoundary.getInstance().getMusic().healthSound();
                growingPlants[index].decreaseHealth();

            }else{
                killPlant(index);
            }
        }
        else if(growingPlants[index].getWaterLevel() < 1.0){
            //fill the water level by x amount
            boolean shouldItLevelUp =growingPlants[index].waterThePlant();
            if(growingPlants[index].getHealthLevel() != 1.0) {
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
     * @author Emre Mengütay
     */
    public void killPlant(int index){
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
     * @author Yrja Mai Hoang
     */
    public double updateWaterBarGUI(int index) {
        return growingPlants[index].getWaterLevel();
    }

    /**
     * This method fetches the plant's health level and sends the double to the GUI.
     * @author Yrja Mai Hoang
     */
    public double updateHealthBarGUI(int index) {
        return growingPlants[index].getHealthLevel();
    }

    public double plantGetWaterLevel(){
        return plant.getWaterLevel();
    }

    /**
     * This method returns the plant at the specified index.
     * @param index The index of the plant to return
     * @return The plant at the specified index, or null if no plant is found
     * @author Yrja Mai Hoang
     */
    public Plant getPlant(int index){
        if(growingPlants[index] != null){
            return growingPlants[index];
        }
        return null;
    }

    public void skipDay(int index){
        if(growingPlants[index] != null) {
            growingPlants[index].skipDayWater();
            growingPlants[index].setLevelSkip();
        }
    }

    /**
     * Sets the name of the plant at the specified index.
     * @param name The name to set
     * @param index The index of the plant to set the name for
     * @author Yrja Mai Hoang
     */
    public void setPlantName(String name, int index) {
        growingPlants[index].setName(name);
    }


    /**
     * This keeps track of the time the plant has been alive. It saves the date when the plant was last saved.
     * @author Emre Mengütay
     */
    public void timeTrackWriter() { // need to specifgy how we write the progress for three plants
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("dd/MM-yy");

        System.out.println("The date is: " + formatedDate.format(date));

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("saveFile.txt", false))) {

            for(int i = 0; i<growingPlants.length; i++) {
                if(growingPlants[i] != null) {
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
                    for(int i = 0; i<growingPlants.length;i++) {
                        if(i==0 && growingPlants[i] != null) {
                            int daysAlive = Integer.parseInt(daysAliveStr);
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM-yy");
                            LocalDate lastSavedDate = LocalDate.parse(lastSavedDateStr, formatter);
                            dateNow = LocalDate.now();

                            long daysDifference = ChronoUnit.DAYS.between(lastSavedDate, dateNow);

                            growingPlants[i].setLevel((int) (daysAlive + daysDifference));
                            double waterLoss = daysDifference * 0.3;

                            double newWaterLevel = growingPlants[i].getWaterLevel() - waterLoss;
                            growingPlants[i].setWaterLevel(newWaterLevel);                 }

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
     * @author Akmal Safi
     * @author Emre Mengutay
     */
    public void SavePlantToFile() {
        String filename = "src/main/resources/SaveFile/PlantSaveFile.dat";
        File file = new File(filename);
        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println("Failed to create file " + e.getMessage());
            }
        }
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(filename))){
            for (Plant plant: growingPlants){
                if (plant!= null){
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
        }catch (IOException e){
            System.out.println("Failed to save plants" + e.getMessage());
        }
    }

    /**
     * Loads plant data from a file and populates the growingPlants array and legendaryPlants set.
     * If the file does not exist, it is created.
     * For each plant in the file, its details including water level,
     * health level, and level are read and assigned.
     * Legendary plants are also loaded and added to the legendaryPlants set.
     * @author Akmal Safi
     * @author Emre Mengutay
     */
    public void LoadPlantsFromFile(){
        String filename = "src/main/resources/SaveFile/PlantSaveFile.dat";
        File file = new File(filename);
        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println("Failed to create file " + e.getMessage());
            }
        }else {
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
                } catch (EOFException e) {
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

    //this is to set the images it's not the best but it was either this or saving the pixels of the picture. // gg (Emre Mengutay);
    /**
     * @author Mojtaba and some parts by Emre
     */
    public void setPlantImage(Plant plant){
        if(plant.getLevel() < 25) {
            if(plant.getType() == PlantTypes.CACTUS) {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel1/cactuslevel1mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.PUMPKIN) {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel1/pumpkinlevel1mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.MONSTERA) {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel1/monsteralevel1mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SUNFLOWER) {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel1/sunflowerlevel1mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SNAKEPLANT) {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel1/snakeplantlevel1mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            }
        }
        if(plant.getLevel() < 50 && plant.getLevel() >= 25){
            if(plant.getType() == PlantTypes.CACTUS) {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel2/cactuslevel2mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.PUMPKIN) {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel2/pumpkinlevel2mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.MONSTERA) {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel2/monsteralevel2mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SUNFLOWER) {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel2/sunflowerlevel2mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SNAKEPLANT) {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel2/snakeplantlevel2mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            }
        }
        if(plant.getLevel() < 75 && plant.getLevel() >= 50){
            if(plant.getType() == PlantTypes.CACTUS) {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel3/cactuslevel3mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.PUMPKIN) {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel3/pumpkinlevel3mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.MONSTERA) {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel3/monsteralevel3mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SUNFLOWER) {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel3/sunflowerlevel3mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SNAKEPLANT) {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel3/snakeplantlevel3mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            }
        }

        if(plant.getLevel() < 100 && plant.getLevel() >= 75){
            if(plant.getType() == PlantTypes.CACTUS) {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel4/cactuslevel4mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.PUMPKIN) {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel4/pumpkinlevel4mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.MONSTERA) {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel4/monsteralevel4mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SUNFLOWER) {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel4/sunflowerlevel4mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SNAKEPLANT) {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel4/snakeplantlevel4mort.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            }
        }
    }

    public ArrayList<LegendaryPlant> getLegendaryPlants() {
        return legendaryPlants;
    }

    /**
     * Method to discard the first plant
     * @author Akmal Safi
     * @author Yrja Mai Hoang
     */
    public void discardPlant1 () {
      //  growingPlants[0] = null;
        deleteGrowingPlant(0);
    }

    /**
     * Method to discard the second plant
     * @author Akmal Safi
     * @author Yrja Mai Hoang
     */
    public void discardPlant2 () {
      //  growingPlants[1] = null;
        deleteGrowingPlant(1);
    }

    /**
     * Method to discard the third plant
     * @author Akmal Safi
     * @author Yrja Mai Hoang
     */
    public void discardPlant3 () {
       // growingPlants[2] = null;
        deleteGrowingPlant(2);
    }
}



