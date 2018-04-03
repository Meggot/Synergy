package com.accountservice.handlers;


import handlers.AccountRequestHandler;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

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
}
