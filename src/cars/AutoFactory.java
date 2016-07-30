package cars;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class AutoFactory {

    /**
     * This is real factory!
     *
     * @param carType "diesel", "gas", "electric", "hydrogen"
     * @return <Car> car
     */
    public Car getCar(String carType) {
        Car car = null;
        if (carType == null) {
            return car;
        }
        switch (carType) {
            case "diesel":
                car = new DieselCar();
                break;
            case "gas":
                car = new GasCar();
                break;
            case "electric":
                car = new ElectricCar();
                break;
            case "hydrogen":
                car = new HydrogenCar();
                break;
        }

        return car;
    }
}

