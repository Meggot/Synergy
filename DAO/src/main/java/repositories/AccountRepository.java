package repositories;

import models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer>{

    Account getAccountById(Integer accountId);
    Account getAccountByEmail(String email);
}
