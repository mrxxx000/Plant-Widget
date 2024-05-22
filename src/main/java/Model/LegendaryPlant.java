package Model;

import javafx.scene.image.Image;
import java.io.Serializable;

/**
 * This class represents a legendary plant in the game.
 * @author Akmal Safi
 * @author Yrja Mai Hoang
 */

public class LegendaryPlant implements Serializable {
    private String name;
    private PlantTypes type;
    private String imagePath; // Store the image path instead of the Image object
    private transient Image image; // Transient to avoid serialization
    private PotType potType;

    /**
     * Default constructor for the LegendaryPlant class.
     * @author Akmal Safi
     */
    public LegendaryPlant() {}

    /**
     * Sets the image path and initializes the image using the provided image path.
     *
     * @author Akmal Safi
     * @param imagePath The path of the image resource.
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        this.image = new Image(getClass().getResourceAsStream(imagePath));
    }

    /**
     * Returns the path of the image resource.
     * @author Akmal Safi
     * @return The path of the image resource.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Returns the image. If the image is not already initialized and the image path is set, it initializes the image using the image path.
     * @author Akmal Safi
     * @return The image object.
     */
    public Image getImage() {
        if (image == null && imagePath != null) {
            image = new Image(getClass().getResourceAsStream(imagePath));
        }
        return image;
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
     * Sets the pot type of the legendary plant.
     * @author Yrja Mai Hoang
     * @param potType The pot type of the legendary plant.
     */
    public void setPotType(PotType potType) {
        this.potType = potType;
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

    /**
     * Returns the pot type of the legendary plant.
     * @author Yrja Mai Hoang
     * @return The pot type of the legendary plant.
     */
    public PotType getPotType() {
        return potType;
    }
}
