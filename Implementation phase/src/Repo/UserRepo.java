package Repo;
import ExternalAccs.BankAccount;
import LogicBusiness.Asset;
import LogicBusiness.User;

import java.util.Vector;
import java.io.*;

public class UserRepo {
    private Vector<User> users;

    public UserRepo(){
        users = new Vector<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
            String userName = br.readLine();
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

        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    };

    public void Adduser(User user){
        users.add(user);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt", true))) {
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
        } catch (IOException e) {
            System.err.println("Error writing user to file: " + e.getMessage());
        }
    }

    public boolean search(User user){
        for(User u : users){
            if(u.getUsername().equals(user.getUsername())  && u.getEmail().equals(user.getEmail())){
                return true;
            }
        }
        return false;
    }

    public User search(String Username, String Password){
        for (User user : users) {
            if (user.getUsername().equals(Username) && user.getPassword().equals(Password)) {
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }
}
