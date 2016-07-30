package io;

import cars.Car;
import company.TaxiCompany;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class IOFileWriter {
    public IOFileWriter() throws IOException {

        boolean firstLine = true;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path.getFile()))) {
            for (Car car : TaxiCompany.getCarList()) {
                writer.write((firstLine ? "" : "\n") + car.toString());
                firstLine = false;
            }
        } finally {
            System.out.println("file written.");
        }
    }
}