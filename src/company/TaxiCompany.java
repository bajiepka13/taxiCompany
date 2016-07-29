package company;

import cars.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
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

    /**
     * Method sorts all elements in array by value of one field
     */
    public static List sortCarList(List<Car> list, boolean direction){

        Car tempElement;
        for (int i = 0; i < list.size(); i++) {

            boolean isChanged = false;

            double price = Double.parseDouble(list.get(i).toString().split(",")[2]);
            Car tempMin = list.get(i);

            for (int j = 0; j < list.size(); j++){
                double nextPrice = Double.parseDouble(list.get(j).toString().split(",")[2]);
                if (direction ? nextPrice < price : nextPrice > price){
                    tempMin = list.get(j);
                    isChanged = true;
                }
                if (isChanged){
                    tempElement = list.get(i);
                    list.set(i, tempMin);
                    list.set(j, tempElement);
                    isChanged = false;
                }
            }
        }
        return list;
    }
}
