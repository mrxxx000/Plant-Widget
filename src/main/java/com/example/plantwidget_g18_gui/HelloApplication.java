package com.example.plantwidget_g18_gui;


import Model.Music;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        boolean fileExists = true;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/SaveFile/PlantSaveFile.dat"));
            if (bufferedReader.readLine() == null) {
                System.out.println("File is empty");
                fileExists = false;
            } else {
                System.out.println("File is not empty");
            }
        } catch (IOException e) {
            System.out.println("File not found");
            fileExists = false;
        }

        if (fileExists) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            System.out.println(System.getProperty("javafx.runtime.version"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Plant Widget Library!");
            stage.setScene(scene);
            stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setResizable(false);
            Image image = new Image(getClass().getResource("/images/34a878b5ee65d73.png").toString());
            //Image icon = new Image("src/main/resources/images/pngtree-cactus-pixel-art-png-image_6581983.png");
            stage.getIcons().add(image);
            stage.show();
        } else if (fileExists == false) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SeedMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Plant Seed!");
            stage.setScene(scene);
            stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
            stage.setResizable(false);
            Image image = new Image(getClass().getResource("/images/34a878b5ee65d73.png").toString());
            stage.getIcons().add(image);
            stage.show();
        }
        //Music.playMusic("musicc/mountainflowers.wav");
    }

    public static void main(String[] args) {
        launch();
    }
}