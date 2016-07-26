package ParkCars;

import java.util.Scanner;

/**
 * Created by skydock on 22.07.2016.
 */
public class DieselCar extends GasCars {

    DieselCar(){
        fuelConsumptionRate = 12;
        fuelType = "diesel";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter car Brand");
        setBrand(s.next());
        System.out.println("Enter car Model");
        setModel(s.next());
    }

    @Override
    public void getRefuelableRate(double d, String s) {
        super.getRefuelableRate(this.fuelConsumptionRate, this.fuelType);
    }

    @Override
    public void setModel(String model) {
        super.setModel(this.model);
    }

    @Override
    public void setBrand(String brand) {
        super.setBrand(this.brand);
    }
}
