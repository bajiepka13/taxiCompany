package ParkCars;

/**
 * Created by skydock on 20.07.2016.
 */
public class AutoFactory {

    /**
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
            car = new ElectroCar();
        } else if (carType.equals("hydrogen")){
            car = new HydrogenCar();
        }

        return car;
    }
}

