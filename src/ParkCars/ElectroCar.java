package ParkCars;

import ModelScanner.ModelScanner;
import Randomizator.RandomValue;

import java.util.Scanner;

/**
 * Created by skydock on 22.07.2016.
 */
public class ElectroCar extends NonGasCars {

    ElectroCar(){
        fuelConsumptionRate = RandomValue.getRandomNumber(33);
        fuelType = "electricity";
        setModel(ModelScanner.getCarModel());
    }

    public ElectroCar(double fuelRate, String model){
        this.fuelConsumptionRate = fuelRate;
        this.fuelType = "electricity";
        setModel(model);
    }

    @Override
    public void getRechargableRate(double d, String s) {
        super.getRechargableRate(this.fuelConsumptionRate, this.fuelType);
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }
}
