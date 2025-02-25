import ContactsPackage.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {

    static private boolean isSaved=false;
    static private boolean isFirst=true;
    private  ContactManager manager;
    private String NameOfFile;



    private  String check_menu( String menuText , ArrayList<String> choices){

        String currentAnswer;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println(menuText);
            currentAnswer=in.nextLine();
            if(currentAnswer.length() != 1 || !choices.contains(currentAnswer))
                System.out.println("Please Enter a valid option");
            else
                break;
        }


        return currentAnswer;
    }



    public  boolean MainMenu(){

        Scanner in = new Scanner(System.in);

        if (isFirst)
            manager=new ContactManager();


        ArrayList<String> choices=new ArrayList<String>(Arrays.asList("1","2","3","4","5","6"));
        String choice=check_menu("Choose from the following : \n\n1.Add a new contact\n2.Delete a contact\n3.Search for a contact\n4.View all contacts\n5.Save contacts in a file\n6.Exit\n\nEnter your answer : ",choices );


        if(choice.equals("1")){//Add

            boolean isRepeated=manager.Add();
            if(!isRepeated)
                System.out.println("Sorry , it will not be added for repeating phone number or email");
            else
                isSaved=false;

        }
        else if( choice.equals("2")){//Delete

            if(manager.Delete())
                isSaved=false;

        }
        else if( choice.equals("3")){//search for (by name , number)

            ArrayList<String> Choices=new ArrayList<String>(Arrays.asList("1","2"));
            String Choice =check_menu("you want to search by:\n1.phone number\n2.name\n\nEnter your choice : ",Choices);


            // by phone number
            if(Choice.equals("1")) {
                contact person = manager.Search(true);
                if(person!=null)
                    System.out.println(person.tostring());
                else
                    System.out.printf("Sorry the contact is not found\n\n");

            }
            else { // by name
                contact person = manager.Search(false);
                if(person!=null)
                    System.out.println(person.tostring());
                else
                    System.out.printf("Sorry the contact is not found\n\n");

            }



        }
        else if( choice.equals("4")){//view all contacts

           manager.Display();

        }
        else if( choice.equals("5")){//Save contacts in file

            if(!isSaved)
                manager.Save();

            isSaved=true;

        }else{//Exit

            if(!isSaved){// for saving option

                ArrayList<String>Choices=new ArrayList<String>(Arrays.asList("1","2"));
                String Choice=check_menu("Do you want to save changes before exiting?\n1.Yes\n2.No\n\nEnter your choice : ",Choices);

                if(Choice.equals("1"))// as task 5
                     manager.Save();

            }

            return false;
        }



        isFirst=false;
        return true;

    }
}
