package Workers.Manger;

import Workers.Worker;

/**
 * The {@code Manger} class extends the {@link Worker} class and represents a manager
 * with additional authentication details such as a username and password.
 *
 * @author Aly El-Deen Yasser Ali
 * @version 1.0
 */

public class Manger extends Worker {
    /** The manager's username and password used for authentication.**/
    private String Username, Password;

    /**
     * Constructs a new {@code Manger} with the specified details.
     *
     * @param name       The manager's name.
     * @param salary     The manager's salary.
     * @param FieldType  The field or department the manager belongs to.
     * @param Username   The manager's username for login.
     * @param Password   The manager's password for login.
     */
    public Manger(String name, double salary, String FieldType, String Username, String Password) {
        super(name, salary, FieldType);
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }

}
