package com.accountservice.handlers;


import com.handlers.util.DateFormatPassing;
import com.models.ResponseMessages;
import com.models.entity.Account;
import com.models.entity.Password;
import com.requests.UpdateAccountRequest;
import com.responses.UpdateAccountResponse;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        Account account1 = new Account("Test1", "Test1@net.com", new Password("pas", "salt"));
        account1.setId(1);
        add(account1);
        Account account2 = new Account("Test2", "Test2@net.com", new Password("pas2", "salt2"));
        account2.setId(2);
        add(account2);
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
        CreateAccountResponse duplicateUsernameResponse = accountRequestHandler.handleCreateAccountRequest(duplicateUsernameRequest);
        assertThat(duplicateUsernameResponse.getMessage()).isEqualTo(ResponseMessages.DUPLICATE_USERNAME);
        assertThat(duplicateUsernameResponse.isAccepted()).isFalse();

        CreateAccountRequest duplicateEmailRequest = new CreateAccountRequest("Test4", "Test1@net.com", "password", "salt");
        CreateAccountResponse duplicateEmailResponse = accountRequestHandler.handleCreateAccountRequest(duplicateEmailRequest);
        assertThat(duplicateEmailResponse.getMessage()).isEqualTo(ResponseMessages.DUPLICATE_EMAIL);
        assertThat(duplicateEmailResponse.isAccepted()).isFalse();
    }

    @Test
    public void handleUpdateAccount() throws Exception {
        UpdateAccountRequest validUpdateRequest = new UpdateAccountRequest(1, "Testudo", "Test1@net.com", null);
        UpdateAccountResponse validUpdateResponse = accountRequestHandler.handleUpdateAccountRequest(validUpdateRequest);
        assertThat(validUpdateResponse.getMessage()).isEqualTo(ResponseMessages.VALID_ACCOUNT_UPDATE);
        assertThat(validUpdateResponse.isAccepted()).isTrue();
        assertThat(validUpdateResponse.getUpdatedFields()).contains("Username");
        assertThat(accountDao.getAccountById(1).getUsername()).isEqualTo("Testudo");

        UpdateAccountRequest validDobUpdate = new UpdateAccountRequest(1, "Testudo", "Test1@net.com", "12/01/95");
        UpdateAccountResponse validDobResponse = accountRequestHandler.handleUpdateAccountRequest(validDobUpdate);
        assertThat(validDobResponse.getMessage()).isEqualTo(ResponseMessages.VALID_ACCOUNT_UPDATE);
        assertThat(validDobResponse.isAccepted()).isTrue();
        assertThat(validDobResponse.getUpdatedFields()).contains("DOB");
        assertThat(accountDao.getAccountById(1).getDateOfBirth()).isEqualTo(DateFormatPassing.getDobFromString("12/01/95"));

        UpdateAccountRequest validEmailUpdateRequest = new UpdateAccountRequest(1, "Testudo", "Test6@net.com", null);
        UpdateAccountResponse validEmailUpdateResponse = accountRequestHandler.handleUpdateAccountRequest(validEmailUpdateRequest);
        assertThat(validEmailUpdateResponse.getMessage()).isEqualTo(ResponseMessages.VALID_ACCOUNT_UPDATE);
        assertThat(validEmailUpdateResponse.isAccepted()).isTrue();
        assertThat(validEmailUpdateResponse.getUpdatedFields()).contains("Email");
        assertThat(accountDao.getAccountById(1).getEmail()).isEqualTo("Test6@net.com");

        UpdateAccountRequest invalidUserIdRequest = new UpdateAccountRequest(12, "Test2", "Test1@net.com", null);
        UpdateAccountResponse invalidUserIdResponse = accountRequestHandler.handleUpdateAccountRequest(invalidUserIdRequest);
        assertThat(invalidUserIdResponse.getMessage()).isEqualTo(ResponseMessages.USER_ID_INVALID);
        assertThat(invalidUserIdResponse.isAccepted()).isFalse();

        UpdateAccountRequest duplicateUsernameRequest = new UpdateAccountRequest(1, "Test2", "Test1@net.com", null);
        UpdateAccountResponse duplicateUsernameResponse = accountRequestHandler.handleUpdateAccountRequest(duplicateUsernameRequest);
        assertThat(duplicateUsernameResponse.getMessage()).isEqualTo(ResponseMessages.DUPLICATE_USERNAME);
        assertThat(duplicateUsernameResponse.isAccepted()).isFalse();

        UpdateAccountRequest duplicateEmailRequest = new UpdateAccountRequest(1, "Testudo", "Test2@net.com", null);
        UpdateAccountResponse duplicateEmailResponse = accountRequestHandler.handleUpdateAccountRequest(duplicateEmailRequest);
        assertThat(duplicateEmailResponse.getMessage()).isEqualTo(ResponseMessages.DUPLICATE_EMAIL);
        assertThat(duplicateEmailResponse.isAccepted()).isFalse();

        UpdateAccountRequest invalidDobFormatRequest = new UpdateAccountRequest(1, "Testudo", "Test1@net.com", "1212/04/1995");
        UpdateAccountResponse invalidDobFormatResponse = accountRequestHandler.handleUpdateAccountRequest(invalidDobFormatRequest);
        assertThat(invalidDobFormatResponse.getMessage()).isEqualTo(ResponseMessages.INVALID_DATE_OF_BIRTH);
        assertThat(invalidDobFormatResponse.isAccepted()).isFalse();
    }
}
