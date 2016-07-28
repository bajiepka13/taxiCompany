import scanner.ModelScanner;
import cars.Car;

import java.io.IOException;
import java.util.List;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public class ApplicationRunner {

    public ApplicationRunner(){}

    public static void main(String[] args) throws IOException {

        /* загружаемся из файла по-умолчанию */
        Controller.initTaxiPark();

        System.out.println("printing inited cars:");
        List<Car> cars = TaxiCompany.getCarList();
        for (Car car : cars){
            System.out.println(car.toString());
        }

        while (ModelScanner.getAnotherCar()) {
            /* запускаем фабрику */
            Controller.createCarFrmFactory();
        }

        /* сохраняемся в файл по-умолчанию */
        Controller.saveTaxiPark();

    }
}
