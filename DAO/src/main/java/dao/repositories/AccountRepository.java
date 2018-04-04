package dao.repositories;

import com.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

    Account getAccountById(Integer accountId);
    Account getAccountByEmail(String email);
}
