package Integrations;

import ExternalAccs.BankAccount;

/**
 * Interface for bank API integrations.
 * Provides methods to simulate connecting to a bank account and verifying credentials.
 */
public interface BanksAPIs_Account {

    /**
     * Establishes a connection with the bank to gather and authenticate account information.
     *
     * @return A valid {@link BankAccount} object if connection and verification succeed; otherwise, {@code null}.
     */
    BankAccount Connection();

    /**
     * Verifies the provided bank account credentials.
     *
     * @param account The {@link BankAccount} to be verified.
     * @return {@code true} if the credentials are valid; {@code false} otherwise.
     */
    boolean VerfiyCred(BankAccount account);
}
