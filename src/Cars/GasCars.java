package cars;

import java.util.Locale;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public abstract class GasCars extends Vehicle implements Refuelable{

    @Override
    public void getRefuelableRate(double fuelConsumptionRate, String fuelType) {
        System.out.println("Fuel this car with " + fuelType + " for " + fuelConsumptionRate + " per 100 km.");
    }

    @Override
    public String toString() {
        Locale.setDefault(Locale.US);
        return String.format("[%s,%s,%.2f,%.2f/100 km of %s]",
                model,                      //[1]
                this.getClass().getName(),  //[2]
                price,                      //[3]
                fuelConsumptionRate,        //[4]
                fuelType);                  //[5]
    }
}
