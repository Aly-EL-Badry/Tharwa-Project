package Panels;

import ExternalAccs.BankAccount;
import Funcs.HelperFunc;
import Integrations.*;
import LogicBusiness.User;
import Repo.BankRepo;
import Repo.StockRepo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents the integration panel where a user can connect to different bank and stock accounts.
 * It provides options for selecting and connecting to available bank accounts and stock accounts through APIs.
 */
public class IntegerationPanel implements Panel {
    private User user;
    private BankRepo banks;
    private StockRepo stocks;
    private BanksAPIs_Account bankAPIS;
    private StocksAPIs_Account stockAPIS;

    /**
     * Constructs an IntegerationPanel for a given user.
     *
     * @param user the user associated with the integration panel
     */
    public IntegerationPanel(User user){
        this.user = user;
        banks = new BankRepo();
        stocks = new StockRepo();
    }

    /**
     * Displays a menu for available banks to connect with and returns the user's selection.
     *
     * @return the user's choice of bank or an option to go back
     */
    private String BanksMenu (){

        System.out.println("## ## The Available Banks to connect with ## ## \n");
        ArrayList<String> Banks = banks.getBanks();
        ArrayList<String> choices = new ArrayList<>();
        StringBuilder text = new StringBuilder();
        int idx = 0;

        // Create a menu listing all available banks
        for (; idx < Banks.size(); idx++) {
            text.append((idx + 1) + "." + Banks.get(idx) + "\n");
            choices.add(String.valueOf(idx + 1));
        }

        // Add the "Go back" option at the end of the list
        text.append((idx + 1) + ".Go back\n\n");
        choices.add(String.valueOf(idx + 1));
        text.append("Enter your choice: ");

        return HelperFunc.check_menu(text.toString(), choices);
    }

    /**
     * Connects to a selected bank and sets up the user's bank account.
     * If the connection fails, it notifies the user.
     */
    private void ConnectBank (){

        BankAccount NewAcc = bankAPIS.Connection();

        if (NewAcc == null) {
            System.out.println("Sorry, connection failed!!");
            return;
        }

        System.out.println("Connection is done successfully!!");
        user.setAccount(NewAcc);
    }

    /**
     * Displays the main menu for the integration panel.
     * Allows the user to connect to a bank account, a stock account, or go back.
     */
    @Override
    public void ViewMenu() {

        while (true) {
            System.out.println("# === Connection Panel === #");
            String menu = "1.Connect with bank account\n2.Connect with stock account" +
                    "\n3.Go Back\n\nEnter your choice: ";

            ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3"));
            String choice = HelperFunc.check_menu(menu, choices);

            if (choice.equals("1")){

                // Call BanksMenu to select a bank
                String Choice = BanksMenu();

                // Set the API connection for the selected bank
                if (Choice.equals("1"))
                    bankAPIS = new API_AhlyBank();
                else if (Choice.equals("2"))
                    bankAPIS = new API_BankMisr();
                else if (Choice.equals("3"))
                    bankAPIS = new API_HSBC();
                else
                    continue;

                // Attempt to connect to the bank
                ConnectBank();

            } else if(choice.equals("2")) {
                System.out.print("That part will be added soon!!\n");
            } else {
                break;
            }
        }
    }
}
