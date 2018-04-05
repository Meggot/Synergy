package com.controllers;

import com.abstracts.SynergyResponse;
import com.handlers.AccountRequestHandler;
import com.models.entity.Account;
import com.requests.UpdateAccountRequest;
import com.responses.UpdateAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.requests.CreateAccountRequest;
import com.requests.LoginAccountRequest;
import com.responses.CreateAccountResponse;
import com.responses.LoginAccountResponse;

import javax.validation.Valid;
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
    public Account getAccountById(@PathVariable final Integer id) {
        return accountRequestHandler.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(path="/update", method =RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<UpdateAccountResponse> updateAccount(@RequestBody @Valid final UpdateAccountRequest request,
                                                               BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(accountRequestHandler.handleUpdateAccountRequest(request));
        }
    }

    @ResponseBody
    @RequestMapping(path="/create", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<CreateAccountResponse> createNewAccount(@RequestBody @Valid final CreateAccountRequest request,
                                                                  BindingResult result) {
       if (result.hasErrors()) {
           System.out.println(result.getAllErrors());
           return ResponseEntity.badRequest().body(null);
       } else {
           return ResponseEntity.ok(accountRequestHandler.handleCreateAccountRequest(request));
       }
    }

}
