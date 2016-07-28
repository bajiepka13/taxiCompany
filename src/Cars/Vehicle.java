package cars;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public abstract class Vehicle implements Car {
    protected double fuelConsumptionRate;
    protected double price;
    protected String fuelType;
    protected String model;

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price){
        this.price = price;
    }

}
