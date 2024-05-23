package Controller;

import Model.PotType;

/**
 * This class is responsible for the logic of what image to display based on plant type, pot type, and level.
 * It is used by the PlantController class and returns the image to be displayed in the GUI for the plant.
 * @author Yrja Mai Hoang
 * @author Akmal Safi
 */
public class ImageController {
    private PlantController plantController;

    /**
     * Constructor for ImageController
     * @param plantController PlantController object
     * @author Yrja Mai Hoang
     * @author Akmal Safi
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
     * @author Akmal Safi
     */
    public String getCactusPotImagePath(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return getCactusImageMortPath(level);
            }
            case HelloKitty -> {
                return getCactusImageHelloKittyPath(level);
            }
            case Peter -> {
                return getCactusImagePeterPath(level);
            }
            case Roblox -> {
                return getCactusImageRobloxPath(level);
            }
            case Smile -> {
                return getCactusImageSmilePath(level);
            }
            case Sponge -> {
                return getCactusImageSpongePath(level);
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
     * @author Akmal Safi
     */
    private String getCactusImageMortPath(int level) {
        return switch (level) {
            case 1 -> "/images/cactuslevel1/cactuslevel1mort.png";
            case 2 -> "/images/cactuslevel2/cactuslevel2mort.png";
            case 3 -> "/images/cactuslevel3/cactuslevel3mort.png";
            case 4 -> "/images/cactuslevel4/cactuslevel4mort.png";
            case 5 -> "/images/cactuslegendary/cactuslegendarymort.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getCactusImageHelloKittyPath(int level) {
        return switch (level) {
            case 1 -> "/images/cactuslevel1/cactuslevel1hellokitty.png";
            case 2 -> "/images/cactuslevel2/cactuslevel2hellokitty.png";
            case 3 -> "/images/cactuslevel3/cactuslevel3hellokitty.png";
            case 4 -> "/images/cactuslevel4/cactuslevel4hellokitty.png";
            case 5 -> "/images/cactuslegendary/cactuslegendaryhellokitty.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getCactusImagePeterPath(int level) {
        return switch (level) {
            case 1 -> "/images/cactuslevel1/cactuslevel1peter.png";
            case 2 -> "/images/cactuslevel2/cactuslevel2peter.png";
            case 3 -> "/images/cactuslevel3/cactuslevel3peter.png";
            case 4 -> "/images/cactuslevel4/cactuslevel4peter.png";
            case 5 -> "/images/cactuslegendary/cactuslegendarypeter.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getCactusImageRobloxPath(int level) {
        return switch (level) {
            case 1 -> "/images/cactuslevel1/cactuslevel1roblox.png";
            case 2 -> "/images/cactuslevel2/cactuslevel2roblox.png";
            case 3 -> "/images/cactuslevel3/cactuslevel3roblox.png";
            case 4 -> "/images/cactuslevel4/cactuslevel4roblox.png";
            case 5 -> "/images/cactuslegendary/cactuslegendaryroblox.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getCactusImageSmilePath(int level) {
        return switch (level) {
            case 1 -> "/images/cactuslevel1/cactuslevel1smile.png";
            case 2 -> "/images/cactuslevel2/cactuslevel2smile.png";
            case 3 -> "/images/cactuslevel3/cactuslevel3smile.png";
            case 4 -> "/images/cactuslevel4/cactuslevel4smile.png";
            case 5 -> "/images/cactuslegendary/cactuslegendarysmile.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the cactus plant.
     * It returns the image of the cactus plant with Sponge pot based on the level category.
     * @param level int level category
     * @return Image object of the cactus plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getCactusImageSpongePath(int level) {
        return switch (level) {
            case 1 -> "/images/cactuslevel1/cactuslevel1sponge.png";
            case 2 -> "/images/cactuslevel2/cactuslevel2sponge.png";
            case 3 -> "/images/cactuslevel3/cactuslevel3sponge.png";
            case 4 -> "/images/cactuslevel4/cactuslevel4sponge.png";
            case 5 -> "/images/cactuslegendary/cactuslegendarysponge.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * Returns the image of the Monstera based on the plant type, pot type, and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int level category
     * @return Image object of the monstera plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    public String getMonsteraPotImagePath(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return getMonsteraImageMortPath(level);
            }
            case HelloKitty -> {
                return getMonsteraImageHelloKittyPath(level);
            }
            case Peter -> {
                return getMonsteraImagePeterPath(level);
            }
            case Roblox -> {
                return getMonsteraImageRobloxPath(level);
            }
            case Smile -> {
                return getMonsteraImageSmilePath(level);
            }
            case Sponge -> {
                return getMonsteraImageSpongePath(level);
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
     * @author Akmal Safi
     */
    private String getMonsteraImageSpongePath(int level) {
        return switch (level) {
            case 1 -> "/images/monsteralevel1/monsteralevel1sponge.png";
            case 2 -> "/images/monsteralevel2/monsteralevel2sponge.png";
            case 3 -> "/images/monsteralevel3/monsteralevel3sponge.png";
            case 4 -> "/images/monsteralevel4/monsteralevel4sponge.png";
            case 5 -> "/images/monsteralegendary/monsteralegendarysponge.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getMonsteraImageSmilePath(int level) {
        return switch (level) {
            case 1 -> "/images/monsteralevel1/monsteralevel1smile.png";
            case 2 -> "/images/monsteralevel2/monsteralevel2smile.png";
            case 3 -> "/images/monsteralevel3/monsteralevel3smile.png";
            case 4 -> "/images/monsteralevel4/monsteralevel4smile.png";
            case 5 -> "/images/monsteralegendary/monsteralegendarysmile.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getMonsteraImageRobloxPath(int level) {
        return switch (level) {
            case 1 -> "/images/monsteralevel1/monsteralevel1roblox.png";
            case 2 -> "/images/monsteralevel2/monsteralevel2roblox.png";
            case 3 -> "/images/monsteralevel3/monsteralevel3roblox.png";
            case 4 -> "/images/monsteralevel4/monsteralevel4roblox.png";
            case 5 -> "/images/monsteralegendary/monsteralegendaryroblox.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getMonsteraImagePeterPath(int level) {
        return switch (level) {
            case 1 -> "/images/monsteralevel1/monsteralevel1peter.png";
            case 2 -> "/images/monsteralevel2/monsteralevel2peter.png";
            case 3 -> "/images/monsteralevel3/monsteralevel3peter.png";
            case 4 -> "/images/monsteralevel4/monsteralevel4peter.png";
            case 5 -> "/images/monsteralegendary/monsteralegendarypeter.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }


    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getMonsteraImageHelloKittyPath(int level) {
        return switch (level) {
            case 1 -> "/images/monsteralevel1/monsteralevel1hellokitty.png";
            case 2 -> "/images/monsteralevel2/monsteralevel2hellokitty.png";
            case 3 -> "/images/monsteralevel3/monsteralevel3hellokitty.png";
            case 4 -> "/images/monsteralevel4/monsteralevel4hellokitty.png";
            case 5 -> "/images/monsteralegendary/monsteralegendaryhellokitty.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }
    /**
     * This method is the final step in determining what image to display for the monstera plant.
     * It returns the image of the monstera plant with Mort pot based on the level category.
     * @param level int level category
     * @return Image object of the monstera plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getMonsteraImageMortPath(int level) {
        return switch (level) {
            case 1 -> "/images/monsteralevel1/monsteralevel1mort.png";
            case 2 -> "/images/monsteralevel2/monsteralevel2mort.png";
            case 3 -> "/images/monsteralevel3/monsteralevel3mort.png";
            case 4 -> "/images/monsteralevel4/monsteralevel4mort.png";
            case 5 -> "/images/monsteralegendary/monsteralegendarymort.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * Returns the image of the Pumpkin based on the plant type, pot type, and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int level category
     * @return Image object of the snake plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    public String getPumpkinPotImagePath(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return getPumpkinImageMortPath(level);
            }
            case HelloKitty -> {
                return getPumpkinImageHelloKittyPath(level);
            }
            case Peter -> {
                return getPumpkinImagePeterPath(level);
            }
            case Roblox -> {
                return getPumpkinImageRobloxPath(level);
            }
            case Smile -> {
                return getPumpkinImageSmilePath(level);
            }
            case Sponge -> {
                return getPumpkinImageSpongePath(level);
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
     * @author Akmal Safi
     */
    private String getPumpkinImageMortPath(int level) {
        return switch (level) {
            case 1 -> "/images/pumpkinlevel1/pumpkinlevel1mort.png";
            case 2 -> "/images/pumpkinlevel2/pumpkinlevel2mort.png";
            case 3 -> "/images/pumpkinlevel3/pumpkinlevel3mort.png";
            case 4 -> "/images/pumpkinlevel4/pumpkinlevel4mort.png";
            case 5 -> "/images/pumpkinlegendary/pumpkinlegendarymort.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getPumpkinImageHelloKittyPath(int level) {
        return switch (level) {
            case 1 -> "/images/pumpkinlevel1/pumpkinlevel1hellokitty.png";
            case 2 -> "/images/pumpkinlevel2/pumpkinlevel2hellokitty.png";
            case 3 -> "/images/pumpkinlevel3/pumpkinlevel3hellokitty.png";
            case 4 -> "/images/pumpkinlevel4/pumpkinlevel4hellokitty.png";
            case 5 -> "/images/pumpkinlegendary/pumpkinlegendaryhellokitty.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getPumpkinImagePeterPath(int level) {
        return switch (level) {
            case 1 -> "/images/pumpkinlevel1/pumpkinlevel1peter.png";
            case 2 -> "/images/pumpkinlevel2/pumpkinlevel2peter.png";
            case 3 -> "/images/pumpkinlevel3/pumpkinlevel3peter.png";
            case 4 -> "/images/pumpkinlevel4/pumpkinlevel4peter.png";
            case 5 -> "/images/pumpkinlegendary/pumpkinlegendarypeter.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getPumpkinImageRobloxPath(int level) {
        return switch (level) {
            case 1 -> "/images/pumpkinlevel1/pumpkinlevel1roblox.png";
            case 2 -> "/images/pumpkinlevel2/pumpkinlevel2roblox.png";
            case 3 -> "/images/pumpkinlevel3/pumpkinlevel3roblox.png";
            case 4 -> "/images/pumpkinlevel4/pumpkinlevel4roblox.png";
            case 5 -> "/images/pumpkinlegendary/pumpkinlegendaryroblox.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getPumpkinImageSmilePath(int level) {
        return switch (level) {
            case 1 -> "/images/pumpkinlevel1/pumpkinlevel1smile.png";
            case 2 -> "/images/pumpkinlevel2/pumpkinlevel2smile.png";
            case 3 -> "/images/pumpkinlevel3/pumpkinlevel3smile.png";
            case 4 -> "/images/pumpkinlevel4/pumpkinlevel4smile.png";
            case 5 -> "/images/pumpkinlegendary/pumpkinlegendarysmile.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the pumpkin plant.
     * It returns the image of the pumpkin plant with Sponge pot based on the level category.
     * @param level int level category
     * @return Image object of the pumpkin plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getPumpkinImageSpongePath(int level) {
        return switch (level) {
            case 1 -> "/images/pumpkinlevel1/pumpkinlevel1sponge.png";
            case 2 -> "/images/pumpkinlevel2/pumpkinlevel2sponge.png";
            case 3 -> "/images/pumpkinlevel3/pumpkinlevel3sponge.png";
            case 4 -> "/images/pumpkinlevel4/pumpkinlevel4sponge.png";
            case 5 -> "/images/pumpkinlegendary/pumpkinlegendarysponge.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * Returns the image of the Snake Plant based on the plant type, pot type, and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int level category
     * @return Image object of the snake plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    public String getSnakePlantPotImagePath(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return getSnakePlantImageMortPath(level);
            }
            case HelloKitty -> {
                return getSnakePlantImageHelloKittyPath(level);
            }
            case Peter -> {
                return getSnakePlantImagePeterPath(level);
            }
            case Roblox -> {
                return getSnakePlantImageRobloxPath(level);
            }
            case Smile -> {
                return getSnakePlantImageSmilePath(level);
            }
            case Sponge -> {
                return getSnakePlantImageSpongePath(level);
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
     * @author Akmal Safi
     */
    private String getSnakePlantImageMortPath(int level) {
        return switch (level) {
            case 1 -> "/images/snakeplantlevel1/snakeplantlevel1mort.png";
            case 2 -> "/images/snakeplantlevel2/snakeplantlevel2mort.png";
            case 3 -> "/images/snakeplantlevel3/snakeplantlevel3mort.png";
            case 4 -> "/images/snakeplantlevel4/snakeplantlevel4mort.png";
            case 5 -> "/images/snakeplantlegendary/snakeplantlegendarymort.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Hello Kitty pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSnakePlantImageHelloKittyPath(int level) {
        return switch (level) {
            case 1 -> "/images/snakeplantlevel1/snakeplantlevel1hellokitty.png";
            case 2 -> "/images/snakeplantlevel2/snakeplantlevel2hellokitty.png";
            case 3 -> "/images/snakeplantlevel3/snakeplantlevel3hellokitty.png";
            case 4 -> "/images/snakeplantlevel4/snakeplantlevel4hellokitty.png";
            case 5 -> "/images/snakeplantlegendary/snakeplantlegendaryhellokitty.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSnakePlantImagePeterPath(int level) {
        return switch (level) {
            case 1 -> "/images/snakeplantlevel1/snakeplantlevel1peter.png";
            case 2 -> "/images/snakeplantlevel2/snakeplantlevel2peter.png";
            case 3 -> "/images/snakeplantlevel3/snakeplantlevel3peter.png";
            case 4 -> "/images/snakeplantlevel4/snakeplantlevel4peter.png";
            case 5 -> "/images/snakeplantlegendary/snakeplantlegendarypeter.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSnakePlantImageRobloxPath(int level) {
        return switch (level) {
            case 1 -> "/images/snakeplantlevel1/snakeplantlevel1roblox.png";
            case 2 -> "/images/snakeplantlevel2/snakeplantlevel2roblox.png";
            case 3 -> "/images/snakeplantlevel3/snakeplantlevel3roblox.png";
            case 4 -> "/images/snakeplantlevel4/snakeplantlevel4roblox.png";
            case 5 -> "/images/snakeplantlegendary/snakeplantlegendaryroblox.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSnakePlantImageSmilePath(int level) {
        return switch (level) {
            case 1 -> "/images/snakeplantlevel1/snakeplantlevel1smile.png";
            case 2 -> "/images/snakeplantlevel2/snakeplantlevel2smile.png";
            case 3 -> "/images/snakeplantlevel3/snakeplantlevel3smile.png";
            case 4 -> "/images/snakeplantlevel4/snakeplantlevel4smile.png";
            case 5 -> "/images/snakeplantlegendary/snakeplantlegendarysmile.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }


    /**
     * This method is the final step in determining what image to display for the snake plant.
     * It returns the image of the snake plant with Sponge pot based on the level category.
     * @param level int level category
     * @return Image object of the snake plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSnakePlantImageSpongePath(int level) {
        return switch (level) {
            case 1 -> "/images/snakeplantlevel1/snakeplantlevel1sponge.png";
            case 2 -> "/images/snakeplantlevel2/snakeplantlevel2sponge.png";
            case 3 -> "/images/snakeplantlevel3/snakeplantlevel3sponge.png";
            case 4 -> "/images/snakeplantlevel4/snakeplantlevel4sponge.png";
            case 5 -> "/images/snakeplantlegendary/snakeplantlegendarysponge.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }
    /**
     * Returns the image of the Sunflower based on the plant type, pot type, and level category.
     * It calls the appropriate method to figure out what image to return.
     * @param potType PotType enum
     * @param level int level category
     * @return Image object of the sunflower plant based on the pot type and level category. Returns null if invalid pot type.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    public String getSunflowerPotImagePath(PotType potType, int level){
        switch (potType) {
            case Mort -> {
                return getSunflowerImageMortPath(level);
            }
            case HelloKitty -> {
                return getSunflowerImageHelloKittyPath(level);
            }
            case Peter -> {
                return getSunflowerImagePeterPath(level);
            }
            case Roblox -> {
                return getSunflowerImageRobloxPath(level);
            }
            case Smile -> {
                return getSunflowerImageSmilePath(level);
            }
            case Sponge -> {
                return getSunflowerImageSpongePath(level);
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
     * @author Akmal Safi
     */
    private String getSunflowerImageHelloKittyPath(int level) {
        return switch (level) {
            case 1 -> "/images/sunflowerlevel1/sunflowerlevel1hellokitty.png";
            case 2 -> "/images/sunflowerlevel2/sunflowerlevel2hellokitty.png";
            case 3 -> "/images/sunflowerlevel3/sunflowerlevel3hellokitty.png";
            case 4 -> "/images/sunflowerlevel4/sunflowerlevel4hellokitty.png";
            case 5 -> "/images/sunflowerlegendary/sunflowerlegendaryhellokitty.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Peter pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSunflowerImagePeterPath(int level) {
        return switch (level) {
            case 1 -> "/images/sunflowerlevel1/sunflowerlevel1peter.png";
            case 2 -> "/images/sunflowerlevel2/sunflowerlevel2peter.png";
            case 3 -> "/images/sunflowerlevel3/sunflowerlevel3peter.png";
            case 4 -> "/images/sunflowerlevel4/sunflowerlevel4peter.png";
            case 5 -> "/images/sunflowerlegendary/sunflowerlegendarypeter.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Roblox pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSunflowerImageRobloxPath(int level) {
        return switch (level) {
            case 1 -> "/images/sunflowerlevel1/sunflowerlevel1roblox.png";
            case 2 -> "/images/sunflowerlevel2/sunflowerlevel2roblox.png";
            case 3 -> "/images/sunflowerlevel3/sunflowerlevel3roblox.png";
            case 4 -> "/images/sunflowerlevel4/sunflowerlevel4roblox.png";
            case 5 -> "/images/sunflowerlegendary/sunflowerlegendaryroblox.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }

    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Smile pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSunflowerImageSmilePath(int level) {
        return switch (level) {
            case 1 -> "/images/sunflowerlevel1/sunflowerlevel1smile.png";
            case 2 -> "/images/sunflowerlevel2/sunflowerlevel2smile.png";
            case 3 -> "/images/sunflowerlevel3/sunflowerlevel3smile.png";
            case 4 -> "/images/sunflowerlevel4/sunflowerlevel4smile.png";
            case 5 -> "/images/sunflowerlegendary/sunflowerlegendarysmile.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }
    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Sponge pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSunflowerImageSpongePath(int level) {
        return switch (level) {
            case 1 -> "/images/sunflowerlevel1/sunflowerlevel1sponge.png";
            case 2 -> "/images/sunflowerlevel2/sunflowerlevel2sponge.png";
            case 3 -> "/images/sunflowerlevel3/sunflowerlevel3sponge.png";
            case 4 -> "/images/sunflowerlevel4/sunflowerlevel4sponge.png";
            case 5 -> "/images/sunflowerlegendary/sunflowerlegendarysponge.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }
    /**
     * This method is the final step in determining what image to display for the sunflower plant.
     * It returns the image of the sunflower plant with Mort pot based on the level category.
     * @param level int level category
     * @return Image object of the sunflower plant based on the level category. Returns null if invalid level category.
     * @author Yrja Mai Hoang
     * @author Akmal Safi
     */
    private String getSunflowerImageMortPath(int level) {
        return switch (level) {
            case 1 -> "/images/sunflowerlevel1/sunflowerlevel1mort.png";
            case 2 -> "/images/sunflowerlevel2/sunflowerlevel2mort.png";
            case 3 -> "/images/sunflowerlevel3/sunflowerlevel3mort.png";
            case 4 -> "/images/sunflowerlevel4/sunflowerlevel4mort.png";
            case 5 -> "/images/sunflowerlegendary/sunflowerlegendarymort.png";
            default -> {
                System.out.println("Invalid level");
                yield null;
            }
        };
    }
}
