import java.util.*;
import java.io.*;
public class Main {
  //  ArrayList<Menu> menu_list;
   static Order odr =new Order();
  static Menu m = new Menu();
    static ArrayList<Menu> orders = new ArrayList<Menu>();
    public static void main(String[] args) {
        System.out.println("Welcome to my shop!");
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sr.nextLine();
        System.out.println("Enter your Address");
        String email = sr.nextLine();
        User user = new User(name,email);
        System.out.println("Welcome to my shop "+user.getName());
         run();
    }
    public static void run(){
       // Menu m = new Menu();
        Menu menu = new Menu("burger",21,35);
       Menu menu2 = new Menu("spaghetti",54,60);
        
        m.menu_list.add(menu);
        m.menu_list.add(menu2);
        m.menu2.add(menu2);
        m.menu2.add(menu);
        
        Scanner sr = new Scanner(System.in);
        System.out.println("1.Menu\n2.Add items to cart\n3.View Orders");
        try{
            
           ArrayList<Menu> displays = m.get_menu();
          int input = sr.nextInt();
            int z= 1;
            switch(input){
                case 1:
                for(Menu dis:displays){
                    dis.display_menu(dis,z++);
                    System.out.println("________");
                }
                  run();
                break;
                case 2:
                boolean exit = false;
                while(!exit){
                       odr.addToCart();
                       run(); 
                }
                
                break;
                case 3: odr.display_Orders();
                        run();  
                break;
                
        }
        }catch(InputMismatchException e){
            System.out.println("invalid input");
        }
    }
        
  /*  public static void addToCart(){
        System.out.println("Please select an order by their number:");
        Scanner sr = new Scanner(System.in);
        int input = sr.nextInt();
        System.out.println("Quantity");
        int qty = sr.nextInt();
        if(input >= 0 && input < menu_list.size()){
          
        }
        
        
    }*/
    public static void viewOrder(){
        for(Menu order: orders){
            System.out.println(order.displayOrders(order));
        }
    }
}



