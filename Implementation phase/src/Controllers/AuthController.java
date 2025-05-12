package Controllers;

import Funcs.HelperFunc;
import Repo.UserRepo;
import LogicBusiness.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AuthController {

    private UserRepo repo;
    private Scanner scanner;

    public AuthController() {
        this.repo = new UserRepo();
        ViewMenu();
        repo.saveAll();
    }

    private User Verification(String username, String password) {
        return repo.search(username, password);
    }

    private User VerifyCred(User user) {
        if(!repo.search(user)) {
            return user;
        }
        else{
            System.out.println("This User is already verified");
            return null;
        }
    }

    public void SignUp() {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your full name:");
        String fullName = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter a password:");
        String password = scanner.nextLine();

        User user = VerifyCred(new User(username, fullName, email, password));

        if(user != null) {
            repo.Adduser(user);
            System.out.println("Login successful!");
            new DashboardController(user);
        }

    }

    public void Login() {
        // Get username and password from user input
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User authenticatedUser = Verification(username, password);

        if (authenticatedUser == null) {
            System.out.println("Wrong Password or Username");
        } else {
            System.out.println("Login successful!");
            new DashboardController(authenticatedUser);
        }
    }

    private void ViewMenu() {
        label:
        while(true){
            System.out.println("Welcome to the Our Program");
            String Menu = "1. Sign Up\n2. Login\n3. Exit";
            ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3"));
            String choice = HelperFunc.check_menu(Menu, choices);

            switch (choice) {
                case "1":
                    SignUp();
                    break;
                case "2":
                    Login();
                    break;
                case "3":
                    break label;
            }
        }
    }
}
