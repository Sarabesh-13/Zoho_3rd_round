import java.util.*;

public class Customer
{
    static int id = 0;
    String name;
    @SuppressWarnings("FieldMayBeFinal")
    private int pinNo;
    int remainingBalance;
    int customerId = 0;
    int account_no = 0;
    int transactionCount;
    String account_type;
    List<String> transaction_history;

    public Customer(String customer_name,int pin,int Balance)
    {
        this.name = customer_name;
        this.pinNo = pin;
        this.remainingBalance = Balance;
        id=id+1;
        this.customerId = id;
        this.account_no = id;
        this.account_type = "Savings";
        this.transactionCount = 0;
        this.transaction_history = new ArrayList<>();
    }

    public boolean authenicate(int pin)
    {
        return pinNo == pin;
    }

    public int check_balance()
    {
        return remainingBalance;
    }

    @Override
    public String toString()
    {
     return "Name:"+name+"\n"+"CustomerID:"+customerId+"\n"+"Account_Type:"+account_type+"\n"+"Account_number:"+account_no+"\n"+"PinNumber:"+pinNo+"\n"+"Account_balance:"+remainingBalance;
    }

    public void show_transaction_history()
    {
        for(String history:transaction_history)
        {
            System.out.println(history);
        }
    }

    public int get_AccountNo()
    {
      return account_no;
    }
    
    public int get_customerId()
    {
        return customerId;
    }

    public void get_transactionCount()
    {
        System.out.println("Transaction Count:"+transactionCount);
    }

    public String getCustomerName()
    {
        return name;
    }
}