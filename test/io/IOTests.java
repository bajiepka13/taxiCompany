package io;

import cars.AutoFactory;
import cars.Car;
import company.TaxiCompany;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import scanner.ModelScanner;

import java.io.*;
import java.util.List;

import static org.junit.Assert.*;


public class IOTests {
    private final int CAR_TO_ADD_PER_RUN = 1;
    private final String SEND_DATA = "\n";
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
    *  and compares them with quantity, got by counting lines from original file
    */
    public void testReaderQuantityInListAndFile() throws Exception {
        carQuantityInList = TaxiCompany.getCarList().size();
        assertEquals(carQuantityInList, initFileLinesQuantity);

    }

    @Test
    /* This test writes created car to file from singleton list and then checks the
    *  quantity of lines written according to list size
    */
    public void testWriterQuantityAfterOneCarAdd() throws Exception {
        final String ENTER_CAR_TYPE = "1" + SEND_DATA;
        final String ENTER_CAR_BRAND = "TestCompany" + SEND_DATA;
        final String ENTER_CAR_MODEL = "TestCar" + SEND_DATA;
        final String ENTER_CAR_PRICE = "99999" + SEND_DATA;
        final String COMPLETE_ENTRY = "no" + SEND_DATA;

        final String TEST_CAR_DATA =
                ENTER_CAR_TYPE + ENTER_CAR_BRAND + ENTER_CAR_MODEL + ENTER_CAR_PRICE + COMPLETE_ENTRY;

        /* from Controller.createCarFromFactory() */
        TaxiCompany.getInstance();
        List<Car> carList = TaxiCompany.getCarList();
        AutoFactory autoFactory = new AutoFactory();

        /* Generate string with car description and add to carList */
        carList.add(autoFactory.getCar(getCarFromEmulatedInput(TEST_CAR_DATA)));

        for (Car car : carList) {
            System.out.println(car.getClass().getName() + " : " + car.toString());
        }

        /* from Controller.saveTaxiPark() */
        new IOFileWriter();

        carQuantityInList = carList.size();
        int expectedCarQuantityAfterOneRun = initFileLinesQuantity + CAR_TO_ADD_PER_RUN;
        assertEquals(carQuantityInList, expectedCarQuantityAfterOneRun);
    }

    /* Method counts & returns current file's row quantity */
    private static int countLinesInFile() throws Exception {
        BufferedReader buffer = new BufferedReader(new FileReader(Path.getFile()));
        int quantityOfLinesInFile = 0;
        while (buffer.readLine() != null) {
            quantityOfLinesInFile++;
        }
        buffer.close();
        return quantityOfLinesInFile;
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
