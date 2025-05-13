package Controllers;

import Funcs.HelperFunc;
import Repo.UserRepo;
import LogicBusiness.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class AuthController {

    private UserRepo repo;

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

        String username = HelperFunc.getNonEmptyInput("Enter your username: ");
        String fullName = HelperFunc.getNonEmptyInput("Enter your full name: ");
        String email;
        while (true) {
             email = HelperFunc.getNonEmptyInput("Enter your email: ");
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (email.matches(emailRegex)) {
                // Valid email, break out of the loop
                break;
            } else {
                System.out.println("❌ Invalid email format. Please try again.");
            }
        }
        String password = HelperFunc.getNonEmptyInput("Enter your password: ");

        User user = VerifyCred(new User(username, fullName, password, email));

        if(user != null) {
            repo.Adduser(user);
            System.out.println("Login successful!");
            new DashboardController(user);
        }

    }

    public void Login() {
        // Get username and password from user input
        String username = HelperFunc.getNonEmptyInput("Enter your username: ");
        String password = HelperFunc.getNonEmptyInput("Enter your password: ");

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
            String Menu = "1. Sign Up\n2. Login\n3. Exit\nEnter your choice:";
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
