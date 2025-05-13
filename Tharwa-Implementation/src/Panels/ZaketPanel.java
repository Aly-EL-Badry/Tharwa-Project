package Panels;

import Funcs.HelperFunc;
import LogicBusiness.Asset;
import LogicBusiness.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class ZaketPanel implements Panel{

    final private User user;

    public ZaketPanel(User user){this.user=user;}

    @Override
    public void ViewMenu() {
        label:
        while(true){
            System.out.println("# === Zaket Panel === #");
    
            String Menu = "1.Zakat Calculation\n2.Halal investment Screen\n3.Tax Complaint\n4.Go back\nEnter your choice :";
            ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
            String choice = HelperFunc.check_menu(Menu, choices);

            switch (choice) {
                case "1":
                    zakatCalculation();
                    break;
                case "2":
                    HalalInvestment();
                    break;
                case "3":
                    TaxComplaintsRepo();
                    break;
                default:
                    break label;
            }
        }
    }


    public void zakatCalculation(){
        final double MINIMUM_VALUE_FOR_ZAKET = 7246;
        final double ZAKAH_PRECENTAGE = 2.5/100;
        double TotalWealth = 0, Zakah;

        Vector<Asset> userAssets = user.getAssets();

        for(Asset asset : userAssets){
            TotalWealth += asset.getQuantity() * asset.getPurchasePrice();
        }

        Zakah = TotalWealth*ZAKAH_PRECENTAGE;

        if(TotalWealth < MINIMUM_VALUE_FOR_ZAKET){
            System.out.println("You Dont Have to Pay Zakat");
        } else{
            System.out.println("Your total wealth is " + TotalWealth);
            System.out.println("So your Zakah is " + Zakah);
        }
    }
    public void HalalInvestment(){
        System.out.println("Halal Investment");
    }
    public void TaxComplaintsRepo(){
        System.out.println("Tax Complaints");
    }
}
