import io.IOFileReader;
import io.IOFileWriter;
import io.Path;
import scanner.ModelScanner;
import company.TaxiCompany;
import cars.AutoFactory;
import cars.Car;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class Controller {

    public Controller() {

    }

    /**
     * Method serves as factory init for another car instance
     */
    public static void createCarFromFactory() {

        TaxiCompany park = TaxiCompany.getInstance();
        List<Car> carList = TaxiCompany.getCarList();

        AutoFactory autoFactory = new AutoFactory();

        carList.add(autoFactory.getCar(ModelScanner.getCarType()));

        for (Car car : carList) {
            System.out.println(car.getClass().getName() + " : " + car.toString());
        }
    }

    /**
     * Method inits further file reading from file and puts it's content to singleton TaxiCompany
     *
     * @throws IOException
     */
    public static void initTaxiPark() throws IOException {
        try {
            IOFileReader reader = new IOFileReader();
        } finally {
            System.out.println("job done");
        }
    }

    /**
     * Method saves all content of singleton to file in specified way
     */
    public static void saveTaxiPark() {
        File file = Path.getFile();

        try {
            IOFileWriter myWriter = new IOFileWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
