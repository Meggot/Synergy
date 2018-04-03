package accountDao.interfaces;

import models.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by bradleyw on 24/03/2018.
 */
@Component
public interface AccountDaoInterface {
    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Integer accountId);
    void addAccount(Account newAccount);
}
