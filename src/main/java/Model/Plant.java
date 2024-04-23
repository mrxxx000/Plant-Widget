package Model;

import javafx.scene.image.Image;
import java.io.Serializable;
import java.time.LocalDate;

public class Plant implements Serializable {
    private String name;
    private int level;
    private double healthLevel; //Max 1.0
    private double waterLevel; //Max 1.0
    private Image image; //ImageIcon not available?
    private PlantTypes type;
    private int levelUpCountdown = 3; // once counter hits 0, plant levels up
    private LocalDate datePlanted;


    public Plant(PlantTypes type) {
        datePlanted = LocalDate.now();
        this.type = type;
        setWaterLevel(1.0);
        setHealthLevel(1.0);
        //setImage(); //TODO Set the image to be the SEED image, regardless of plant type
    }

    /**
     * Method decreases the water level of the plant over time based on its specific watering needs.
     * The method calculates the decrease in water level per hour depending on the plant.
     * Method then decreases the water level based on the elapsed hours and watering needs.
     * It ensures that the water level doesn't go below 0.0 and
     * decreases the health if the water level becomes critical.
     * @param hoursElapsed
     * @param plant
     */
    //Akmal Safi
    public void decreaseWaterOverTime(int hoursElapsed, Plant plant) {
        // Calculate the water loss rate based on the plant type
        double waterLossPerHours = 0.0;

        switch (type){
            case CACTUS:
                //Water bar goes from full to empty after 5 days (5 * 24 = 120 hours
                waterLossPerHours = 1.0/120.0;
                break;
            // Water bar goes from full to empty after 3 days (3 * 24 = 72 hours)
            case PUMPKIN:
                waterLossPerHours = 1.0/72.0;
                break;
            // Water bar goes from full to empty after 4 days (4 * 24 = 96 hours)
            case SNAKEPLANT:
                waterLossPerHours = 1.0/96.0;
                break;
            // Water bar goes from full to empty after 1 day (1 * 24 = 24 hours)
            case MONSTERA:
                waterLossPerHours = 1.0/24.0;
                break;
            // Water bar goes from full to empty after 2 days (2 * 24 = 48 hours)
            case SUNFLOWER:
                waterLossPerHours = 1.0/48.0;
                break;
        }

        // Decrease water level based on elapsed hours and watering needs
        waterLevel -= waterLossPerHours * hoursElapsed;

        // Ensure water level doesn't go below 0
        if (waterLevel < 0.0) {
            waterLevel = 0.0;
        }

        // Check if the plant's water level has reached critical level
        if (waterLevel<= 0.0){
            decreaseHealth(); // Decrease health if water level is critical
        }


    }

    public boolean waterThePlant() {
        waterLevel = waterLevel + 0.2;
        // if we have filled the water bar, decrement the countdown
        if (waterLevel == 1.0) {
             return levelUpCountdown();
        }
        return false;
    }

    public void decreaseHealth() {
        healthLevel = healthLevel - 0.2;
        if (healthLevel <= 0.0) {
            // TODO the plant is now dead, implement the logic needed.
        }
    }

    public void skipDayWater() {
        this.waterLevel = waterLevel - 0.2;
        if (waterLevel <= 0.0) {
            decreaseHealth();
        }
    }

    public void increaseHealth() {
        healthLevel = healthLevel + 0.2;
        if(healthLevel > 1.0) {
            healthLevel = 1.0;
        }
    }

    public boolean levelUpCountdown() {
        levelUpCountdown--;
        if(levelUpCountdown == 0) {
            levelUpCountdown = 3;
            return true;
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setLevelSkip() {
        this.level++;
    }
    public int getLevel() {

        return this.level;
    }
    public void setHealthLevel(double healthLevel) {
        this.healthLevel = healthLevel;
    }
    public double getHealthLevel() {
        return healthLevel;
    }
    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }
    public double getWaterLevel() {
        return waterLevel;
    }
    public void setType(PlantTypes type) {
        this.type = type;
    }
    public PlantTypes getType() {
        return type;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public Image getImage() {
        return image;
    }
    public void incrementLevel() {
        this.level = level++;
        setHealthLevel(1.0);
        setWaterLevel(1.0);
        //TODO instead of calling this, call the LevelUp method in PlantController
    }
}
