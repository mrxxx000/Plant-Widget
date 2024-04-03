package com.example.plantwidget_g18_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.plantwidget_g18_gui.*;
import javafx.stage.Stage;

public class HelloController implements Initializable {
    @FXML
    private Button addNewPLantButton;
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
    double healthPlantOne = 0.5;
    double waterPlantOne = 0.7;
    int levelOfPlantOne = 99;

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
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updatePlantHealthBarOne(double healthPlantOne) {
        plantHealthBarOne.setProgress(healthPlantOne);
    }
    public void updatePlantWaterBarOne(double waterPlantOne) {
        plantWaterBarOne.setProgress(waterPlantOne);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        plantHealthBarOne.setStyle("-fx-accent: red;");
        plantWaterBarOne.setStyle("-fx-accent: blue;");
        levelPlantOne.setStyle("-fx-accent: #92eaa9;");
        levelPlantOne.setText("Level : " + String.valueOf(levelOfPlantOne));
    }
    public void waterPlantOne(){
        healthPlantOne+=0.1;
        waterPlantOne = 1.0;
        updatePlantHealthBarOne(healthPlantOne);
        updatePlantWaterBarOne(waterPlantOne);
    }
    public void skipHour(){
        if(waterPlantOne>0.0){
        waterPlantOne = waterPlantOne-0.5;
        updatePlantHealthBarOne(healthPlantOne);
        updatePlantWaterBarOne(waterPlantOne);}
        else{
            healthPlantOne-=0.3;
            updatePlantHealthBarOne(healthPlantOne);

        }
    }
    @FXML
    public void addNewPlant(){
        Image image = new Image("C:\\Users\\petvi\\IdeaProjects\\Plant-Widget\\images\\34a878b5ee65d73.png");
        imagePlantTwo.setImage(image);
    }
}