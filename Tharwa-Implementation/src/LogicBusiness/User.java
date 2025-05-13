package LogicBusiness;

import ExternalAccs.BankAccount;   // Import from ExternalAccs
import ExternalAccs.StockAccount; // Import from ExternalAccs

import java.util.Vector;

/**
 * Represents a user with a set of bank accounts, stock accounts, and assets.
 * Extends the Person class and provides functionality for managing user accounts and assets.
 */
public class User extends Person {
    private Vector<BankAccount> accounts;
    private Vector<StockAccount> stocks;
    private Vector<Asset> assets;

    /**
     * Default constructor for creating a user with empty attributes.
     * Calls the super class constructor with empty strings and initializes empty vectors for accounts, stocks, and assets.
     */
    public User() {
        super("", "", "", ""); // Default constructor with empty strings
        this.accounts = new Vector<>();
        this.stocks = new Vector<>();
        this.assets = new Vector<>();
    }

    /**
     * Constructs a User object with the given username, name, password, and email.
     * Initializes empty vectors for accounts, stocks, and assets.
     *
     * @param username the username of the user
     * @param name the name of the user
     * @param password the password of the user
     * @param email the email of the user
     */
    public User(String username, String name, String password, String email) {
        super(username, name, password, email);
        this.accounts = new Vector<>();
        this.stocks = new Vector<>();
        this.assets = new Vector<>();
    }

    /**
     * Adds an asset to the user's asset collection.
     *
     * @param asset the asset to be added
     */
    public void setAsset(Asset asset) {
        assets.add(asset);
    }

    /**
     * Adds a bank account to the user's account collection.
     *
     * @param account the bank account to be added
     */
    public void setAccount(BankAccount account) {
        accounts.add(account);
    }

    /**
     * Removes a bank account from the user's account collection.
     *
     * @param account the bank account to be removed
     */
    public void delAccounts(BankAccount account) {
        accounts.remove(account);
    }

    /**
     * Removes a stock account from the user's stock collection.
     *
     * @param account the stock account to be removed
     */
    public void delStocks(StockAccount account) {
        stocks.remove(account);
    }

    /**
     * Returns a list of the user's bank accounts.
     *
     * @return the user's bank accounts
     */
    public Vector<BankAccount> getAccounts() {
        return accounts;
    }

    /**
     * Removes an asset from the user's asset collection.
     *
     * @param asset the asset to be removed
     */
    public void delAssets(Asset asset) {
        assets.remove(asset);
    }

    /**
     * Returns a list of the user's assets.
     *
     * @return the user's assets
     */
    public Vector<Asset> getAssets() {
        return assets;
    }

    /**
     * Searches for a specific asset in the user's asset collection.
     *
     * @param asset the asset to be searched for
     * @return true if the asset is found, false otherwise
     */
    public boolean SearchAsset(Asset asset){
        for (int idx = 0; idx < assets.size(); idx++)
            if(assets.elementAt(idx).equals(asset))
                return true;

        return false;
    }
}
