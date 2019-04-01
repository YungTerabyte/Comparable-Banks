
/**
 * Write a description of class Compare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Compare
{

    public static int compare( BankAccount b1, BankAccount b2 )

    {

        if( b1.getName().equals( b2.getName() ) )

        {

            if( b1.getBalance() == b2.getBalance() ) // sort by account number

            {

                return b1.getAccountNumber() - b2.getAccountNumber();

            }

            else // sort by account balance

            {

                if( b1.getBalance() < b2.getBalance() )

                {

                    return -1;

                }

                else if( b1.getBalance() > b2.getBalance() )

                {

                    return 1;

                }

                else

                    return 0;

            }

        }

        else // sort by account name

        {

            return b1.getName().compareTo( b2.getName() );

        }

    }



    public static int compareAccNum( BankAccount b1, BankAccount b2 )

    {

        return b1.getAccountNumber() - b2.getAccountNumber();

    }


    public static int compareAccType( BankAccount b1, BankAccount b2 )
    {
        if( b1 instanceof SavingsAccount && !(b2 instanceof SavingsAccount) )
        {
            return -1;
        }
        else if ( b2 instanceof SavingsAccount && !(b1 instanceof SavingsAccount) )
        {
            return 1;
        }
        else
        {
            if( b1.getBalance() < b2.getBalance() )
            {
                return 1;
            }
            else if ( b1.getBalance() > b2.getBalance() )
            {
                return -1;
            }
            else // balances of each account are the same
            {
                if( b1 instanceof SavingsAccount && b2 instanceof SavingsAccount )
                {
                    SavingsAccount a1 = (SavingsAccount)b1;
                    SavingsAccount a2 = (SavingsAccount)b2;
                    
                    if( a1.getRate() < a2.getRate() )
                    {
                        return 1;
                    }
                    else if( a1.getRate() > a2.getRate() )
                    {
                        return -1;
                    }
                    else
                    {
                        return 0;
                    }
                }
                else
                    return 0;
            }
        }
    }
}


