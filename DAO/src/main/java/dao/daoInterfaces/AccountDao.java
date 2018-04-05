package dao.daoInterfaces;

import com.models.entity.Account;
import com.models.entity.Password;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    public Account getAccountById(Integer accountid) throws SQLException;
    public Account getAccountByEmail(String email) throws SQLException;
    public Account getAccountByUsername(String username) throws SQLException;
    public void updateAccount(Account updatedAccount) throws SQLException;
    public void createNewAccount(String username, String email, Password password) throws SQLException;
    public List<Account> getAllAccounts();
}
