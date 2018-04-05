package com.requests;

import com.abstracts.SynergyRequest;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class UpdateAccountRequest extends SynergyRequest {

    private Integer accountId;
    private String username;
    private String email;
    public UpdateAccountRequest(){

    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
