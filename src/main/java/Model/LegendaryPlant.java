package Model;

import javafx.scene.image.Image;
import java.io.Serializable;

public class LegendaryPlant implements Serializable {
    private String name;
    private PlantTypes type;
    private String imagePath; // Store the image path instead of the Image object
    private transient Image image; // Transient to avoid serialization
    private PotType potType;

    public LegendaryPlant() {}

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        this.image = new Image(getClass().getResourceAsStream(imagePath));
    }

    public String getImagePath() {
        return imagePath;
    }

    public Image getImage() {
        if (image == null && imagePath != null) {
            image = new Image(getClass().getResourceAsStream(imagePath));
        }
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(PlantTypes type) {
        this.type = type;
    }

    public void setPotType(PotType potType) {
        this.potType = potType;
    }

    public String getName() {
        return name;
    }

    public PlantTypes getType() {
        return type;
    }

    public PotType getPotType() {
        return potType;
    }
}
