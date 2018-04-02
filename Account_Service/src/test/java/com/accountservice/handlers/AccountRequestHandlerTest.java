package com.accountservice.handlers;


import accountDao.impl.AccountDaoMemory;
import accountDao.interfaces.AccountDaoInterface;
import dbConfigurations.EmbeddedDatabaseConfiguration;
import handlers.AccountRequestHandler;
import models.Account;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import requests.CreateAccountRequest;
import requests.LoginAccountRequest;
import requests.UpdateAccountRequest;
import responses.LoginAccountResponse;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by bradleyw on 24/03/2018.
 */
@ComponentScan("com")
@RunWith(JUnit4.class)
public class AccountRequestHandlerTest {

    //  MODEL
    @Autowired
    private AccountRequestHandler accountRequestHandler;

    // TESTING DAO
    private AccountDaoInterface accountDao;

    public AccountRequestHandlerTest() {
        accountDao = new AccountDaoMemory();
    }

    @Before
    public void setup() {
        accountRequestHandler.setAccountDao(accountDao);
    }

    @Ignore
    @Test
    public void handleGoodCreateAccountRequest() {
        assertThat(accountDao.getAccountById(6L).isPresent()).isFalse();
        CreateAccountRequest createAccountRequest = new CreateAccountRequest("RickyBobby", "newUser@newUser.com");
        accountRequestHandler.handleCreateAccountRequest(createAccountRequest);
        Optional<Account> newCreatedAccount = accountDao.getAccountById(6L);
        assertThat(newCreatedAccount.isPresent()).isTrue();
        assertThat(newCreatedAccount.get().getUsername()).isEqualTo("RickyBobby");
        assertThat(newCreatedAccount.get().getEmail()).isEqualTo("newUser@newUser.com");
    }


    @Ignore
    @Test
    public void handleGoodUpdateAccountRequest() {
        Account currentAccount = accountDao.getAccountById(1L).get();
        assertThat(currentAccount.getUsername()).isEqualTo("Meggot");
        Account newAccount = new Account(currentAccount.getId(), "NotMeggot", currentAccount.getEmail());
        accountRequestHandler.handleUpdateAccountRequest(new UpdateAccountRequest(1L, newAccount));
        assertThat(accountDao.getAccountById(1L).get().getUsername()).isEqualTo("NotMeggot");
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