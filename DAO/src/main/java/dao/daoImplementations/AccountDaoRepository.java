package dao.daoImplementations;

import dao.daoInterfaces.AccountDao;
import models.Account;
import models.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.AccountRepository;

@Component
public class AccountDaoRepository implements AccountDao {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account getAccountById(final Integer accountid) {
        return accountRepository.getAccountById(accountid);
    }

    @Override
    public Account getAccountWithEmail(final String email) {
        return accountRepository.getAccountByEmail(email);
    }

    @Override
    public void createNewAccount(String username, String email, Password password) {
        accountRepository.save(new Account(username, email, password));
    }


}
