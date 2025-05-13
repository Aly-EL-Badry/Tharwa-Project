package Integrations;

import ExternalAccs.BankAccount;
import Funcs.HelperFunc;

import java.util.Random;
import java.util.Scanner;

public class API_BankMisr implements BanksAPIs_Account{
    @Override
    public BankAccount Connection() {

        BankAccount account = new BankAccount();
        account.gatherInfo("Misr bank");

        // some authentications and coding related to the bank
        //......... to get the account

        if(VerfiyCred(account))
            return account;
        return null;
    }

    @Override
    public boolean VerfiyCred(BankAccount account) {
        // depends on the bank and the data of the bank

        return true;
    }
}
