package ContactsPackage;


import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;


import java.nio.file.*;
import java.io.*;


public class ContactManager {

    private ArrayList<contact>Contacts;
    private String File;

    //Validation codes for data and files

    private String validNum(String num){

        Scanner in =new Scanner(System.in) ;
        String NumberRegex = "^(01\\d{9}|\\d{5})$";

        while (!num.matches(NumberRegex)){
            System.out.print("Please enter correct format of phone number : ");
            num= in.nextLine();
        }
        return num;

    }

    private String validName(String name){

        Scanner in =new Scanner(System.in) ;
        String NameRegex ="^[A-Za-z -]+$";


        while (name.trim().isEmpty()||!name.matches(NameRegex)){
            System.out.print("Please Enter a valid name : ");
            name= in.nextLine();
        }
        return name;

    }

    private String validEmail(String email){

        Scanner in = new Scanner(System.in);

        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        while (!email.matches(emailPattern)){
            System.out.print("Please enter correct email : ");
            email= in.nextLine();
        }
        return email;

    }

    private boolean ValidationData(String txt , int stage){

        String regex ;

        if(stage==1)
             regex = "^(01\\d{9}|\\d{5})$";
        else if (stage==2)
            regex ="^[A-Za-z -]+$";
        else
            regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        return txt.matches(regex);

    }


    // Loading at the begining of the program the file
    private boolean LoadData(){

        //String NameOfFile =FileManagement();

        Scanner in = new Scanner(System.in);

        System.out.println("Please Enter the file name : ");
        String NameOfFile = in.nextLine();
        Path path = Paths.get(NameOfFile);


        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            System.out.println("File does not exist or is not a valid file.");
            return false;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(NameOfFile))) {


            String line;
            line=reader.readLine();

            File=NameOfFile;

            if(line==null)
                return true;

            Contacts=new ArrayList<>();

            while (line!=null){

                String name="" , phone="" , email="";
                StringBuilder transition= new StringBuilder();

                boolean needAppend=true;

                for (int index = 0, order=0; index < line.length(); index++) {

                    char c = line.charAt(index);
                    if(c==','){
                        order++;

                        if (order==1)
                            name=transition.toString();
                        else if (order==2)
                            phone=transition.toString();
                        else
                            email= transition.toString();

                        transition.setLength(0);
                        needAppend=false;

                    }else {
                        transition.append(c);
                        needAppend=true;
                    }
                }


                if(name.isEmpty()&&needAppend)
                    name=transition.toString();
                else if(phone.isEmpty()&&needAppend)
                    phone=transition.toString();
                else if(needAppend)
                    email= transition.toString();



                if(!ValidationData(email,3)||!ValidationData(name,2)||!ValidationData(phone,1)) {
                    Contacts.clear();
                    return false;
                }
                contact Contact=new contact(name,phone,email);
                Contacts.add(Contact);
                line=reader.readLine();
            }


        }catch (IOException e){
            System.out.println("Error!!\n\n");
        }
        return true;

    }



    public ContactManager(){

        while (!LoadData())
            System.out.println("File contains wrong data or not exist try again!!!");

    }


    //Functionalities of the program
    public boolean Add (){

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the name : ");
        String name= in.nextLine();
        name=validName(name);

        System.out.print("Please enter the phone number : ");
        String num= in.nextLine();
        num=validNum(num);


        System.out.printf("Please enter the email : ");
        String email= in.nextLine();
        email=validEmail(email);



        if(!Contacts.isEmpty()) {

            for (contact Contact : Contacts)

                if (Contact.getEmail().equals(email)
                        || Contact.getPhoneNum().equals(num)
                        || Contact.getName().equals(name))

                    return false;
        }


        Contacts.add(new contact(name,num,email));
        return true;


    }

    public void Display(){

        if(Contacts.isEmpty()) {

            System.out.println("The file is empty\n\n");
            return;
        }
        for (int Contact = 0; Contact < Contacts.size(); Contact++) {
            contact person = Contacts.get(Contact);// same object
            System.out.println((Contact+1)+" . "+person.tostring());
        }
    }

    public contact Search( boolean isNum){

        Scanner in = new Scanner(System.in);


        if(!isNum){

            System.out.print("Please Enter the name : ");
            String name=in.nextLine();
            name=validName(name);

            for (int Contact = 0; Contact < Contacts.size() ; Contact++) {

                contact person = Contacts.get(Contact);
                if(person.getName().equals(name))
                    return person;

            }
        }else{
            System.out.printf("Please Enter the Phone number : ");
            String name=in.nextLine();
            name=validNum(name);

            for (int Contact = 0; Contact < Contacts.size() ; Contact++) {

                contact person = Contacts.get(Contact);
                if(person.getPhoneNum().equals(name))
                    return person;

            }

        }


        return null;

    }

    public boolean Delete(){

        if(Contacts.isEmpty()) {
            System.out.println("the contact file is empty!\n\n");
            return false;
        }

        contact person =Search(true);
        if(person!=null) {
            System.out.println("Deleting is done!\n\n");
            Contacts.remove(person);
        }else {
            System.out.println("The contact is not found \n\n");
            return false;
        }
        return true;

    }

    public void Save(){

        try( FileWriter writer = new FileWriter(File)) {


            for (int contacts = 0; contacts < Contacts.size(); contacts++) {

                String Line;

                String name = Contacts.get(contacts).getName();
                String phone = Contacts.get(contacts).getPhoneNum();
                String email = Contacts.get(contacts).getEmail();

                Line=name+","+phone+","+email+"\n";
                writer.write(Line);
            }

            //writer.close();

        } catch (Exception e) {
            System.out.println("will not happen");
        }
    }



}
