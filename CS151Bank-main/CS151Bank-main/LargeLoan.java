public class LargeLoan extends Loan {
    public LargeLoan() 
    {
        super(1.5, 50000);
    }

    @Override
    public void createLoan(Account account) {
        if (remaining == 0) 
        {
            remaining = loanInterest * loanAmount;
            System.out.println("Large loan taken.");
        } 
        else 
        {
            System.out.println("Pay off your current loan first.");
        }
    }
}