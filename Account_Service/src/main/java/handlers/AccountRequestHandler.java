package handlers;

import dao.daoInterfaces.AccountDao;
import com.interfaces.SynergyRequestHandler;

import com.models.Account;
import com.models.Password;
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
        return accountDao.getAllAccounts();
    }

    public CreateAccountResponse handleCreateAccountRequest(CreateAccountRequest createAccountRequest) {
        Password generatedPassword = new Password(createAccountRequest.getHashedPassword(), createAccountRequest.getHashedPassword());
        accountDao.createNewAccount(createAccountRequest.getRequestedUsername(), createAccountRequest.getRequestedEmail(), generatedPassword);
        CreateAccountResponse response = new CreateAccountResponse(createAccountRequest);
        response.setMessage("Successfully created an account.");
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
        return accountDao.getAccountById(id);
    }
}
