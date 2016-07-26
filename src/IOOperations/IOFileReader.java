package IOOperations;

import ParkCars.Car;
import TaxiPark.TaxiCompany;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by skydock on 25.07.2016.
 */
public class IOFileReader {

    public IOFileReader() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader bufferedReader = initBufferedReader();
        parseFile(bufferedReader);
    }


    private BufferedReader initBufferedReader(){

        BufferedReader  bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(Path.getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    private void parseFile(BufferedReader reader) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        try {
            while (reader.readLine() != null){
                createCarFromString(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCarFromString(String carString) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] carInfo = carString.split(",");
        List<Car> newCarList = new ArrayList<>();

        try {
            Class<?> someClass = Class.forName(carInfo[1]);
            try {
                Constructor<?> constructor = someClass.getConstructor(Double.class, String.class, String.class);
                Car newCar = (Car) constructor.newInstance(
                        carInfo[0],
                        carInfo[1].substring(carInfo[1].indexOf(" of ")+4,carInfo[1].length()-1),
                        carInfo[2]);

                newCarList.add(newCar);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
