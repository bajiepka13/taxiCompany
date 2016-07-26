package IOOperations;

import TaxiPark.TaxiCompany;

import java.io.*;

/**
 * Created by skydock on 25.07.2016.
 */
public class IOFileReader {

    public IOFileReader(){
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

    private void parseFile(BufferedReader reader){

//        File file = new File(FilePath.getConfigFile());
//        if (!file.exists()) {
//            try {
//                Settings.getInstance();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }

        }
    }
