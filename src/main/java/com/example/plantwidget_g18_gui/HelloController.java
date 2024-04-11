package com.example.plantwidget_g18_gui;

import Controller.PlantController;
import Model.Plant;
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
import javafx.stage.Stage;
import javafx.util.Duration;


public class HelloController implements Initializable {

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
    private Button skipHourButton;
    @FXML
    private TextField levelPlantOne;
    @FXML
    private ProgressBar plantHealthBarOne;
    @FXML
    private ProgressBar plantWaterBarOne;
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
    //int levelOfPlantOne = 99;
    private PlantController plantController;
    private Plant plant1;
    private Plant plant2;
    private Plant plant3;


    public void selectPlant(ActionEvent event){
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
    public void placeOnDesk1(ActionEvent event){
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
    public void goToSettings(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SettingsGUI.fxml"));
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
    public void closeProgram(ActionEvent event){
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void goBackToLibrary(ActionEvent event){
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        System.out.println(System.getProperty("javafx.runtime.version"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Plant Widget Library!");
        stage.setScene(scene);
        stage.show();*/
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

    public void goTochooseSeedScene(ActionEvent event){
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


    public void updatePlantHealthBarOne() {
        plantHealthBarOne.setProgress(plantController.updateHealthBarGUI(plant1));
    }
    public void updatePlantWaterBarOne(double waterPlantOne) {
        plantHealthBarOne.setProgress(plantController.updateWaterBarGUI(plant1));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.plantController = new PlantController();
        this.plant1 = plantController.getPlant1();
        plantHealthBarOne.getStyleClass().add("progressBarHealth");
        ProgressBar plantWaterBarOne = new ProgressBar();
        plantWaterBarOne.setStyle("-fx-accent: #34a8d9;");
        plantWaterBarOne.setBackground(Background.EMPTY);
        levelPlantOne.setStyle("-fx-accent: #92eaa9;");
        levelPlantOne.setText("Level : " + String.valueOf(levelOfPlantOne));

    }
    public void waterPlantOne(){
        //water plant in controller, that takes in the plant
    }
    public void skipDay1(){
        plantController.skipDay(plant1);
    }
    public void skipDay3(){
        plantController.skipDay(plant3);
    }
    public void skipDay2(){
        plantController.skipDay(plant2);
    }
    @FXML
    public void addNewPlant(){
        Image image = new Image("C:\\Users\\petvi\\IdeaProjects\\Plant-Widget\\images\\34a878b5ee65d73.png");
        imagePlantTwo.setImage(image);
    }

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


}
