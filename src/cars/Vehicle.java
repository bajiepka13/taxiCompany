package cars;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
abstract class Vehicle implements Car {
    double fuelConsumptionRate;
    double price;
    String fuelType;
    String model;

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
