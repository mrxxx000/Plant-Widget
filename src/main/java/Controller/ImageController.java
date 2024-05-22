package Controller;

import Model.PotType;
import javafx.scene.image.Image;
import java.io.InputStream;

/**
 * This class is responsible for the logic of what image to display based on plant type, pot type, and level.
 * It is used by the PlantController class and returns the image to be displayed in the GUI for the plant.
 * @author Yrja Mai Hoang
 */
public class ImageController {
    private PlantController plantController;

    /**
     * Constructor for ImageController
     * @param plantController PlantController object
     * @author Yrja Mai Hoang
     */
    public ImageController(PlantController plantController) {
        this.plantController = plantController;
    }

    /**
     * Returns the image of the Cactus based on the plant type and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int
     * @return Image object of the cactus plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     */
    public Image getCactusPotImage(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return setCactusImageMort(level);
            }
            case HelloKitty -> {
                return setCactusImageHelloKitty(level);
            }
            case Peter -> {
                return setCactusImagePeter(level);
            }
            case Roblox -> {
                return setCactusImageRoblox(level);
            }
            case Smile -> {
                return setCactusImageSmile(level);
            }
            case Sponge -> {
                return setCactusImageSponge(level);
            }
            default -> {
                System.out.println("Invalid pot type");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Mort pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    public Image setCactusImageMort(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel1/cactuslevel1mort.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel2/cactuslevel2mort.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel3/cactuslevel3mort.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel4/cactuslevel4mort.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    public Image setCactusImageHelloKitty(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel1/cactuslevel1hellokitty.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel2/cactuslevel2hellokitty.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel3/cactuslevel3hellokitty.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel4/cactuslevel4hellokitty.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    public Image setCactusImagePeter(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel1/cactuslevel1peter.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel2/cactuslevel2peter.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel3/cactuslevel3peter.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel4/cactuslevel4peter.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    public Image setCactusImageRoblox(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel1/cactuslevel1roblox.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel2/cactuslevel2roblox.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel3/cactuslevel3roblox.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel4/cactuslevel4roblox.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    public Image setCactusImageSmile(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel1/cactuslevel1smile.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel2/cactuslevel2smile.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel3/cactuslevel3smile.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel4/cactuslevel4smile.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Sponge pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    public Image setCactusImageSponge(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel1/cactuslevel1sponge.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel2/cactuslevel2sponge.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel3/cactuslevel3sponge.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/cactuslevel4/cactuslevel4sponge.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * Returns the image of the Monstera based on the plant type, pot type, and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int level category
     * @return Image object of the monstera plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     */
    public Image getMonsteraPotImage(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return setMonsteraImageMort(level);
            }
            case HelloKitty -> {
                return setMonsteraImageHelloKitty(level);
            }
            case Peter -> {
                return setMonsteraImagePeter(level);
            }
            case Roblox -> {
                return setMonsteraImageRoblox(level);
            }
            case Smile -> {
                return setMonsteraImageSmile(level);
            }
            case Sponge -> {
                return setMonsteraImageSponge(level);
            }
            default -> {
                System.out.println("Invalid pot type");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Mort pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setMonsteraImageSponge(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel1/monsteralevel1sponge.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel2/monsteralevel2sponge.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel3/monsteralevel3sponge.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel4/monsteralevel4sponge.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setMonsteraImageSmile(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel1/monsteralevel1smile.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel2/monsteralevel2smile.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel3/monsteralevel3smile.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel4/monsteralevel4smile.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setMonsteraImageRoblox(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel1/monsteralevel1roblox.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel2/monsteralevel2roblox.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel3/monsteralevel3roblox.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel4/monsteralevel4roblox.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setMonsteraImagePeter(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel1/monsteralevel1peter.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel2/monsteralevel2peter.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel3/monsteralevel3peter.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel4/monsteralevel4peter.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setMonsteraImageHelloKitty(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel1/monsteralevel1hellokitty.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel2/monsteralevel2hellokitty.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel3/monsteralevel3hellokitty.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel4/monsteralevel4hellokitty.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Mort pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setMonsteraImageMort(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel1/monsteralevel1mort.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel2/monsteralevel2mort.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel3/monsteralevel3mort.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/monsteralevel4/monsteralevel4mort.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * Returns the image of the Pumpkin based on the plant type, pot type, and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int level category
     * @return Image object of the snake plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     */
    public Image getPumpkinPotImage(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return setPumpkinImageMort(level);
            }
            case HelloKitty -> {
                return setPumpkinImageHelloKitty(level);
            }
            case Peter -> {
                return setPumpkinImagePeter(level);
            }
            case Roblox -> {
                return setPumpkinImageRoblox(level);
            }
            case Smile -> {
                return setPumpkinImageSmile(level);
            }
            case Sponge -> {
                return setPumpkinImageSponge(level);
            }
            default -> {
                System.out.println("Invalid pot type");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Mort pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setPumpkinImageMort(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel1/pumpkinlevel1mort.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel2/pumpkinlevel2mort.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel3/pumpkinlevel3mort.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel4/pumpkinlevel4mort.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setPumpkinImageHelloKitty(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel1/pumpkinlevel1hellokitty.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel2/pumpkinlevel2hellokitty.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel3/pumpkinlevel3hellokitty.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel4/pumpkinlevel4hellokitty.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setPumpkinImagePeter(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel1/pumpkinlevel1peter.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel2/pumpkinlevel2peter.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel3/pumpkinlevel3peter.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel4/pumpkinlevel4peter.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setPumpkinImageRoblox(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel1/pumpkinlevel1roblox.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel2/pumpkinlevel2roblox.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel3/pumpkinlevel3roblox.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel4/pumpkinlevel4roblox.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setPumpkinImageSmile(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel1/pumpkinlevel1smile.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel2/pumpkinlevel2smile.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel3/pumpkinlevel3smile.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel4/pumpkinlevel4smile.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Sponge pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setPumpkinImageSponge(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel1/pumpkinlevel1sponge.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel2/pumpkinlevel2sponge.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel3/pumpkinlevel3sponge.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/pumpkinlevel4/pumpkinlevel4sponge.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * Returns the image of the Snake Plant based on the plant type, pot type, and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int level category
     * @return Image object of the snake plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     */
    public Image getSnakePlantPotImage(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return setSnakePlantImageMort(level);
            }
            case HelloKitty -> {
                return setSnakePlantImageHelloKitty(level);
            }
            case Peter -> {
                return setSnakePlantImagePeter(level);
            }
            case Roblox -> {
                return setSnakePlantImageRoblox(level);
            }
            case Smile -> {
                return setSnakePlantImageSmile(level);
            }
            case Sponge -> {
                return setSnakePlantImageSponge(level);
            }
            default -> {
                System.out.println("Invalid pot type");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Mort pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSnakePlantImageMort(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel1/snakeplantlevel1mort.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel2/snakeplantlevel2mort.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel3/snakeplantlevel3mort.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel4/snakeplantlevel4mort.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSnakePlantImageHelloKitty(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel1/snakeplantlevel1hellokitty.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel2/snakeplantlevel2hellokitty.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel3/snakeplantlevel3hellokitty.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel4/snakeplantlevel4hellokitty.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSnakePlantImagePeter(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel1/snakeplantlevel1peter.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel2/snakeplantlevel2peter.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel3/snakeplantlevel3peter.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel4/snakeplantlevel4peter.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSnakePlantImageRoblox(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel1/snakeplantlevel1roblox.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel2/snakeplantlevel2roblox.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel3/snakeplantlevel3roblox.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel4/snakeplantlevel4roblox.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSnakePlantImageSmile(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel1/snakeplantlevel1smile.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel2/snakeplantlevel2smile.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel3/snakeplantlevel3smile.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel4/snakeplantlevel4smile.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Sponge pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSnakePlantImageSponge(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel1/snakeplantlevel1sponge.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel2/snakeplantlevel2sponge.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel3/snakeplantlevel3sponge.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/snakeplantlevel4/snakeplantlevel4sponge.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * Returns the image of the Sunflower based on the plant type, pot type, and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int level category
     * @return Image object of the sunflower plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     */
    public Image getSunflowerPotImage(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return setSunflowerImageMort(level);
            }
            case HelloKitty -> {
                return setSunflowerImageHelloKitty(level);
            }
            case Peter -> {
                return setSunflowerImagePeter(level);
            }
            case Roblox -> {
                return setSunflowerImageRoblox(level);
            }
            case Smile -> {
                return setSunflowerImageSmile(level);
            }
            case Sponge -> {
                return setSunflowerImageSponge(level);
            }
            default -> {
                System.out.println("Invalid pot type");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSunflowerImageHelloKitty(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel1/sunflowerlevel1hellokitty.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel2/sunflowerlevel2hellokitty.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel3/sunflowerlevel3hellokitty.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel4/sunflowerlevel4hellokitty.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSunflowerImagePeter(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel1/sunflowerlevel1peter.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel2/sunflowerlevel2peter.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel3/sunflowerlevel3peter.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel4/sunflowerlevel4peter.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSunflowerImageRoblox(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel1/sunflowerlevel1roblox.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel2/sunflowerlevel2roblox.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel3/sunflowerlevel3roblox.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel4/sunflowerlevel4roblox.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSunflowerImageSmile(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel1/sunflowerlevel1smile.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel2/sunflowerlevel2smile.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel3/sunflowerlevel3smile.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel4/sunflowerlevel4smile.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Sponge pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSunflowerImageSponge(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel1/sunflowerlevel1sponge.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel2/sunflowerlevel2sponge.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel3/sunflowerlevel3sponge.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel4/sunflowerlevel4sponge.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Mort pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     */
    private Image setSunflowerImageMort(int level) {
        switch (level) {
            case 1 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel1/sunflowerlevel1mort.png");
                return new Image(inputStream);
            }
            case 2 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel2/sunflowerlevel2mort.png");
                return new Image(inputStream);
            }
            case 3 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel3/sunflowerlevel3mort.png");
                return new Image(inputStream);
            }
            case 4 -> {
                InputStream inputStream = getClass().getResourceAsStream("/images/sunflowerlevel4/sunflowerlevel4mort.png");
                return new Image(inputStream);
            }
            default -> {
                System.out.println("Invalid level");
                return null;
            }
        }
    }
}
