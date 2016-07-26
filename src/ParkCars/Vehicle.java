package ParkCars;

/**
 * Created by skydock on 22.07.2016.
 */
public abstract class Vehicle implements Car {
    protected double fuelConsumptionRate;
    protected String fuelType;
    protected String model;
    protected String brand;

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
