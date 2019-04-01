import java.util.ArrayList;

/**

 * Write a description of class Bank here.

 * 

 * @author (your name) 

 * @version (a version number or a date)

 */

public class Bank

{
    private String bankName;
    private int numEmployees;
    private ArrayList<BankAccount> accounts;

    public Bank( String name, int emp )
    {
        bankName = name;
        numEmployees = emp;
        accounts = new ArrayList<BankAccount>();
    }

    public String getName()
    {
        return bankName;
    }

    public int getNumberOfEmployees()
    {
        return numEmployees;
    }

    public ArrayList<BankAccount> getAccounts()
    {
        return accounts;
    }

    public void addAccount( BankAccount b )
    {
        accounts.add(b);
    }
    
    public void updateAccounts( BankAccount[] arr )
    {
        accounts = new ArrayList <BankAccount>();
        for( int i = 0; i < arr.length; i++)
        {
            accounts.add(arr[i]);
        }
    }
    
    public String toString()
    {
        String s = "";
        s += "BankName=" + bankName + "\n";
        s += "NumberofEmployees=" + numEmployees + "\n";
        for( BankAccount ba : accounts )
        {
            if( ba instanceof SavingsAccount )
            {
                s += "SavingsAccount=" + ba.getName() + "\n";
                s += "AccountNumber=" + ba.getAccountNumber() + "\n";
                s += "Balance=" + ba.getBalance() + "\n";
                s += "Rate=" + ((SavingsAccount)ba).getRate() + "\n";
            }
            else
            {
                s += "BankAccount=" + ba.getName() + "\n";
                s += "AccountNumber=" + ba.getAccountNumber() + "\n";
                s += "Balance=" + ba.getBalance() + "\n";
            }
        }
        return s.trim();
    }

}