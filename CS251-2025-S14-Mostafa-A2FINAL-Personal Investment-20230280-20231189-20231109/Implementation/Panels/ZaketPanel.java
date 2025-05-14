package Panels;

import Funcs.HelperFunc;
import LogicBusiness.Asset;
import LogicBusiness.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * ZaketPanel is responsible for managing the Zakat-related operations
 * and providing the user interface for zakat calculation, halal investments,
 * and tax complaint handling.
 * It implements the {@link Panel} interface.
 */
public class ZaketPanel implements Panel {

    private final User user;

    /**
     * Constructor to initialize the ZaketPanel with a specific user.
     *
     * @param user the user for whom the Zakat panel will be managed.
     */
    public ZaketPanel(User user) {
        this.user = user;
    }

    /**
     * Displays the menu options for the Zaket panel and handles user input
     * to navigate through the options.
     * It allows the user to calculate zakat, view halal investments, or submit tax complaints.
     */
    @Override
    public void ViewMenu() {
        label:
        while (true) {
            System.out.println("# === Zaket Panel === #");

            String Menu = "1.Zakat Calculation\n2.Halal investment Screen\n3.Tax Complaint\n4.Go back\nEnter your choice :";
            ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
            String choice = HelperFunc.check_menu(Menu, choices);

            switch (choice) {
                case "1":
                    zakatCalculation();
                    break;
                case "2":
                    HalalInvestment();
                    break;
                case "3":
                    TaxComplaintsRepo();
                    break;
                default:
                    break label;
            }
        }
    }

    /**
     * Calculates and displays the zakat based on the user's assets.
     * It checks if the user's total wealth exceeds the minimum zakat threshold
     * and computes the zakat based on 2.5% of the total wealth.
     */
    public void zakatCalculation() {
        final double MINIMUM_VALUE_FOR_ZAKET = 7246;
        final double ZAKAH_PRECENTAGE = 2.5 / 100;
        double TotalWealth = 0, Zakah;

        Vector<Asset> userAssets = user.getAssets();

        for (Asset asset : userAssets) {
            TotalWealth += asset.getQuantity() * asset.getPurchasePrice();
        }

        Zakah = TotalWealth * ZAKAH_PRECENTAGE;

        if (TotalWealth < MINIMUM_VALUE_FOR_ZAKET) {
            System.out.println("You don't have to pay Zakat");
        } else {
            System.out.println("Your total wealth is " + TotalWealth);
            System.out.println("So your Zakah is " + Zakah);
        }
    }

    /**
     * Displays information about halal investment options.
     * This function is currently a placeholder for halal investment information.
     */
    public void HalalInvestment() {
        System.out.println("Halal Investment");
    }

    /**
     * Displays information for submitting tax complaints.
     * This function is currently a placeholder for tax complaints handling.
     */
    public void TaxComplaintsRepo() {
        System.out.println("Tax Complaints");
    }
}
