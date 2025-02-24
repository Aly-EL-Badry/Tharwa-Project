package ContactsPackage;

import java.util.Objects;

public class contact {

    private final String name , phoneNum , email;

    public String getName(){
        return name;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public String getEmail(){
        return email;
    }

    contact(String name , String phoneNum , String email){
        this.name=name;
        this.phoneNum=phoneNum;
        this.email=email;
    }

    public String tostring(){
        return "Name : "+name+" Phone number : "+phoneNum+" Email : "+email;
    }

    @Override
    public boolean equals(Object obj){

        if(this==obj)
            return true;
        if(obj==null||getClass()!=obj.getClass())
            return false;
        contact Contact = (contact) obj;

        return Objects.equals(name,((contact) obj).name)
             &&Objects.equals(email,((contact) obj).email)
             &&Objects.equals(phoneNum,((contact) obj).phoneNum);

    }

}
