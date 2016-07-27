import IOOperations.IOFileReader;
import IOOperations.IOFileWriter;
import ModelScanner.ModelScanner;
import ParkCars.AutoFactory;
import ParkCars.Car;
import IOOperations.Path;
import TaxiPark.TaxiCompany;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by skydock on 26.07.2016.
 */
public class Controller {

    public Controller(){

    }

    /**
     * Method serves as factory init for another car instance
     */
    public static void createCarFrmFactory(){

        TaxiPark.TaxiCompany park = TaxiCompany.getInstance();
        List<Car> carList = TaxiCompany.getCarList();

        AutoFactory autoFactory = new AutoFactory();

        carList.add(autoFactory.getCar(ModelScanner.getCarType()));

        for (Car car : carList){
            System.out.println(car.getClass().getName() + " : " + car.toString());
        }
    }

    /**
     * Method inits further file reading from file and puts it's content to sungleton TaxiCompany
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
    public static void saveTaxiPark(){
        File file = Path.getFile();

        try {
            IOFileWriter myWriter = new IOFileWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
