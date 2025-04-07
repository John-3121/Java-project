import java.util.Scanner;

class atmmachine{
    public static void main(String[] args) {
        double balance = 575.00;
        boolean loop = true;
        Scanner user = new Scanner(System.in);
        
        String[] prints = {"1.Balance","2.Deposit","3.Widthraw","4.Exit"};

        for(int i = 0; i<= 3; i++){
            System.out.println(prints[i]);

        }
        while(loop){
          System.out.println("Enter a valid number");
          int userIn = user.nextInt();
          switch(userIn){
            case 1:
            System.out.println("Your current balancee is"+ balance +"$");
            break;
            
            case 2:
            int deposit = user.nextInt();
            balance += deposit;
            System.out.println("Your current balance is now" +  balance + "$");
            break;

            case 3 :
            int withraw = user.nextInt();
            balance -=  withraw;
            System.out.println("Your current balance is now" + balance + "$");
            break;

            case 4 : 
               loop = false;
               System.out.println("Thank you for coming");
               
            
            

          }
        }
        
        
       
    }
}