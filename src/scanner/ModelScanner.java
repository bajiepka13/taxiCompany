package scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Bulgakov Alexandr & Chalenko Valerii
 * @version 1.0
 */
public class ModelScanner {

    final static String[] Model = new String[]{"",""};
    final static Scanner s = new Scanner(System.in);

    private ModelScanner(){
    }

    /**
     * Method generates car name and model from user's input information
     *
     * @return String: name and model of car, example: "Toyota (Corolla)"
     */
    public static String getCarModel(){

        for (int i = 0; i < 2; i++){
            System.out.println(i == 0 ? "Enter car brand: " : "Enter car model: ");
            Model[i] = s.next();
        }
        return String.format("%s (%s)",Model[0], Model[1]);
    }

    /**
     * Shows user dialog and returns boolean for further actions
     *
     * @return true if new car creation is required
     */
    public static boolean getAnotherCar(){

        Boolean b = null;

        System.out.println("\ndo you want to add car to taxi park? (yes / no)");
        String string = s.next();

        if (string.equals("yes")){
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    /**
     * Method automates factory car generation
     *
     * @return String: appropriate for car factory class
     */
    public static String getCarType() {

        String car = "gas";

        System.out.println("Enter the number of car type you want to add:" +
                "\n1 - electromobile" +
                "\n2 - hydrogenobile" +
                "\n3 - gasoline car" +
                "\n4 - diesel car\n");

        try {
            if (s.hasNextInt()) {
                int choice = s.nextInt();

                switch (choice) {
                    case 1:
                        car = "electric";
                        break;
                    case 2:
                        car = "hydrogen";
                        break;
                    case 3:
                        car = "gas";
                        break;
                    case 4:
                        car = "diesel";
                        break;
                    default:
                        car = "gas";
                        break;
                }
            }
        } catch (InputMismatchException in) {
            in.printStackTrace();
        }
        return car;
    }

    /**
     * Method shows user fialog and returns the double value of car price
     *
     * @return
     */
    public static double getCarPrice() {

        System.out.println("\nenter this car price");
        double price = 0.00;
        try{
            if (s.hasNextDouble()){
                price = s.nextDouble();
            }
        } catch (InputMismatchException e){
            e.printStackTrace();
        }

        return price;

    }
}
