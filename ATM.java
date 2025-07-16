import java.util.*;

public class ATM {
    
    // @SuppressWarnings("unused")
    static ArrayList<Integer> denominations = new ArrayList<>(Arrays.asList(2,5,10,20,50,100,500,1000));
    static Map<Integer,Integer> DenominationMap = new HashMap<>();
    // @SuppressWarnings("FieldMayBeFinal")
    static {
        DenominationMap.put(2,200);
        DenominationMap.put(5,200);
        DenominationMap.put(10,100);
        DenominationMap.put(20,100);
        DenominationMap.put(50,100);
        DenominationMap.put(100,100);
        DenominationMap.put(500,100);
        DenominationMap.put(1000,100);
    }
    static Map<Integer,Customer> CustomerMap;

    public ATM()
    {
        CustomerMap = new HashMap<>();
    }
    
    public void add_Customer(Customer cust)
    {
        CustomerMap.put(cust.get_customerId(),cust);
        System.out.println("Account created successfully for:"+cust.getCustomerName());
    }
    
    public Customer get_CustomerDetails(int custID,int pinNo)
    {
     Customer cust = CustomerMap.getOrDefault(custID, null);
     if(cust == null)
     {
       return null;
     }
     return (cust.authenicate(pinNo)?(cust):(null));
    }
    
    public String withDrawCash(int custID,int pinNo,int Amount)
    {
       Customer cust = get_CustomerDetails(custID, pinNo);
       
       if(cust == null)
       {
       return "Invalid Customer ID or Invalid PinNumber";
       }

       if(cust.check_balance()<Amount)
       {
        return "Insufficient funds to withdraw";
       }

       else if(Amount<=0)
       {
        return "Enter a Valid Amount to WithDraw";
       }

       int Atm_Balance=0;

       for(Map.Entry<Integer,Integer> entry:DenominationMap.entrySet())
       {
        int denomination = entry.getKey();
        int coins = entry.getValue();
        
        if(coins>0)
        {
         Atm_Balance+=(denomination*coins);
        //  System.out.println(Atm_Balance);
        }
       
        }

       if(Amount>Atm_Balance)
       {
        return "Insufficient funds to withdraw";
       }

       Stack<int[]> requiredAmount = new Stack<>();
       cust.remainingBalance -= Amount;

       for(int i=denominations.size()-1;i>=0;i--)
       {
          if(Amount == 0)
          {
            break;
          }
          int denomination = denominations.get(i);
          if((Amount>2000 && Amount<5000) && (denomination == 1000))
          {
               if(DenominationMap.get(1000)>0)
               {
                  DenominationMap.put(1000,DenominationMap.get(1000)-1);
                  requiredAmount.push(new int[] {1000,1});
                  Amount -= (1000*1);
               }
            }
            else
            {
                if(DenominationMap.get(denomination)>0)
                {
                    int neededAmount = Amount/denomination;
                    int available_Amount = Math.min(neededAmount,DenominationMap.get(denomination));
                    DenominationMap.computeIfPresent(denomination,(k,v) -> (v-available_Amount));
                    requiredAmount.push(new int[] {denomination,available_Amount});
                    Amount -= (denomination*available_Amount);
                }
            }
        }
       if(Amount>0)
       {
        System.out.println("3");
        return "Insufficient Funds to Withdraw";
       }
       cust.transactionCount += 1;
       String transHistory = "Withdrawal from Account_No:"+cust.get_AccountNo()+" Account_type:"+cust.account_type+" Remaining_Balance:"+cust.check_balance();
       cust.transaction_history.add(transHistory);

       for(int[] amount:requiredAmount)
       {
         String denom = String.valueOf(amount[0]);
         String coins = String.valueOf(amount[1]);
         System.out.println(denom+'*'+coins);
       }
       return "Withdraw Successfull for AccountNo:"+cust.get_AccountNo();
    }

    public String depositCash(int custID,int pinNo,String[] amount_with_Denomination)
    {
        Customer cust = get_CustomerDetails(custID, pinNo);
        
        if(cust ==  null)
        {
            return "Invalid Customer Id or Invalid Pin Number";
        }
        int total_Amount = 0;
        
        for(int i=0;i<amount_with_Denomination.length;i+=2)
        {
            Integer Denomination = Integer.valueOf(amount_with_Denomination[i]);
            Integer coins = Integer.valueOf(amount_with_Denomination[i+1]);
            DenominationMap.computeIfPresent(Denomination, (k,v) -> (v + (Denomination * coins)));
            total_Amount += (Denomination*coins);
        }
        cust.remainingBalance += total_Amount;
        cust.transactionCount += 1;
        String transHistory = "Deposited Amount:"+total_Amount+" for Account_No"+cust.get_AccountNo()+" Account_type:"+cust.account_type+" Balance:"+cust.check_balance();
        cust.transaction_history.add(transHistory);
        
        return "Amount Deposited:"+total_Amount+" for Account_No:"+cust.get_AccountNo()+" New_Balance_Amount:"+cust.check_balance();
    }
}