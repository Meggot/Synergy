package com.controllers;

import com.abstracts.SynergyResponse;
import com.handlers.AccountRequestHandler;
import com.models.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.requests.CreateAccountRequest;
import com.requests.LoginAccountRequest;
import com.responses.CreateAccountResponse;
import com.responses.LoginAccountResponse;

import javax.xml.ws.Response;
import java.util.List;


/**
 * Created by bradleyw on 25/03/2018.
 */
@RestController
@RequestMapping(path = "/accounts", produces = "application/json")
public class AccountController {

    @Autowired
    private AccountRequestHandler accountRequestHandler;

    @ResponseBody
    @RequestMapping(path = "/login")
    public LoginAccountResponse login(@RequestBody final LoginAccountRequest request) {
        return accountRequestHandler.handleLoginRequest(request);
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
    @RequestMapping(path="/create", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<CreateAccountResponse> createNewAccount(@RequestBody final CreateAccountRequest request) {
        return ResponseEntity.ok(accountRequestHandler.handleCreateAccountRequest(request));
    }

}
