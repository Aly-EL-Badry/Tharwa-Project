package Panels;
import LogicBusiness.Asset;
import LogicBusiness.User;
import Funcs.HelperFunc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class InvestDashBoardPanel implements Panel{
    private final User user ;



    @Override
    public void ViewMenu() {
        while (true) {

            System.out.println("        ##Asset Panel ##\n");

            String Menu = "1.add Asset\n2.Remove Asset\n3.ViewAssets\n4.EditAsset\n5.Go back\nEnter your choice :";
            ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
            String choice = HelperFunc.check_menu(Menu, choices);

            if (choice.equals("1"))
                addAsset();
            else if (choice.equals("2"))
                removeAsset();
            else if(choice.equals("3"))
                ViewAssets();
            else if(choice.equals("4"))
                EditAsset();
            else
                break;

        }


    }

    public InvestDashBoardPanel(User user){
        this.user=user;
    }

    public void addAsset (){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the name of the asset : ");
        String name = in.nextLine();



        // validation for type
        String menu = "Choose a type for the new asset" +
                     " :\n1.Gold\n2.Real state\n3.Crypto\n4.Stocks\n\nEnter your choice : ";
        ArrayList<String>choices= new ArrayList<>(Arrays.asList("1","2","3","4","5"));
        String choice = HelperFunc.check_menu(menu,choices);
        String Type ;
        if(choice.equals("1"))
            Type="Gold";
        else if(choice.equals("2"))
            Type="Real state";
        else if( choice.equals("3"))
            Type="Crypto";
        else
            Type="Stocks";




        //validation for date
        System.out.print("Enter the purchase date !! ");

        System.out.print("Enter the day :");
        String day = in.next();
        while(!HelperFunc.isNum(day )|| (Integer.parseInt(day)<=31&&Integer.parseInt(day)>=1)){
            System.out.println("Please enter a valid day !!");
            System.out.print("Enter the day :");
            day=in.next();
        }

        System.out.print("Enter the month :");
        String month = in.next();
        while(!HelperFunc.isNum(month )|| (Integer.parseInt(month)<=12&&Integer.parseInt(month)>=1)){
            System.out.println("Please enter a valid month !!");
            System.out.print("Enter the month :");
            month=in.next();
        }

        System.out.print("Enter the year :");
        String year = in.next();
        while(!HelperFunc.isNum(year )|| (Integer.parseInt(year)<=2025&&Integer.parseInt(year)>=1800)){
            System.out.println("Please enter a valid year !!");
            System.out.print("Enter the year :");
            year=in.next();
        }
        String purchaseTime = day+'/'+month+'/'+year;




        //validation for numbers
        System.out.print("Enter the quantity : ");
        String quantity = in.next();
        while(!HelperFunc.isNum(quantity )){
            System.out.println("Please enter a valid number !!");
            System.out.print("Enter the quantity : ");
            quantity=in.next();
        }


        //validation for repeating
        Asset asset =new Asset(name,Type ,purchaseTime, Integer.parseInt(quantity));
        boolean isFound =user.SearchAsset(asset);
        if(isFound)
            System.out.println("That Asset already exists !!\n\n");
        else {
            System.out.println("The Asset is added successfully !!\n\n");
            user.setAsset(asset);
        }
    }

    public void removeAsset(){
 Vector<Asset> assets = user.getAssets();
        if (assets.isEmpty()) {
            System.out.println("No assets available to remove!\n\n");
            return;
        }

        // Display all assets with numbers
        System.out.println("Available assets:");
        for (int i = 0; i < assets.size(); i++) {
            System.out.print((i + 1) + ". ");
            assets.get(i).ViewAsset();
        }

        // Get user input for which asset to remove
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of asset to remove (or 0 to cancel): ");
        String input = in.next();

        while (!HelperFunc.isNum(input) || Integer.parseInt(input) < 0 || Integer.parseInt(input) > assets.size()) {
            System.out.println("Invalid input! Please enter a number between 1 and " + assets.size() + " (or 0 to cancel)");
            System.out.print("Enter the number of asset to remove: ");
            input = in.next();
        }

        int choice = Integer.parseInt(input);
        if (choice == 0) {
            System.out.println("Operation cancelled.\n\n");
            return;
        }

        // Remove the selected asset
        Asset removedAsset = assets.remove(choice - 1);
        System.out.println("Asset '" + removedAsset.getName() + "' removed successfully!\n\n");
    }

    public void ViewAssets (){
        Vector<Asset> assets = user.getAssets();
        for (int idx = 0; idx < assets.size(); idx++) {
            System.out.print("Asset "+(idx+1)+" --> ");
            assets.elementAt(idx).ViewAsset();
        }
    }

    public void EditAsset(){
Vector<Asset> assets = user.getAssets();
        if (assets.isEmpty()) {
            System.out.println("No assets available to edit!\n\n");
            return;
        }

        // Display all assets with numbers
        System.out.println("Available assets:");
        for (int i = 0; i < assets.size(); i++) {
            System.out.print((i + 1) + ". ");
            assets.get(i).ViewAsset();
        }

        // Get user input for which asset to edit
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of asset to edit (or 0 to cancel): ");
        String input = in.next();

        while (!HelperFunc.isNum(input) || Integer.parseInt(input) < 0 || Integer.parseInt(input) > assets.size()) {
            System.out.println("Invalid input! Please enter a number between 1 and " + assets.size() + " (or 0 to cancel)");
            System.out.print("Enter the number of asset to edit: ");
            input = in.next();
        }

        int choice = Integer.parseInt(input);
        if (choice == 0) {
            System.out.println("Operation cancelled.\n\n");
            return;
        }

        Asset assetToEdit = assets.get(choice - 1);

        // Display edit menu
        String menu = "What would you like to edit?\n" +
                "1. Name\n" +
                "2. Type\n" +
                "3. Purchase Date\n" +
                "4. Quantity\n" +
                "5. Cancel\n" +
                "Enter your choice: ";

        ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        String editChoice = HelperFunc.check_menu(menu, choices);

        switch (editChoice) {
            case "1": // Edit Name
                in.nextLine(); // Consume newline
                System.out.print("Enter new name (current: " + assetToEdit.getName() + "): ");
                String newName = in.nextLine();
                assetToEdit.setName(newName);
                System.out.println("Name updated successfully!\n\n");
                break;

            case "2": // Edit Type
                String typeMenu = "Choose new type:\n" +
                        "1. Gold\n" +
                        "2. Real state\n" +
                        "3. Crypto\n" +
                        "4. Stocks\n" +
                        "Enter your choice: ";
                ArrayList<String> typeChoices = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
                String typeChoice = HelperFunc.check_menu(typeMenu, typeChoices);

                String newType;
                if (typeChoice.equals("1")) newType = "Gold";
                else if (typeChoice.equals("2")) newType = "Real state";
                else if (typeChoice.equals("3")) newType = "Crypto";
                else newType = "Stocks";

                assetToEdit.setType(newType);
                System.out.println("Type updated successfully!\n\n");
                break;

            case "3": // Edit Purchase Date
                System.out.print("Enter new purchase date (current: " + assetToEdit.getPurchaseTime() + ")\n");

                System.out.print("Day: ");
                String day = in.next();
                while (!HelperFunc.isNum(day) || Integer.parseInt(day) > 31 || Integer.parseInt(day) < 1) {
                    System.out.println("Please enter a valid day (1-31)!");
                    System.out.print("Day: ");
                    day = in.next();
                }

                System.out.print("Month: ");
                String month = in.next();
                while (!HelperFunc.isNum(month) || Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1) {
                    System.out.println("Please enter a valid month (1-12)!");
                    System.out.print("Month: ");
                    month = in.next();
                }

                System.out.print("Year: ");
                String year = in.next();
                while (!HelperFunc.isNum(year) || Integer.parseInt(year) > 2025 || Integer.parseInt(year) < 1800) {
                    System.out.println("Please enter a valid year (1800-2025)!");
                    System.out.print("Year: ");
                    year = in.next();
                }

                String newDate = day + "/" + month + "/" + year;
                assetToEdit.setPurchaseTime(newDate);
                System.out.println("Purchase date updated successfully!\n\n");
                break;

            case "4": // Edit Quantity
                System.out.print("Enter new quantity (current: " + assetToEdit.getQuantity() + "): ");
                String quantity = in.next();
                while (!HelperFunc.isNum(quantity)) {
                    System.out.println("Please enter a valid number!");
                    System.out.print("Enter new quantity: ");
                    quantity = in.next();
                }
                assetToEdit.setQuantity(Integer.parseInt(quantity));
                System.out.println("Quantity updated successfully!\n\n");
                break;

            case "5": // Cancel
                System.out.println("Edit cancelled.\n\n");
                break;
        }
    }

    public void Evaluate(){

    }
}
