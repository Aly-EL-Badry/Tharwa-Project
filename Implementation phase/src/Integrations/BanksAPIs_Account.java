package Integrations;

import ExternalAccs.BankAccount;

public interface BanksAPIs_Account {
    public BankAccount Connection();
    boolean VerfiyCred (BankAccount account);
}
