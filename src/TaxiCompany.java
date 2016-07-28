import cars.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public class TaxiCompany {

    private static TaxiCompany instance = new TaxiCompany();
    private static List<Car> carList = new ArrayList();

    private TaxiCompany(){

    }

    public static TaxiCompany getInstance() {
        return instance;
    }

    public static void setCarList(List<Car> carList) {
        TaxiCompany.carList = carList;
    }

    public static List<Car> getCarList() {
        return carList;
    }

}
