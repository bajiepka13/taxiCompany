package cars;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public class AutoFactory {

    /** This is real factory!
     * @param carType "diesel", "gas", "electric", "hydrogen"
     * @return <Car> car
     */
    public Car getCar(String carType){
        Car car = null;
        if (carType == null){
            return car;
        }
        if (carType.equals("diesel")){
            car = new DieselCar();
        } else if (carType.equals("gas")){
            car = new GasCar();
        } else if (carType.equals("electric")){
            car = new ElectricCar();
        } else if (carType.equals("hydrogen")){
            car = new HydrogenCar();
        }

        return car;
    }
}

