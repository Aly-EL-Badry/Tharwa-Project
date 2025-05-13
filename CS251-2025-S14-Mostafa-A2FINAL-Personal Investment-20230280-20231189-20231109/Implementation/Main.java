import Controllers.AuthController;

/**
 * The Main class serves as the entry point for the application.
 * It initializes the authentication controller.
 */
public class Main {

    /**
     * The main method is the entry point of the Java application.
     * It creates a new instance of the AuthController to handle user authentication.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        new AuthController();
    }
}
