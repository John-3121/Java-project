import java.util.*;
public class Menu{
  static ArrayList<Menu> menu_list = new ArrayList<Menu>(); 
    static ArrayList<Menu> menu2 = new ArrayList<Menu>();
     private String product;
     private int qty;
     private int price;
   //  private int increment;
    public Menu(String product,int qty,int price){
        this.product = product;
        this.qty = qty;
        this.price = price;
      // menu_list.add(this);
        //increment = increment + 1;
    }
    Menu(){}
    public ArrayList<Menu> get_menu(){
        return menu_list;
    }
    public ArrayList<Menu> get_menu2(){
        return menu2;
    }
    
    public String getProduct(){return product;}
    public int getQty(){return qty;}
    public int getPrice(){return price;}
    public  String displayOrders(Menu order){
        return "order:"+ order.getProduct()+"\n"+"Quantity: ";
    }
    public void display_order(int input){
        System.out.println();
    }
    
    public void display_menu(Menu m,int z){
            System.out.println((z)+"."+"Food: "+ m.getProduct()+"\n" +"Quantity: "+ m.getQty() +"\n"+"Price: "+ m.getPrice());
        
        
    }
}