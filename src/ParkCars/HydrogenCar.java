package ParkCars;

import java.util.Scanner;

/**
 * Created by skydock on 22.07.2016.
 */
public class HydrogenCar extends NonGasCars {

    HydrogenCar(){
        fuelConsumptionRate = 45;
        fuelType = "hydrogen";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter car Brand");
        setBrand(s.next());
        System.out.println("Enter car Model");
        setModel(s.next());
    }

    @Override
    public void getRechargableRate(double d, String s) {
        super.getRechargableRate(this.fuelConsumptionRate, this.fuelType);
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
