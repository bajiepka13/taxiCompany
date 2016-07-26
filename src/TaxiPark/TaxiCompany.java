package TaxiPark;

import ParkCars.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skydock on 23.07.2016.
 */
public class TaxiCompany {

    private static TaxiCompany instance = new TaxiCompany();
    final static List<Car> carList = new ArrayList<>();
    private TaxiCompany() {
    }

    public static TaxiCompany getInstance(){
        return instance;
    }

    public static List<Car> getCarList() {
        return carList;
    }
}
