package dao.daoImplementations;

import com.models.entity.Account;
import com.models.entity.Password;
import dbConfigurations.EmbeddedDatabaseConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = EmbeddedDatabaseConfiguration.class)
@Rollback
@Transactional
public class AccountDaoRepositoryTest {

    @Autowired
    AccountDaoRepository accountDaoRepository;

    @Test
    public void getAccountById() throws Exception {
        //Weirdness here, transactional rollbacks dont wipe the sequential ids..
        accountDaoRepository.createNewAccount("Mikey", "foo2@foonet.com", new Password("sad","bilbo"));
        Account createdAccount = accountDaoRepository.getAccountByUsername("Mikey");
        assertThat(accountDaoRepository.getAccountById(createdAccount.getId())).isEqualTo(createdAccount);
    }

    @Test
    public void createNewAccount() throws Exception {
        assertThat(accountDaoRepository.getAccountByEmail("footest@foonet.com")).isNull();
        assertThat(accountDaoRepository.getAccountByUsername("Jimbob")).isNull();
        accountDaoRepository.createNewAccount("Jimbob", "footest@foonet.com", new Password("password2", "password"));
        assertThat(accountDaoRepository.getAccountByEmail("footest@foonet.com")).isNotNull();
        assertThat(accountDaoRepository.getAccountByUsername("Jimbob")).isNotNull();
    }

    @Test
    public void getAccountByUsername() throws Exception {
        assertThat(accountDaoRepository.getAccountByUsername("Sharkey")).isNull();
        accountDaoRepository.createNewAccount("Jimbob", "footest@foonet.com", new Password("password2", "password"));
        assertThat(accountDaoRepository.getAccountByUsername("Jimbob")).isNotNull();
    }

    @Test
    public void getAccountWithEmail() throws Exception {
        assertThat(accountDaoRepository.getAccountByEmail("footestnot@foonet.com")).isNull();
        accountDaoRepository.createNewAccount("Jimbob", "footest@foonet.com", new Password("password2", "password"));
        assertThat(accountDaoRepository.getAccountByEmail("footest@foonet.com")).isNotNull();
    }

    @Test
    public void update() throws Exception {
        String updateMeEmail = "Updater@Updation.net";
        String updatedEmail = "Updated@updated.net";
        accountDaoRepository.createNewAccount("UpdateMe", updateMeEmail, new Password("password", "salt"));
        Account updateMeAccount = accountDaoRepository.getAccountByUsername("UpdateMe");
        assertThat(updateMeAccount.getEmail()).isEqualTo(updateMeEmail);
        updateMeAccount.setEmail(updatedEmail);
        accountDaoRepository.updateAccount(updateMeAccount);
        updateMeAccount = accountDaoRepository.getAccountByUsername("UpdateMe");
        assertThat(updateMeAccount.getEmail()).isEqualTo(updatedEmail);

        Account nonExistingAccount = new Account("notExist", "notExit@sdads.com", new Password("231", "31"));
        assertThat(accountDaoRepository.getAccountByUsername("notExist")).isNull();
        accountDaoRepository.updateAccount(nonExistingAccount);
        assertThat(accountDaoRepository.getAccountByUsername("notExist")).isNull();
    }

}