package Model;

import javafx.scene.image.Image;

public class Plant {
    private String name;
    private int level;
    private double healthLevel;
    private double waterLevel;
    private Image image; //ImageIcon not available?
    private PlantTypes type;


    public Plant(PlantTypes type) {
        this.waterLevel = 100.0;
        this.healthLevel = 100.0;
        this.level = 0;
    }

    public void decreaseWaterOverTime(int minutesElapsed) { // I think maybe this should be done in the controller
        double waterLossPerMinutes = 10.0 / 100.0;

        double waterLoss = waterLossPerMinutes * minutesElapsed;

        waterLevel -= waterLoss;

        if (waterLevel < 0) {
            waterLevel = 0;
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
