package Repo;

import ExternalAccs.BankAccount;
import LogicBusiness.Asset;
import LogicBusiness.User;

import java.util.Vector;
import java.io.*;

/**
 * UserRepo is a repository class that manages a collection of User objects.
 * It provides functionality for adding users, searching for users by username,
 * email, and credentials, and saving and loading users to and from a file.
 * <p>
 * The class also manages assets and bank account information for each user.
 */
public class UserRepo {

    private Vector<User> users;

    /**
     * Constructor that loads user data from a file.
     * The file contains information about users, assets, and bank accounts.
     *
     * @throws RuntimeException if there is an error reading the file.
     */
    public UserRepo() {
        users = new Vector<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Repo/Users"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String userName = line;
                String fullName = br.readLine();
                String password = br.readLine();
                String email = br.readLine();
                User user = new User(userName, fullName, password, email);

                int numAssets = Integer.parseInt(br.readLine());
                for (int i = 0; i < numAssets; i++) {
                    String Assetname = br.readLine();
                    String type = br.readLine();
                    String purchaseTime = br.readLine();
                    int quantity = Integer.parseInt(br.readLine());
                    int price = Integer.parseInt(br.readLine());
                    user.setAsset(new Asset(Assetname, type, purchaseTime, quantity, price));
                }

                int numAccounts = Integer.parseInt(br.readLine());
                for (int i = 0; i < numAccounts; i++) {
                    String bankName = br.readLine();
                    String cardNumber = br.readLine();
                    String cardHolder = br.readLine();
                    String expireDate = br.readLine();
                    int otp = Integer.parseInt(br.readLine());
                    int cvv = Integer.parseInt(br.readLine());
                    user.setAccount(new BankAccount(bankName, cardNumber, cardHolder, expireDate, otp, cvv));
                }
                users.add(user);
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    }

    /**
     * Adds a new user to the repository.
     *
     * @param user the user to be added.
     */
    public void Adduser(User user) {
        users.add(user);
    }

    /**
     * Searches for a user by checking the username or email.
     *
     * @param user the user to search for.
     * @return true if the user exists, false otherwise.
     */
    public boolean search(User user) {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for a user by username and password.
     *
     * @param Username the username of the user.
     * @param Password the password of the user.
     * @return the matching user if found, null otherwise.
     */
    public User search(String Username, String Password) {
        for (User user : users) {
            if (user.getUsername().equals(Username) && user.getPassword().equals(Password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Saves all user data to the file.
     * This includes user information, assets, and bank accounts.
     */
    public void saveAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Repo/Users"))) {
            for (User user : users) {
                writer.write(user.getUsername() + "\n");
                writer.write(user.getName() + "\n");
                writer.write(user.getPassword() + "\n");
                writer.write(user.getEmail() + "\n");

                writer.write(user.getAssets().size() + "\n");
                for (Asset a : user.getAssets()) {
                    writer.write(a.getName() + "\n");
                    writer.write(a.getType() + "\n");
                    writer.write(a.getPurchaseTime() + "\n");
                    writer.write(a.getQuantity() + "\n");
                    writer.write(a.getPurchasePrice() + "\n");
                }

                writer.write(user.getAccounts().size() + "\n");
                for (BankAccount b : user.getAccounts()) {
                    writer.write(b.getBankName() + "\n");
                    writer.write(b.getCardNumber() + "\n");
                    writer.write(b.getCardHolderName() + "\n");
                    writer.write(b.getExpiryDate() + "\n");
                    writer.write(b.getOTP() + "\n");
                    writer.write(b.getCVV() + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error saving all users: " + e.getMessage());
        }
    }
}
