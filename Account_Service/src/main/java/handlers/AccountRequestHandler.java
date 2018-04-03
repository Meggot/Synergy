package handlers;

import dao.daoInterfaces.AccountDao;
import interfaces.SynergyRequestHandler;

import models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import requests.CreateAccountRequest;
import requests.LoginAccountRequest;
import responses.CreateAccountResponse;
import responses.LoginAccountResponse;
import requests.UpdateAccountRequest;
import responses.UpdateAccountResponse;
import sessions.SessionsService;

import java.util.List;

/**
 * Created by bradleyw on 24/03/2018.
 */

@Component
public class AccountRequestHandler implements SynergyRequestHandler{

    private SessionsService sessionsService;

    @Autowired
    private AccountDao accountDao;

    public AccountRequestHandler() {
        setSessionsService(new SessionsService());
    }

    public List<Account> getAllAccounts() {
        return null;
    }

    public CreateAccountResponse handleCreateAccountRequest(CreateAccountRequest createAccountRequest) {
        return null;
    }

    public UpdateAccountResponse handleUpdateAccountRequest(UpdateAccountRequest updateAccountRequest) {
        return null;
    }

    public LoginAccountResponse handleLoginRequest(LoginAccountRequest loginAccountRequest) { return null;
    }

    public SessionsService getSessionsService() {
        return sessionsService;
    }

    public void setSessionsService(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account getUserById(Integer id) {
        return accountDao.getAccountById(id);
    }
}
