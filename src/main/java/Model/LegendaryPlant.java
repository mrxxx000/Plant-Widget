package Model;

import javafx.scene.image.Image;
import java.io.Serializable;

/**
 * This is pretty much a static object. It should never be changed after it is created unless it is being removed.
 */
public class LegendaryPlant implements Serializable {
    private String name;
    private PlantTypes type;
    private Image image;
    public LegendaryPlant(){

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
