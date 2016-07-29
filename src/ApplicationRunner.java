import company.TaxiCompany;
import scanner.ModelScanner;
import cars.Car;

import java.io.IOException;
import java.util.List;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class ApplicationRunner {

    public ApplicationRunner() {
    }

    public static void main(String[] args) throws IOException {

        boolean sortOrderDecrease = false;

        /* Load data from file by default */
        Controller.initTaxiPark();

        System.out.println("printing inited cars:");
        List<Car> cars = TaxiCompany.getCarList();
        TaxiCompany.sortCarList(cars, sortOrderDecrease);
        for (Car car : cars) {
            System.out.println(car.toString());
        }

        while (ModelScanner.getAnotherCar()) {
            /* Run the factory */
            Controller.createCarFromFactory();
        }

        /* Save data to file by default */
        Controller.saveTaxiPark();

    }
}
