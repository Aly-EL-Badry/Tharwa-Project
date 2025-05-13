package LogicBusiness;

import java.util.ArrayList;

/**
 * Represents an asset with its details, including name, type, purchase information, quantity, and goals associated with it.
 */
public class Asset {

    private String Name, Type, purchaseTime;
    private int Quantity, PurchasePrice;
    private ArrayList<Goal> Goals;

    /**
     * Gets the list of goals associated with the asset.
     *
     * @return An {@link ArrayList} of {@link Goal} objects associated with the asset.
     */
    public ArrayList<Goal> getGoals() {
        return Goals;
    }

    /**
     * Gets the quantity of the asset.
     *
     * @return The quantity of the asset.
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Gets the name of the asset.
     *
     * @return The name of the asset.
     */
    public String getName() {
        return Name;
    }

    /**
     * Gets the purchase time of the asset.
     *
     * @return The purchase time of the asset.
     */
    public String getPurchaseTime() {
        return purchaseTime;
    }

    /**
     * Gets the type of the asset.
     *
     * @return The type of the asset.
     */
    public String getType() {
        return Type;
    }

    /**
     * Sets the purchase price of the asset.
     *
     * @param purchasePrice The purchase price to set.
     */
    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    /**
     * Gets the purchase price of the asset.
     *
     * @return The purchase price of the asset.
     */
    public int getPurchasePrice() {
        return PurchasePrice;
    }

    /**
     * Adds a goal to the asset.
     *
     * @param goal The goal to be added.
     */
    public void setGoal(Goal goal) {
        Goals.add(goal);
    }

    /**
     * Sets the quantity of the asset.
     *
     * @param val The quantity to set.
     */
    public void setQuantity(int val) {
        Quantity = val;
    }

    /**
     * Sets the purchase time of the asset.
     *
     * @param val The purchase time to set.
     */
    public void setPurchaseTime(String val) {
        this.purchaseTime = val;
    }

    /**
     * Sets the type of the asset.
     *
     * @param val The type to set.
     */
    public void setType(String val) {
        Type = val;
    }

    /**
     * Sets the name of the asset.
     *
     * @param val The name to set.
     */
    public void setName(String val) {
        Name = val;
    }

    /**
     * Constructor to create a new asset with the specified details.
     *
     * @param Name        The name of the asset.
     * @param Type        The type of the asset.
     * @param purchaseTime The time when the asset was purchased.
     * @param Quantity    The quantity of the asset.
     * @param PurchasePrice The purchase price of the asset.
     */
    public Asset(String Name, String Type, String purchaseTime, int Quantity, int PurchasePrice) {
        this.Name = Name;
        this.purchaseTime = purchaseTime;
        this.Type = Type;
        this.Quantity = Quantity;
        this.PurchasePrice = PurchasePrice;
        Goals = new ArrayList<>();
    }

    /**
     * Displays detailed information about the asset, including its name, type, purchase time, price, quantity, and associated goals.
     */
    public void ViewAsset() {
        System.out.print("Asset \"" + Name + "\" :\n\n");
        System.out.print("Type : " + Type + "\n");
        System.out.print("Purchase date : " + purchaseTime + "\n");
        System.out.print("Purchase price : " + PurchasePrice + "\n");
        System.out.print("Quantity of that asset : " + Quantity + "\n");
        System.out.println("The goals of that asset : ");

        if (!Goals.isEmpty())
            for (int idx = 0; idx < Goals.size(); idx++)
                System.out.println("Goal #" + (idx + 1) + ": ");
        else
            System.out.println("Goals have not been added yet !!");

        System.out.print("\n\n");
    }

    /**
     * Compares this asset to another object for equality.
     * Two assets are considered equal if they have the same name, purchase time, type, and quantity.
     *
     * @param obj The object to compare this asset with.
     * @return {@code true} if the assets are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Asset asset = (Asset) obj;
        return asset.Name.equals(Name)
                && asset.purchaseTime.equals(purchaseTime)
                && asset.Type.equals(Type)
                && asset.Quantity == Quantity;
    }
}
