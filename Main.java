import java.util.*;

public class Main 
{
    public static void main(String[] args) {
        
    Customer cust1 = new Customer("Varun",1562,87456);
    Customer cust2 = new Customer("Ram",6666,56870);
    Customer cust3 = new Customer("Sarabesh", 1210, 48350);
    Customer cust4 = new Customer("Sanjay", 4512, 64520);

    ATM atm = new ATM();

    atm.add_Customer(cust1);
    atm.add_Customer(cust2);
    atm.add_Customer(cust3);
    atm.add_Customer(cust4);
    
    try(Scanner sc = new Scanner(System.in))
    {
        boolean loop = true;
        System.out.println("Welcome to ATM");
        while(loop)
        {
            System.out.println("Enter Customer Number");
            int cust_id = sc.nextInt();
            System.out.println("Enter your pinNumber");
            int PinNumber = sc.nextInt();
            Customer cust = atm.get_CustomerDetails(cust_id, PinNumber);
            if(cust == null)
            {
                System.out.println("Invalid CustomerId or Invalid PinNumber");
                // loop = false;
                return;
            }
            System.out.println("Choose any one choice");
            System.out.println(
                """
                               1.WithDraw
                               2.Deposit
                               3.Check Balance
                               4.Customer_Details
                               5.Transaction_History
                               6.exit
                """
            );
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1 ->
                {
                    System.out.println("Enter the Amount to Withdraw");
                    int amount = sc.nextInt();
                    System.out.println(atm.withDrawCash(cust_id, PinNumber, amount));
                }
                case 2 ->
                {
                    System.out.println("Enter the Amount to Deposit with Denominations");
                    //500 10 200 20 -> (denomination , coins)
                    sc.nextLine();
                    String[] Denomination_with_Amount = sc.nextLine().split("\\s");
                    // String[] Denomination_with_Amount = denwithAmount.split("");
                    System.out.println(atm.depositCash(cust_id, PinNumber, Denomination_with_Amount));
                }
                case 3 ->
                {
                    System.out.println(cust.check_balance());
                }
                case 4 ->
                {
                    System.out.println(cust);
                }
                case 5 ->
                {
                    cust.show_transaction_history();
                }
                case 6 ->
                {
                    loop = false;
                }
                default ->
                {

                }
            }
        }
    }
  }
}