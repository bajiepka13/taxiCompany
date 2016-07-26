package IOOperations;

import ParkCars.Car;
import TaxiPark.TaxiCompany;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by skydock on 25.07.2016.
 */
public class IOFileWriter {
    public IOFileWriter() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(Path.getFile()));

        try {
            for (Car car : TaxiCompany.getCarList()) {
                writer.write(car.toString());
            }
        } finally {
            writer.close();
            System.out.println("file written.");
        }
    }
}