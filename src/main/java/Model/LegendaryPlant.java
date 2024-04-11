package Model;

import javafx.scene.image.Image;

public class LegendaryPlant {
    private String name;
    private PlantTypes type;
    private Image image;

    public void setImage(Image image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(PlantTypes type) {
        this.type = type;
    }
    public Image getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public PlantTypes getType() {
        return type;
    }
}
