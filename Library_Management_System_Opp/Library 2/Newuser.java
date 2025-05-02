package library;
import java.util.Scanner;

public class Newuser extends User{
    public Newuser(String name){
        super(name);
        this.operations = new IOOperation[]{
            new ViewBooks(),
            new Search(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit()
            
        };
    }
    public Newuser(String name,String email,String phonenumber){
        super(name,email,phonenumber);
        this.operations = new IOOperation[]{
            new ViewBooks(),
            new Search(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit()
            
        };
    }
    @Override
    public void menu(Database database,User user){
        System.out.println("1.View books");
        System.out.println("2.Search");
        System.out.println("3.Place order");
        System.out.println("4.Borrow book");
        System.out.println("5.Calculate fine");
        System.out.println("6.Return book");
        System.out.println("7.Exit");
        System.out.println("--------");
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database,user);
        s.close();
        
        
    }
    
    
    
    
    
}