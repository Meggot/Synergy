package dao.daoInterfaces;

import com.models.Account;
import com.models.Password;

import java.util.List;

public interface AccountDao {
    public Account getAccountById(Integer accountid);
    public Account getAccountWithEmail(String email);
    public void createNewAccount(String username, String email, Password password);
    public List<Account> getAllAccounts();
}
