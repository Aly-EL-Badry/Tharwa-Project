package Repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * BankRepo is responsible for loading and managing the list of bank names
 * stored in a file. It reads the bank names from the specified file
 * and provides methods to retrieve the list of banks.
 */
public class BankRepo {

    private ArrayList<String> banks;

    /**
     * Constructor that initializes the BankRepo by reading bank names
     * from a file located at "src/Repo/Banks".
     * The bank names are read line by line and stored in an ArrayList.
     *
     * @throws RuntimeException if there is an issue reading the file.
     */
    public BankRepo() {
        banks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Repo/Banks"))) {
            String line = reader.readLine();
            while (line != null) {
                banks.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the list of bank names that were loaded from the file.
     *
     * @return an ArrayList containing the names of banks.
     */
    public ArrayList<String> getBanks() {
        return banks;
    }
}
