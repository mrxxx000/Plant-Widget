package Model;

import javafx.scene.image.Image;
import java.io.Serializable;

/**
 * This class is used to create a legendary plant object.
 * It contains the name, type, and image of the legendary plant.
 * This class is meant to be a static version of the Plant class, it's status never changes and needs no maintenance.
 * @author Yrja Mai Hoang
 */
public class LegendaryPlant implements Serializable {
    private String name;
    private PlantTypes type;
    private Image image;

    /**
     * Constructor for the LegendaryPlant class.
     * @author Yrja Mai Hoang
     * @param image The image of the legendary plant.
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Sets the name of the legendary plant.
     * @author Yrja Mai Hoang
     * @param name The name of the legendary plant.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the type of the legendary plant.
     * @author Yrja Mai Hoang
     * @param type The type of the legendary plant.
     */
    public void setTypes(PlantTypes type) {
        this.type = type;
    }

    /**
     * Returns the image of the legendary plant.
     * @author Yrja Mai Hoang
     * @return The image of the legendary plant.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Returns the name of the legendary plant.
     * @author Yrja Mai Hoang
     * @return The name of the legendary plant.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the legendary plant.
     * @author Yrja Mai Hoang
     * @return The type of the legendary plant.
     */
    public PlantTypes getType() {
        return type;
    }
}
