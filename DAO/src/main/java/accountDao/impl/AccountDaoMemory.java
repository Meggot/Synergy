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
    private Map<Integer, Account> accountMap;

    public AccountDaoMemory() {
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<Account>(accountMap.values());
    }

    @Override
    public Optional<Account> getAccountById(Integer accountId) {
        return Optional.ofNullable(accountMap.get(accountId));
    }

    @Override
    public void addAccount(Account account) {
        accountMap.put(account.getId(), account);
    }

    public void setAccountMap(Map<Integer, Account> accountMap) {
        this.accountMap = accountMap;
    }
}
