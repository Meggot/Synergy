package com.handlers;

import com.exceptions.NoDataFoundException;
import com.handlers.util.DateFormatPassing;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
                Password generatedPassword = new Password(createAccountRequest.getSalt(), createAccountRequest.getHashedPassword());
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

    public UpdateAccountResponse handleUpdateAccountRequest(UpdateAccountRequest updateAccountRequest) throws NoDataFoundException{
        logger.debug("handleUpdateAccountRequest: Received new update account request=" + updateAccountRequest);
        UpdateAccountResponse response = new UpdateAccountResponse(updateAccountRequest);
        response.setAccepted(true);
        boolean updatedFields = false;
        List<String> proposedUpdates = new ArrayList<>();
        try {
            String updatedUsername = updateAccountRequest.getUsername();
            String updatedEmail = updateAccountRequest.getEmail();
            String updateDob = updateAccountRequest.getDob();
            Account accountToUpdate = accountDao.getAccountById(updateAccountRequest.getAccountId());
            if (accountToUpdate==null) {
                response.setAccepted(false);
                response.setMessage(ResponseMessages.USER_ID_INVALID);
            } else {
                if (updatedUsername != null && !updatedUsername.equals(accountToUpdate.getUsername())) {
                    if (accountDao.getAccountByUsername(updatedUsername) != null) {
                        response.setMessage(ResponseMessages.DUPLICATE_USERNAME);
                        response.setAccepted(false);
                        return response;
                    } else {
                        accountToUpdate.setUsername(updatedUsername);
                        proposedUpdates.add("Username");
                        updatedFields = true;
                    }
                }
                if (updatedEmail != null && !updatedEmail.equals(accountToUpdate.getEmail())) {
                    if (accountDao.getAccountByEmail(updatedEmail) != null) {
                        response.setMessage(ResponseMessages.DUPLICATE_EMAIL);
                        response.setAccepted(false);
                        return response;
                    } else {
                        accountToUpdate.setEmail(updatedEmail);
                        proposedUpdates.add("Email");
                        updatedFields = true;
                    }
                }
                    try {
                        if (updateDob != null){
                            Date formattedUpdatedDob = DateFormatPassing.getDobFromString(updateDob);
                            if (accountToUpdate.getDateOfBirth()==null || ( accountToUpdate.getDateOfBirth()!=null && accountToUpdate.getDateOfBirth().compareTo(formattedUpdatedDob)!=0)) {
                                accountToUpdate.setDateOfBirth(formattedUpdatedDob);
                                proposedUpdates.add("DOB");
                                updatedFields = true;
                            }
                        }
                    } catch (ParseException e) {
                        response.setMessage(ResponseMessages.INVALID_DATE_OF_BIRTH);
                        response.setAccepted(false);
                        return response;
                    }
            }
            if (response.isAccepted()) {
                if (updatedFields) {
                    accountDao.updateAccount(accountToUpdate);
                    response.setUpdatedFields(proposedUpdates);
                    response.setMessage(ResponseMessages.VALID_ACCOUNT_UPDATE);
                } else {
                    response.setAccepted(false);
                    response.setMessage(ResponseMessages.INVALID_ACCOUNT_UPDATE);
                }
            }
        } catch (SQLException e) {
            response.setMessage(ResponseMessages.DATABASE_ERROR);
            response.setAccepted(false);
        }
        logger.debug("handleUpdateAccountRequest: Processed update account request, response=" + response);
        return response;
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
