public class MediumLoan extends Loan {
    public MediumLoan() 
    {
        super(1.2, 10000);
    }

    @Override
    public void createLoan(Account account) {
        if (remaining == 0) 
        {
            remaining = loanInterest * loanAmount;
            System.out.println("Medium loan taken.");
        } 
        else 
        {
            System.out.println("Pay off your current loan first.");
        }
    }
}