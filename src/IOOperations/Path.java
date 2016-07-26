package IOOperations;

import java.io.File;

/**
 * Created by skydock on 27.07.2016.
 */
public class Path {

    static String file = "taxiCompany.txt";

    private Path(){

    }

    public static File getFile(){
        return new File(file);
    }
}
