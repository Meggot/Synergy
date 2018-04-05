package dao.daoImplementations;

import dao.daoInterfaces.AccountDao;
import com.models.entity.Account;
import com.models.entity.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import dao.repositories.AccountRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class AccountDaoRepository implements AccountDao {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account getAccountById(final Integer accountid) {
        return accountRepository.getAccountById(accountid);
    }

    @Override
    public Account getAccountByEmail(final String email) {
        return accountRepository.getAccountByEmail(email);
    }

    @Override
    public Account getAccountByUsername(final String username) {
        return accountRepository.getAccountByUsername(username);
    }

    @Override
    public void updateAccount(final Account updatedAccount) {
        Account account = accountRepository.getAccountById(updatedAccount.getId()) ;
        if (account!=null){
            accountRepository.save(updatedAccount);
        }
    }

    @Override
    public void createNewAccount(String username, String email, Password password) {
        accountRepository.save(new Account(username, email, password));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostConstruct
    void init() {

    }
}