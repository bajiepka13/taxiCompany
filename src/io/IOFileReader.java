package io;
import cars.Car;
import company.TaxiCompany;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class IOFileReader {

    public IOFileReader() {
        initBufferedReader();
    }

    /**
     * INITIALIZER
     * method initializes BufferedReader and moves it's line to parse method
     *
     * @return void
     */
    private void initBufferedReader() {

        BufferedReader reader = null;

        try {
            File file = Path.getFile();
            if (file.exists()) {

                reader = new BufferedReader(new FileReader(file));
                String bufferLine;

                while ((bufferLine = reader.readLine()) != null) {
                    /* parsing file string */
                    parseLineOfFile(bufferLine);
                }
                reader.close();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * method parses incomming string to String[] and then generates parameters for
     * further class constructor generator
     *
     * @param parseLine - String of params, separated by ','
     */
    private void parseLineOfFile(String parseLine) {
        /* splitting string into array by commas */
        String[] carInfo = parseLine.split(",");
        String carModel = carInfo[0].substring(1, carInfo[0].length());
        String carClass =  carInfo[1];
        double carPrice = Double.parseDouble(carInfo[2]);
        double carFuel = Double.parseDouble(carInfo[3].substring(0,carInfo[3].indexOf('/')));

        createCarFromString(carModel,carClass,carPrice,carFuel);

    }

    /**
     * Method creates instance of certain class and adds it to singleton list
     *
     * @param model - String: model of car, for example 'Toyota (Corolla)'
     * @param className - String: name of generated class (case sensitive)
     * @param fuel - double: fuel consumption rate
     */
    private void createCarFromString(String model, String className, double price, double fuel) {

        List<Car> newCarList = new ArrayList<>();

        try {
            /* creating new class by class name */
            Class<?> someClass = Class.forName(className);
            Constructor<?> constructor = someClass.getConstructor(double.class, double.class, String.class);
            Object newCar = constructor.newInstance(fuel, price, model);

            TaxiCompany.addCarToList((Car) newCar);

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            System.out.println("new class added");
        }
    }
}
