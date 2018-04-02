package accountDao.impl;

import accountDao.interfaces.AccountDaoInterface;
import models.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by bradleyw on 24/03/2018.
 * This is for testing purposes without spinning up a test db
 */
@Component
@Profile("test")
public class AccountDaoMemory implements AccountDaoInterface {
    private Map<Long, Account> accountMap;

    public AccountDaoMemory() {
        setAccountMap(new HashMap<Long, Account>() {{
            put(1L, new Account(1L, "Meggot", "Meggot@username.com"));
            put(2L, new Account(2L, "Sharkbait", "Sharkbait@username.com"));
            put(3L, new Account(3L, "Poza", "Poza@username.com"));
            put(4L, new Account(4L, "Zolu", "Zolu@username.com"));
            put(5L, new Account(5L, "Sciatican", "Sciatican@username.com"));
        }});
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<Account>(accountMap.values());
    }

    @Override
    public Optional<Account> getAccountById(Long accountId) {
        return Optional.ofNullable(accountMap.get(accountId));
    }

    @Override
    public void addAccount(Account account) {
        accountMap.put(account.getId(), account);
    }

    public void setAccountMap(Map<Long, Account> accountMap) {
        this.accountMap = accountMap;
    }
}
