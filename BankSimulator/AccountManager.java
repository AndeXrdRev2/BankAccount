import java.util.ArrayList;

public class AccountManager {
    ArrayList<Account> accounts = new ArrayList<Account>();

    public void createAccount(String user, String pass, int num)
    {
        accounts.add(new Account(user,pass,num));
    }

    public Account findAccount(String user, String pass, int iDNum) {
        for (Account account : accounts) {
            if (account.getID() == iDNum && account.getUser().equals(user) && account.getPass().equals(pass)) {
                return account;
            }
        }
        return null; 
    }

}
