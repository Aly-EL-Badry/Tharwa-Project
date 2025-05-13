package Controllers;

import Funcs.HelperFunc;
import Repo.UserRepo;
import LogicBusiness.User;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The {@code AuthController} class manages user authentication processes
 * including sign-up, login, and input validation. It also initializes the
 * authentication menu and handles user interaction.
 */
public class AuthController {

    private UserRepo repo;

    /**
     * Constructs an {@code AuthController} instance, initializes the user repository,
     * displays the authentication menu, and saves all users.
     */
    public AuthController() {
        this.repo = new UserRepo();
        ViewMenu();
        repo.saveAll();
    }

    /**
     * Verifies the provided username and password against stored users.
     *
     * @param username the username entered by the user.
     * @param password the password entered by the user.
     * @return the authenticated {@code User} object if credentials are correct, otherwise {@code null}.
     */
    private User Verification(String username, String password) {
        return repo.search(username, password);
    }

    /**
     * Verifies if the user credentials are not already in use.
     *
     * @param user the {@code User} object containing user details.
     * @return the user object if not already verified, otherwise {@code null}.
     */
    private User VerifyCred(User user) {
        if (!repo.search(user)) {
            return user;
        } else {
            System.out.println("This User is already verified");
            return null;
        }
    }

    /**
     * Handles the user registration (sign-up) process by prompting the user
     * for required credentials, validating them, and saving the new user.
     */
    public void SignUp() {
        String username = HelperFunc.getNonEmptyInput("Enter your username: ");
        String fullName = HelperFunc.getNonEmptyInput("Enter your full name: ");
        String email;
        while (true) {
            email = HelperFunc.getNonEmptyInput("Enter your email: ");
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (email.matches(emailRegex)) {
                break;
            } else {
                System.out.println("❌ Invalid email format. Please try again.");
            }
        }
        String password = HelperFunc.getNonEmptyInput("Enter your password: ");

        User user = VerifyCred(new User(username, fullName, password, email));

        if (user != null) {
            repo.Adduser(user);
            System.out.println("Login successful!");
            new DashboardController(user);
        }
    }

    /**
     * Handles the user login process by requesting credentials and authenticating the user.
     */
    public void Login() {
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

    /**
     * Displays the authentication menu and allows the user to choose between signing up,
     * logging in, or exiting the program.
     */
    private void ViewMenu() {
        label:
        while (true) {
            System.out.println("Welcome to the Our Program");
            String menu = "1. Sign Up\n2. Login\n3. Exit\nEnter your choice:";
            ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3"));
            String choice = HelperFunc.check_menu(menu, choices);

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
