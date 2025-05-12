package Panels;
import ExternalAccs.BankAccount;
import Funcs.HelperFunc;
import Integrations.*;
import LogicBusiness.User;
import Repo.BankRepo;
import Repo.StockRepo;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerationPanel implements Panel{
    private User user;
    private BankRepo banks;
    private StockRepo stocks;
    private BanksAPIs_Account bankAPIS;
    private StocksAPIs_Account stockAPIS;

    public IntegerationPanel(User user){
        this.user= user;
        banks=new BankRepo();
        stocks=new StockRepo();
    }

    private String BanksMenu (){

        System.out.println("## ## The Available Banks to connect with ## ## \n");
        ArrayList<String>Banks = banks.getBanks();
        ArrayList<String>choices= new ArrayList<>();
        StringBuilder text =new StringBuilder() ;
        int idx=0;
        for ( ; idx < Banks.size(); idx++) {
            text.append((idx + 1) + "." + Banks.get(idx) + "\n");
            choices.add(String.valueOf(idx + 1));
        }
        text.append((idx + 1)+".Go back\n\n");
        choices.add(String.valueOf(idx + 1));
        text.append("Enter your choice : ");

        return HelperFunc.check_menu(text.toString(),choices);




    }

    private void ConnectBank (){

        BankAccount NewAcc=bankAPIS.Connection();

        if(NewAcc==null) {
            System.out.println("Sorry connection failed !!");
            return;
        }

        System.out.println("Connection is done successfully !!");
        user.setAccount(NewAcc);

    }

    @Override
    public void ViewMenu() {

        System.out.println("            ##Connection Panel##\n\n");

        while (true) {
            String menu = "1.Connect with bank account\n2.Connect with stock account" +
                    "\n3.Go Back\n\nEnter your choice: ";

            ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3"));
            String choice = HelperFunc.check_menu(menu, choices);

            if (choice.equals("1")){

                String Choice = BanksMenu();

                if(Choice.equals("1"))
                    bankAPIS = new API_AhlyBank();
                else if (Choice.equals("2"))
                    bankAPIS = new API_BankMisr();
                else if (Choice.equals("3"))
                    bankAPIS = new API_HSBC();
                else
                    continue;

                ConnectBank();

            }else if(choice.equals("2"))
                System.out.print("That part will be added soon!!\n");
            else
                break;
        }
    }
}
