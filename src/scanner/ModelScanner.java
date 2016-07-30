package scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Bulgakov Alexander & Chalenko Valerii
 * @version 1.0
 */
public class ModelScanner {

    final static String[] MODEL = new String[]{"", ""};
    final static Scanner SCANNER = new Scanner(System.in);


    private ModelScanner() {
    }

    /**
     * Method generates car name and model from user's input information
     *
     * @return String: name and model of car, example: "Toyota (Corolla)"
     */
    public static String getCarModel() {
        final int CAR_PARAM_QUANTITY = 2;
        final int CAR_BRAND_INDEX = 0;
        final int CAR_MODEL_INDEX = 1;

        for (int i = 0; i < CAR_PARAM_QUANTITY; i++) {
            System.out.println(i == CAR_BRAND_INDEX ? "Enter car brand: " : "Enter car model: ");
            MODEL[i] = SCANNER.next();
        }
        return String.format("%s (%s)", MODEL[CAR_BRAND_INDEX], MODEL[CAR_MODEL_INDEX]);
    }

    /**
     * Shows user dialog and returns boolean for further actions
     *
     * @return true if new car creation is required
     */
    public static boolean getAnotherCar() {

        Boolean isCarNeedsToBeAdded = false;

        System.out.println("\ndo you want to add car to taxi park? (yes / no)");
        String string = SCANNER.next();

        isCarNeedsToBeAdded = string.equals("yes");
        return isCarNeedsToBeAdded;
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
                "\n2 - hydrogen car" +
                "\n3 - gasoline car" +
                "\n4 - diesel car\n");

        try {
            if (SCANNER.hasNextInt()) {
                int choice = SCANNER.nextInt();

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
        try {
            if (SCANNER.hasNextDouble()) {
                price = SCANNER.nextDouble();
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        return price;

    }
}
