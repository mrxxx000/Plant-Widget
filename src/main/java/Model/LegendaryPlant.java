package Model;

import javafx.scene.image.Image;
import java.io.Serializable;

/**
 * This class is used to create a legendary plant object.
 * It contains the name, type and image of the legendary plant.
 * A Legendary plant is static, in the sense that it does not need maintenance.
 *
 * @author Yrja Mai Hoang
 */
public class LegendaryPlant implements Serializable {
    private String name;
    private PlantTypes type;
    private Image image;
    private PotType potType;

    public LegendaryPlant() {

    }

    public void setImage(Image image) {
        this.image = image;
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

    public Image getImage() {
        return image;
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
