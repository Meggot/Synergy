package accountDao;

import models.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by bradleyw on 24/03/2018.
 */
@Component(value="accountDao")
@Profile("default")
public class AccountDaoDatabase implements AccountDaoInterface {

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    @Override
    public Optional<Account> getAccountById(Long accountId) {
        return null;
    }

    @Override
    public void addAccount(Account newAccount) {

    }
}
