public class SmallLoan extends Loan {
    public SmallLoan() 
    {
        super(1.1, 1000);
    }

    @Override
    public void createLoan(Account account) {
        if (remaining == 0) 
        {
            remaining = loanInterest * loanAmount;
            System.out.println("Small loan taken.");
        } 
        else 
        {
            System.out.println("Pay off your current loan first.");
        }
    }
}