package Model;

import javafx.scene.image.Image;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * This is the Plant class. It is the main object that the user interacts with.
 * It has a name, level, health level, water level, image, type, level up countdown, and date planted.
 * The plant has methods to decrease water over time, water the plant, decrease health, skip a day of watering,
 * increase health, and level up the plant.
 * @author Yrja Mai Hoang and Akmal Safi
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

    /**
     * Constructor for Plant class. It sets the date planted to the current date and the water and health levels to 1.0.
     * @param type The type of plant that is being created.
     */
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
     * @author Akmal Safi
     * @param hoursElapsed
     * @param plant
     */
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

    /**
     * Method waters the plant by increasing the water level by 0.2.
     * If the water level reaches 1.0, the method calls the levelUpCountdown method.(Might not use this anymore)
     * @author Yrja Mai Hoang
     * @return boolean value that indicates if the plant has leveled up
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
     * Method decreases the health level of the plant by 0.2.
     * If the health level reaches 0.0, the plant is considered dead and the method calls the logic needed for that.
     * @author Yrja Mai Hoang
     */
    public void decreaseHealth() {
        healthLevel = healthLevel - 0.2;
        if (healthLevel <= 0.0) {
            // TODO the plant is now dead, implement the logic needed.
        }
    }

    /**
     * Method skips a day of watering by decreasing the water level by 0.2.
     * If the water level reaches 0.0, the method calls the decreaseHealth method.
     * @author Yrja Mai Hoang
     */
    public void skipDayWater() {
        this.waterLevel = waterLevel - 0.2;
        if (waterLevel <= 0.0) {
            decreaseHealth();
        }
    }

    /**
     * Method increases the health level of the plant by 0.2.
     * If the health level reaches 1.0, the method sets the health level to 1.0 to make sure it never goes above the max.
     * @author Yrja Mai Hoang
     */
    public void increaseHealth() {
        healthLevel = healthLevel + 0.2;
        if(healthLevel > 1.0) {
            healthLevel = 1.0;
        }
    }

    /**
     * Decrements the countdown for leveling up the plant.
     * Once the countdown hits zero, the plant levels up and the method returns true.
     * It then sets the health and water levels to 1.0 and resets the level up countdown to 3.
     * (Might not use this anymore)
     * @author Yrja Mai Hoang
     * @return boolean value that indicates if the plant has leveled up.
     */
    public boolean levelUpCountdown() {
        levelUpCountdown--;
        if(levelUpCountdown == 0) {
            levelUpCountdown = 3;
            return true;
        }
        return false;
    }

    /**
     * Method returns the date the plant was planted.
     * @author Yrja Mai Hoang
     * @param name The name of the plant.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method returns the name of the plant.
     * @author Yrja Mai Hoang
     * @return The name of the plant.
     */
    public String getName() {
        return name;
    }

    /**
     * Method sets the level of the plant.
     * @author Yrja Mai Hoang
     * @param level The level of the plant.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Method increases the level of the plant by one and prints out the new level.
     */
    public void setLevelSkip() {
        this.level++;
        System.out.println("Level is now: " + this.level);
    }

    /**
     * Method returns the level of the plant.
     * @return The level of the plant.
     */
    public int getLevel() {

        return this.level;
    }

    /**
     * Method sets the health level of the plant.
     * @author Yrja Mai Hoang
     * @param healthLevel The health level of the plant.
     */
    public void setHealthLevel(double healthLevel) {
        this.healthLevel = healthLevel;
    }

    /**
     * Method returns the health level of the plant.
     * @author Yrja Mai Hoang
     * @return The health level of the plant.
     */
    public double getHealthLevel() {
        return healthLevel;
    }

    /**
     * Method sets the water level of the plant.
     * @author Yrja Mai Hoang
     * @param waterLevel The water level of the plant.
     */
    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    /**
     * Method returns the water level of the plant.
     * @author Yrja Mai Hoang
     * @return The water level of the plant.
     */
    public double getWaterLevel() {
        return waterLevel;
    }

    /**
     * Method sets the date the plant was planted.
     * @author Yrja Mai Hoang
     * @param type The type of plant that was planted.
     */
    public void setType(PlantTypes type) {
        this.type = type;
    }

    /**
     * Method returns the type of plant that was planted.
     * @author Yrja Mai Hoang
     * @return The type of plant that was planted.
     */
    public PlantTypes getType() {
        return type;
    }

    /**
     * Method sets the date the plant was planted.
     * @author Yrja Mai Hoang
     * @param image The image of the plant.
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Method returns the image of the plant.
     * @author Yrja Mai Hoang
     * @return The image of the plant.
     */
    public Image getImage() {
        return image;
    }

    /**
     * This method increments the level of the plant by one and sets the health and water levels to 1.0.
     * (Might not use this anymore)
     * @author Yrja Mai Hoang
     */
    public void incrementLevel() {
        this.level = level++;
        setHealthLevel(1.0);
        setWaterLevel(1.0);
        //TODO instead of calling this, call the LevelUp method in PlantController
    }
}
