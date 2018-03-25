package handlers;


import accountDao.AccountDaoMemory;
import models.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import requests.CreateAccountRequest;
import requests.LoginAccountRequest;
import requests.UpdateAccountRequest;
import responses.LoginAccountResponse;

import java.util.HashMap;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by bradleyw on 24/03/2018.
 */

@RunWith(JUnit4.class)
public class AccountRequestHandlerTest {

    private AccountRequestHandler accountRequestHandler;
    private AccountDaoMemory accountTestingDao;

    public AccountRequestHandlerTest() {

    }

    @Before
    public void setup() {
        accountRequestHandler = new AccountRequestHandler();
        accountTestingDao = new AccountDaoMemory();
        accountTestingDao.setAccountMap(new HashMap<Long, Account>() {{
            put(1L, new Account(1L, "Meggot", "Meggot@username.com"));
            put(2L, new Account(2L, "Sharkbait", "Sharkbait@username.com"));
            put(3L, new Account(3L, "Poza", "Poza@username.com"));
            put(4L, new Account(4L, "Zolu", "Zolu@username.com"));
            put(5L, new Account(5L, "Sciatican", "Sciatican@username.com"));
        }});
        accountRequestHandler.setAccountDao(accountTestingDao);
    }

    @Test
    public void handleGoodCreateAccountRequest() {
        assertThat(accountTestingDao.getAccountById(6L).isPresent()).isFalse();
        CreateAccountRequest createAccountRequest = new CreateAccountRequest("RickyBobby", "newUser@newUser.com");
        accountRequestHandler.handleCreateAccountRequest(createAccountRequest);
        Optional<Account> newCreatedAccount = accountTestingDao.getAccountById(6L);
        assertThat(newCreatedAccount.isPresent()).isTrue();
        assertThat(newCreatedAccount.get().getUsername()).isEqualTo("RickyBobby");
        assertThat(newCreatedAccount.get().getEmail()).isEqualTo("newUser@newUser.com");
    }


    @Test
    public void handleGoodUpdateAccountRequest() {
        Account currentAccount = accountTestingDao.getAccountById(1L).get();
        assertThat(currentAccount.getUsername()).isEqualTo("Meggot");
        Account newAccount = new Account(currentAccount.getId(), "NotMeggot", currentAccount.getEmail());
        accountRequestHandler.handleUpdateAccountRequest(new UpdateAccountRequest(1L, newAccount));
        assertThat(accountTestingDao.getAccountById(1L).get().getUsername()).isEqualTo("NotMeggot");
    }


    @Test
    public void handleGoodLoginRequest() {
        LoginAccountRequest loginAccountRequest = new LoginAccountRequest(1L);
        LoginAccountResponse loginAccountResponse = accountRequestHandler.handleLoginRequest(loginAccountRequest);
        assertThat(loginAccountRequest.isLoginSuccessful()).isTrue();
        System.out.println(loginAccountResponse.getMessage());
    }

    @Test
    public void alreadyLoggedInRequest() {
        LoginAccountRequest loginAccountRequest = new LoginAccountRequest(1L);
        accountRequestHandler.handleLoginRequest(loginAccountRequest);
        assertThat(loginAccountRequest.isLoginSuccessful()).isTrue();
        LoginAccountRequest secondLoginAttempt = new LoginAccountRequest(1L);
        LoginAccountResponse secondLoginResponse = accountRequestHandler.handleLoginRequest(secondLoginAttempt);
        assertThat(secondLoginAttempt.isLoginSuccessful()).isFalse();
        System.out.println(secondLoginResponse.getMessage());
    }

    @Test
    public void accountDoesntExistLoginRequest() {
        LoginAccountRequest loginAccountRequest = new LoginAccountRequest(006L);
        LoginAccountResponse loginAccountResponse = accountRequestHandler.handleLoginRequest(loginAccountRequest);
        assertThat(loginAccountRequest.isLoginSuccessful()).isFalse();
        System.out.println(loginAccountResponse.getMessage());
    }

}