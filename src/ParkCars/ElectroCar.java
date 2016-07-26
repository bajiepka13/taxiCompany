package ParkCars;

import java.util.Scanner;

/**
 * Created by skydock on 22.07.2016.
 */
public class ElectroCar extends NonGasCars {

    ElectroCar(){
        fuelConsumptionRate = 33;
        fuelType = "electricity";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter car Brand");
        this.setBrand(s.next());
        System.out.println("Enter car Model");
        this.setModel(s.next());
    }

    @Override
    public void getRechargableRate(double d, String s) {
        super.getRechargableRate(this.fuelConsumptionRate, this.fuelType);
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

}
