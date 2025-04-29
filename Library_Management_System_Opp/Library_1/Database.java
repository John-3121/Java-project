package library;
import java.util.ArrayList;

public class Database {
    
    ArrayList<User> users = new ArrayList<User>();//this helps us holds different data types
    ArrayList<String> usernames = new ArrayList<String>();
    
    public void Adduser(User s){
       users.add(s);
        usernames.add(s.getName());
        
    }
    public int login(String phonenumber,String email){
        int n = -1;
        for(User s: users){
            if(s.getPhoneNumber().matches(phonenumber) && s.getmail().matches(email)){
                n = users.indexOf(s);
                break;
                
            }
        }
        return n;
    }
    public User getUser(int n){  //get the user info
        return users.get(n);
    }
    
   
}
