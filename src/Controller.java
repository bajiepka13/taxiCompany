import IOOperations.IOFileReader;
import IOOperations.IOFileWriter;
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

    public static void createCarFrmFactory(){

        TaxiPark.TaxiCompany park = TaxiCompany.getInstance();
        List<Car> carList = TaxiCompany.getCarList();

        AutoFactory autoFactory = new AutoFactory();

        carList.add(autoFactory.getCar("electric"));

        for (Car car : carList){
            System.out.println(car.getClass().getName() + " : " + car.toString());
        }
    }

    public static void initTaxiPark() throws IOException {
        try {
            IOFileReader reader = new IOFileReader();
        } finally {
            System.out.println("job done");
        }
    }

    public static void saveTaxiPark(){
        File file = Path.getFile();
        if (!file.exists()){
            try {
                IOFileWriter myWriter = new IOFileWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
