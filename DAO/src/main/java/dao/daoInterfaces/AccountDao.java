package dao.daoInterfaces;

import models.Account;
import models.Password;

public interface AccountDao {
    public Account getAccountById(Integer accountid);
    public Account getAccountWithEmail(String email);
    public void createNewAccount(String username, String email, Password password);
}
