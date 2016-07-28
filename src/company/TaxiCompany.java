package company;

import cars.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
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

    public static  void addCarToList(Car newCar) {
        carList.add(newCar);
    }

}
