package com.handlers;

import com.models.ResponseMessages;
import dao.daoInterfaces.AccountDao;
import com.interfaces.SynergyRequestHandler;

import com.models.entity.Account;
import com.models.entity.Password;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.requests.CreateAccountRequest;
import com.requests.LoginAccountRequest;
import com.responses.CreateAccountResponse;
import com.responses.LoginAccountResponse;
import com.requests.UpdateAccountRequest;
import com.responses.UpdateAccountResponse;
import com.sessions.SessionsService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bradleyw on 24/03/2018.
 */

@Component
public class AccountRequestHandler implements SynergyRequestHandler{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SessionsService sessionsService;

    @Autowired
    private AccountDao accountDao;

    public AccountRequestHandler() {
        setSessionsService(new SessionsService());
    }

    public List<Account> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    public CreateAccountResponse handleCreateAccountRequest(CreateAccountRequest createAccountRequest) {
        logger.debug("handleCreateAccountRequest: Received new create account request=" + createAccountRequest);
        CreateAccountResponse response = new CreateAccountResponse(createAccountRequest);
        try {
            if (accountDao.getAccountByEmail(createAccountRequest.getEmail()) != null) {
                response.setAccepted(false);
                response.setMessage(ResponseMessages.DUPLICATE_EMAIL);
            } else if (accountDao.getAccountByUsername(createAccountRequest.getUsername()) != null) {
                response.setAccepted(false);
                response.setMessage(ResponseMessages.DUPLICATE_USERNAME);
            } else {
                Password generatedPassword = new Password(createAccountRequest.getHashedPassword(), createAccountRequest.getSaltUsed());
                accountDao.createNewAccount(createAccountRequest.getUsername(), createAccountRequest.getEmail(), generatedPassword);
                response.setAccepted(true);
                response.setMessage(ResponseMessages.VALID_ACCOUNT_CREATION);
            }
        } catch (SQLException exc) {
            response.setAccepted(false);
            response.setMessage(ResponseMessages.DATABASE_ERROR);
        }
        logger.debug("handleCreateAccountRequest: Processed request, response=" + response);
        return response;
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
        Account accountById = null;
        try {
            accountById = accountDao.getAccountById(id);
        } catch (SQLException e) {
        }
        return accountById;
    }
}
