package Integrations;

import ExternalAccs.BankAccount;
import Funcs.HelperFunc;

import java.util.Random;
import java.util.Scanner;

/**
 * Represents an integration with HSBC Bank's system.
 * Implements the {@link BanksAPIs_Account} interface to simulate connection and verification processes.
 */
public class API_HSBC implements BanksAPIs_Account {

    /**
     * Simulates a connection to HSBC Bank by gathering account information from the user.
     * If the credentials are valid (as per the simulation), a {@link BankAccount} is returned.
     *
     * @return A valid {@code BankAccount} if verification passes; otherwise, {@code null}.
     */
    @Override
    public BankAccount Connection() {
        BankAccount account = new BankAccount();
        account.gatherInfo("HSBC bank");

        // Simulated authentication and internal bank handling

        if (VerfiyCred(account))
            return account;
        return null;
    }

    /**
     * Simulates the verification of bank account credentials for HSBC.
     * This implementation always returns {@code false}, indicating verification failure.
     *
     * @param account The {@link BankAccount} to verify.
     * @return {@code false} to simulate failure in verification.
     */
    @Override
    public boolean VerfiyCred(BankAccount account) {
        // Simulation: credentials are always considered invalid for HSBC
        return false;
    }
}
