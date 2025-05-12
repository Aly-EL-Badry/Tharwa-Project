package Panels;

import Funcs.HelperFunc;
import LogicBusiness.User;

import java.util.ArrayList;
import java.util.Arrays;

public class ZaketPanel implements Panel{

    private User user;

    public ZaketPanel(User user){this.user=user;}

    @Override
    public void ViewMenu() {
        System.out.println("# === Zaket Panel === #");

        String Menu = "1.Zakat Calculation\n2.Halal investment Screen\n3.Tax Complaint\n4.Go back\nEnter your choice :";
        ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        String choice = HelperFunc.check_menu(Menu, choices);

        if(choice.equals("1"))
            zakatCalculation();
        else if (choice.equals("2"))
            HalalInvestment();
        else
            TaxComplaintsRepo();
    }


    public void zakatCalculation(){
        // Calculate Zakah of Bank account
        double zakatableAmount = 0.0;


    }
    public void HalalInvestment(){}
    public void TaxComplaintsRepo(){}
}
