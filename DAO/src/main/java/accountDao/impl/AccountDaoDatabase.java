package accountDao.impl;

import accountDao.interfaces.AccountDaoInterface;
import models.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by bradleyw on 24/03/2018.
 */
@Component
@Profile("default")
public class AccountDaoDatabase implements AccountDaoInterface {

    @Autowired
    @Qualifier("dataSource")
    private DataSource datasource;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Account> getAllAccounts() {
        JdbcTemplate template = new JdbcTemplate(datasource);
        final List<Map<String, Object>> result = template.queryForList("SELECT * FROM ACCOUNTS");
        System.out.println(result);
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
