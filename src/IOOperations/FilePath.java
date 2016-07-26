package IOOperations;

/**
 * Created by skydock on 25.07.2016.
 */
public abstract class FilePath {

    static String configFile = "taxiCompanyList.txt";

    FilePath(){

    }

    public static String getConfigFile() {
        return configFile;
    }

}
