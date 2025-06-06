 import java.util.*;

public class Order{
   public static ArrayList<Integer> order= new ArrayList<Integer>();
    private int product;
    private int qty;
    static int qty2;
    static int input;
    static Menu mn = new Menu();
    Order(int product,int qty){
        this.product = product;
        this.qty = qty;
    }
    Order(){}
    public void setProduct(int p){
        this.product = p;
    }
    public void setQty(int p){
        this.qty = qty;
    }
  //  public Arraylist<Order>
    
    public int getProduct(){return product;}
    public int getQty(){return qty;}
      
    public void addToCart(){
        ArrayList<Menu> m = mn.get_menu2();
        System.out.println("Please select an order by their number:");
        Scanner sr = new Scanner(System.in);
        int input = sr.nextInt();
        order.add(input);
        System.out.println("Quantity");
         qty2 = sr.nextInt();
        order.add(qty);
        System.out.println("Do you still want to Order?\n1.Yes\n2.No");
       int again = sr.nextInt();
        if(again ==1){
            addToCart();
        }else{
            Main.run();
        }
        
    }
    public void display_Orders(){
        ArrayList<Menu> m = mn.get_menu2();
        for(Menu me:m){
            if(input>= 0 && input<m.size()){
                
                System.out.println(me.getProduct());
            }
           
        }
        
        
    }
}

/*
    public void display_Orders() {
        ArrayList<String> m = mn.get_menu2();
        if (orderList.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            System.out.println("Your Orders:");
            for (Order o : orderList) {
                int index = o.getProductIndex();
                if (index >= 0 && index < m.size()) {
                    String productName = m.get(index);
                    System.out.println("Product: " + productName);
                    System.out.println("Quantity: " + o.getQty());
                    System.out.println("________");
                } else {
                    System.out.println("Invalid product index in order.");
                }
            }
        }
    }
}*/