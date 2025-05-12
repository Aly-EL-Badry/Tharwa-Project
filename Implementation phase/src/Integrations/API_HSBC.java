package Integrations;

import ExternalAccs.BankAccount;

import java.util.Random;

public class API_HSBC implements BanksAPIs_Account{

    @Override
    public BankAccount Connection() {

    }

    @Override
    public boolean VerfiyCred(BankAccount account) {
        // depends on the bank and the data of the bank
        Random random = new Random();
        return random.nextBoolean();
    }
}
