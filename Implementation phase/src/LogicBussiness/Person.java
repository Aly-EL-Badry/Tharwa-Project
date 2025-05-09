package LogicBussiness;

import java.util.Vector;
public class Person {
   private String username;
    private String name;
    private String password;
    private String email;

    public Person(String username, String name, String password, String email) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String val) {
        this.username = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String val) {
        this.name = val;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String val) {
        this.password = val;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String val) {
        this.email = val;
    }
}
