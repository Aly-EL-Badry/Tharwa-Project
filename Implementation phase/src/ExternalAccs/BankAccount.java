package ExternalAccs;

public class BankAccount {
    private final int OTP , CVV ;
    private final String  cardNumber, cardHolderName , expiryDate;

    public BankAccount(int OTP , int CVV , String cardNumber , String cardHolderName , String expiryDate ){
         this.OTP=OTP;
         this.CVV=CVV;
         this.cardHolderName=cardHolderName;
         this.cardNumber=cardNumber;
         this.expiryDate=expiryDate;
    }
}
