package cars;

import scanner.ModelScanner;
import randomizator.RandomValue;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public class HydrogenCar extends NonGasCars {

    HydrogenCar(){
        fuelConsumptionRate = RandomValue.getRandomNumber(45);
        fuelType = "hydrogen";
        setModel(ModelScanner.getCarModel());
        setPrice(ModelScanner.getCarPrice());
    }

    public HydrogenCar(double fuelRate, double price, String model){
        this.fuelConsumptionRate = fuelRate;
        this.fuelType = "hydrogen";
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
