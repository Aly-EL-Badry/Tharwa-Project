package LogicBusiness;

import ExternalAccs.BankAccount;   // Import from ExternalAccs
import ExternalAccs.StockAccount; // Import from ExternalAccs

import java.util.Vector;

public class User extends Person {
    private Vector<BankAccount> accounts;
    private Vector<StockAccount> stocks;
    private Vector<Asset> assets;

    public User() {
        super("", "", "", ""); // Default constructor with empty strings
        this.accounts = new Vector<>();
        this.stocks = new Vector<>();
        this.assets = new Vector<>();
    }

    public User(String username, String name, String password, String email) {
        super(username, name, password, email);
        this.accounts = new Vector<>();
        this.stocks = new Vector<>();
        this.assets = new Vector<>();
    }

    public void setAsset(Asset asset) {
        assets.add(asset);
    }

    public void setAccount(BankAccount account) {
        accounts.add(account);
    }

    public void delAccounts(BankAccount account) {
        accounts.remove(account);
    }

    public void delStocks(StockAccount account) {
        stocks.remove(account);
    }

    public Vector<BankAccount> getAccounts() {
        return accounts;
    }

    public void delAssets(Asset asset) {
        assets.remove(asset);
    }

    public Vector<Asset> getAssets() {
        return assets;
    }

    public boolean SearchAsset(Asset asset){
        for (int idx = 0; idx < assets.size(); idx++)
            if(assets.elementAt(idx).equals(asset))
              return true;

        return false;
    }



}
