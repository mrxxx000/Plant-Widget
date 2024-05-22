package Model;

import Controller.PlantController;
import javafx.scene.image.Image;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class is used to create a plant object.
 */

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
    private PotType potType;

    public Plant(PlantTypes type) {
        datePlanted = LocalDate.now();
        this.type = type;
        setWaterLevel(1.0);
        setHealthLevel(1.0);
        this.potType = PotType.Mort;
        //setImage(); //TODO Set the image to be the SEED image, regardless of plant type
    }

    /**
     * Decreases the water level of the plant over time based on its watering needs.
     * Calculates the water loss rate for the plant type and decreases the water level
     * accordingly for the specified duration. Ensures the water level doesn't go below
     * 0 and decreases the plant's health if the water level becomes critical.
     *
     * @param secondsElapsed The duration in seconds for which the water level should decrease
     * @author Akmal Safi
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
     * Method retrieves the watering interval for the specified plant type.
     * Returns the watering interval in seconds based on the plant type.
     * If no specific interval is defined for the type, returns the default interval.
     *
     * @param type The type of plant to retrieve the watering interval for
     * @return The watering interval for the specified plant type in seconds
     * @author Akmal Safi
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

    /**
     * Method to water the plant. Increases the water level of the plant by 0.2.
     * If the water level reaches 1.0, the plant levels up and the level up countdown
     * @return true if the plant levels up, false otherwise
     * @author Yrja Mai Hoang
     */
    public boolean waterThePlant() {
        waterLevel = waterLevel + 0.2;
        // if we have filled the water bar, decrement the countdown
        if (waterLevel == 1.0) {
            return levelUpCountdown();
        }
        return false;
    }

    /**
     * Decreases the health level of the plant.
     * If the health level reaches 0.0, the plant is dead.
     * @author Yrja Mai Hoang
     */
    public void decreaseHealth() {
        healthLevel = healthLevel - 0.3;
        if (healthLevel <= 0.0) {
            // TODO the plant is now dead, implement the logic needed.
        }
    }

    /**
     * Decreases the water level of the plant by 0.2.
     * If the water level reaches 0.0, the plant's health is decreased.
     * @author Yrja Mai Hoang
     */
    public void skipDayWater() {
        this.waterLevel = waterLevel - 0.2;
        if (waterLevel <= 0.0) {
            decreaseHealth();
        }
    }

    /**
     * Increases the health level of the plant by 0.1.
     * If the health level reaches 1.0, it is set to 1.0 so it doesn't go above the max.
     * @author Yrja Mai Hoang
     */
    public void increaseHealth() {
        healthLevel = healthLevel + 0.1;
        if (healthLevel > 1.0) {
            healthLevel = 1.0;
        }
    }

    /**
     * This method keeps track of the countdown for the plant to level up.
     * @return true if the plant levels up, false otherwise
     * @author Yrja Mai Hoang
     */
    public boolean levelUpCountdown() {
        levelUpCountdown--;
        if (levelUpCountdown == 0) {
            levelUpCountdown = 3;
            return true;
        }
        return false;
    }

    /**
     * This method sets the image of the plant based on the plant type.
     * @param name The name of the plant
     * @author Yrja Mai Hoang
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the name of the plant.
     * @return The name of the plant
     * @author Yrja Mai Hoang
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the level of the plant.
     * @param level The level of the plant
     * @author Yrja Mai Hoang
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * This method increases the level of the plant by 1.
     */
    public void setLevelSkip() {
        this.level++;
        System.out.println("Level is now: " + this.level);
    }

    /**
     * This method returns the level of the plant.
     * @return The level of the plant
     * @author Yrja Mai Hoang
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * This method sets the health level of the plant.
     * @param healthLevel the health level that should be set for the plant
     * @author Yrja Mai Hoang
     */
    public void setHealthLevel(double healthLevel) {
        this.healthLevel = healthLevel;
    }

    /**
     * This method returns the health level of the plant.
     * @return The health level of the plant
     * @author Yrja Mai Hoang
     */
    public double getHealthLevel() {
        return healthLevel;
    }

    /**
     * This method sets the water level of the plant.
     * @param waterLevel the water level that should be set for the plant
     * @author Yrja Mai Hoang
     */
    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    /**
     * This method returns the water level of the plant.
     * @return The water level of the plant
     * @author Yrja Mai Hoang
     */
    public double getWaterLevel() {
        return waterLevel;
    }

    /**
     * This method sets the type of the plant.
     * @param type The type of the plant that should be set for the plant object
     * @author Yrja Mai Hoang
     */
    public void setType(PlantTypes type) {
        this.type = type;
    }

    /**
     * This method returns the type of the plant.
     * @return The type of the plant object
     * @author Yrja Mai Hoang
     */
    public PlantTypes getType() {
        return type;
    }

    /**
     * This method sets the image of the plant.
     * @param image The image that should be set for the plant object
     * @author Yrja Mai Hoang
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * This method returns the image of the plant.
     * @return The image of the plant object
     * @author Yrja Mai Hoang
     */
    public Image getImage() {
        return image;
    }

    /**
     * This method increments the level of the plant by 1.
     * It also resets the health and water level of the plant to 1.0.
     * @author Yrja Mai Hoang
     */
    public void incrementLevel() {
        this.level = level++;
        setHealthLevel(1.0);
        setWaterLevel(1.0);
        //Instead of calling this, call the LevelUp method in PlantController
    }

    /**
     * This method sets the pot type of the plant.
     * @param potType The pot type that should be set for the plant object
     * @author Yrja Mai Hoang
     */
    public void setPotType(PotType potType) {
        this.potType = potType;
    }

    /**
     * This method returns the pot type of the plant.
     * @return The pot type of the plant object
     * @author Yrja Mai Hoang
     */
    public PotType getPotType() {
        return potType;
    }
}
