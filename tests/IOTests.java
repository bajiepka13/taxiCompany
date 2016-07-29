import cars.AutoFactory;
import cars.Car;
import cars.ElectricCar;
import company.TaxiCompany;
import io.IOFileReader;
import io.IOFileWriter;
import io.Path;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

/**
 * Created by skydock on 29.07.2016.
 */
public class IOTests {

    static int carQuantity;

    @BeforeClass
    public static void onlyOnce(){
        IOFileReader testReader = new IOFileReader();
    }

    /* This test creates Cars from file contents with IOFileReader class
    *  and compares them with quantity, got by looping lines from original fila
    */
    @Test
    public void testReader() throws FileNotFoundException, IOException {

        carQuantity = TaxiCompany.getCarList().size();
        System.out.println("should be: " + carQuantity);
        Assert.assertEquals(carQuantity, manualFileLooping());

    }

    /* This test writes created cars to file from singleton list and then checks the
    *  quantity of lines written according to list size
    */
    @Test
    public void testWriter() throws IOException {

        IOFileWriter writer = new IOFileWriter();
        System.out.println("should be: " + carQuantity);
        Assert.assertEquals(carQuantity, manualFileLooping());
    }

    protected int manualFileLooping() throws IOException {

        BufferedReader buffer = new BufferedReader(new FileReader(Path.getFile()));
        String bufferLine;
        int fileLines = 0;
        while ((bufferLine = buffer.readLine()) != null){
            fileLines++;
        }
        buffer.close();
        System.out.println("counted: " + fileLines);
        return fileLines;
    }
}
