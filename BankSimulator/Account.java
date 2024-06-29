public class Account
{
    String username;
    String password;
    int ID;
    float balance;

    private LoanManager loanManager;
    Loan currLoan;

    public Account(String user, String pass, int idNumber)
    {
        username = user;
        password = pass;
        ID = idNumber;
        balance = 0;
        loanManager = new LoanManager();
    }

    public String getUser()
    {
        return this.username;
    }

    public void setUser(String user)
    {
        this.username = user;
    }

    public String getPass()
    {
        return this.password;
    }

    public void setPass(String pass)
    {
        this.password = pass;
    }

    public int getID()
    {
        return this.ID;
    }

    public float getBalance()
    {
        return this.balance;
    }

    public void deposit(float amount)
    {
        if (amount >= 0)
        {
            balance += amount;
            System.out.printf("Deposited $%.2f",amount);
            System.out.println();
            System.out.printf("Your balance is now $%.2f",balance);
            System.out.println();
        }
        else
        {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(float amount)
    {
        if (amount >= 0 && amount <= balance)
        {
            balance -= amount;
            System.out.printf("Withdrew $%.2f", amount);
            System.out.println();
            System.out.printf("Your balance is now $%.2f",balance);
            System.out.println();
        }
        else
        {
            System.out.println("Invalid amount");
        }
    }

    public void takeSmallLoan()
    {
        if (currLoan == null)
        {
            loanManager.createLoan(currLoan = new SmallLoan(),this);
            deposit((float)currLoan.getLoanAmount());
        }
        else
        {
            System.out.println("Pay off your current loan first.");
        }
    }

    public void takeMediumLoan()
    {
        if (currLoan == null)
        {
            loanManager.createLoan(currLoan = new MediumLoan(),this);
            deposit((float)currLoan.getLoanAmount());
        }
        else
        {
            System.out.println("Pay off your current loan first.");
        }
    }

    public void takeLargeLoan()
    {
        if (currLoan == null)
        {
            loanManager.createLoan(currLoan = new LargeLoan(),this);
            deposit((float)currLoan.getLoanAmount());
        }
        else
        {
            System.out.println("Pay off your current loan first.");
        }
    }

    public void payoffLoan(double amount)
    {
        if (currLoan != null)
        {
            if (amount <= balance)
            {
                loanManager.paybackLoan(currLoan, amount);
                withdraw((float) amount);
            }
            else
            {
                System.out.println("You can't pay all that off!");
            }
            
            if(currLoan.getRemaining() == 0)
            {
                System.out.println("You've paid off your loan!");
                currLoan = null;
            }
        }
        else
        {
            System.out.println("You do not currently have a loan");
        }
        
    }
    
}