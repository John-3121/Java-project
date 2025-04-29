package library;
import java.util.Scanner;



public class Main {
    static Database database;
    static Scanner s;
    static Main m;
    
    public static void main(String[] args) {
        System.out.println("Welcome To Library Management System");
        database = new Database();
        
        int num;
        do{
           System.out.println("0.Exit\n1.Login\n2.New user");
        s = new Scanner(System.in);
        num = s.nextInt();
        
        switch(num){
            case 1: login();
            case 2: newuser();
            
        } 
        }while(num != 0);
        
        
        
    }
    private static void login(){
            System.out.println("Enter phone number");
            String phonenumber = s.next();
            System.out.println("Enter email");
            String email = s.next();
            int n = database.login(phonenumber,email);//get the position of thr user in arrayList
            if(n != -1){
                User user = database.getUser(n);
                user.menu();
                
            }else{
                System.out.println("User doesn't exist!!");
            }
            
        }
        
        
        private static void newuser(){
            System.out.println("Enter name");
            String name = s.next();
            System.out.println("Enter phone number");
            String phonenumber = s.next();
            System.out.println("Enter email");
            String email = s.next();
            System.out.println("1.Admin\n2.Newuser");
            int n2 = s.nextInt();
            User user;
            if(n2 == 1){
                user = new Admin(name,email,phonenumber);
            }else{
                user = new Newuser(name,email,phonenumber);
                
            }
            database.Adduser(user);//store the new user to the arraylist of users
            user.menu();//show the menu of admin or normaluser
            System.out.println("User account created sucessfully");
            
        }
    
    
}
