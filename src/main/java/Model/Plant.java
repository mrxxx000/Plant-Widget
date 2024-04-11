package Model;

import javafx.scene.image.Image;

public class Plant {
    private String name;
    private int level;
    private double healthLevel; //Max 1.0
    private double waterLevel; //Max 1.0
    private Image image; //ImageIcon not available?
    private PlantTypes type;


    public Plant(PlantTypes type) {
        setWaterLevel(1.0);
        setHealthLevel(1.0);
        setLevel(0);
        //setImage(); //TODO Set the image to be the SEED image, regardless of plant type
    }

    public void decreaseWaterOverTime(int minutesElapsed) {
        double waterLossPerMinutes = 10.0 / 100.0;

        double waterLoss = waterLossPerMinutes * minutesElapsed;

        waterLevel -= waterLoss;

        if (waterLevel < 0) {
            waterLevel = 0;
        }
    }

    public void waterThePlant() {
        waterLevel = waterLevel + 0.2;
        if (waterLevel > 1.0) {
            waterLevel = 1.0;
        }
    }

    public void decreaseHealth() {
        healthLevel = healthLevel - 0.2;
        if (healthLevel <= 0.0) {
            // TODO the plant is now dead, implement the logic needed.
        }
    }

    public void skipDayWater() {
        waterLevel = waterLevel - 0.2;
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

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
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
    }
}
