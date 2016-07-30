package cars;

import scanner.ModelScanner;
import randomizator.RandomValue;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class ElectricCar extends NonGasCars {

    private static final int AVG_ELECTRICITY_CONSUMPTION = 11;

    ElectricCar(){
        fuelConsumptionRate = RandomValue.getRandomNumber(AVG_ELECTRICITY_CONSUMPTION);
        fuelType = "electricity";
        setModel(ModelScanner.getCarModel());
        setPrice(ModelScanner.getCarPrice());
    }

    public ElectricCar(double fuelRate, double price, String model){
        this.fuelConsumptionRate = fuelRate;
        this.fuelType = "electricity";
        this.price = price;
        setModel(model);
    }

    @Override
    public void getRechargableRate(double d, String s) {
        super.getRechargableRate(this.fuelConsumptionRate, this.fuelType);
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
