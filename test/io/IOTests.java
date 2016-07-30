package io;

import cars.AutoFactory;
import cars.Car;
import company.TaxiCompany;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import scanner.ModelScanner;

import java.io.*;
import java.util.List;


public class IOTests {
    private static int carQuantityInList;
    private static int initFileLinesQuantity;
    private static IOFileReader ioFileReader;

    @BeforeClass
    public static void SetUpClass() throws Exception {
        /* singleton's List initialization from file */
        initFileLinesQuantity = countLinesInFile();
        ioFileReader = new IOFileReader();

    }
    
    @Test
    /* This test creates Cars from file contents with IOFileReader class
    *  and compares them with quantity, got by looping lines from original file
    */
    public void testReaderQuantityInListAndFile() throws Exception {
        carQuantityInList = TaxiCompany.getCarList().size();
        Assert.assertEquals(carQuantityInList, initFileLinesQuantity);

    }

    @Test
    /* This test writes created car to file from singleton list and then checks the
    *  quantity of lines written according to list size
    */
    public void testWriterQuantityAfterOneCarAdd() throws Exception {
        final int CAR_TO_ADD_PER_RUN = 1;
        final String TEST_CAR_DATA = "1\nTestCompany\nTestCar\n99999\nno\n";

        /* from Controller.createCarFromFactory() */
        TaxiCompany.getInstance();
        List<Car> carList = TaxiCompany.getCarList();
        AutoFactory autoFactory = new AutoFactory();

        carList.add(autoFactory.getCar(getCarFromEmulatedInput(TEST_CAR_DATA)));

        for (Car car : carList) {
            System.out.println(car.getClass().getName() + " : " + car.toString());
        }

        /* from Controller.saveTaxiPark() */
        new IOFileWriter();

        Assert.assertEquals(carList.size(), initFileLinesQuantity + CAR_TO_ADD_PER_RUN);
    }

    /* Method counts & returns current file's row quantity */
    private static int countLinesInFile() throws Exception {
        BufferedReader buffer = new BufferedReader(new FileReader(Path.getFile()));
        int fileLines = 0;
        while (buffer.readLine() != null) {
            fileLines++;
        }
        buffer.close();
        return fileLines;
    }

    private String getCarFromEmulatedInput(String inputData) throws IOException {
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        return ModelScanner.getCarType();
    }

    @AfterClass
    public static void TearDownClass() throws Exception {
        initFileLinesQuantity = 0;
        ioFileReader = null;
    }
}
