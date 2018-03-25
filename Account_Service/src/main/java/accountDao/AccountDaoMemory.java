package accountDao;

import models.Account;

import java.util.*;

/**
 * Created by bradleyw on 24/03/2018.
 * This is for testing purposes without spinning up a test db
 */
public class AccountDaoMemory implements AccountDaoInterface {
    private Map<Long, Account> accountMap;

    public AccountDaoMemory() {
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
