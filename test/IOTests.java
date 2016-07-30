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


public class IOTests {
    static IOFileReader testReader;
    private static int carQuantity;

    @BeforeClass
    public static void SetUpClass() throws Exception {
        /* singleton's List initialization from file */
        new IOFileReader();
    }

    @Test
    /* This test creates Cars from file contents with IOFileReader class
    *  and compares them with quantity, got by looping lines from original file
    */
    public void testReader() throws Exception {

        carQuantity = TaxiCompany.getCarList().size();
        System.out.println("should be: " + carQuantity);
        Assert.assertEquals(carQuantity, manualFileLooping());

    }

    @Test
    /* This test writes created cars to file from singleton list and then checks the
    *  quantity of lines written according to list size
    */
    public void testWriter() throws Exception {

        IOFileWriter writer = new IOFileWriter();
        System.out.println("should be: " + carQuantity);
        Assert.assertEquals(carQuantity, manualFileLooping());
    }

    /* Method counts & returns current file's row quantity */
    protected int manualFileLooping() throws Exception {

        BufferedReader buffer = new BufferedReader(new FileReader(Path.getFile()));
        String bufferLine;
        int fileLines = 0;
        while ((bufferLine = buffer.readLine()) != null) {
            fileLines++;
        }
        buffer.close();
        System.out.println("counted: " + fileLines);
        return fileLines;
    }
}
