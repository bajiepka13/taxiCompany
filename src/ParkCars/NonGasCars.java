package ParkCars;

import java.util.Locale;

/**
 * Created by skydock on 22.07.2016.
 */
public abstract class NonGasCars extends Vehicle implements Rechargeable {

    @Override
    public void getRechargableRate(double d, String s) {
        System.out.println("Fuel this car with " + fuelType + " for " + fuelConsumptionRate + " per 100 km.");
    }

    @Override
    public String toString() {
        Locale.setDefault(Locale.US);
        return String.format("[%s,%s,%.2f/100 km of %s]",
                model,                      //[1]
                this.getClass().getSimpleName(),  //[2]
                fuelConsumptionRate,        //[3]
                fuelType);                  //[4]
    }
}
