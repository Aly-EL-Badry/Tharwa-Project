package Panels;
import LogicBusiness.User;
import Funcs.HelperFunc;
import java.util.ArrayList;
import java.util.Arrays;

public class InvestDashBoardPanel implements Panel{
    private final User user ;

    @Override
    public void ViewMenu() {
        while (true) {

            System.out.println("        ##Asset Panel ##\n");

            String Menu = "1.add Asset\n2.Remove Asset\n3.ViewAssets\n4.EditAsset\n5.Go back\nEnter your choice :";
            ArrayList<String> choices = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
            String choice = HelperFunc.check_menu(Menu, choices);

            if (choice.equals("1"))
                addAsset();
            else if (choice.equals("2"))
                removeAsset();
            else if(choice.equals("3"))
                ViewAssets();
            else if(choice.equals("4"))
                EditAsset();
            else
                break;

        }


    }

    public InvestDashBoardPanel(User user){
        this.user=user;
    }

    public void addAsset (){

    }

    public void removeAsset(){

    }
    public void ViewAssets (){

    }

    public void EditAsset(){

    }

    public void Evaluate(){

    }
}
