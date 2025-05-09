package LogicBusiness;

import java.util.ArrayList;

public class Asset {
   private String Name , Type , purchaseTime ;
   private int Quantity ;
   private ArrayList<Goal> Goals;

    public ArrayList<Goal> getGoals() {
        return Goals;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getName() {
        return Name;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public String getType() {
        return Type;
    }

    public void setGoal(Goal goal) {
        Goals.add(goal);
    }

    public void setQuantity(int val) {
        Quantity = val;
    }

    public void setPurchaseTime(String val) {
        this.purchaseTime = val;
    }

    public void setType(String val) {
        Type = val;
    }

    public void setName(String val) {
        Name = val;
    }

    public Asset(String Name , String Type , String purchaseTime , int Quantity){
        this.Name=Name;
        this.purchaseTime=purchaseTime;
        this.Type=Type;
        this.Quantity=Quantity;
    }

    public void ViewAsset (){

        System.out.print("Asset \""+ Name +"\" :\n\n");
        System.out.print("Type : "+Type+"\n");
        System.out.print("Purchase data : "+purchaseTime+"\n");
        System.out.print("Quantity of that asset : "+Quantity+"\n");
        System.out.println("The goals of that asset : ");

        if(!Goals.isEmpty())
            for (int idx = 0; idx < Goals.size(); idx++)
                System.out.println("Goal #" + (idx + 1) + ": ");
        else
            System.out.println("Goals have not added yet !!");

    }
}
