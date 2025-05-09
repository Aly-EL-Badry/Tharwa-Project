package Funcs;

import java.util.ArrayList;
import java.util.Scanner;

public class HelperFunc {
    public static String check_menu( String menuText , ArrayList<String> choices){

        String currentAnswer;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print(menuText);
            currentAnswer=in.nextLine();
            if(currentAnswer.length() != 1 || !choices.contains(currentAnswer))
                System.out.println("Please Enter a valid option !!\n");
            else
                break;
        }


        return currentAnswer;
    }
}
