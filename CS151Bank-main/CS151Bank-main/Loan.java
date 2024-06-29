public abstract class Loan {
    protected double loanInterest;
    protected double loanAmount;
    protected double remaining;

    public Loan(double interest, double amount) 
    {
        loanInterest = interest;
        loanAmount = amount;
        remaining = 0;
    }

    public abstract void createLoan(Account account);

    public void paybackLoan(double amt) 
    {
        if (amt > 0 && amt <= remaining) 
        {
            this.remaining -= amt;
            System.out.println("$" + remaining + " left to pay");
        } 
        else 
        {
            System.out.println("Invalid payment amount.");
        }
    }

    public double getRemaining() 
    {
        return remaining;
    }

    public double getLoanAmount() 
    {
        return loanAmount;
    }
}