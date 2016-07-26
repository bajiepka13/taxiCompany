package IOOperations;

import java.io.*;

/**
 * Created by skydock on 25.07.2016.
 */
public class IOFileReader {

    public IOFileReader(){
        BufferedReader bufferedReader = initBufferedReader();
    }


    private BufferedReader initBufferedReader(){

        BufferedReader  bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(FilePath.getConfigFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    private void initSettings(){

        File file = new File(FilePath.getConfigFile());
        if (!file.exists()) {
//            try {
//                Settings.getInstance();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
        }
    }

}
