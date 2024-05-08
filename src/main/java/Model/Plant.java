package Model;

import Controller.PlantController;
import javafx.scene.image.Image;
import kotlin.jvm.Transient;

import java.io.Serializable;
import java.time.LocalDate;

public class Plant implements Serializable {
    private String name;
    private int level;
    private double healthLevel; //Max 1.0
    private double waterLevel; //Max 1.0
    private transient Image image; // transient just means it doesnt get serialized when saving to dat file
    private PlantTypes type;
    private int levelUpCountdown = 3; // once counter hits 0, plant levels up
    private LocalDate datePlanted;
    private PlantController plantController;



    public Plant(PlantTypes type) {
        datePlanted = LocalDate.now();
        this.type = type;
        setWaterLevel(1.0);
        setHealthLevel(1.0);
        //setImage(); //TODO Set the image to be the SEED image, regardless of plant type
    }


    /**
     * Akmal Safi
     * Decreases the water level of the plant over time based on its watering needs.
     * Calculates the water loss rate for the plant type and decreases the water level
     * accordingly for the specified duration. Ensures the water level doesn't go below
     * 0 and decreases the plant's health if the water level becomes critical.
     *
     * @param secondsElapsed The duration in seconds for which the water level should decrease
     */

    public void decreaseWaterOverTime(int secondsElapsed) {
        double waterLossRate = 1.0 / (getWateringIntervalForPlantType(type) * 3600); // Convert hours to seconds

        // Decrease water level based on the calculated water loss rate and elapsed time
        waterLevel -= waterLossRate * secondsElapsed;

        // Ensure water level doesn't go below 0
        if (waterLevel < 0.0) {
            waterLevel = 0.0;
        }

        // Check if the plant's water level has reached critical level
        if (waterLevel <= 0.0) {
            decreaseHealth(); // Decrease health if water level is critical
        }
    }

    /**
     * Akmal Safi
     * Method retrieves the watering interval for the specified plant type.
     * Returns the watering interval in seconds based on the plant type.
     * If no specific interval is defined for the type, returns the default interval.
     *
     * @param type The type of plant to retrieve the watering interval for
     * @return The watering interval for the specified plant type in seconds
     */
    public double getWateringIntervalForPlantType(PlantTypes type) {
        switch (type) {
            // calculation: 3,6 = 0.001 so if you want 30sec the calculation will be
            // 30/3,6 which is 8,33 and then 8,33* 0,001 = 0,0083
            case CACTUS:
                return 0.0166; // Cactus water level will reach water level 0 in 20sec
            // in the future it will be 5 days according to req
            case PUMPKIN: // Pumpkin water level will reach water level 0 in 30sec
                // in the future it will be 3 days according to req
                return 0.0166;
            case SNAKEPLANT: // SnakePlant water level will reach water level 0 in 30sec
                // in the future it will be 4 days according to req
                return 0.0166;
            case MONSTERA: // Monstera water level will reach water level 0 in 60sec
                // in the future it will be 1 day according to req
                return 0.0083;
            case SUNFLOWER:
                return 0.0083; // Sunflower water level will reach water level 0 in 60sec
            // in the future it will be 2 days according to req
            default:
                return 1;
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
        healthLevel = healthLevel - 0.3;
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
        healthLevel = healthLevel + 0.1;
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
        System.out.println("Level is now: " + this.level);
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
