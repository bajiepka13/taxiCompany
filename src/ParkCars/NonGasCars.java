package ParkCars;

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
        return "NonGasCar"  + brand + "\t" + model + "\t" +
                "fuelConsumptionRate=" + fuelConsumptionRate +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
