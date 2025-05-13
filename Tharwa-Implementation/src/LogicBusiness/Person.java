package LogicBusiness;

/**
 * Represents a person with a username, name, password, and email.
 * This class encapsulates the basic personal information of a user.
 */
public class Person {
    private String username;
    private String name;
    private String password;
    private String email;

    /**
     * Constructs a Person object with the given username, name, password, and email.
     *
     * @param username the username of the person
     * @param name the name of the person
     * @param password the password of the person
     * @param email the email address of the person
     */
    public Person(String username, String name, String password, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    /**
     * Returns the username of the person.
     *
     * @return the username of the person
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the person.
     *
     * @param val the new username
     */
    public void setUsername(String val) {
        this.username = val;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param val the new name
     */
    public void setName(String val) {
        this.name = val;
    }

    /**
     * Returns the password of the person.
     *
     * @return the password of the person
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the person.
     *
     * @param val the new password
     */
    public void setPassword(String val) {
        this.password = val;
    }

    /**
     * Returns the email address of the person.
     *
     * @return the email address of the person
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person.
     *
     * @param val the new email address
     */
    public void setEmail(String val) {
        this.email = val;
    }
}
