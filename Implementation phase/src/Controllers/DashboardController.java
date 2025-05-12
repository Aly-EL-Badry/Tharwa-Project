package Controllers;
import Funcs.HelperFunc;
import LogicBusiness.User;
import Panels.IntegerationPanel;
import Panels.InvestDashBoardPanel;
import Panels.Panel;
import Panels.ZaketPanel;


import java.util.ArrayList;
import java.util.Arrays;


public class DashboardController {
    private User user;
    private Panel panel;
    private void viewMenu (){

        System.out.println("                   ##Welcome ya investor "+user.getName()+"##\n\n");
       while(true){

           System.out.println("         ##MAIN PANEL##\n");
           String text ="Choose from the following" +
                   " which panel you want : \n\n"+"1.Invest panel" +
                   "\n2.Integration panel\n3.Zaket panel\n4.Exit\n\n"+
                   "Enter your choice : ";
           ArrayList<String> choices = new ArrayList<>(Arrays.asList("1","2","3","4"));
           String choice = HelperFunc.check_menu(text,choices);
           if(choice.equals("1"))
               panel= new InvestDashBoardPanel(user);
           else if(choice.equals("2"))
               panel =new IntegerationPanel(user);
           else if(choice.equals("3"))
               panel =new ZaketPanel (user);
           else {
               System.out.println("Now You are logged out !!");
               break;
           }

           panel.ViewMenu();

       }
    }
    DashboardController(User user){
        this.user=user;
        viewMenu();
    }
}
