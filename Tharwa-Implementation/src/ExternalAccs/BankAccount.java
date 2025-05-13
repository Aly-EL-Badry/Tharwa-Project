package ExternalAccs;

import Funcs.HelperFunc;

import java.util.Scanner;

public class BankAccount {
    private int OTP , CVV ;
    private String  cardNumber, cardHolderName , expiryDate;
    private String bankName;

    public int getOTP() {
        return OTP;
    }

    public int getCVV() {
        return CVV;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getBankName() {
        return bankName;
    }

    public BankAccount(){

    }

    public BankAccount(String BankName, String CardNumber, String CardHolderName , String expiryDate, int otp, int cvv){

        this.bankName=BankName;
        this.cardNumber = CardNumber;
        this.cardHolderName = CardHolderName;
        this.expiryDate = expiryDate;
        this.OTP = otp;
        this.CVV = cvv;

    }

    public void gatherInfo (String bankName){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your CVV number : ");
        String cvv = in.next();
        while(!HelperFunc.isNum(cvv)||cvv.length()>4||cvv.length()<3) {
            System.out.println("Pls enter a valid cvv num");
            System.out.print("Enter your CVV number : ");
            cvv=in.next();
        }
        CVV=Integer.parseInt(cvv);

        System.out.print("Enter your card number : ");
        String cardNum = in.next();
        String regex = "^\\d{4}-\\d{4}-\\d{4}-\\d{4}$";
        while(!cardNum.matches(regex)) {
            System.out.println("Pls enter a valid card num !!");
            System.out.print("Enter your card number : ");
            cardNum=in.next();
        }
        cardNumber=cardNum;

        System.out.print("Enter your expiry date !!\n");


        System.out.print("Enter the day :");
        String day = in.next();
        while(!HelperFunc.isNum(day )|| (Integer.parseInt(day)>31||Integer.parseInt(day)<1)){
            System.out.println("Please enter a valid day !!");
            System.out.print("Enter the day :");
            day=in.next();
        }

        System.out.print("Enter the month :");
        String month = in.next();
        while(!HelperFunc.isNum(month )|| (Integer.parseInt(month)>12||Integer.parseInt(month)<1)){
            System.out.println("Please enter a valid month !!");
            System.out.print("Enter the month :");
            month=in.next();
        }
        System.out.print("Enter the year :");
        String year = in.next();
        while(!HelperFunc.isNum(year )|| (Integer.parseInt(year)<2025)){
            System.out.println("Please enter a valid year !!");
            System.out.print("Enter the year :");
            year=in.next();
        }
         expiryDate  = day+'-'+month+'-'+year;

        System.out.print("Enter the card Holder name : ");
        cardHolderName="";
        cardHolderName=HelperFunc.getNonEmptyInput(cardHolderName);

        System.out.print("Enter your OTP : ");
        String otp = in.next();
        while(!HelperFunc.isNum(otp)||otp.length()!=6) {
            System.out.println("Pls enter a valid OTP num !!");
            System.out.print("Enter your OTP : ");
            otp=in.next();
        }
        OTP=Integer.parseInt(otp);
        this.bankName=bankName;
    }
}
