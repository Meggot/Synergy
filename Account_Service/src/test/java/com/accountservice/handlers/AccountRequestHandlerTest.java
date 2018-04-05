package com.accountservice.handlers;


import com.models.ResponseMessages;
import com.models.entity.Account;
import com.models.entity.Password;
import dao.daoImplementations.AccountDaoMemory;
import com.handlers.AccountRequestHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.requests.CreateAccountRequest;
import com.responses.CreateAccountResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bradleyw on 24/03/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountRequestHandlerTest {

    //  MODEL
    private AccountRequestHandler accountRequestHandler = new AccountRequestHandler();

    // TESTING DAO
    private AccountDaoMemory accountDao = new AccountDaoMemory();

    //ModelAccountsInDB
    private Set<Account> modelAccountsInDB = new HashSet<Account>() {{
        add(new Account("Test1", "Test1@net.com", new Password("pas", "salt")));
        add(new Account("Test2", "Test2@net.com", new Password("pas2", "salt2")));
    }};

    @Before
    public void init() {
        accountDao.setAccounts(modelAccountsInDB);
        accountRequestHandler.setAccountDao(accountDao);
    }

    @Test
    public void handleCreateNewAccount() {
        CreateAccountRequest validCreateRequest = new CreateAccountRequest("Test3", "Test3@Email.com", "testpassword", "testsalt");
        CreateAccountResponse validCreateResponse = accountRequestHandler.handleCreateAccountRequest(validCreateRequest);
        assertThat(validCreateResponse.getMessage()).isEqualTo(ResponseMessages.VALID_ACCOUNT_CREATION);
        assertThat(validCreateResponse.isAccepted()).isTrue();

        CreateAccountRequest duplicateUsernameRequest = new CreateAccountRequest("Test1", "Test4@Email.com", "pass", "this");
        CreateAccountResponse duplicateUsernameResponse  = accountRequestHandler.handleCreateAccountRequest(duplicateUsernameRequest);
        assertThat(duplicateUsernameResponse.getMessage()).isEqualTo(ResponseMessages.DUPLICATE_USERNAME);
        assertThat(duplicateUsernameResponse.isAccepted()).isFalse();

        CreateAccountRequest duplicateEmailRequest = new CreateAccountRequest("Test4", "Test1@net.com", "password", "salt");
        CreateAccountResponse duplicateEmailResponse = accountRequestHandler.handleCreateAccountRequest(duplicateEmailRequest);
        assertThat(duplicateEmailResponse.getMessage()).isEqualTo(ResponseMessages.DUPLICATE_EMAIL);
        assertThat(duplicateEmailResponse.isAccepted()).isFalse();
    }
}
