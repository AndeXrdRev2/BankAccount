import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

public class Login
{
    public static void main(String args[])
    {
        //Account management
        AccountManager manager = new AccountManager();
        Account currAccount;

        //User input + random 
        Scanner scanner = new Scanner(System.in);
        RandomGenerator rand = new Random();
        int upperBound = 10000;
        int lowerBound = 1000;

        //Keep track of user's status
        String userStatus;
        String accountAction;
        String bankAction;
        String loanAction;
        boolean loggedIn = false;

        //Account creation variables
        String username;
        String password;
        int accountNum;
        float bankAmt;

        System.out.println("Please log in or sign up. Type \"Login\",\"Sign up\", or \"Stop\" ");
        userStatus = scanner.nextLine();
        while (true) //Loop for user input to eventually work
        {
            if(userStatus.equals("Login")) //Login and Bank User
            {
                System.out.println("Log in:");
                System.out.println("Enter username:");
                username = scanner.nextLine();
                System.out.println("Enter password:");
                password = scanner.nextLine();
                System.out.println("Enter account ID:");
                accountNum = scanner.nextInt();
                scanner.nextLine();

                currAccount = manager.findAccount(username, password, accountNum);
                if (currAccount == null)
                {
                    System.out.println("Account does not exist.");
                    System.out.println("Please log in or sign up. Type \"Login\",\"Sign up\", or \"Stop\" ");
                    userStatus = scanner.nextLine();
                }
                else
                {
                    loggedIn = true;
                }

                while (loggedIn == true) //User is logged in
                {
                    System.out.println("You are logged in. Type \"Bank Account\", \"Loan\", \"Log out\"");
                    accountAction = scanner.nextLine();
                    if (accountAction.equals("Bank Account"))//User doing bank actions
                    {
                        System.out.printf("You currently have $%.2f", currAccount.getBalance());
                        System.out.println();
                        System.out.println("Choose \"Deposit\", \"Withdraw\", \"Return\"");
                        bankAction = scanner.nextLine();
                        if (bankAction.equals("Deposit")) //User chooses to Deposit
                        {
                            System.out.println("Enter deposit amount: ");
                            bankAmt = scanner.nextFloat();
                            scanner.nextLine();
                            currAccount.deposit(bankAmt);
                        }
                        else if (bankAction.equals("Withdraw"))// User chooses to withdraw
                        {
                            System.out.println("Enter withdrawal amount: ");
                            bankAmt = scanner.nextFloat();
                            scanner.nextLine();
                            currAccount.withdraw(bankAmt);
                        }
                        else if (bankAction.equals("Return")) //User wants to return to menu
                        {
                            System.out.println("Returning to menu.");
                        }
                        else
                        {
                            System.out.println("Invalid choice.");
                        }
                    }
                    else if (accountAction.equals("Loan"))//User takes out a loan
                    {
                        System.out.printf("You currently have $%.2f", currAccount.getBalance());
                        System.out.println();
                        System.out.println("Will you take a loan or pay one off? Enter \"Small\", \"Medium\", \"Large\", \"Payoff\", \"Return\"");
                        loanAction = scanner.nextLine();
                        if(loanAction.equals("Small")) //User takes a small loan
                        {
                            currAccount.takeSmallLoan();
                        }
                        else if (loanAction.equals("Medium")) //User takes a medium loan
                        {
                            currAccount.takeMediumLoan();
                        }
                        else if (loanAction.equals("Large")) //User takes a large loan
                        {
                            currAccount.takeLargeLoan();
                        }
                        else if (loanAction.equals("Payoff")) //User tries to off a loan
                        {
                            if (currAccount.currLoan != null)
                            {
                                System.out.printf("How much will you pay off? You have $%.2f left.", currAccount.currLoan.getRemaining());
                                System.out.println();
                                bankAmt = scanner.nextFloat();
                                scanner.nextLine();
                                currAccount.payoffLoan(bankAmt);
                            }
                            else
                            {
                                System.out.println("You do not have a loan!");
                            }
                            
                        }
                        else if (loanAction.equals("Return")) //User wants to return to menu
                        {
                            System.out.println("Returning to menu.");
                        }
                        else
                        {
                            System.out.println("Invalid choice.");
                        }
                    }
                    else if (accountAction.equals("Log out"))//User wants to log out
                    {
                        System.out.println("Please log in or sign up. Type \"Login\",\"Sign up\", or \"Stop\" ");
                        userStatus = scanner.nextLine();
                        loggedIn = false;
                    }
                    else
                    {
                        System.out.println("Invalid choice.");
                    }
                }

            }
            else if (userStatus.equals("Sign up"))//Create account for account manager
            {
                System.out.println("Create username:");
                username = scanner.nextLine();
                System.out.println("Create password:");
                password = scanner.nextLine();
                accountNum = rand.nextInt(upperBound-lowerBound) + lowerBound;

                manager.createAccount(username, password, accountNum);
                System.out.println("Account created! Your account ID is " + accountNum);
                userStatus = "Login";
            }
            else if (userStatus.equals("Stop"))//Stop program 
            {
                break;
            }
            else
            {
                System.out.println("Returning to menu. Please log in or sign up. Type \"Login\",\"Sign up\", or \"Stop\" ");
                userStatus = scanner.nextLine();
            }
        }
        scanner.close();
    }
}
