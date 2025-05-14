package ExternalAccs;

import Funcs.HelperFunc;

import java.util.Scanner;

/**
 * Represents a bank account associated with a card, containing information
 * such as card number, holder name, expiry date, CVV, OTP, and bank name.
 */
public class BankAccount {
    private int OTP, CVV;
    private String cardNumber, cardHolderName, expiryDate;
    private String bankName;

    /**
     * Gets the OTP (One-Time Password) associated with the account.
     *
     * @return the OTP as an integer
     */
    public int getOTP() {
        return OTP;
    }

    /**
     * Gets the CVV (Card Verification Value) of the card.
     *
     * @return the CVV as an integer
     */
    public int getCVV() {
        return CVV;
    }

    /**
     * Gets the card number.
     *
     * @return the card number as a string
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Gets the card holder's name.
     *
     * @return the name of the card holder
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Gets the expiry date of the card.
     *
     * @return the expiry date in the format day-month-year
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Gets the name of the bank.
     *
     * @return the bank name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Default constructor for BankAccount.
     */
    public BankAccount() {
    }

    /**
     * Constructs a BankAccount with full card and bank details.
     *
     * @param BankName        the name of the bank
     * @param CardNumber      the card number in string format
     * @param CardHolderName  the full name of the cardholder
     * @param expiryDate      the expiry date in format day-month-year
     * @param otp             the OTP (6-digit code)
     * @param cvv             the CVV (3- or 4-digit code)
     */
    public BankAccount(String BankName, String CardNumber, String CardHolderName, String expiryDate, int otp, int cvv) {
        this.bankName = BankName;
        this.cardNumber = CardNumber;
        this.cardHolderName = CardHolderName;
        this.expiryDate = expiryDate;
        this.OTP = otp;
        this.CVV = cvv;
    }

    /**
     * Gathers bank account information interactively from the user via the console.
     * Validates CVV, card number, expiry date (day, month, year), cardholder name, and OTP.
     *
     * @param bankName the name of the bank associated with the card
     */
    public void gatherInfo(String bankName) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your CVV number : ");
        String cvv = in.next();
        while (!HelperFunc.isNum(cvv) || cvv.length() > 4 || cvv.length() < 3) {
            System.out.println("Pls enter a valid cvv num");
            System.out.print("Enter your CVV number : ");
            cvv = in.next();
        }
        CVV = Integer.parseInt(cvv);

        System.out.print("Enter your card number : ");
        String cardNum = in.next();
        String regex = "^\\d{4}-\\d{4}-\\d{4}-\\d{4}$";
        while (!cardNum.matches(regex)) {
            System.out.println("Pls enter a valid card num !!");
            System.out.print("Enter your card number : ");
            cardNum = in.next();
        }
        cardNumber = cardNum;

        System.out.print("Enter your expiry date !!\n");

        System.out.print("Enter the day :");
        String day = in.next();
        while (!HelperFunc.isNum(day) || (Integer.parseInt(day) > 31 || Integer.parseInt(day) < 1)) {
            System.out.println("Please enter a valid day !!");
            System.out.print("Enter the day :");
            day = in.next();
        }

        System.out.print("Enter the month :");
        String month = in.next();
        while (!HelperFunc.isNum(month) || (Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1)) {
            System.out.println("Please enter a valid month !!");
            System.out.print("Enter the month :");
            month = in.next();
        }

        System.out.print("Enter the year :");
        String year = in.next();
        while (!HelperFunc.isNum(year) || (Integer.parseInt(year) < 2025)) {
            System.out.println("Please enter a valid year !!");
            System.out.print("Enter the year :");
            year = in.next();
        }
        expiryDate = day + '-' + month + '-' + year;

        System.out.print("Enter the card Holder name : ");
        cardHolderName = "";
        cardHolderName = HelperFunc.getNonEmptyInput(cardHolderName);

        System.out.print("Enter your OTP : ");
        String otp = in.next();
        while (!HelperFunc.isNum(otp) || otp.length() != 6) {
            System.out.println("Pls enter a valid OTP num !!");
            System.out.print("Enter your OTP : ");
            otp = in.next();
        }
        OTP = Integer.parseInt(otp);
        this.bankName = bankName;
    }
}
