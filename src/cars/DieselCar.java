package cars;

import scanner.ModelScanner;
import randomizator.RandomValue;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class DieselCar extends GasCars {

    private static final int AVG_FUEL_CONSUMPTION = 7;

    DieselCar(){
        fuelConsumptionRate = RandomValue.getRandomNumber(AVG_FUEL_CONSUMPTION);
        fuelType = "diesel";
        setModel(ModelScanner.getCarModel());
        setPrice(ModelScanner.getCarPrice());
    }

    public DieselCar(double fuelRate, double price, String model){
        this.fuelConsumptionRate = fuelRate;
        this.fuelType = "diesel";
        this.price = price;
        setModel(model);
    }

    @Override
    public void getRefuelableRate(double d, String s) {
        super.getRefuelableRate(this.fuelConsumptionRate, this.fuelType);
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(this.price = price);
    }
}
