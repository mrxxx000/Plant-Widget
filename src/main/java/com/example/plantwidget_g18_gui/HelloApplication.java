package com.example.plantwidget_g18_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        System.out.println(System.getProperty("javafx.runtime.version"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Plant Widget Library!");
        stage.setScene(scene);
        stage.initStyle(javafx.stage.StageStyle.UNDECORATED);
        stage.setResizable(false);
        Image icon = new Image("C:\\Users\\petvi\\IdeaProjects\\Plant-Widget\\src\\main\\resources\\images\\pngtree-cactus-pixel-art-png-image_6581983.png");
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}