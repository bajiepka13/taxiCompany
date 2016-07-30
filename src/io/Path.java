package io;

import java.io.File;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class Path {

    static String file = "taxiCompany.txt";

    private Path(){

    }

    public static File getFile(){
        return new File(file);
    }
}
