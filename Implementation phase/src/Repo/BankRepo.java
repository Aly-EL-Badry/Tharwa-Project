package Repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BankRepo {
    private ArrayList<String> banks;
    public BankRepo(){
        try (BufferedReader reader = new BufferedReader( new FileReader("Repo/Banks"))){
            String line = reader.readLine();
            while (line!=null){
                banks.add(line);
                line= reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getBanks() {
        return banks;
    }
}
