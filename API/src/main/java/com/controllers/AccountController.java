package com.controllers;

import handlers.AccountRequestHandler;
import com.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import requests.CreateAccountRequest;
import responses.CreateAccountResponse;
import responses.LoginAccountResponse;

import java.util.List;


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
        return null;
    }

    @ResponseBody
    @RequestMapping(path = "/listAll", method = RequestMethod.GET, produces = "application/json")
    public List<Account> getAllAccounts() {
        return accountRequestHandler.getAllAccounts();
    }

    @ResponseBody
    @RequestMapping(path = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Account getAccountRequestHandler(@PathVariable final Integer id) {
        return accountRequestHandler.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(path="/create/{username}/{email}/{hashedpassword}/{salt}")
    public CreateAccountResponse createNewAccount(@PathVariable final String username,
                                                  @PathVariable final String email,
                                                  @PathVariable final String hashedPassword,
                                                  @PathVariable final String salt) {
        return accountRequestHandler.handleCreateAccountRequest(
                new CreateAccountRequest(username, email, hashedPassword, salt));
    }

    public void setAccountRequestHandler(AccountRequestHandler accountRequestHandler) {
        this.accountRequestHandler = accountRequestHandler;
    }
}
