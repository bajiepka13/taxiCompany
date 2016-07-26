package ParkCars;

/**
 * Created by skydock on 22.07.2016.
 */
public abstract class GasCars extends Vehicle implements Refuelable{

    @Override
    public void getRefuelableRate(double fuelConsumptionRate, String fuelType) {
        System.out.println("Fuel this car with " + fuelType + " for " + fuelConsumptionRate + " per 100 km.");
    }

    @Override
    public String toString() {
        return "GasCars{" + brand + ":" + model +
                "fuelConsumptionRate=" + fuelConsumptionRate +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
