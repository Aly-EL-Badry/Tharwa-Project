package Funcs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class that provides helper functions for input validation and user interaction.
 */
public class HelperFunc {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Displays a menu and checks if the user input is a valid option.
     *
     * @param menuText The menu text to display.
     * @param choices  A list of valid choices.
     * @return The valid user input from the choices.
     */
    public static String check_menu(String menuText, ArrayList<String> choices) {
        String currentAnswer;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(menuText);
            currentAnswer = in.nextLine();
            if (currentAnswer.length() != 1 || !choices.contains(currentAnswer))
                System.out.println("Please Enter a valid option !!\n");
            else
                break;
        }
        return currentAnswer;
    }

    /**
     * Checks whether a string consists only of numeric digits.
     *
     * @param num The string to check.
     * @return True if the string is a valid number, false otherwise.
     */
    public static boolean isNum(String num) {
        for (int idx = 0; idx < num.length(); idx++)
            if (!Character.isDigit(num.charAt(idx)))
                return false;
        return true;
    }

    /**
     * Checks whether a string represents a valid floating-point number.
     *
     * @param num The string to check.
     * @return True if the string is a valid float, false otherwise.
     */
    public static boolean isFloat(String num) {
        boolean dot = true;
        for (int idx = 0; idx < num.length(); idx++) {
            if (!Character.isDigit(num.charAt(idx)) && num.charAt(idx) != '.')
                return false;
            if (num.charAt(idx) == '.') {
                if (!dot)
                    return false;
                dot = false;
            }
        }
        return true;
    }

    /**
     * Prompts the user for input until a non-empty string is entered.
     *
     * @param prompt The prompt message to display.
     * @return A non-empty string entered by the user.
     */
    public static String getNonEmptyInput(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty())
                System.out.println("Please Enter a valid option !!\n");
        }
        return input;
    }

}
