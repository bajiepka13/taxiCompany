package ParkCars;

import ModelScanner.ModelScanner;
import Randomizator.RandomValue;

import java.util.Scanner;

/**
 * Created by skydock on 22.07.2016.
 */
public class DieselCar extends GasCars {

    DieselCar(){
        fuelConsumptionRate = RandomValue.getRandomNumber(12);
        fuelType = "diesel";
        setModel(ModelScanner.getCarModel());
    }

    public DieselCar(double fuelRate, String model){
        this.fuelConsumptionRate = fuelRate;
        this.fuelType = "diesel";
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
