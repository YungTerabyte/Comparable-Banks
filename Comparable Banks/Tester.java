import java.util.*;
import java.io.*;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args) throws IOException
    {
        String[] lines = ReadFromFile.ReadFile("E:/Comparable/Project/Bank of OSSM.txt");
        String bankName = lines[0].substring( lines[0].indexOf("=") + 1, lines[0].length());
        int numEmployees = Integer.parseInt(lines[1].substring(lines[1].indexOf("=") + 1, lines[1].length()));
        Bank myBank = new Bank(bankName, numEmployees);

        int i = 2;
        while( i <= lines.length - 1)
        {
            if(lines[i].contains("SavingsAccount"))
            {
                String name = lines[i].substring( lines[i].indexOf("=") + 1, lines[i].length());
                double balance = Double.parseDouble(lines[i + 2].substring(lines[i + 2].indexOf("=") + 1, lines[i + 2].length()));
                double rate = Double.parseDouble(lines[i + 3].substring(lines[i + 3].indexOf("=") + 1, lines[i + 3].length()));
                myBank.addAccount(new SavingsAccount(name, balance, rate));
                i += 4;
            }
            else
            {
                String name = lines[i].substring( lines[i].indexOf("=") + 1, lines[i].length());
                double balance = Double.parseDouble(lines[i + 2].substring(lines[i + 2].indexOf("=") + 1, lines[i + 2].length()));
                myBank.addAccount(new BankAccount(name,balance));
                i += 3;
            }

        }

        Scanner sc = new Scanner(System.in);
        int rand = 0;
        while(rand == 0)
        {
            System.out.print("Type in the name of the bank account owner, or if wish to exit, type exit: ");
            String name = sc.next();
            if(name.compareTo( "exit" ) == 0)
            {
                break;
            }
            System.out.print("Enter the intial balance for the bank account: ");
            double bal = sc.nextDouble();
            System.out.print("Is this a savings account? ");
            if(sc.next().compareTo("yes") == 0)
            {
                System.out.print("Enter rate for the savings account: ");
                double rate = sc.nextDouble();
                myBank.addAccount(new SavingsAccount(name,bal,rate));
                
            }
            else
            {
                myBank.addAccount(new BankAccount(name,bal));
                
            }

        }

        System.out.println("How would you like to sort your bank accounts? (a, b, or c)");
        System.out.println("a. Ascending sort by account number");
        System.out.println("b. Ascending sort by account name");
        System.out.println("c. Sort by account type");
        String sort = sc.next();
        
        BankAccount[] arr = new BankAccount[myBank.getAccounts().size()];
        BankAccount[] ba = myBank.getAccounts().toArray(arr) ;
        
        if( sort.compareTo( "a" ) == 0)
        {
            ba = sortNum(ba);
        }
        else if( sort.compareTo( "b" ) == 0)
        {
            ba = sortName(ba);
        }
        else if( sort.compareTo( "c" ) == 0)
        {
            ba = sortAccType(ba);
        }
        
        myBank.updateAccounts(ba);
        
        FileWriter fw = new FileWriter("E:/Comparable/Project/SortedBank.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        String s = myBank.toString();
        Scanner sca = new Scanner(s);
        while(sca.hasNext())
        {
            pw.println(sca.nextLine());
        }
        
        pw.close();
        fw.close();
    }
    
        public static BankAccount[] sortNum( BankAccount a[] )

    {

        for( int i = 0; i < a.length; i++ )

        {

            BankAccount min = a[i];

            int minIndex = i;



            for( int j = i + 1; j < a.length; j++ )

            {

                if( Compare.compareAccNum( min, a[j] ) > 0 )

                {

                    min = a[j];

                    minIndex = j;

                }

            }



            // swap values here

            a[minIndex] = a[i];

            a[i] = min;

        }
        
        return a;
    }
    
        public static BankAccount[] sortName( BankAccount a[] )

    {

        for( int i = 0; i < a.length; i++ )

        {

            BankAccount min = a[i];

            int minIndex = i;



            for( int j = i + 1; j < a.length; j++ )

            {

                if( Compare.compare( min, a[j] ) > 0)

                {

                    min = a[j];

                    minIndex = j;

                }

            }



            // swap values here

            a[minIndex] = a[i];

            a[i] = min;

        }
        
        return a;
    }
    
        public static BankAccount[] sortAccType( BankAccount a[] )

    {

        for( int i = 0; i < a.length; i++ )

        {

            BankAccount min = a[i];

            int minIndex = i;



            for( int j = i + 1; j < a.length; j++ )

            {

                if( Compare.compareAccType(min, a[j]) > 0 )

                {

                    min = a[j];

                    minIndex = j;

                }

            }



            // swap values here

            a[minIndex] = a[i];

            a[i] = min;

        }
        
        return a;
    }
}

