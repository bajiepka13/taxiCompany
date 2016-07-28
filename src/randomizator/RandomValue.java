package randomizator;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public class RandomValue {

    public RandomValue(){
        for (int i = 0; i < 50; i++){
            System.out.println("new random: " + getRandomNumber(10));
        }
    }

    public static double getRandomNumber(double avg){

        double min = avg - 3;
        double max = avg + 3;
        return min + (Math.random() * ((max - min)));
    }

}
