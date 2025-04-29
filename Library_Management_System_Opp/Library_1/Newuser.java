package library;

public class Newuser extends User{
    public Newuser(String name){
        super(name);
    }
    public Newuser(String name,String email,String phonenumber){
        super(name,email,phonenumber);
    }
    @Override
    public void menu(){
        System.out.println("1.View books");
        System.out.println("2.Search");
        System.out.println("3.Place order");
        System.out.println("4.Borrow book");
        System.out.println("5.Calculate fine");
        System.out.println("6.return book");
        System.out.println("7.Exit");
        System.out.println("--------");
        
    }
    
    
    
    
    
}