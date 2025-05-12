package Integrations;

import ExternalAccs.BankAccount;
import Funcs.HelperFunc;

import java.util.Random;
import java.util.Scanner;

public class API_AhlyBank implements BanksAPIs_Account{
    @Override
    public BankAccount Connection() {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter your CVV number : ");
        String cvv = in.next();
        while(!HelperFunc.isNum(cvv)||cvv.length()>4||cvv.length()<3) {
            System.out.println("Pls enter a valid num");
            cvv=in.next();
        }

        System.out.print("Enter your card number : ");
        String cardNum = in.next();
        while(!HelperFunc.isNum(cardNum)||cardNum.length()!=16) {
            System.out.println("Pls enter a valid num");
            cardNum=in.next();
        }

        System.out.print("Enter your expiry date : ");
        String ExpiryDate = in.next();

        System.out.print("Enter your OTP : ");
        String OTP = in.next();
        while(!HelperFunc.isNum(OTP)||OTP.length()!=6) {
            System.out.println("Pls enter a valid num");
            OTP=in.next();
        }

        BankAccount acc

    }

    @Override
    public boolean VerfiyCred(BankAccount account) {
        // depends on the bank and the data of the bank
        Random random = new Random();
        return random.nextBoolean();
    }
}
