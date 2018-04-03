package com.accountservice.handlers;


import accountDao.impl.AccountDaoMemory;
import accountDao.interfaces.AccountDaoInterface;
import dbConfigurations.EmbeddedDatabaseConfiguration;
import handlers.AccountRequestHandler;
import models.Account;
import models.Password;
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

}