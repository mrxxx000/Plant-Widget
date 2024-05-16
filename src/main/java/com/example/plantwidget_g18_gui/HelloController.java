package com.example.plantwidget_g18_gui;

import Controller.PlantController;
import Model.LegendaryPlant;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
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
    private Button chooseSeedButton1;
    @FXML
    private Button chooseSeedButton2;
    @FXML
    private Button chooseSeedButton3;
    @FXML
    private Button settingsButton;
    @FXML
    private Button chooseSeedButtonExtended1;
    @FXML
    private Button chooseSeedButtonExtended2;
    @FXML
    private Button chooseSeedButtonExtended3;
    @FXML
    private Rectangle seedSpecies1;
    @FXML
    private Rectangle seedSpecies2;
    @FXML
    private Rectangle seedSpecies3;
    @FXML
    private Label seedSpeciesLabel1;
    @FXML
    private Label seedSpeciesLabel2;
    @FXML
    private Label seedSpeciesLabel3;
    @FXML
    private Rectangle seedSpeciesDifficualty1;
    @FXML
    private Rectangle seedSpeciesDifficualty2;
    @FXML
    private Rectangle seedSpeciesDifficualty3;
    @FXML
    private Label seedDifficualty1;
    @FXML
    private Label seedDifficualty2;
    @FXML
    private Label seedDifficualty3;
    @FXML
    private ProgressBar seedDifficultyBar1;
    @FXML
    private ProgressBar seedDifficultyBar2;
    @FXML
    private ProgressBar seedDifficultyBar3;

    @FXML
    private Button plantNewSeedButton1;
    @FXML
    private Button plantNewSeedButton2;
    @FXML
    private Button plantNewSeedButton3;
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

    /*
         switches gui to the plant info scene, currently only works for plant number 1.
     */
    public void selectPlant(ActionEvent event, int index){
        mainBoundary.getPlantController().startTheTimer();
        timelineUpdateHealth.playFromStart();
        mainBoundary.getPlantController().SavePlantToFile();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlantInfoGUI.fxml"));
            scene = new Scene(fxmlLoader.load());
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Plant Widget Library!");
            //stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setScene(scene);
            mouseMoveable(scene);

            ImageView plantImageForInfo = getImageViewFromStage(stage); // this gets the imageview from the stage so to set the image of the plant
            plantImageForInfo.setImage(mainBoundary.getPlantController().getPlant(index).getImage());//sets the image but i dont know if this breaks MVC
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
    /*
     this turns the first plant in to a widget, specific to plant number 1.
     */
    public void placeOnDesk1(ActionEvent event){
        mainBoundary.getPlantController().startTheTimer();
        //timelineUpdateHealth.playFromStart();
        mainBoundary.getPlantController().SavePlantToFile();
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
    /*
         switches gui settings scene
     */
    public void goToSettings(ActionEvent event){
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
    /*
        makes the scene moveable
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
    /*
        CLOSES THE PROGRAM
    */
    public void closeProgram(ActionEvent event){
        mainBoundary.getPlantController().timeTrackWriter();
        mainBoundary.getPlantController().SavePlantToFile();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void deletePlant1(ActionEvent event){
        mainBoundary.getPlantController().discardPlant1();
        mainBoundary.getPlantController().SavePlantToFile();
        mainBoundary.getPlantController().LoadPlantsFromFile();
        goBackToLibrary(event);
        System.out.println("Plant Deleted");
    }

    public void deletePlant2(ActionEvent event){
        mainBoundary.getPlantController().discardPlant2();
        mainBoundary.getPlantController().SavePlantToFile();
        mainBoundary.getPlantController().LoadPlantsFromFile();
        goBackToLibrary(event);
        System.out.println("Plant Deleted");
    }
    public void deletePlant3(ActionEvent event){
        mainBoundary.getPlantController().discardPlant3();
        mainBoundary.getPlantController().SavePlantToFile();
        mainBoundary.getPlantController().LoadPlantsFromFile();
        goBackToLibrary(event);
        System.out.println("Plant Deleted");
    }
    /*
        GOES BACK TO THE PLANT LIBRARY GUI SCENE
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
        updateGUI();
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
    /*
            GOES TO THE PLANT NEW SEED SCENE, OR THE FIRST GUI WHEN OPENING PROGRAM FOR THE FIRST TIME
        */
    public void goTochooseSeedScene(ActionEvent event){
        mainBoundary.getPlantController().stopTheTimer();
        timelineUpdateHealth.stop();
        mainBoundary.getPlantController().SavePlantToFile();
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


    /*
            UPDATES THE HEALTH BAR OF THE FIRST PLANT
        */
    public void updatePlantHealthBarOne() {
        if(plantHealthBarOne != null && mainBoundary.getPlantController().getPlant(0) != null){
            plantHealthBarOne.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(0)); // implement health level
        }
    }
    /*
        UPDATES TEH WATER BAR OF THE FIRST PLANT
    */
    public void updatePlantWaterBarOne() {
        if(plantWaterBarOne != null && mainBoundary.getPlantController().getPlant(0) != null){
            plantWaterBarOne.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(0)); // implement water level
        }
    }
    /*
        THIS METHOD IS CALLED WHEN THE GUI IS INITIALIZED, IT'S LIKE A CONSTRUCTOR FOR THE GUI.
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
    public HelloController() {
        this.pot = new ImageView();
        this.pot2 = new ImageView();
        this.pot3 = new ImageView();
        pot.setVisible(false);
        pot2.setVisible(false);
        pot3.setVisible(false);
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
            if(plants != null) {
                for (int i = 0; i < plants.length; i++) {
                    if (plants[i] != null && plants[i].getHealthLevel() < 0.01 ) {
                        try {
                            showDeathAlert();
                        }catch (Exception e){
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

    public void showDeathAlert() {
        JButton backButton = new JButton(":(");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                goBackToLibrarySwing();
            }
        });

        String message = "Your plant has died... you should be ashamed of yourself...";
        Object[] params = {message, backButton};

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(params);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Death Alert");
        dialog.setVisible(true);
    }


    public void goBackToLibrarySwing() {
        Platform.runLater(() -> {
            mainBoundary.getPlantController().startTimer();
            timelineUpdateHealth.playFromStart();
            mainBoundary.getPlantController().SavePlantToFile();
            mainBoundary.getPlantController().LoadPlantsFromFile();
            updateGUI();
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

    public void waterPlantOne(ActionEvent event){
        mainBoundary.getPlantController().waterPlant(0);
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();
        if(checkLegendary(0)){
            goBackToLibrary(event);
        }
        //water plant in controller, that takes in the plant
    }

    public void waterPlantTwo(ActionEvent event) {
        mainBoundary.getPlantController().waterPlant(1);
        if(plantWaterBarTwo != null){
            plantWaterBarTwo.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(1));
            plantHealthBarTwo.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(1));
        }
        if(checkLegendary(1)) {
            goBackToLibrary(event);
        }
    }

    public void waterPlantThree(ActionEvent event) {
        mainBoundary.getPlantController().waterPlant(2);
        if(plantWaterBarOne != null){
            plantWaterBarThree.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(2));
            plantHealthBarThree.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(2));
        }
        if(checkLegendary(2)) {
            goBackToLibrary(event);
        }
    }

    public void skipDay1(ActionEvent event){
        mainBoundary.getPlantController().skipDay(0);
        if(checkLegendary(0)) {
            goBackToLibrary(event);
        }
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();// implement skipping 1 day, this is plant spot specific.
        System.out.println(mainBoundary.getPlantController().getPlant(0).getLevel());
    }

    public void skipDay2(ActionEvent event){
        mainBoundary.getPlantController().skipDay(1);
        if(checkLegendary(1)) {
            goBackToLibrary(event);
        }
        System.out.println(mainBoundary.getPlantController().getPlant(1).getLevel());
    }

    public void skipDay3(ActionEvent event){
        mainBoundary.getPlantController().skipDay(2);
        if(checkLegendary(2)){
            goBackToLibrary(event);
        }
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();// implement skipping 1 day, this is plant spot specific.
        System.out.println(plant1.getLevel());
    }

    /**
     * same with this metod
     * @param e
     * Akmal Safi
     */
    public void plantSeed(ActionEvent e){
        System.out.println("planted seed");
        PlantController.getInstance().plantSeed(selectedPlantType,"Name of the plant");
        goBackToLibrary(e);
    }

    public void showExtendedSeedMenu1(ActionEvent e){
        chooseSeedButtonExtended1.setVisible(true);
        seedSpecies1.setVisible(true);
        seedSpeciesLabel1.setVisible(true);
        seedSpeciesDifficualty1.setVisible(true);
        seedDifficualty1.setVisible(true);
        seedDifficultyBar1.setVisible(true);
        plantNewSeedButton1.setVisible(true);
    }
    public void showExtendedSeedMenu2(ActionEvent e){
        chooseSeedButtonExtended2.setVisible(true);
        seedSpecies2.setVisible(true);
        seedSpeciesLabel2.setVisible(true);
        seedSpeciesDifficualty2.setVisible(true);
        seedDifficualty2.setVisible(true);
        seedDifficultyBar2.setVisible(true);
        plantNewSeedButton2.setVisible(true);


    }
    public void showExtendedSeedMenu3(ActionEvent e){
        chooseSeedButtonExtended3.setVisible(true);
        seedSpecies3.setVisible(true);
        seedSpeciesLabel3.setVisible(true);
        seedSpeciesDifficualty3.setVisible(true);
        seedDifficualty3.setVisible(true);
        seedDifficultyBar3.setVisible(true);
        plantNewSeedButton3.setVisible(true);
    }

    public void hideExtendedSeedMenu1(ActionEvent e){
        chooseSeedButtonExtended1.setVisible(false);
        seedSpecies1.setVisible(false);
        seedSpeciesLabel1.setVisible(false);
        seedSpeciesDifficualty1.setVisible(false);
        seedDifficualty1.setVisible(false);
        seedDifficultyBar1.setVisible(false);
        plantNewSeedButton1.setVisible(false);
    }

    public void hideExtendedSeedMenu2(ActionEvent e){
        chooseSeedButtonExtended2.setVisible(false);
        seedSpecies2.setVisible(false);
        seedSpeciesLabel2.setVisible(false);
        seedSpeciesDifficualty2.setVisible(false);
        seedDifficualty2.setVisible(false);
        seedDifficultyBar2.setVisible(false);
        plantNewSeedButton2.setVisible(false);
    }

    public void hideExtendedSeedMenu3(ActionEvent e){
        chooseSeedButtonExtended3.setVisible(false);
        seedSpecies3.setVisible(false);
        seedSpeciesLabel3.setVisible(false);
        seedSpeciesDifficualty3.setVisible(false);
        seedDifficualty3.setVisible(false);
        seedDifficultyBar3.setVisible(false);
        plantNewSeedButton3.setVisible(false);
    }
    public void updateLevelPlantOne(){
        levelPlantOne.setText(String.valueOf(mainBoundary.getPlantController().getPlant(0).getLevel()));
    }

    public void plantSeedOne(ActionEvent e){
            if (namePlantField.getText().length() > 0) {
                String name = namePlantField.getText();
                System.out.println("in plant seed one");
                System.out.println(name);
                if(name != null){
                    switch (indexOfChosenSeed){
                        case 0:
                            mainBoundary.getPlantController().plantSeed(PlantTypes.CACTUS,name);
                            break;
                        case 1:
                            mainBoundary.getPlantController().plantSeed(PlantTypes.PUMPKIN,name);
                            break;
                        case 2:
                            mainBoundary.getPlantController().plantSeed(PlantTypes.MONSTERA,name);
                            break;
                    }
                    goBackToLibrary(e);
                }
            }
    }

    public void namePlantPrompt(ActionEvent e){
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
            }
        }
    }

    public void hideNamePrompt(ActionEvent e){
        namePlantPrompt.setVisible(false);
        namePlantField.setVisible(false);
        nameYourPlantLabel.setVisible(false);
        closeNamePlantButton.setVisible(false);
        enterNameButton.setVisible(false);
    }

    public boolean checkLegendary(int index){
        int level1 = mainBoundary.getPlantController().getPlant(index).getLevel();
        if(level1>=100){
            mainBoundary.getPlantController().createLegendary(mainBoundary.getPlantController().getPlant(index));
            mainBoundary.getPlantController().deleteGrowingPlant(index);
            ActionEvent event = new ActionEvent();
            return true;
        }
        return false;
    }
    public void updateCurrentLibrary(){
        Plant plant1 = mainBoundary.getPlantController().getPlant(0);
        if(plant1 != null){
            checkLegendary(0);
        }
        Plant plant2 = mainBoundary.getPlantController().getPlant(1);
        if(plant2 != null){
            checkLegendary(1);
        }
        Plant plant3 = mainBoundary.getPlantController().getPlant(2);
        if(plant3 != null){
            checkLegendary(2);
        }
        /*for(int i =0;i<mainBoundary.getPlantController().getGrowingPlantsArray().length;i++){
            checkLegendary(i);
        }*/

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1),e ->{
            if(plantNewSeedButton !=null) {
                if (mainBoundary.getPlantController().checkForSpace() == false) {
                    plantNewSeedButton.setDisable(true);
                } else {
                    plantNewSeedButton.setDisable(false);
                }
            }

            if(plant1 != null && mainBoundary.getPlantController().getPlant(0) != null){
                String plantLevel1 = Integer.toString(mainBoundary.getPlantController().getPlant(0).getLevel());
                double plantWaterLevel1 = mainBoundary.getPlantController().getPlant(0).getWaterLevel();
                double plantHealthLevel1 = mainBoundary.getPlantController().getPlant(0).getHealthLevel();
                int level = mainBoundary.getPlantController().getPlant(0).getLevel();

                if(levelPlantOne!= null && plantWaterBarOne!=null) {
                    levelPlantOne.setText(plantLevel1);
                    imagePlantOne.setImage(mainBoundary.getPlantController().getPlant(0).getImage());
                    plantWaterBarOne.setProgress(plantWaterLevel1);
                    plantHealthBarOne.setProgress(plantHealthLevel1);

                    levelPlantOne.setVisible(true);
                    imagePlantOne.setVisible(true);
                    pot.setVisible(true);
                    plantWaterBarOne.setVisible(true);
                    plantHealthBarOne.setVisible(true);
                    selectPlantOne.setVisible(true);
                    waterPlantOne.setVisible(true);
                    //pot.setVisible(true);
                }
            }else if(levelPlantOne != null && plantWaterBarOne != null){
                plantWaterBarOne.setProgress(0);
                plantHealthBarOne.setProgress(0);

                levelPlantOne.setVisible(false);
                imagePlantOne.setVisible(false);
                pot.setVisible(false);
                plantWaterBarOne.setVisible(false);
                plantHealthBarOne.setVisible(false);
                selectPlantOne.setVisible(false);
                waterPlantOne.setVisible(false);
            }
            else{

            }
            if(plant2 != null && mainBoundary.getPlantController().getPlant(1) != null){
                String plantLevel2 = Integer.toString(mainBoundary.getPlantController().getPlant(1).getLevel());
                double plantWaterLevel2 = mainBoundary.getPlantController().getPlant(1).getWaterLevel();
                double plantHealthLevel2 = mainBoundary.getPlantController().getPlant(1).getHealthLevel();


                if(plantLeveltwo!= null) {
                    plantLeveltwo.setText(plantLevel2);
                    imagePlantTwo.setImage(mainBoundary.getPlantController().getPlant(1).getImage()); // not working rn
                    plantWaterBarTwo.setProgress(plantWaterLevel2);
                    plantHealthBarTwo.setProgress(plantHealthLevel2);

                    plantLeveltwo.setVisible(true);
                    imagePlantTwo.setVisible(true);
                    pot2.setVisible(true);
                    plantWaterBarTwo.setVisible(true);
                    plantHealthBarTwo.setVisible(true);
                    selectPlantTwo.setVisible(true);
                    waterPlantTwo.setVisible(true);
                    //pot2.setVisible(true);
                }
                else if(plantLeveltwo != null){
                    plantHealthBarTwo.setProgress(0);
                    plantHealthBarTwo.setProgress(0);

                    plantLeveltwo.setVisible(false);
                    imagePlantTwo.setVisible(false);
                    pot.setVisible(false);
                    plantWaterBarTwo.setVisible(false);
                    plantHealthBarTwo.setVisible(false);
                    selectPlantTwo.setVisible(false);
                    waterPlantTwo.setVisible(false);
                }
                else{

                }
            }
            if(plant3 != null && mainBoundary.getPlantController().getPlant(2) != null ){
                String plantLevel3 = Integer.toString(mainBoundary.getPlantController().getPlant(2).getLevel());
                double plantWaterLevel3 = mainBoundary.getPlantController().getPlant(2).getWaterLevel();
                double plantHealthLevel3 = mainBoundary.getPlantController().getPlant(2).getHealthLevel();

                if(plantLevelThree != null){
                    plantLevelThree.setText(plantLevel3);
                    imagePlantThree.setImage(mainBoundary.getPlantController().getPlant(2).getImage());
                    plantWaterBarThree.setProgress(plantWaterLevel3);
                    plantHealthBarThree.setProgress(plantHealthLevel3);

                    plantLevelThree.setVisible(true);
                    imagePlantThree.setVisible(true);
                    pot3.setVisible(true);
                    plantWaterBarThree.setVisible(true);
                    plantHealthBarThree.setVisible(true);
                    selectPlantThree.setVisible(true);
                    waterPlantThree.setVisible(true);
                    //pot3.setVisible(true);
                }
                else if(plantLevelThree != null){
                    plantWaterBarThree.setProgress(0);
                    plantHealthBarThree.setProgress(0);

                    plantLevelThree.setVisible(false);
                    imagePlantThree.setVisible(false);
                    pot.setVisible(false);
                    plantWaterBarThree.setVisible(false);
                    plantHealthBarThree.setVisible(false);
                    selectPlantThree.setVisible(false);
                    waterPlantThree.setVisible(false);
                }
                else{

                }
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }


    public void selectPlantOne(ActionEvent e){
        selectPlant(e,0);
        if(checkLegendary(0)) {
            goBackToLibrary(e);
        }
    }

    public void selectPlantTwo(ActionEvent e){
        selectPlant(e,1);
        if(checkLegendary(1)) {
            goBackToLibrary(e);
        }

    }

    public void selectPlantThree(ActionEvent e){
        selectPlant(e,2);
        if(checkLegendary(2)) {
            goBackToLibrary(e);
        }
    }

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

    public ImageView getImageViewFromStage(Stage stage, String id){
        Node root = stage.getScene().getRoot();
        if(root instanceof Parent){
            for(Node node : ((Parent) root).getChildrenUnmodifiable()){
                if(node instanceof ImageView && node.getId().equals(id)){
                    return (ImageView) node;
                }
            }
        }
        return null;
    }

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

    //this method uses a timeline to update waterbar and health bar with the right index for the plant
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
    public void updateGUI(){
        Plant[] plants = mainBoundary.getPlantController().getGrowingPlants();
        for(int i = 0; i<plants.length; i++){
            if(plants[i] == null){

            }

        }

    }

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

}
