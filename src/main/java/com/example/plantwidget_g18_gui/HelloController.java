package com.example.plantwidget_g18_gui;

import Controller.PlantController;
import Model.Plant;
import Model.PlantTypes;
import View.MainBoundary;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import com.example.plantwidget_g18_gui.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HelloController implements Initializable {

    private Timeline timelineUpdateHealth;
    @FXML
    private Button enterNameButton;
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
    private Button addNewPLantButton;
    @FXML
    private Button placeOnDesk1;
    @FXML
    private Button exitButton;
    @FXML
    private Button waterThePlantOne;
    @FXML
    private Button skipDayButton1;
    @FXML
    private TextField levelPlantOne;
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
    @FXML
    private Label plantLeveltwo;
    @FXML
    private Label plantLevelThree;
    @FXML
    private Button waterPlantTwo;
    @FXML
    private Button waterPlantThree;
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
    private Stage stage;
    private Scene scene;
    @FXML
    private Button backButton;
    @FXML
    private Button selectPlantButton;
    private double xOffset = 0;
    private double yOffset = 0;
    //double healthPlantOne = 0.5;
    //double waterPlantOne = 0.7;
    int levelOfPlantOne = 99; // dont forget to implement it
    private MainBoundary mainBoundary;
    private Plant plant1;
    private Plant plant2;
    private Plant plant3;

    /*
         switches gui to the plant info scene, currently only works for plant number 1.
     */
    public void selectPlant(ActionEvent event){
        mainBoundary.getPlantController().startTheTimer();
        timelineUpdateHealth.playFromStart();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlantInfoGUI.fxml"));
            scene = new Scene(fxmlLoader.load());
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
     this turns the first plant in to a widget, specific to plant number 1.
     */
    public void placeOnDesk1(ActionEvent event){
        mainBoundary.getPlantController().startTheTimer();
        timelineUpdateHealth.playFromStart();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("widget-view.fxml"));
            scene = new Scene(fxmlLoader.load());
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
         switches gui settings scene
     */
    public void goToSettings(ActionEvent event){
        mainBoundary.getPlantController().stopTheTimer();
        timelineUpdateHealth.stop();
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
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
            GOES TO THE PLANT NEW SEED SCENE, OR THE FIRST GUI WHEN OPENING PROGRAM FOR THE FIRST TIME
        */
    public void goTochooseSeedScene(ActionEvent event){
        mainBoundary.getPlantController().stopTheTimer();
        timelineUpdateHealth.stop();
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SeedMenu.fxml")));
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SeedMenu.fxml"));
            Scene scene = new Scene(root);
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Choose Seed");
            stage.setScene(scene);
            //stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println("fel i gotochooseseedscene");
            e.printStackTrace();
        }
    }


    /*
            UPDATES THE HEALTH BAR OF THE FIRST PLANT
        */
    public void updatePlantHealthBarOne() {
        plantHealthBarOne.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(0)); // implement health level
    }
    /*
        UPDATES TEH WATER BAR OF THE FIRST PLANT
    */
    public void updatePlantWaterBarOne() {
        plantWaterBarOne.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(0)); // implement water level
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
        plantHealthBarOne.getStyleClass().add("progressBarHealth");
        ProgressBar plantWaterBarOne = new ProgressBar();
        plantWaterBarOne.setStyle("-fx-accent: #34a8d9;");
        plantWaterBarOne.setBackground(Background.EMPTY);



        //levelPlantOne.setStyle("-fx-accent: #92eaa9;");

    }
    public void startTimeline() {
        timelineUpdateHealth.playFromStart();
    }
    public HelloController() {
        this.mainBoundary = MainBoundary.getInstance();
        this.plant1 = mainBoundary.getPlantController().getPlant(0);
        mainBoundary.getPlantController().timeTrackReader();
        timelineUpdateHealth = new Timeline();
        KeyFrame updateGUIFrame = new KeyFrame(Duration.millis(1), event -> {
            updatePlantWaterBarOne(); // updates the waterbar to correct value every 5 seconds
            updatePlantHealthBarOne(); // updates the healthbar to correct value every 5 seconds
            //mainBoundary.getPlantController().getPlant(0).setWaterLevel(0.2); // just for testing, remove later (decreases water level)
        });
        timelineUpdateHealth.getKeyFrames().add(updateGUIFrame);
        timelineUpdateHealth.setCycleCount(Animation.INDEFINITE);


    }
    public void waterPlantOne(){
        mainBoundary.getPlantController().waterPlant(0);
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();
        //water plant in controller, that takes in the plant
    }
    public void skipDay1(){
        mainBoundary.getPlantController().timeTrackReader();
        mainBoundary.getPlantController().skipDay(0);
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();// implement skipping 1 day, this is plant spot specific.
        System.out.println(plant1.getLevel());
    }
    //public void skipDay3(){
    //    plantController.skipDay(plant3);// implement skipping 1 day, this is plant spot specific.
    //}
   // public void skipDay2(){
     //   plantController.skipDay(plant2);// implement skipping 1 day, this is plant spot specific.
    //}

    public void plantSeed(ActionEvent e){
        System.out.println("planted seed");
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
                System.out.println(name);
                if(name != null){
                    mainBoundary.getPlantController().plantSeed(PlantTypes.CACTUS,name);
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
    }

    public void hideNamePrompt(ActionEvent e){
        namePlantPrompt.setVisible(false);
        namePlantField.setVisible(false);
        nameYourPlantLabel.setVisible(false);
        closeNamePlantButton.setVisible(false);
        enterNameButton.setVisible(false);
    }

    public void updateCurrentLibrary(){
        Plant plant2 = mainBoundary.getPlantController().getPlant(1);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1),e ->{
            if(plant2 != null){
                String plantLevel2 = Integer.toString(mainBoundary.getPlantController().getPlant(1).getLevel());
                double plantWaterLevel2 = mainBoundary.getPlantController().getPlant(1).getWaterLevel();
                double plantHealthLevel2 = mainBoundary.getPlantController().getPlant(1).getHealthLevel();


                if(plantLeveltwo!= null) {
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


            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
}
