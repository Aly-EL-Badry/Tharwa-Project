package Repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BankRepo {
    private ArrayList<String> banks;
    public BankRepo(){
        banks= new ArrayList<>();
        try (BufferedReader reader = new BufferedReader( new FileReader("src/Repo/Banks"))){
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
