package Controller;

import Model.Plant;

import java.io.*;

public class PlantController2 implements Serializable {
    private Plant[] growingPlants;


    public void SavePlantToFile(String filename) {
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(filename))){
            for (Plant plant: growingPlants){
                if (plant!= null){
                    oss.writeObject(plant);
                }
            }
            System.out.println("Plant info saved successfully");

        }catch (IOException e){
            System.out.println("Failed to save plants" + e.getMessage());
        }
    }

    public void LoadPlantsFromFile(String filename){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            int index = 0;
            while (true){
                Plant plant = (Plant) ois.readObject();
                if (plant!=null){
                    growingPlants[index++] = plant;
                }
            }
        }catch (EOFException e){
            e.printStackTrace();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Failed to load plants " +e.getMessage());
        }
    }

}
