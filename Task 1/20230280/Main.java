//Author: Fatema El-Zhraa Ahmed Mohamed Elfiky
//ID: 20230280

//version: V1.0
//First Modified: 24 Feb 2025
//Last Modified: 25 Feb 2025

//Purpose: a Contact Management System

/**Key Features:
 * Add a contact
 * delete a contact by phone number ,
 * Display contacts
 * save file
 * search for contact by name or by phone number
**/

public class Main {
    public static void main(String[] args) {

        System.out.println("##Welcome to the contact management system ##\n\n");

        // the class is manging the flow of the program
        UI UserInterface= new UI();
        while (UserInterface.MainMenu());

        System.out.println("###Thanks for using our program####");

    }

}