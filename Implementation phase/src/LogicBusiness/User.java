package LogicBusiness;

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

    public void delAccounts(Asset asset) {
        accounts.remove(asset);
    }

    public void delStocks(Asset asset) {
        stocks.remove(asset);
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

}
