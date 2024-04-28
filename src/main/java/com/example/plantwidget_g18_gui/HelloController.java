package com.example.plantwidget_g18_gui;

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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
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
        timelineUpdateHealth.playFromStart();
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
        String name = mainBoundary.getPlantController().getPlant(0).getName();
        System.out.println(name);
        if(name != null){

                System.out.println("HELLOOOOO IS : " + name);

        }
        mainBoundary.getPlantController().removePlantFromFile(name);
        mainBoundary.getPlantController().LoadPlantsFromFile();
        updateCurrentLibrary();
        goBackToLibrary(event);

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
        mainBoundary.getPlantController().SavePlantToFile();
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
            int row = -1;

            //loop for legendary plant list
            for(int i = 0; i < 10; i++){
                if(i % 3== 0){
                    row++;
                }

                StackPane stackPane = new StackPane();
                GridPane gridPane = new GridPane();
                Rectangle rectangle = new Rectangle(152, 181, Color.GREEN);

                //Plant name
                Label plantName = new Label("Name 1");
                GridPane.setConstraints(plantName,0,2);

                //Plant image
                ImageView plantImage = new ImageView();
                InputStream inputStream = getClass().getResourceAsStream("/images/testCat.jpg");
                Image image = new Image(inputStream);
                plantImage.setImage(image);
                plantImage.setFitHeight(88);
                plantImage.setFitWidth(111);
                GridPane.setConstraints(plantImage, 0,1);


                gridPane.getChildren().addAll(plantImage, plantName);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setHgap(10);
                gridPane.setVgap(10);

                stackPane.setMaxHeight(152);
                stackPane.setMaxWidth(181);

                StackPane.setAlignment(gridPane, Pos.CENTER);
                stackPane.getChildren().addAll(rectangle, gridPane);


                legendaryGridPane.add(stackPane,(i + 3) % 3, row);
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
        if(plantHealthBarOne != null){
            plantHealthBarOne.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(0)); // implement health level
        }
    }
    /*
        UPDATES TEH WATER BAR OF THE FIRST PLANT
    */
    public void updatePlantWaterBarOne() {
        if(plantWaterBarOne != null){
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
        mainBoundary.getPlantController().LoadPlantsFromFile();
        updateCurrentLibrary();

    }


    public void waterPlantOne(){
        mainBoundary.getPlantController().waterPlant(0);
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();
        //water plant in controller, that takes in the plant
    }

    public void waterPlantTwo() {
        mainBoundary.getPlantController().waterPlant(1);
        if(plantWaterBarOne != null){
            plantWaterBarTwo.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(1));
            plantHealthBarTwo.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(1));
        }
    }

    public void waterPlantThree() {
        mainBoundary.getPlantController().waterPlant(2);
        if(plantWaterBarOne != null){
            plantWaterBarThree.setProgress(mainBoundary.getPlantController().updateWaterBarGUI(2));
            plantHealthBarThree.setProgress(mainBoundary.getPlantController().updateHealthBarGUI(2));
        }
    }

    public void skipDay1(){

        mainBoundary.getPlantController().skipDay(0);
        updatePlantWaterBarOne();
        updatePlantHealthBarOne();// implement skipping 1 day, this is plant spot specific.
        System.out.println(mainBoundary.getPlantController().getPlant(0).getLevel());
    }

    public void skipDay2(){
        mainBoundary.getPlantController().skipDay(1);
        System.out.println(mainBoundary.getPlantController().getPlant(1).getLevel());
    }

    public void skipDay3(){
        mainBoundary.getPlantController().skipDay(2);
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
                            mainBoundary.getPlantController().plantSeed(PlantTypes.SNAKEPLANT,name);
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

    public void updateCurrentLibrary(){
        Plant plant2 = mainBoundary.getPlantController().getPlant(1);
        Plant plant3 = mainBoundary.getPlantController().getPlant(2);

        if(plant2 != null && plant3 != null) {
            System.out.println("in update current library");
            System.out.println(plant2.getName());
            System.out.println(plant3.getName());
        }

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1),e ->{
            if(plant2 != null){
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
                    plantWaterBarTwo.setVisible(true);
                    plantHealthBarTwo.setVisible(true);
                    selectPlantTwo.setVisible(true);
                    waterPlantTwo.setVisible(true);
                }
            }
            if(plant3 != null){
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
                    plantWaterBarThree.setVisible(true);
                    plantHealthBarThree.setVisible(true);
                    selectPlantThree.setVisible(true);
                    waterPlantThree.setVisible(true);
                }
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    public void selectPlantOne(ActionEvent e){
        selectPlant(e,0);
    }

    public void selectPlantTwo(ActionEvent e){
        selectPlant(e,1);

    }

    public void selectPlantThree(ActionEvent e){
        selectPlant(e,2);
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
                if(node instanceof ScrollPane){
                    ScrollPane scorllPane = (ScrollPane) node;
                    Object gridPane = scorllPane.getContent();
                    return (GridPane) gridPane;
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

    //this method uses a timeline to update waterbar and health bar with the right index for the plant
    public void updateWaterAndHealthBar(ProgressBar waterBar, ProgressBar healthBar, int index){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1),e ->{
            if(waterBar != null && healthBar != null){
                waterBar.setProgress(mainBoundary.getPlantController().getPlant(index).getWaterLevel());
                healthBar.setProgress(mainBoundary.getPlantController().getPlant(index).getHealthLevel());
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

    public void setUpSelectPlantScene(Stage stage,int index){
        speciesNameInSelectPlantScene = getLabelFromStage(stage, "speciesNameInSelectPlantScene");
        plantNameInSelectPlantScene = getLabelFromStage(stage, "plantNameInSelectPlantScene");
        if(index == 0){
            Button waterThePlantOne = getButtonsFromSelectPlantScene(stage, "waterThePlantOne");
            Button skipDayButton1 = getButtonsFromSelectPlantScene(stage, "skipDayButton1");
            Button placeOnDesk1 = getButtonsFromSelectPlantScene(stage, "placeOnDesk1");
            speciesNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(0).getType().toString());
            plantNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(0).getName());
            waterThePlantOne.setVisible(true);
            skipDayButton1.setVisible(true);
            placeOnDesk1.setVisible(true);
        }
        else if(index == 1){
            Button waterThePlantTwo = getButtonsFromSelectPlantScene(stage, "waterThePlantTwo");
            Button skipDayButton2 = getButtonsFromSelectPlantScene(stage, "skipDayButton2");
            Button placeOnDesk2 = getButtonsFromSelectPlantScene(stage, "placeOnDesk2");
            speciesNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(1).getType().toString());
            plantNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(1).getName());
            waterThePlantTwo.setVisible(true);
            skipDayButton2.setVisible(true);
            placeOnDesk2.setVisible(true);
        }
        else if(index == 2){
            Button waterThePlantThree = getButtonsFromSelectPlantScene(stage, "waterThePlantThree");
            Button skipDayButton3 = getButtonsFromSelectPlantScene(stage, "skipDayButton3");
            Button placeOnDesk3 = getButtonsFromSelectPlantScene(stage, "placeOnDesk3");
            speciesNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(2).getType().toString());
            plantNameInSelectPlantScene.setText(mainBoundary.getPlantController().getPlant(2).getName());
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
