package com.example.plantwidget_g18_gui;

import Controller.PlantController;
import Model.LegendaryPlant;
import Model.Music;
import Model.Plant;
import Model.PlantTypes;
import View.MainBoundary;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ImageView leftArrow;
    @FXML
    private ImageView rightArrow;
    @FXML
    private Button switchSeedButtonRight;
    @FXML
    private Button switchSeedButtonLeft;
    @FXML
    private Button backToLib;
    @FXML
    private ButtonType backToLibButtonType;
    @FXML
    private Label speciesNameInSelectPlantScene;
    @FXML
    private Label plantNameInSelectPlantScene;
    @FXML
    private ProgressBar waterBarInWidgetScene;
    @FXML
    private ProgressBar healthBarInWidgetScene;
    @FXML
    private ProgressBar waterBarInSelectPlantScene;
    @FXML
    private ProgressBar healthBarInSelectPlantScene;
    @FXML
    private Timeline timelineUpdateHealth;
    @FXML
    private Button enterNameButton;
    @FXML
    private Button deletePlantButton;
    @FXML
    private Button deletePlantButton2;
    @FXML
    private Button deletePlantButton3;
    @FXML
    private Button closeNamePlantButton;
    @FXML
    private Label nameYourPlantLabel;
    @FXML
    private Rectangle namePlantPrompt;
    @FXML
    private TextField namePlantField;
    @FXML
    private Font pixelFont;
    @FXML
    private Label seedName1;
    @FXML
    private ImageView seedImage4;
    @FXML
    private ImageView seedImage5;
    @FXML
    private Button chooseSeedButton1;
    @FXML
    private Button chooseSeedButton2;
    @FXML
    private Button chooseSeedButton3;
    @FXML
    private Button chooseSeedButton4;
    @FXML
    private Button chooseSeedButton5;
    @FXML
    private Button settingsButton;
    @FXML
    private Button chooseSeedButtonExtended1;
    @FXML
    private Button chooseSeedButtonExtended2;
    @FXML
    private Button chooseSeedButtonExtended3;
    @FXML
    private Button chooseSeedButtonExtended4;
    @FXML
    private Button chooseSeedButtonExtended5;
    @FXML
    private Rectangle seedSpecies1;
    @FXML
    private Rectangle seedSpecies2;
    @FXML
    private Rectangle seedSpecies3;
    @FXML
    private Rectangle seedSpecies4;
    @FXML
    private Rectangle seedSpecies5;
    @FXML
    private Label seedSpeciesLabel1;
    @FXML
    private Label seedSpeciesLabel2;
    @FXML
    private Label seedSpeciesLabel3;
    @FXML
    private Label seedSpeciesLabel4;
    @FXML
    private Label seedSpeciesLabel5;
    @FXML
    private Rectangle seedSpeciesDifficualty1;
    @FXML
    private Rectangle seedSpeciesDifficualty2;
    @FXML
    private Rectangle seedSpeciesDifficualty3;
    @FXML
    private Rectangle seedSpeciesDifficualty4;
    @FXML
    private Rectangle seedSpeciesDifficualty5;
    @FXML
    private Label seedDifficualty1;
    @FXML
    private Label seedDifficualty2;
    @FXML
    private Label seedDifficualty3;
    @FXML
    private Label seedDifficualty4;
    @FXML
    private Label seedDifficualty5;
    @FXML
    private ProgressBar seedDifficultyBar1;
    @FXML
    private ProgressBar seedDifficultyBar2;
    @FXML
    private ProgressBar seedDifficultyBar3;
    @FXML
    private ImageView imageX1;
    @FXML
    private ProgressBar seedDifficultyBar4;
    @FXML
    private ProgressBar seedDifficultyBar5;

    @FXML
    private Button plantNewSeedButton1;
    @FXML
    private Button plantNewSeedButton2;
    @FXML
    private Button plantNewSeedButton3;
    @FXML
    private Button plantNewSeedButton4;
    @FXML
    private Button plantNewSeedButton5;
    @FXML
    private Button plantNewSeedButton;
    @FXML
    private Button addNewPLantButton;
    @FXML
    private Button placeOnDesk1;
    @FXML
    private Button placeOnDesk2;
    @FXML
    private Button placeOnDesk3;
    @FXML
    private Button exitButton;
    @FXML
    private Button waterThePlantOne;
    @FXML
    private Button waterThePlantTwo;
    @FXML
    private Button waterThePlantThree;
    @FXML
    private Button skipDayButton1;
    @FXML
    private Button skipDayButton2;
    @FXML
    private Button skipDayButton3;
    @FXML
    private Label levelPlantOne;
    @FXML
    private ProgressBar plantHealthBarOne;
    @FXML
    private ProgressBar plantWaterBarOne;
    @FXML
    private ProgressBar plantHealthBarTwo;
    @FXML
    private ProgressBar plantWaterBarTwo;
    @FXML
    private ProgressBar plantHealthBarThree;
    @FXML
    private ProgressBar plantWaterBarThree;
    private Label plantLevelOne;
    @FXML
    private Label plantLeveltwo;
    @FXML
    private Label plantLevelThree;
    @FXML
    private Button waterPlantOne;
    @FXML
    private Button waterPlantTwo;
    @FXML
    private Button waterPlantThree;
    @FXML
    private Button selectPlantOne;
    @FXML
    private Button selectPlantTwo;
    @FXML
    private Button selectPlantThree;
    @FXML
    private ProgressBar difficultyBarOne;
    @FXML
    private ProgressBar difficultyBarTwo;
    @FXML
    private ProgressBar difficultyBarThree;
    @FXML
    private ImageView imagePlantOne;
    @FXML
    private ImageView imagePlantTwo;
    @FXML
    private ImageView imagePlantThree;
    @FXML
    private ImageView imagePlantFour;
    @FXML
    private ImageView imagePlantFive;
    @FXML
    private ImageView imagePlantSix;
    @FXML
    private ImageView pot;
    @FXML
    private ImageView pot3;
    @FXML
    private ImageView pot2;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button backButton;
    @FXML
    private Button selectPlantButton;
    @FXML
    private ScrollPane legendaryScrollPane;
    @FXML
    private GridPane legendaryGridPane;
    private double xOffset = 0;
    private double yOffset = 0;
    //double healthPlantOne = 0.5;
    //double waterPlantOne = 0.7;
    int levelOfPlantOne = 99; // dont forget to implement it
    private MainBoundary mainBoundary;
    private Plant plant1;
    private Plant plant2;
    private Plant plant3;
    private int indexOfChosenSeed;
    private ComboBox<PlantTypes>plantTypesComboBox;
    private PlantTypes selectedPlantType;
    private PlantController plantController;

    /**
     * This method switches scene to Plant Info scene.
     * @param event Button click.
     * @param index Index of the plant.
     */
    public void selectPlant(ActionEvent event, int index){
        mainBoundary.getPlantController().startTheTimer();
        timelineUpdateHealth.playFromStart();
        mainBoundary.getPlantController().SavePlantToFile();
        buttonClickSound();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlantInfoGUI.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Plant Widget Library!");
            //stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setScene(scene);
            mouseMoveable(scene);

            ImageView plantImageForInfo = getImageViewFromStage(stage); // this gets the imageview from the stage so to set the image of the plant
            plantImageForInfo.setImage(mainBoundary.getPlantController().getPlant(index).getImage());//sets the image but I don't know if this breaks MVC
            ProgressBar waterBarInSelectPlantScene = getWaterBarInSelectPlantScene(stage);
            ProgressBar healthBarInSelectPlantScene = getHealthBarInSelectPlantScene(stage);
            healthBarInSelectPlantScene.getStyleClass().add("progressBarHealth");
            waterBarInSelectPlantScene.setStyle("-fx-accent: #34a8d9;");
            waterBarInSelectPlantScene.setBackground(Background.EMPTY);
            updateWaterAndHealthBar(waterBarInSelectPlantScene, healthBarInSelectPlantScene, index);
            updatePictureInSelectPlantScene(plantImageForInfo, index);
            setUpSelectPlantScene(stage,index);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method makes the plant in to widget scene.
     * @param event Button click.
     * @author Emre Mengütay
     */
    public void placeOnDesk1(ActionEvent event){
        mainBoundary.getPlantController().startTheTimer();
        //timelineUpdateHealth.playFromStart();
        mainBoundary.getPlantController().SavePlantToFile();
        buttonClickSound();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("widget-view.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Plant Widget Library!");
            //stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setScene(scene);
            mouseMoveable(scene);

            Button button = (Button)event.getSource();
            setupWidgetScene(button,stage);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method takes the user to the Setting scene.
     * @param event Button click.
     * @author Emre Mengütay
     */
    public void goToSettings(ActionEvent event){
        buttonClickSound();
        mainBoundary.getPlantController().stopTheTimer();
        timelineUpdateHealth.stop();
        mainBoundary.getPlantController().SavePlantToFile();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SettingsGUI.fxml")));
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SettingsGUI.fxml"));
            scene = new Scene(root);
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Plant Widget Library!");
            //stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setScene(scene);
            mouseMoveable(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method makes the scene moveable.
     * @param scene The scene that should be moveable.
     */
    public void mouseMoveable(Scene scene){
        scene.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    /**
     * This method closes the program and saves the plant progress.
     * @param event Button click event that triggers the method.
     */
    public void closeProgram(ActionEvent event) {
        if (confirmExit()) {
            closeProgramSound();
            mainBoundary.getPlantController().timeTrackWriter();
            mainBoundary.getPlantController().SavePlantToFile();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    /**
     *
     * @return boolean
     * @author Akmal Safi
     */
    public boolean confirmDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("⚠️ Hold on! ⚠️");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Are you absolutely, positively, beyond any shadow of a doubt sure " +
                "you want to send this plant to the great compost heap in the sky? 🌿💀");

        ButtonType okButton = new ButtonType("Yes, compost-bound! 🚮");
        ButtonType cancelButton = new ButtonType("No way, I'm growing attached! 🌱");

        alert.getButtonTypes().setAll(okButton, cancelButton);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #C8E6C9;");

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == okButton;
    }

    /**
     *
     * @return boolean
     * @author Akmal Safi
     */
    public boolean confirmExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit 🌿🌸");
        alert.setHeaderText("Are you sure you want to leave the garden?");
        alert.setContentText("Leaving now may cause your plants to feel neglected! 🥀🍃");

        ButtonType exitButton = new ButtonType("Exit, my plants can wait! 🏡👋");
        ButtonType cancelButton = new ButtonType("Cancel, I'll stay and tend to my garden! 🌱");

        alert.getButtonTypes().setAll(exitButton, cancelButton);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #B0E57C; -fx-font-size: 14pt;");

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == exitButton;
    }

    /**
     * Method for delete plant button, deletes the plant and goes back to the library scene.
     * @param event that triggers the method. (Button click).
     * @author Emre Mengütay
     */
    public void deletePlant1(ActionEvent event){
        if (confirmDelete()) {
            playSadMusic();
            mainBoundary.getPlantController().discardPlant1();
            mainBoundary.getPlantController().SavePlantToFile();
            mainBoundary.getPlantController().LoadPlantsFromFile();
            goBackToLibrary(event);
            System.out.println("Plant Deleted1");
        }
    }

    public void deletePlant2(ActionEvent event) {
        if (confirmDelete()) {
            playSadMusic();
            mainBoundary.getPlantController().discardPlant2();
            mainBoundary.getPlantController().SavePlantToFile();
            mainBoundary.getPlantController().LoadPlantsFromFile();
            goBackToLibrary(event);
            System.out.println("Plant Deleted2");
        }
    }

    public void deletePlant3(ActionEvent event) {
        if (confirmDelete()) {
            playSadMusic();
            mainBoundary.getPlantController().discardPlant3();
            mainBoundary.getPlantController().SavePlantToFile();
            mainBoundary.getPlantController().LoadPlantsFromFile();
            goBackToLibrary(event);
            System.out.println("Plant Deleted3");
        }
    }

    /**
     * This method takes the user back to the library scene.
     * @param event that triggers the method.
     * @author Emre Mengütay
     */
    public void goBackToLibrary(ActionEvent event){
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        System.out.println(System.getProperty("javafx.runtime.version"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Plant Widget Library!");
        stage.setScene(scene);
        stage.show();*/
        mainBoundary.getPlantController().startTimer();
        timelineUpdateHealth.playFromStart();
        mainBoundary.getPlantController().SavePlantToFile();
        mainBoundary.getPlantController().LoadPlantsFromFile();
        buttonClickSound();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Plant Widget Library!");
            stage.setScene(scene);
            //stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e){

        }
    }

    /**
     * GOES TO THE PLANT NEW SEED SCENE, OR THE FIRST GUI WHEN OPENING PROGRAM FOR THE FIRST TIME
     * @param event that triggers the method.
     */
    public void goTochooseSeedScene(ActionEvent event){
        mainBoundary.getPlantController().stopTheTimer();
        timelineUpdateHealth.stop();
        mainBoundary.getPlantController().SavePlantToFile();
        buttonClickSound();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SeedMenu.fxml")));
            Scene scene = new Scene(root);
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Choose Seed");
            stage.setScene(scene);
            stage.setResizable(false);
            setUpSeedScene(stage);
            stage.show();
        } catch (IOException e) {
            System.out.println("fel i gotochooseseedscene");
            e.printStackTrace();
        }
    }

    public void goToLegendaryScene(ActionEvent event){
        buttonClickSound();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LegendaryMenu.fxml")));
            Scene scene = new Scene(root);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Legendary Plants");
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();

            legendaryGridPane = getLegendaryGridPane(stage);
            //int row = -1;
            ArrayList<LegendaryPlant> legendaryPlants = mainBoundary.getPlantController().getLegendaryPlants(); // Assuming you have a PlantController instance named plantController
            int row = 0;
            int i = 0;

            for (LegendaryPlant legendaryPlant : legendaryPlants) {
                if(i % 3 == 0){
                    row++;
                }
                //Gridpane stacks on top of rectangle
                StackPane stackPane = new StackPane();
                GridPane gridPane = new GridPane();
                Rectangle rectangle = new Rectangle(152, 181, Color.color(0.5725490196078431, 0.9176470588235294 ,0.6627450980392157));
                rectangle.setStyle(" -fx-stroke: black; -fx-stroke-width: 1;");
                //Plant name
                Label plantName = new Label(legendaryPlant.getName());
                plantName.setFont(new Font("Verdana Pro Cond Black", 24));
                plantName.setAlignment(Pos.CENTER);
                plantName.setMaxWidth(Double.MAX_VALUE);
                GridPane.setConstraints(plantName,0,2);

                //Plant image
                ImageView plantImage = new ImageView();
                plantImage.setImage(legendaryPlant.getImage());
                plantImage.setFitHeight(88);
                plantImage.setFitWidth(111);
                BorderPane imageWrap = new BorderPane(plantImage);
                imageWrap.setStyle("-fx-border-color: gold; -fx-border-width: 2;");
                imageWrap.setPadding(new Insets(1));

                GridPane.setConstraints(imageWrap, 0,1);

                gridPane.getChildren().addAll(imageWrap, plantName);
                gridPane.setAlignment(Pos.TOP_CENTER);
                gridPane.setHgap(10);
                gridPane.setVgap(20);

                stackPane.setMaxHeight(152);
                stackPane.setMaxWidth(181);

                StackPane.setAlignment(gridPane, Pos.CENTER);
                stackPane.getChildren().addAll(rectangle, gridPane);

                legendaryGridPane.add(stackPane,(i + 3) % 3, row);
                i++;
            }
           // legendaryGridPane.add(new Rectangle(50, 50, Color.BLUE), 0 , 0);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method updates the health bar of the first plant.
     * @author Emre Mengütay
     */
    public void updatePlantHealthBarOne() {
        if(plantHealthBarOne != null && mainBoundary.getPlantController().getPlant(0) != null){
            plantHealthBarOne.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(0)); // implement health level
        }
    }

    /**
     * This method updates the water bar of the first plant.
     * @author Emre Mengütay
     */
    public void updatePlantWaterBarOne() {
        if(plantWaterBarOne != null && mainBoundary.getPlantController().getPlant(0) != null){
            plantWaterBarOne.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(0)); // implement water level
        }
    }

    /**
     * This method initalizes the JavaFX GUI. It starts the timer and reads the time track from the file.
     * @author Emre Mengütay & ---
    */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // this is like the constructor for the gui
        mainBoundary.getPlantController().startTheTimer();
        mainBoundary.getPlantController().timeTrackReader();
        startTimeline();
        updatePlantWaterBarOne(); // updates the waterbar to correct value every 5 seconds
        updatePlantHealthBarOne();
        /*

        plantHealthBarOne.getStyleClass().add("progressBarHealth");
        plantWaterBarOne.setStyle("-fx-accent: #34a8d9;");  // vet inte om detta ska vara här för då funkar inte "select plant" scene. la den direkt under gotoselectplant
        plantWaterBarOne.setBackground(Background.EMPTY);

         */

        //levelPlantOne.setStyle("-fx-accent: #92eaa9;");
    }

    public void startTimeline() {
        timelineUpdateHealth.playFromStart();
    }

    /**
     * Constructs a new HelloController object. It initializes the mainBoundary, plant1, plant2, plant3, and-
     * timelineUpdateHealth.
     * It also reads the time track from the file.
     * It also loads the plants from the file.
     * It also updates the current library.
     * @author Emre Mengütay
     * @author Akmal Safi & ---
     */
    public HelloController() {
        this.mainBoundary = MainBoundary.getInstance();
        this.plant1 = mainBoundary.getPlantController().getPlant(0);
        this.plant2 =  mainBoundary.getPlantController().getPlant(1);
        this.plant3 =  mainBoundary.getPlantController().getPlant(2);
        mainBoundary.getPlantController().timeTrackReader();
        timelineUpdateHealth = new Timeline();
        KeyFrame updateGUIFrame = new KeyFrame(Duration.millis(1), event -> {
            updatePlantWaterBarOne(); // updates the waterbar to correct value every 5 seconds
            updatePlantHealthBarOne();
            Plant[] plants = mainBoundary.getPlantController().getGrowingPlants();
            if (plants != null) {
                for (int i = plants.length - 1; i >= 0; i--) {
                    if (plants[i] != null && plants[i].getHealthLevel() < 0.01) {
                        try {
                            mainBoundary.getMusic().deathSoundGenerator();
                            Platform.runLater(() -> showDeathAlert());
                        } catch (Exception e) {
                            System.out.println("Death alert not working");
                        }
                        mainBoundary.getPlantController().killPlant(i);
                    }
                }
            }
        });
        timelineUpdateHealth.getKeyFrames().add(updateGUIFrame);
        timelineUpdateHealth.setCycleCount(Animation.INDEFINITE);
        mainBoundary.getPlantController().LoadPlantsFromFile();
            updateCurrentLibrary();
    }

    /**
     * This method creates a pop-up window that alerts the user that their plant has died. It also plays a sound effect.
     * After clicking the :(  button the user is taken back to the library scene.
     * @author Emre Mengütay
     */
    /*public void showDeathAlert() {
        playSadMusic();
        JButton backButton = new JButton(":(");
        JDialog dialog = new JDialog();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                goBackToLibrarySwing();
                dialog.dispose();
            }
        });

        String message = "Your plant has died... you should be ashamed of yourself...";
        JLabel messageLabel = new JLabel(message);

        JPanel panel = new JPanel();
        panel.add(messageLabel);
        panel.add(backButton);

        dialog.setUndecorated(true);
        dialog.setContentPane(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        mainBoundary.getMusic().deathSoundGenerator();
    }

     */

    public void showDeathAlert() {
        playSadMusic();

        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.initModality(Modality.APPLICATION_MODAL);

        VBox dialogPaneContent = new VBox();

        Label messageLabel = new Label("Your plant has died... you should be ashamed of yourself.");
        messageLabel.setStyle("-fx-text-fill: white; -fx-background-color: red; -fx-padding: 10px; -fx-font-weight: bold;");
        messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        BorderPane labelPane = new BorderPane();
        labelPane.setCenter(messageLabel);
        dialogPaneContent.getChildren().add(labelPane);

        Image image = new Image(getClass().getResourceAsStream("/sadplantimage/sadplant.jpg"));
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(250);
        imageView.setFitHeight(200);

        dialogPaneContent.getChildren().add(imageView);

        alert.getDialogPane().setContent(dialogPaneContent);

        ButtonType closeButton = new ButtonType("Close, I promise to water the next plant", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(closeButton);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/sadplantimage/sadplant.jpg")));

        alert.showAndWait();
        stage.toFront();

        if (alert.getResult() == ButtonType.CLOSE) {
            goBackToLibrarySwing();
        }

        mainBoundary.getMusic().deathSoundGenerator();
    }

    /**
     * Method that takes the program back to the library scene. It needs to be run on Swing because of JavaFX requiring
     * an action event.
     * @author Emre Mengütay
     */
    public void goBackToLibrarySwing() {
        buttonClickSound();
        Platform.runLater(() -> {
            mainBoundary.getPlantController().startTimer();
            timelineUpdateHealth.playFromStart();
            mainBoundary.getPlantController().SavePlantToFile();
            mainBoundary.getPlantController().LoadPlantsFromFile();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                scene = new Scene(fxmlLoader.load());
                stage.setTitle("Plant Widget Library!");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * This method waters the plant in the library. It also plays a watering sound effect.
     * @param event The event that triggers the watering of the plant and goes back to the library if the plant is legendary..
     * @author Emre Mengütay
     * @author Mojtaba Hauari
     */
    public void waterPlantOne(ActionEvent event){
        mainBoundary.getPlantController().waterPlant(0);
        mainBoundary.getMusic().wateringSound();
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();
        if(checkLegendary(0)){
            goBackToLibrary(event);
        }
        //water plant in controller, that takes in the plant
    }

    /**
     * This method waters the plant in the library. It also plays a watering sound effect.
     * @param event The event that triggers the watering of the plant and goes back to the library if the plant is legendary.
     * @author Emre Mengütay
     * @author Mojtaba Hauari
     */
    public void waterPlantTwo(ActionEvent event) {
        mainBoundary.getPlantController().waterPlant(1);
        mainBoundary.getMusic().wateringSound();
        if(plantWaterBarTwo != null){
            plantWaterBarTwo.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(1));
            plantHealthBarTwo.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(1));
        }
        if(checkLegendary(1)) {
            goBackToLibrary(event);
        }
    }

    /**
     * This method waters the third plant in the library. It also plays a watering sound effect.
     * @param event The event that triggers the watering of the plant and goes back to the library if the plant is legendary.
     * @author Emre Mengütay
     * @author Mojtaba Hauari
     */
    public void waterPlantThree(ActionEvent event) {
        mainBoundary.getPlantController().waterPlant(2);
        mainBoundary.getMusic().wateringSound();
        if(plantWaterBarOne != null){
            plantWaterBarThree.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(2));
            plantHealthBarThree.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(2));
        }
        if(checkLegendary(2)) {
            goBackToLibrary(event);
        }
    }

    /**
     * This method simulates skipping a day for the first plant.
     * @author Emre Mengütay
     * @author Mojtaba Hauari
     */
    public void skipDay1(ActionEvent event){
        buttonClickSound();
        mainBoundary.getPlantController().skipDay(0);
        if(checkLegendary(0)) {
            goBackToLibrary(event);
        }
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();// implement skipping 1 day, this is plant spot specific.
        if(mainBoundary.getPlantController().getPlant(0) != null) {
            System.out.println(mainBoundary.getPlantController().getPlant(0).getLevel());
        }
    }

    /**
     * This method simulates skipping a day for the second plant.
     * @author Emre Mengütay
     * @author Mojtaba Hauari
     */
    public void skipDay2(ActionEvent event){
        buttonClickSound();
        mainBoundary.getPlantController().skipDay(1);
        if(checkLegendary(1)) {
            goBackToLibrary(event);
        }
        if(mainBoundary.getPlantController().getPlant(1) != null) {
            System.out.println(mainBoundary.getPlantController().getPlant(1).getLevel());
        }
    }

    /**
     * This method simulates skipping a day for the third plant.
     * @author Emre Mengütay
     * @author Mojtaba Hauari
     */
    public void skipDay3(ActionEvent event){
        buttonClickSound();
        mainBoundary.getPlantController().skipDay(2);
        if(checkLegendary(2)){
            goBackToLibrary(event);
        }
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();// implement skipping 1 day, this is plant spot specific.
        if(mainBoundary.getPlantController().getPlant(2) != null) {
            System.out.println(plant1.getLevel());
        }
    }

    /**
     * This method is called when the user clicks on the first seed button
     * What this method does is that it enables more buttons for the user to prompt him to plant the seed and-
     * -show more information about the seed
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     */
    public void showExtendedSeedMenu1(ActionEvent e){
        chooseSeedButtonExtended1.setVisible(true);
        seedSpecies1.setVisible(true);
        seedSpeciesLabel1.setVisible(true);
        seedSpeciesDifficualty1.setVisible(true);
        seedDifficualty1.setVisible(true);
        seedDifficultyBar1.setVisible(true);
        plantNewSeedButton1.setVisible(true);
    }

    /**
     * Same with this method but for the second seed
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     */
    public void showExtendedSeedMenu2(ActionEvent e){
        chooseSeedButtonExtended2.setVisible(true);
        seedSpecies2.setVisible(true);
        seedSpeciesLabel2.setVisible(true);
        seedSpeciesDifficualty2.setVisible(true);
        seedDifficualty2.setVisible(true);
        seedDifficultyBar2.setVisible(true);
        plantNewSeedButton2.setVisible(true);
    }

    /**
     * Same with this method but for the third seed
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     */
    public void showExtendedSeedMenu3(ActionEvent e){
        chooseSeedButtonExtended3.setVisible(true);
        seedSpecies3.setVisible(true);
        seedSpeciesLabel3.setVisible(true);
        seedSpeciesDifficualty3.setVisible(true);
        seedDifficualty3.setVisible(true);
        seedDifficultyBar3.setVisible(true);
        plantNewSeedButton3.setVisible(true);
    }

    /**
     * Same with this method but for the forth seed
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     */
    public void showExtendedSeedMenu4(ActionEvent e){
        chooseSeedButtonExtended4.setVisible(true);
        seedSpecies4.setVisible(true);
        seedSpeciesLabel4.setVisible(true);
        seedSpeciesDifficualty4.setVisible(true);
        seedDifficualty4.setVisible(true);
        seedDifficultyBar4.setVisible(true);
        plantNewSeedButton4.setVisible(true);
    }

    /**
     * Same with this method but for the fifth seed
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     */
    public void showExtendedSeedMenu5(ActionEvent e){
        chooseSeedButtonExtended5.setVisible(true);
        seedSpecies5.setVisible(true);
        seedSpeciesLabel5.setVisible(true);
        seedSpeciesDifficualty5.setVisible(true);
        seedDifficualty5.setVisible(true);
        seedDifficultyBar5.setVisible(true);
        plantNewSeedButton5.setVisible(true);
    }

    /**
     * this method is called when the user closes clicks on the prompt that was shown to close it down and hide it
     *
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     */
    public void hideExtendedSeedMenu1(ActionEvent e){
        chooseSeedButtonExtended1.setVisible(false);
        seedSpecies1.setVisible(false);
        seedSpeciesLabel1.setVisible(false);
        seedSpeciesDifficualty1.setVisible(false);
        seedDifficualty1.setVisible(false);
        seedDifficultyBar1.setVisible(false);
        plantNewSeedButton1.setVisible(false);
    }

    /**
     * This method does the same thing but for the second seed
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     */
    public void hideExtendedSeedMenu2(ActionEvent e){
        chooseSeedButtonExtended2.setVisible(false);
        seedSpecies2.setVisible(false);
        seedSpeciesLabel2.setVisible(false);
        seedSpeciesDifficualty2.setVisible(false);
        seedDifficualty2.setVisible(false);
        seedDifficultyBar2.setVisible(false);
        plantNewSeedButton2.setVisible(false);
    }

    /**
     * This method does the same thing but for the third seed
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     */
    public void hideExtendedSeedMenu3(ActionEvent e){
        chooseSeedButtonExtended3.setVisible(false);
        seedSpecies3.setVisible(false);
        seedSpeciesLabel3.setVisible(false);
        seedSpeciesDifficualty3.setVisible(false);
        seedDifficualty3.setVisible(false);
        seedDifficultyBar3.setVisible(false);
        plantNewSeedButton3.setVisible(false);
    }

    /**
     * This method does the same thing but for the forth seed
     * @param e the event that triggers the method
     * @author Mojtaba H
     */
    public void hideExtendedSeedMenu4(ActionEvent e){
        chooseSeedButtonExtended4.setVisible(false);
        seedSpecies4.setVisible(false);
        seedSpeciesLabel4.setVisible(false);
        seedSpeciesDifficualty4.setVisible(false);
        seedDifficualty4.setVisible(false);
        seedDifficultyBar4.setVisible(false);
        plantNewSeedButton4.setVisible(false);
    }

    /**
     * This method does the same thing but for the fifth seed
     * @param e the event that triggers the method
     * @author Mojtaba H
     */
    public void hideExtendedSeedMenu5(ActionEvent e){
        chooseSeedButtonExtended5.setVisible(false);
        seedSpecies5.setVisible(false);
        seedSpeciesLabel5.setVisible(false);
        seedSpeciesDifficualty5.setVisible(false);
        seedDifficualty5.setVisible(false);
        seedDifficultyBar5.setVisible(false);
        plantNewSeedButton5.setVisible(false);
    }

    /**
     * this method is called when the user wants to plant a seed and has named it
     * What this method does is that it checks which seed the user has chosen and then plants that seed
     * as well as playing a sound effect
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     * @author Emre Mengütay
     * @author Akmal Safi
     */
    public void plantSeedOne(ActionEvent e){
        buttonClickSound();
        if (namePlantField.getText().length() > 0) {
                String name = namePlantField.getText();
                System.out.println("in plant seed one");
                System.out.println(name);
                if(name != null){
                    switch (indexOfChosenSeed){
                        case 0:
                            mainBoundary.getPlantController().plantSeed(PlantTypes.CACTUS,name);
                            mainBoundary.getMusic().cactusSound();
                            break;
                        case 1:
                            mainBoundary.getPlantController().plantSeed(PlantTypes.PUMPKIN,name);
                            mainBoundary.getMusic().pumpkinSound();
                            break;
                        case 2:
                            mainBoundary.getPlantController().plantSeed(PlantTypes.MONSTERA,name);
                            mainBoundary.getMusic().monsteraSound();
                            break;
                        case 3:
                            mainBoundary.getPlantController().plantSeed(PlantTypes.SUNFLOWER,name);
                            mainBoundary.getMusic().sunflowerSound();
                            break;
                        case 4:
                            mainBoundary.getPlantController().plantSeed(PlantTypes.SNAKEPLANT,name);
                            mainBoundary.getMusic().snakeplantSound();
                            break;
                    }
                    goBackToLibrary(e);
                }
            }
    }

    /**
     * This method is called before the seed is planted and it prompts the user to name the plant.
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     * @author Emre Mengütay
     */
    public void namePlantPrompt(ActionEvent e){
        buttonClickSound();
        namePlantPrompt.setVisible(true);
        nameYourPlantLabel.setVisible(true);
        closeNamePlantButton.setVisible(true);
        enterNameButton.setVisible(true);
        namePlantField.setVisible(true);
        if(e.getSource() instanceof Button){
            Button button = (Button) e.getSource();
            if(button.getId().equals("plantNewSeedButton1")){
                this.indexOfChosenSeed = 0;
            }
            else if(button.getId().equals("plantNewSeedButton2")){
                this.indexOfChosenSeed = 1;
            }
            else if(button.getId().equals("plantNewSeedButton3")){
                this.indexOfChosenSeed = 2;
            }else if(button.getId().equals("plantNewSeedButton4")){
                this.indexOfChosenSeed = 3;
            }else if(button.getId().equals("plantNewSeedButton5")){
                this.indexOfChosenSeed = 4;
            }
        }
    }

    /**
     * This method is called when the user enters a name or when he closes the name prompt.
     * @param e the event that triggers the method
     * @author Mojtaba Hauari
     * @author Emre Mengütay
     */
    public void hideNamePrompt(ActionEvent e){
        buttonClickSound();
        namePlantPrompt.setVisible(false);
        namePlantField.setVisible(false);
        nameYourPlantLabel.setVisible(false);
        closeNamePlantButton.setVisible(false);
        enterNameButton.setVisible(false);
    }

    /**
     * This checks if the plant has reached legendary status and if so, it creates a legendary plant and deletes the
     * growing plant.
     * @param index the index of the plant in the plant array
     * @return true if the plant has reached legendary status, false otherwise
     * @author Emre Mengütay
     */
    public boolean checkLegendary(int index){
        if(mainBoundary.getPlantController().getPlant(index) != null) {

            int level1 = mainBoundary.getPlantController().getPlant(index).getLevel();
            if (level1 >= 10) {
                mainBoundary.getPlantController().createLegendary(mainBoundary.getPlantController().getPlant(index));
                mainBoundary.getPlantController().deleteGrowingPlant(index);
                ActionEvent event = new ActionEvent();
                return true;
            }
        }
        return false;
    }

    // Akmal Safi and mojtaba and Emre Mengütay
    //Fixed the metod which caused the problem in plant death
    /**
     * This method updates the current library scene with the current plants in the library.
     * It also checks if the plant has achieved legendary status and if so, it switches back to the library scene.
     * It also checks if there is space for a new plant and disables the plantNewSeedButton if there is no space.
     * It also updates the water and health bars of the plants in the library.
     * It also updates the level of the plants in the library.
     * It also updates the image of the plants in the library.
     * It also updates the visibility of the plants in the library.
     * @author Emre Mengütay
     * @author Mojtaba Hauari
     * @author Akmal safi
     */
    public void updateCurrentLibrary(){
        Plant plant1 = mainBoundary.getPlantController().getPlant(0);
        if (plant1 != null) {
            checkLegendary(0);
        }
        Plant plant2 = mainBoundary.getPlantController().getPlant(1);
        if (plant2 != null) {
            checkLegendary(1);
        }
        Plant plant3 = mainBoundary.getPlantController().getPlant(2);
        if (plant3 != null) {
            checkLegendary(2);
        }
        Timeline healthLoss = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            if (mainBoundary.getPlantController().getPlant(0) != null) {
                if(mainBoundary.getPlantController().getPlant(0).getHealthLevel()<1){
                    playHealthLossSound();
                }
            }
            if (mainBoundary.getPlantController().getPlant(1) != null) {
                if(mainBoundary.getPlantController().getPlant(1).getHealthLevel()<1){
                    playHealthLossSound();
                }
            }
            if (mainBoundary.getPlantController().getPlant(2) != null) {
             if(mainBoundary.getPlantController().getPlant(2).getHealthLevel()<1){
                 playHealthLossSound();
             }
            }
        }));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> {
            if (plantNewSeedButton != null) {
                plantNewSeedButton.setDisable(!mainBoundary.getPlantController().checkForSpace());
            }

            if (plant1 != null && mainBoundary.getPlantController().getPlant(0) != null) {
                String plantLevel1 = Integer.toString(mainBoundary.getPlantController().getPlant(0).getLevel());
                double plantWaterLevel1 = mainBoundary.getPlantController().getPlant(0).getWaterLevel();
                double plantHealthLevel1 = mainBoundary.getPlantController().getPlant(0).getHealthLevel();
                int level = mainBoundary.getPlantController().getPlant(0).getLevel();

                if (levelPlantOne != null && plantWaterBarOne != null) {
                    levelPlantOne.setText(plantLevel1);
                    imagePlantOne.setImage(mainBoundary.getPlantController().getPlant(0).getImage());
                    plantWaterBarOne.setProgress(plantWaterLevel1);
                    plantHealthBarOne.setProgress(plantHealthLevel1);


                    levelPlantOne.setVisible(true);
                    imagePlantOne.setVisible(true);
                    plantWaterBarOne.setVisible(true);
                    plantHealthBarOne.setVisible(true);
                    selectPlantOne.setVisible(true);
                    waterPlantOne.setVisible(true);
                }
            } else if (levelPlantOne != null && plantWaterBarOne != null) {
                plantWaterBarOne.setProgress(0);
                plantHealthBarOne.setProgress(0);

                levelPlantOne.setVisible(false);
                imagePlantOne.setVisible(false);

                plantWaterBarOne.setVisible(false);
                plantHealthBarOne.setVisible(false);
                selectPlantOne.setVisible(false);
                waterPlantOne.setVisible(false);
            }

            if (plant2 != null && mainBoundary.getPlantController().getPlant(1) != null) {
                String plantLevel2 = Integer.toString(mainBoundary.getPlantController().getPlant(1).getLevel());
                double plantWaterLevel2 = mainBoundary.getPlantController().getPlant(1).getWaterLevel();
                double plantHealthLevel2 = mainBoundary.getPlantController().getPlant(1).getHealthLevel();

                if (plantLeveltwo != null) {
                    plantLeveltwo.setText(plantLevel2);
                    imagePlantTwo.setImage(mainBoundary.getPlantController().getPlant(1).getImage());
                    plantWaterBarTwo.setProgress(plantWaterLevel2);
                    plantHealthBarTwo.setProgress(plantHealthLevel2);

                    plantLeveltwo.setVisible(true);
                    imagePlantTwo.setVisible(true);

                    plantWaterBarTwo.setVisible(true);
                    plantHealthBarTwo.setVisible(true);
                    selectPlantTwo.setVisible(true);
                    waterPlantTwo.setVisible(true);
                }
            } else if (plantLeveltwo != null) {
                plantWaterBarTwo.setProgress(0);
                plantHealthBarTwo.setProgress(0);

                plantLeveltwo.setVisible(false);
                imagePlantTwo.setVisible(false);

                plantWaterBarTwo.setVisible(false);
                plantHealthBarTwo.setVisible(false);
                selectPlantTwo.setVisible(false);
                waterPlantTwo.setVisible(false);
            }

            if (plant3 != null && mainBoundary.getPlantController().getPlant(2) != null) {
                String plantLevel3 = Integer.toString(mainBoundary.getPlantController().getPlant(2).getLevel());
                double plantWaterLevel3 = mainBoundary.getPlantController().getPlant(2).getWaterLevel();
                double plantHealthLevel3 = mainBoundary.getPlantController().getPlant(2).getHealthLevel();

                if (plantLevelThree != null) {
                    plantLevelThree.setText(plantLevel3);
                    imagePlantThree.setImage(mainBoundary.getPlantController().getPlant(2).getImage());
                    plantWaterBarThree.setProgress(plantWaterLevel3);
                    plantHealthBarThree.setProgress(plantHealthLevel3);

                    plantLevelThree.setVisible(true);
                    imagePlantThree.setVisible(true);

                    plantWaterBarThree.setVisible(true);
                    plantHealthBarThree.setVisible(true);
                    selectPlantThree.setVisible(true);
                    waterPlantThree.setVisible(true);
                }
            } else if (plantLevelThree != null) {
                plantWaterBarThree.setProgress(0);
                plantHealthBarThree.setProgress(0);

                plantLevelThree.setVisible(false);
                imagePlantThree.setVisible(false);

                plantWaterBarThree.setVisible(false);
                plantHealthBarThree.setVisible(false);
                selectPlantThree.setVisible(false);
                waterPlantThree.setVisible(false);
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        healthLoss.setCycleCount(Animation.INDEFINITE);
        healthLoss.play();
    }

    /**
     * This method selects the plant and switches to the plant info scene, it also checks if the plant has
     * achieved legendary status and if so, it switches back to the library scene.
     * @author Emre Mengütay
     * @author Mojtaba H
     */
    public void selectPlantOne(ActionEvent e){
        buttonClickSound();
        selectPlant(e,0);
        if(checkLegendary(0)) {
            goBackToLibrary(e);
        }
    }

    /**
     * This method selects the plant and switches to the plant info scene, it also checks if the plant has
     * achieved legendary status and if so, it switches back to the library scene.
     * @author Emre Mengütay
     * @author Mojtaba H
     */
    public void selectPlantTwo(ActionEvent e){
        buttonClickSound();
        selectPlant(e,1);
        if(checkLegendary(1)) {
            goBackToLibrary(e);
        }

    }

    /**
     * This method selects the plant and switches to the plant info scene, it also checks if the plant has
     * achieved legendary status and if so, it switches back to the library scene.
     * @author Emre Mengütay
     * @author Mojtaba H
     */
    public void selectPlantThree(ActionEvent e){
        buttonClickSound();
        selectPlant(e,2);
        if(checkLegendary(2)) {
            goBackToLibrary(e);
        }
    }

    /**
     * this method searches after the label on the active stage with the given id and returns it if it matches
     * @param stage the current stage
     * @param id the id of the label
     * @return if the label is found it returns the label, otherwise it returns null
     * @author Mojtaba H
     */
    public Label getLabelFromStage(Stage stage, String id){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof Label && node.getId().equals(id)){
                    return (Label) node;
                }
            }
        }
        return null;
    }

    /**
     * this method searches after an imageview on the active stage and returns the first one it finds
     * @param stage current stage
     * @return imageview if found, otherwise null
     * @author Mojtaba H
     */
    public ImageView getImageViewFromStage(Stage stage){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof ImageView){
                    return (ImageView) node;
                }
            }
        }
        return null;
    }

    /**
     * this one searches for an imageview on the stage but with a specific id
     * @param stage the current stage
     * @param id  the id of the imageview
     * @return the imageview if found, otherwise null
     * @author Mojtaba H
     */
    public ImageView getImageViewFromStage(Stage stage, String id){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof ImageView && node.getId() != null && node.getId().equals(id)){
                    return (ImageView) node;
                }
            }
        }
        return null;
    }

    /**
     * this method searches for a button on the active stage with a specific id
     * @param stage the current stage
     * @param id the id of the button
     * @return the button if found, otherwise null
     * @author Mojtaba H
     */
    public Button getButtonsFromSelectPlantScene(Stage stage, String id){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof Button && node.getId().equals(id)){
                    return (Button) node;
                }
            }
        }
        return null;
    }

    private GridPane getLegendaryGridPane(Stage stage){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof ScrollPane scrollPane){
                    StackPane stackPane = (StackPane) scrollPane.getContent();

                    for(Node node2 : stackPane.getChildren()){
                        if (node2 instanceof GridPane gridPane) {
                            return gridPane;

                        }
                    }
                }

            }
        }
        return null;
    }

    /**
     * this method searches for a progressbar with a hardcoded ID
     * @param stage the current stage
     * @return the progressbar if found, otherwise null
     * @author Mojtaba H
     */
    public ProgressBar getWaterBarInSelectPlantScene(Stage stage){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof ProgressBar && node.getId().equals("waterBarInSelectPlantScene")){
                    return (ProgressBar) node;
                }
            }
        }
        return null;
    }

    /**
     * this method uses a timeline to update the picture of the plant in the select plant scene based on levels every two seconds
     * @param imageView the imageview that needs to be updated
     * @param index the index of the plant
     * @author Mojtaba H
     */
    public void updatePictureInSelectPlantScene(ImageView imageView, int index){
        int level = mainBoundary.getPlantController().getPlant(index).getLevel();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),e ->{
            if(imageView != null){
                if(mainBoundary.getPlantController().getPlant(index) != null) {
                    if(level < 25){
                        mainBoundary.getPlantController().setPlantImage(mainBoundary.getPlantController().getPlant(index));
                    }else if(level < 50 && level >= 25){
                        mainBoundary.getPlantController().setPlantImage(mainBoundary.getPlantController().getPlant(index));
                    }else if(level < 75 && level >= 50){
                        mainBoundary.getPlantController().setPlantImage(mainBoundary.getPlantController().getPlant(index));
                    }else if(level < 100 && level >= 75){
                        mainBoundary.getPlantController().setPlantImage(mainBoundary.getPlantController().getPlant(index));
                    }
                    imageView.setImage(mainBoundary.getPlantController().getPlant(index).getImage());
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    /**
     * This method uses a timeline to update the water and health bar in the select plant scene every x seconds.
     * @author Emre Mengütay
     * @author Mojtaba H
     */
    public void updateWaterAndHealthBar(ProgressBar waterBar, ProgressBar healthBar, int index){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.001),e ->{
            if(waterBar != null && healthBar != null){
                if(mainBoundary.getPlantController().getPlant(index) != null) {
                    waterBar.setProgress(mainBoundary.getPlantController().getPlant(index).getWaterLevel());
                    healthBar.setProgress(mainBoundary.getPlantController().getPlant(index).getHealthLevel());
                    int level = mainBoundary.getPlantController().getPlant(index).getLevel();
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * This method also searches for a progressbar with a hardcoded ID can be replaced with one that takes in an ID
     * @param stage the current stage
     * @return the progressbar if found, otherwise null
     */
    public ProgressBar getHealthBarInSelectPlantScene(Stage stage){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof ProgressBar && node.getId().equals("healthBarInSelectPlantScene")){
                    return (ProgressBar) node;
                }
            }
        }
        return null;
    }

    /**
     * this method is called after the user selects a plant
     * What this method does is that it sets up the select plant seed with the right buttons corresponding to the right plant object that was selected
     *
     * @param stage the current stage
     * @param index the index of the plant that was selected
     * @author Mojtaba H
     */
    public void setUpSelectPlantScene(Stage stage,int index){
        speciesNameInSelectPlantScene = getLabelFromStage(stage, "speciesNameInSelectPlantScene");
        plantNameInSelectPlantScene = getLabelFromStage(stage, "plantNameInSelectPlantScene");
        if(index == 0){
            Button waterThePlantOne = getButtonsFromSelectPlantScene(stage, "waterThePlantOne");
            Button skipDayButton1 = getButtonsFromSelectPlantScene(stage, "skipDayButton1");
            Button placeOnDesk1 = getButtonsFromSelectPlantScene(stage, "placeOnDesk1");
            Button deletePlantButton = getButtonsFromSelectPlantScene(stage, "deletePlantButton");
            speciesNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(0).getType().toString());
            plantNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(0).getName());
            deletePlantButton.setVisible(true);
            waterThePlantOne.setVisible(true);
            skipDayButton1.setVisible(true);
            placeOnDesk1.setVisible(true);
        }
        else if(index == 1){
            Button waterThePlantTwo = getButtonsFromSelectPlantScene(stage, "waterThePlantTwo");
            Button skipDayButton2 = getButtonsFromSelectPlantScene(stage, "skipDayButton2");
            Button placeOnDesk2 = getButtonsFromSelectPlantScene(stage, "placeOnDesk2");
            Button deletePlantButton2 = getButtonsFromSelectPlantScene(stage, "deletePlantButton2");
            speciesNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(1).getType().toString());
            plantNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(1).getName());
            deletePlantButton2.setVisible(true);
            waterThePlantTwo.setVisible(true);
            skipDayButton2.setVisible(true);
            placeOnDesk2.setVisible(true);
        }
        else if(index == 2){
            Button waterThePlantThree = getButtonsFromSelectPlantScene(stage, "waterThePlantThree");
            Button skipDayButton3 = getButtonsFromSelectPlantScene(stage, "skipDayButton3");
            Button placeOnDesk3 = getButtonsFromSelectPlantScene(stage, "placeOnDesk3");
            Button deletePlantButton3 = getButtonsFromSelectPlantScene(stage, "deletePlantButton3");
            speciesNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(2).getType().toString());
            plantNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(2).getName());
            deletePlantButton3.setVisible(true);
            waterThePlantThree.setVisible(true);
            skipDayButton3.setVisible(true);
            placeOnDesk3.setVisible(true);
        }
    }

    /**
     * This method is called when the user selects a plant to show as a widget
     * This method and the one above does the same thing but for different stages
     * This method sets up the widget scene with the right buttons and labels corresponding to the right plant object that was selected
     * @param button the button that was clicked
     * @param stage the current stage
     */
    public void setupWidgetScene(Button button, Stage stage){
        if(button.getId().equals("placeOnDesk1")){
            ImageView imagePlantOne = getImageViewFromStage(stage);
            imagePlantOne.setImage(mainBoundary.getPlantController().getPlant(0).getImage());
            ProgressBar waterBarInWidgetScene = getProgressBarFromStage(stage,"waterBarInWidgetScene");
            ProgressBar healthBarInWidgetScene = getProgressBarFromStage(stage,"healthBarInWidgetScene");
            waterBarInWidgetScene.setProgress(mainBoundary.getPlantController().getPlant(0).getWaterLevel());
            healthBarInWidgetScene.setProgress(mainBoundary.getPlantController().getPlant(0).getHealthLevel());
            updateWaterAndHealthBar(waterBarInWidgetScene, healthBarInWidgetScene, 0);
            Button waterButton1 = getButtonsFromSelectPlantScene(stage, "waterThePlantOne");
            waterButton1.setVisible(true);
        }
        if(button.getId().equals("placeOnDesk2")){
            ImageView imagePlantTwo = getImageViewFromStage(stage);
            imagePlantTwo.setImage(mainBoundary.getPlantController().getPlant(1).getImage());
            ProgressBar waterBarInWidgetScene = getProgressBarFromStage(stage,"waterBarInWidgetScene");
            ProgressBar healthBarInWidgetScene = getProgressBarFromStage(stage,"healthBarInWidgetScene");
            waterBarInWidgetScene.setProgress(mainBoundary.getPlantController().getPlant(1).getWaterLevel());
            healthBarInWidgetScene.setProgress(mainBoundary.getPlantController().getPlant(1).getHealthLevel());
            updateWaterAndHealthBar(waterBarInWidgetScene, healthBarInWidgetScene, 1);
            Button waterButton2 = getButtonsFromSelectPlantScene(stage, "waterThePlantTwo");
            waterButton2.setVisible(true);
        }
        if(button.getId().equals("placeOnDesk3")){
            ImageView imagePlantThree = getImageViewFromStage(stage);
            imagePlantThree.setImage(mainBoundary.getPlantController().getPlant(2).getImage());
            ProgressBar waterBarInWidgetScene = getProgressBarFromStage(stage,"waterBarInWidgetScene");
            ProgressBar healthBarInWidgetScene = getProgressBarFromStage(stage,"healthBarInWidgetScene");
            waterBarInWidgetScene.setProgress(mainBoundary.getPlantController().getPlant(2).getWaterLevel());
            healthBarInWidgetScene.setProgress(mainBoundary.getPlantController().getPlant(2).getHealthLevel());
            updateWaterAndHealthBar(waterBarInWidgetScene, healthBarInWidgetScene, 2);
            Button waterButton3 = getButtonsFromSelectPlantScene(stage, "waterThePlantThree");
            waterButton3.setVisible(true);
        }
    }

    /**
     * this method sets up the seed scene with the right images to match the information of the plants
     * @param stage the current stage
     * @author Mojtaba Hauari
     * @author Emre Mengütay
     */
    public void setUpSeedScene(Stage stage){
        InputStream inputStream = getClass().getResourceAsStream("/images/plant1/cactusLvl4.png");
        Image image = new Image(inputStream);
        ImageView imageView = getImageViewFromStage(stage,"seedImage1");
        imageView.setImage(image);
        InputStream inputStream2 = getClass().getResourceAsStream("/images/plant2/pumpkinLvl4.png");
        Image image2 = new Image(inputStream2);
        ImageView imageView2 = getImageViewFromStage(stage,"seedImage2");
        imageView2.setImage(image2);
        InputStream inputStream3 = getClass().getResourceAsStream("/images/plant3/monsteraLvl4.png");
        Image image3 = new Image(inputStream3);
        ImageView imageView3 = getImageViewFromStage(stage,"seedImage3");
        imageView3.setImage(image3);
    }

    /**
     * This method is one that searches and returns a progress bar in the stage with a specific id
     * @param stage the current stage
     * @param id the id of the progress bar
     * @return the progress bar if found, otherwise null
     * @author Mojtaba Hauari
     */
    public ProgressBar getProgressBarFromStage(Stage stage, String id){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof ProgressBar && node.getId().equals(id)){
                    return (ProgressBar) node;
                }
            }
        }
        return null;
    }

    /**
     * this method is called when the user clicks on the right button in the seed scene
     * What this method does is that it changes the images of the seeds that are shown by-
     * - disabling the current images and enabling the new ones
     * @param e the action event that was triggered by the user
     */
    public void switchSeedsToRight(ActionEvent e){
        buttonClickSound();
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        leftArrow.setVisible(true);
        switchSeedButtonLeft.setVisible(true);
        rightArrow.setVisible(false);
        switchSeedButtonRight.setVisible(false);

        Button chooseSeedButton1 = getButtonsFromSelectPlantScene(stage,"chooseSeedButton1");
        chooseSeedButton1.setVisible(false);
        ImageView imageView = getImageViewFromStage(stage,"seedImage1");
        imageView.setVisible(false);
        ProgressBar difficultyBarThree2 = getProgressBarFromStage(stage,"difficultyBarThree2");
        difficultyBarThree2.setVisible(false);

        chooseSeedButton2.setVisible(false);
        ImageView imageView2 = getImageViewFromStage(stage,"seedImage2");
        imageView2.setVisible(false);
        ProgressBar difficultyBarThree1 = getProgressBarFromStage(stage,"difficultyBarThree1");
        difficultyBarThree1.setVisible(false);

        chooseSeedButton3.setVisible(false);
        ImageView imageView3 = getImageViewFromStage(stage,"seedImage3");
        imageView3.setVisible(false);
        difficultyBarThree.setVisible(false);

        hideExtendedSeedMenu1(e);
        hideExtendedSeedMenu2(e);
        hideExtendedSeedMenu3(e);

        chooseSeedButton4.setVisible(true);
        ImageView imageView4 = getImageViewFromStage(stage,"seedImage4");
        imageView4.setVisible(true);
        ProgressBar difficultyBarFour = getProgressBarFromStage(stage,"difficultyBarThree21");
        difficultyBarFour.setVisible(true);

        chooseSeedButton5.setVisible(true);
        ImageView imageView5 = getImageViewFromStage(stage,"seedImage5");
        imageView5.setVisible(true);
        ProgressBar difficultyBarFive = getProgressBarFromStage(stage,"difficultyBarThree11");
        difficultyBarFive.setVisible(true);
    }

    /**
     * this method is called when the user clicks on the left button in the seed scene
     * What this method does is that it changes the images of the seeds that are shown by-
     * - disabling the current images and enabling the new ones
     * @param e the action event that was triggered by the user
     */
    public void switchSeedsToLeft(ActionEvent e){
        buttonClickSound();
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        leftArrow.setVisible(false);
        switchSeedButtonLeft.setVisible(false);
        rightArrow.setVisible(true);
        switchSeedButtonRight.setVisible(true);

        Button chooseSeedButton1 = getButtonsFromSelectPlantScene(stage,"chooseSeedButton1");
        chooseSeedButton1.setVisible(true);
        ImageView imageView = getImageViewFromStage(stage,"seedImage1");
        imageView.setVisible(true);
        ProgressBar difficultyBarThree2 = getProgressBarFromStage(stage,"difficultyBarThree2");
        difficultyBarThree2.setVisible(true);

        chooseSeedButton2.setVisible(true);
        ImageView imageView2 = getImageViewFromStage(stage,"seedImage2");
        imageView2.setVisible(true);
        ProgressBar difficultyBarThree1 = getProgressBarFromStage(stage,"difficultyBarThree1");
        difficultyBarThree1.setVisible(true);

        chooseSeedButton3.setVisible(true);
        ImageView imageView3 = getImageViewFromStage(stage,"seedImage3");
        imageView3.setVisible(true);
        difficultyBarThree.setVisible(true);

        chooseSeedButton4.setVisible(false);
        ImageView imageView4 = getImageViewFromStage(stage,"seedImage4");
        imageView4.setVisible(false);
        ProgressBar difficultyBarFour = getProgressBarFromStage(stage,"difficultyBarThree21");
        difficultyBarFour.setVisible(false);

        chooseSeedButton5.setVisible(false);
        ImageView imageView5 = getImageViewFromStage(stage,"seedImage5");
        imageView5.setVisible(false);
        ProgressBar difficultyBarFive = getProgressBarFromStage(stage,"difficultyBarThree11");
        difficultyBarFive.setVisible(false);

        hideExtendedSeedMenu5(e);
        hideExtendedSeedMenu4(e);
    }

    public void deletePlantHover(){
        imageX1.setImage(new Image(getClass().getResourceAsStream("/images/remove.png")));
    }

    public void buttonClickSound(){
        mainBoundary.getMusic().buttonClickSound();
    }

    public void closeProgramSound(){
        mainBoundary.getMusic().closeProgramSound();
    }

    public void stopMusic(){
        mainBoundary.getMusic().stopMusic();
    }

    public void turnOnMusic(){
        Music music = mainBoundary.getMusic();
        if (music.getClipMusic() != null && music.getClipMusic().isRunning()) {
            music.stopMusic();
        }else {
            music.playMusic("musicc/mountainflowers.wav");}
    }

    public void turnOnMusic1(){
        Music music = mainBoundary.getMusic();
        if (music.getClipMusic() != null && music.getClipMusic().isRunning()) {
            music.stopMusic();
        }else {
            music.playMusic("src/main/resources/sounds/euphoria.wav");}
    }

    public void turnOnMusic2(){
        Music music = mainBoundary.getMusic();
        if (music.getClipMusic() != null && music.getClipMusic().isRunning()) {
            music.stopMusic();
        }else {
            music.playMusic("src/main/resources/sounds/Sweden.wav");}
    }

    public void playSadMusic(){
        mainBoundary.getMusic().playSadSound();
    }

    public void playHealthLossSound(){
        mainBoundary.getMusic().healthSound();
    }

    public void closePopUp(ActionEvent event){
        buttonClickSound();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void openPopUp(ActionEvent ev){
        buttonClickSound();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/plantwidget_g18_gui/legendary_pop-up.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openPopUpSeed(ActionEvent ev){
        buttonClickSound();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/plantwidget_g18_gui/seed_pop-up.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method changes the pot image to HelloKitty
     * @param actionEvent the event that triggers the method
     * @author Yrja Mai Hoang
     */
    public void setPotHelloKitty(ActionEvent actionEvent) {
        mainBoundary.getPlantController().setPotHelloKitty();
    }

    /**
     * This method changes the pot image to Mort
     * @param actionEvent the event that triggers the method
     * @author Yrja Mai Hoang
     */
    public void setPotMort(ActionEvent actionEvent) {
        mainBoundary.getPlantController().setPotMort();
    }

    /**
     * This method changes the pot image to Peter
     * @param actionEvent the event that triggers the method
     * @author Yrja Mai Hoang
     */
    public void setPotPeter(ActionEvent actionEvent) {
        mainBoundary.getPlantController().setPotPeter();
    }

    /**
     * This method changes the pot image to Roblox
     * @param actionEvent the event that triggers the method
     * @author Yrja Mai Hoang
     */
    public void setPotRoblox(ActionEvent actionEvent) {
        mainBoundary.getPlantController().setPotRoblox();
    }

    /**
     * This method changes the pot image to Smile
     * @param actionEvent the event that triggers the method
     * @author Yrja Mai Hoang
     */
    public void setPotSmile(ActionEvent actionEvent) {
        mainBoundary.getPlantController().setPotSmile();
    }

    /**
     * This method changes the pot image to Sponge
     * @param actionEvent the event that triggers the method
     * @author Yrja Mai Hoang
     */
    public void setPotSponge(ActionEvent actionEvent) {
        mainBoundary.getPlantController().setPotSponge();
    }
}