import ParkCars.Car;
import Randomizator.RandomValue;
import TaxiPark.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by skydock on 21.07.2016.
 */
public class Main {

    public Main(){}

    public static void main(String[] args) throws IOException {

        //RandomValue myRandom = new RandomValue();

        /* загружаемся из файла по-умолчанию */
        Controller.initTaxiPark();

        System.out.println("printing inited cars:");
        List<Car> cars = TaxiPark.TaxiCompany.getCarList();
        for (Car car : cars){
            System.out.println(car.toString());
        }

        /* запускаем фабрику */
        Controller.createCarFrmFactory();

        /* сохраняемся в файл по-умолчанию */
        Controller.saveTaxiPark();

    }
}
