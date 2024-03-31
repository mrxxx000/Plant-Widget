package com.example.plantwidget_g18_gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button addNewPLantButton;
    @FXML
    private Button waterThePlantOne;
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

    double healthPlantOne = 0.5;
    double waterPlantOne = 0.7;
    int levelOfPlantOne = 99;




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
    @FXML
    public void addNewPlant(){
        Image image = new Image("C:\\Users\\emrem\\IdeaProjects\\PlantWidget_G18_GUI\\images\\34a878b5ee65d73.png");
        imagePlantTwo.setImage(image);
    }
}