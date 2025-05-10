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

    }

    public void ViewAssets (){
        Vector<Asset> assets = user.getAssets();
        for (int idx = 0; idx < assets.size(); idx++) {
            System.out.print("Asset "+(idx+1)+" --> ");
            assets.elementAt(idx).ViewAsset();
        }
    }

    public void EditAsset(){

    }

    public void Evaluate(){

    }
}
