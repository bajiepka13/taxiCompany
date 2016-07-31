package io;


import cars.AutoFactory;
import cars.Car;
import company.TaxiCompany;
import org.junit.Before;
import scanner.ModelScanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.*;


public class IOTests {
    private final String SEND_DATA = "\n";
    private static int carQuantityInList;
    private static int initFileLinesQuantity;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final static File originalFile = Path.getFile();
    private final static File backupFile = new File("taxiCompany.backup");
    private int counterOfAddedToListCars = 0;

    private static List<Car> carList = TaxiCompany.getCarList();
    private static AutoFactory autoFactory = new AutoFactory();

    @BeforeClass
    public static void SetUpClass() throws Exception {
        /* backup the original taxiCompany file */
        copyTaxiCompanyFile(originalFile, backupFile);

        initFileLinesQuantity = countLinesInFile();

        /* singleton's List initialization from file */
        new IOFileReader();

        /* init TaxiCompany */
        TaxiCompany.getInstance();

    }

    @Before
    public void SetUp() throws Exception {
        stringBuilder.delete(0, stringBuilder.length());

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
        final String CAR_TYPE = "1";
        final String CAR_BRAND = "TestCompany";
        final String CAR_MODEL = "TestCar";
        final String CAR_PRICE = "99999";
        final String COMPLETE_ENTRY = "no";

        stringBuilder
                .append(CAR_TYPE).append(SEND_DATA)
                .append(CAR_BRAND).append(SEND_DATA)
                .append(CAR_MODEL).append(SEND_DATA)
                .append(CAR_PRICE).append(SEND_DATA)
                .append(COMPLETE_ENTRY).append(SEND_DATA);
        final String TEST_CAR_DATA = stringBuilder.toString();

        addCarToFile(TEST_CAR_DATA);

        carQuantityInList = TaxiCompany.getCarList().size();

        int expectedCarQuantity = initFileLinesQuantity + counterOfAddedToListCars;
        boolean isLinesInListExpected = (expectedCarQuantity == carQuantityInList);
        boolean isLinesInFileExpected = (expectedCarQuantity == countLinesInFile());

        assertTrue(isLinesInListExpected & isLinesInFileExpected);

    }

    private void addCarToFile(String carData) throws IOException {

        /* Generate string with car description and add to carList */
        carList.add(autoFactory.getCar(getCarFromEmulatedInput(carData)));
        counterOfAddedToListCars++;

        /* write carList to file */
        new IOFileWriter();
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

    private static void copyTaxiCompanyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), REPLACE_EXISTING);

    }

    @AfterClass
    public static void TearDownClass() throws Exception {
        System.setIn(System.in);
        carList = null;
        autoFactory = null;
        /* restore the original taxiCompany file from backup */
        copyTaxiCompanyFile(backupFile, originalFile);
    }


}
