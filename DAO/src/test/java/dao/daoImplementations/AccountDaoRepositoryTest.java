package dao.daoImplementations;

import dbConfigurations.EmbeddedDatabaseConfiguration;
import models.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EmbeddedDatabaseConfiguration.class)
public class AccountDaoRepositoryTest {

    @Autowired
    AccountDaoRepository accountDaoRepository;

    @Test
    public void getAccountById() throws Exception {
        assertNull(accountDaoRepository.getAccountById(0));
    }

    @Test
    public void getAccountWithEmail() throws Exception {
    }

    @Test
    public void createNewAccount() throws Exception {
    }

}