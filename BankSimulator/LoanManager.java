public class LoanManager 
{
    public void createLoan(Loan loan, Account account) {
        loan.createLoan(account);
    }

    public void paybackLoan(Loan loan, double amount) {
        loan.paybackLoan(amount);
    }


}
