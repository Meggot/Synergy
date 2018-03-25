package accountDao;

import models.Account;

import java.util.List;
import java.util.Optional;

/**
 * Created by bradleyw on 24/03/2018.
 */
public interface AccountDaoInterface {
    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Long accountId);
    void addAccount(Account newAccount);
}
