package Model;

public class Plant {
    private double waterLevel;

    public Plant(){
        this.waterLevel = 100.0;
    }

    public void decreaseWaterOverTime(int minutesElapsed){
        double waterLossPerMinutes = 10.0/100.0;

        double waterLoss = waterLossPerMinutes * minutesElapsed;

        waterLevel -= waterLoss;

        if (waterLevel < 0){
            waterLevel = 0;
        }
    }

    public double getWaterLevel(){
        return waterLevel;
    }
}
