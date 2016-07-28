package io;

import cars.Car;
import company.TaxiCompany;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public class IOFileWriter {
    public IOFileWriter() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(Path.getFile()));
        boolean firstLine = true;
        try {
            for (Car car : TaxiCompany.getCarList()) {
                writer.write((firstLine ? "":"\n" ) + car.toString());
                firstLine = false;
            }
        } finally {
            writer.close();
            System.out.println("file written.");
        }
    }
}