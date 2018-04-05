package com.requests;

import com.abstracts.SynergyRequest;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class UpdateAccountRequest extends SynergyRequest {

    @NotNull
    @NotBlank
    private Integer accountId;
    private String username;
    private String email;
    private String dob;

    public UpdateAccountRequest(){

    }

    public UpdateAccountRequest(Integer accountId, String newUsername, String newEmail, String newDob)
    {
        this.accountId = accountId;
        this.username = newUsername;
        this.email = newEmail;
        this.dob = newDob;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "UpdateAccountRequest{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
