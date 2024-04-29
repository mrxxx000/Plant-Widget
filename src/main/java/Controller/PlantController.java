
package Controller;

import Model.LegendaryPlant;
import Model.Plant;
import Model.PlantTypes;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

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

    public Plant[] getGrowingPlants() {
        return growingPlants;
    }

    /**
     * Method to initialize water level property
     * // Creates a new SimpleDoubleProperty object
     * Starts the timer for updating water levels
     */
    //Akmal Safi
    public void initializeWaterLevelProperty() {
        waterLevelProperty = new SimpleDoubleProperty();
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            for (int i = 0; i < growingPlants.length; i++) {
                Plant growinPlant = growingPlants[i];
                if (growinPlant != null) {
                    growinPlant.decreaseWaterOverTime(1, growinPlant);
                    waterLevelProperty.set(growinPlant.getWaterLevel());
                    updateWaterBarGUI(i);
                    updateHealthBarGUI(i); // Update health bar GUI
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        //startTimer();
    }

    public void startTheTimer() {
        timeline.play();
    }

    public void stopTheTimer() {
        timeline.stop();
    }

    /**
     * Method to start the timer for updating water levels
     * Loops through each element of the growingPlants array
     * to update water level property for each plant
     * Checks if the element is not null
     * Decreasing water level for the plant
     */
    //Akmal Safi
    public void startTimer() {

        timeline.play();
    }

    //Akmal Safi
    public DoubleProperty waterLevelProperty() {
        return waterLevelProperty;
    }

    /**
     * This method checks if the growingPlants array is full.
     * Returns true if there is space, false if it is full.
     *
     * @return returns true if there is an empty spot, false if array is full.
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
     * This method goes through the list to find the first empty spot.
     * Once found, it creates a new plant and adds it to the spot.
    // * @param type used to create the right type of plant
     */

    // TODO dont know if this is working correctly since when i plant a seed it plants 2 of them. it doesnt stop when it has already added one

    /**
     * Metod which get instance of the type of plant
     * @return : the typ of plant
     * Akmal Safi
     */
    public static PlantController getInstance(){
        return instance;
    }
    public void plantSeed(PlantTypes type, String name) {

        // TODO Get user input from GUI to know what enum type we need here
        for(int i = 0; i < growingPlants.length; i++) {
            if(growingPlants[i] == null) {
                growingPlants[i] = new Plant(type);
                if(name != null) {
                    growingPlants[i].setName(name);
                }
            }
        }
    }

    // TODO add here a method to create the plants we are going to have with all the constructors image name species etc

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
            String plantName = growingPlants[plantIndex].getName();
            System.out.println("Plant name: " + plantName);
            growingPlants[plantIndex] = null;
            for(int i =0; i < growingPlants.length;i++){
                if(growingPlants[i] != null){
                    System.out.println("Plant name: " + growingPlants[i].getName());
                }
            }

            //removePlantFromFile(plantName);
        }
    }

    public void removePlantFromFile(String plantName){
        File orgFile = new File("src/main/resources/SaveFile/PlantSaveFile.dat");
        File newFile = new File("src/main/resources/SaveFile/tempFile.dat");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(orgFile));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(newFile))) {

            Plant plant;

            while(true) {
                try {
                    plant = (Plant) ois.readObject();
                    System.out.println("Plant name: " + plant.getName());
                    if (!plant.getName().equals(plantName)) {
                        oos.writeObject(plant);
                        deleteGrowingPlant(0);
                        System.out.println("Plant removed from file: " + plant.getName());

                    }
                }catch (OptionalDataException e) {
                    if (e.eof) {
                        System.out.println("End of file reached.");
                    } else {
                        System.out.println("Primitive data: " + e.length);
                        e.printStackTrace();
                        break;
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error removing /disarding plant!");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error removing /disarding plant!");
            throw new RuntimeException(e);
        }

        if(!orgFile.delete()) {
            System.out.println("Failed to delete the original file!");
            return;
        }
        if(!newFile.renameTo(orgFile)) {
            System.out.println("Failed to rename the new file!");
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
        if(growingPlants[index].getWaterLevel() >= 1.0) {
            //if the water is full already, lower health
            growingPlants[index].decreaseHealth();
        } else {
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
        if(growingPlants[index] != null){
            return growingPlants[index];
        }
        return null;
    }
    public void skipDay(int index){
        growingPlants[index].skipDayWater();
        growingPlants[index].setLevelSkip();
    }
    public void setPlantName(String name, int index) {
        growingPlants[index].setName(name);
    }

    //Don't know why it says that I have written this one, might be because of me reseting the merge
    //That's my bad, but who ever has written this one just write your name here
    //Actually written by:
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

    //same goes with this one
    //Actually written by:

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
    //akmal safi & Emre Mengutay
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
            System.out.println("Plant info saved successfully");

        }catch (IOException e){
            System.out.println("Failed to save plants" + e.getMessage());
        }
    }
    //akmal safi & Emre Mengutay
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
                while (true) {
                    try {
                        Plant plant = (Plant) ois.readObject();
                        double waterLevel = ois.readDouble();
                        double healthLevel = ois.readDouble();
                        int level = ois.readInt();
                        if (plant != null) {
                            plant.setWaterLevel(waterLevel);
                            plant.setHealthLevel(healthLevel);
                            plant.setLevel(level);
                            setPlantImage(plant);
                            growingPlants[index++] = plant;
                        }
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (EOFException e) {
                e.printStackTrace();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Failed to load plants " + e.getMessage());
            }
        }
    }

    //this is to set the images it's not the best but it was either this or saving the pixels of the picture.
    public void setPlantImage(Plant plant){
        if(plant.getLevel() < 10) {
            if(plant.getType() == PlantTypes.CACTUS) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant1/testcatlevel1.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.PUMPKIN) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant2/testplantlevel1.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.MONSTERA) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant3/testplantlevel1.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SUNFLOWER) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant4/testplantlevel1.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SNAKEPLANT) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant5/testplantlevel1.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            }
        }
        if(plant.getLevel() < 20 && plant.getLevel() >= 10){
            if(plant.getType() == PlantTypes.CACTUS) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant1/testcatlevel2.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.PUMPKIN) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant2/testplantlevel2.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.MONSTERA) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant3/testplantlevel2.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SUNFLOWER) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant4/testplantlevel2.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SNAKEPLANT) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant5/testplantlevel2.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            }
        }
        if(plant.getLevel() < 30 && plant.getLevel() >= 20){
            if(plant.getType() == PlantTypes.CACTUS) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant1/testcatlevel3.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.PUMPKIN) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant2/testplantlevel3.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.MONSTERA) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant3/testplantlevel3.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SUNFLOWER) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant4/testplantlevel3.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            } else if (plant.getType() == PlantTypes.SNAKEPLANT) {
                InputStream inputStream = getClass().getResourceAsStream("/images/plant5/testplantlevel3.png");
                Image image = new Image(inputStream);
                plant.setImage(image);
            }
        }
    }


}



