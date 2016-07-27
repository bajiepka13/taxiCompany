package ParkCars;

import ModelScanner.ModelScanner;
import Randomizator.RandomValue;

import java.util.Scanner;

/**
 * Created by skydock on 22.07.2016.
 */
public class GasCar extends GasCars {
    GasCar(){
        fuelConsumptionRate = RandomValue.getRandomNumber(8);
        fuelType = "gas";
        setModel(ModelScanner.getCarModel());
    }

    public GasCar(double fuelRate, String model){
        this.fuelConsumptionRate = fuelRate;
        this.fuelType = "gas";
        setModel(model);
    }

    @Override
    public void getRefuelableRate(double d, String s) {
        super.getRefuelableRate(this.fuelConsumptionRate, this.fuelType);
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

}
