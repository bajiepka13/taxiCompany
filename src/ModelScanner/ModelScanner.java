package ModelScanner;

import java.util.Scanner;

/**
 * Created by skydock on 26.07.2016.
 */
public class ModelScanner {

    final static String[] Model = new String[]{"",""};
    final static Scanner s = new Scanner(System.in);

    private ModelScanner(){

    }

    public static String getCarModel(){

        for (int i = 0; i < 2; i++){
            System.out.println(i == 0 ? "Enter car brand: " : "Enter car model: ");
            Model[i] = s.next();
        }
        return String.format("%s (%s)",Model[0], Model[1]);
    }

    public static boolean getAnotherCar(){

        Boolean b = null;

        System.out.println("do you want to add car to taxi park?");
        String string = s.next();

        if (string == "yes"){
            b = true;
        }
        return b;
    }
}
