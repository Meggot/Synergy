package com.controllers;

import handlers.AccountRequestHandler;
import models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import requests.LoginAccountRequest;
import responses.LoginAccountResponse;

import java.util.List;
import java.util.Optional;


/**
 * Created by bradleyw on 25/03/2018.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Qualifier(value = "accountRequestHandler")
    @Autowired
    private AccountRequestHandler accountRequestHandler;

    @ResponseBody
    @RequestMapping(path = "/login/{email}/{hashedAndSaltedPassword}")
    public LoginAccountResponse login(@PathVariable(required = true) String email, @PathVariable (required = false) int hashedAndSaltedPassword) {
        Optional<Account> accountMatchingEmail = accountRequestHandler.getAccountDao().getAllAccounts().stream()
                .filter(account -> account.getEmail().equals(email))
                .findAny();
        if (!accountMatchingEmail.isPresent()) {
            LoginAccountResponse loginAccountResponse = new LoginAccountResponse(null);
            loginAccountResponse.setMessage("Couldn't find a user with that email address.");
            return loginAccountResponse;
        } else {
            LoginAccountRequest loginAccountRequest = new LoginAccountRequest(accountMatchingEmail.get().getId());
            LoginAccountResponse loginAccountResponse = accountRequestHandler.handleLoginRequest(loginAccountRequest);
            return loginAccountResponse;
        }
    }

    @ResponseBody
    @RequestMapping(path = "/listAll", method = RequestMethod.GET, produces = "application/json")
    public List<Account> getAllAccounts() {
        return accountRequestHandler.getAllAccounts();
    }

    @ResponseBody
    @RequestMapping(path = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Account getAccountRequestHandler(@PathVariable final Long id) {
        return accountRequestHandler.getUserById(id);
    }

    public void setAccountRequestHandler(AccountRequestHandler accountRequestHandler) {
        this.accountRequestHandler = accountRequestHandler;
    }
}
