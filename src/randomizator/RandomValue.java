package randomizator;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class RandomValue {

    public static double getRandomNumber(double avg){
        double min = avg - 3;
        double max = avg + 3;
        return min + (Math.random() * ((max - min)));
    }

}
