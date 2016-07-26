package Randomizator;

import java.util.Random;

/**
 * Created by skydock on 26.07.2016.
 */
public class RandomValue {

    private static Random rNum = new Random();
    private RandomValue(){

    }

    public static double getRandomBumber(double borderValue){

        return rNum.nextDouble();
    }

}
