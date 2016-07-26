package ParkCars;

import ModelScanner.ModelScanner;
import Randomizator.RandomValue;

import java.util.Scanner;

/**
 * Created by skydock on 22.07.2016.
 */
public class HydrogenCar extends NonGasCars {

    HydrogenCar(){
        fuelConsumptionRate = RandomValue.getRandomNumber(45);
        fuelType = "hydrogen";
        setModel(ModelScanner.getCarModel());
    }

    @Override
    public void getRechargableRate(double d, String s) {
        super.getRechargableRate(this.fuelConsumptionRate, this.fuelType);
    }

    @Override
    public void setModel(String model) {
        super.setModel(this.model);
    }

}
