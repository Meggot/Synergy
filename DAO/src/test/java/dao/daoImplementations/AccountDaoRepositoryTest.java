package dao.daoImplementations;

import dbConfigurations.EmbeddedDatabaseConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
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