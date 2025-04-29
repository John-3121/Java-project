package library;

abstract public class User {
    
    protected String name;
    protected String email;
    protected String phonenumber;
    
    public User(String name ){
        this.name = name;
    }
    public User(String name,String email,String phonenumber){
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }//setter
    public String getName(){//getters
        return name;
    }
    public String getmail(){
        return email;
    }
    public String getPhoneNumber(){
        return phonenumber;
    }
    
    abstract public void menu();
    
}