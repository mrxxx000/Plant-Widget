
package Controller;
import Model.Plant;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.util.Duration;
public class PlantController {

    private Plant plant;
    private DoubleProperty waterLevelProperty;

    public PlantController() {
        plant = new Plant();
        waterLevelProperty = new SimpleDoubleProperty(plant.getWaterLevel());
        startTimer();
    }

    private void startTimer() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.minutes(1), actionEvent -> {
            plant.decreaseWaterOverTime(1);
            waterLevelProperty.set(plant.getWaterLevel());
        }));


        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.play();
    }


    public DoubleProperty waterLevelProperty() {
        return waterLevelProperty;
    }
}



