package library;
import java.util.Scanner;

public class Admin extends User{
    
    public Admin(String name){
        super(name);
        this.operations = new IOOperation[]{//Array
            new ViewBooks(),
            new AddBook(),
            new DeleteBook(),
            new Search(),
            new DeleteAllData(),
            new ViewOrders(),
            new Exit()
        };
        
    };
    public Admin(String name,String email,String phonenumber){
        super(name,email,phonenumber);
        this.operations = new IOOperation[]{//Array
            new ViewBooks(),
            new AddBook(),
            new DeleteBook(),
            new Search(),
            new DeleteAllData(),
            new ViewOrders(),
            new Exit()
        };
        
    };
    @Override
    public void menu(Database database,User user){
        System.out.println("1.View books");
        System.out.println("2.Add book");
        System.out.println("3.Delete book");
        System.out.println("4.Search");
        System.out.println("5.Delete all data");
        System.out.println("6.View orders");
        System.out.println("7.Exit"); 
        System.out.println("--------");
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database,user);
        s.close();
        
            
        
    };
    
}