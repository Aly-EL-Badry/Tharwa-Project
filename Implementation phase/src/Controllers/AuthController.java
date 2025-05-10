package Controllers;

import Repo.UserRepo;
import LogicBusiness.User;

import java.util.Scanner;

public class AuthController {

    private UserRepo repo;
    private Scanner scanner;

    public AuthController() {
        this.repo = new UserRepo();
    }

    private User Verification(String username, String password) {
        return repo.search(username, password);
    }

    private User VerifyCred(User user) {
        // Implementation goes here
        return null;
    }

    public void SignUp() {
        // Implementation goes here
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
            ViewMenu();
        } else {
            System.out.println("Login successful!");
            new DashboardController(authenticatedUser);
        }
    }

    private void ViewMenu() {
        // Implementation goes here
    }
}
