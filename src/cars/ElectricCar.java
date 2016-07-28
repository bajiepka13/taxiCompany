package cars;

import scanner.ModelScanner;
import randomizator.RandomValue;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public class ElectricCar extends NonGasCars {

    ElectricCar(){
        fuelConsumptionRate = RandomValue.getRandomNumber(33);
        fuelType = "electricity";
        setModel(ModelScanner.getCarModel());
    }

    public ElectricCar(double fuelRate, String model){
        this.fuelConsumptionRate = fuelRate;
        this.fuelType = "electricity";
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
}
