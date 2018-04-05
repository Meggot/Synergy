package dao.daoImplementations;

import com.models.entity.Account;
import com.models.entity.Password;
import dao.daoInterfaces.AccountDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AccountDaoMemory implements AccountDao{

    private Set<Account> accounts;

    private int lastId = 0;

    public AccountDaoMemory() {
    }

    @Override
    public Account getAccountById(final Integer accountid) {
        return getAccounts().stream()
                .filter(account -> account.getId() == accountid)
                .findAny().orElse(null);
    }

    @Override
    public Account getAccountByEmail(final String email) {
        return getAccounts().stream()
                .filter(account -> account.getEmail().equals(email))
                .findAny().orElse(null);
    }

    @Override
    public Account getAccountByUsername(final String username) {
        return getAccounts().stream()
                .filter(account -> account.getUsername().equals(username))
                .findAny().orElse(null);
    }

    @Override
    public void updateAccount(final Account updatedAccount) {
        Account account = getAccountById(updatedAccount.getId());
        getAccounts().remove(account);
        getAccounts().add(updatedAccount);
    }

    @Override
    public void createNewAccount(final String username, final String email, final Password password) {
        Account account = new Account(username, email, password);
        account.setId(lastId++);
        getAccounts().add(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(getAccounts());
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
