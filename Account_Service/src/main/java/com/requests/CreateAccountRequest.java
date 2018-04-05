package com.requests;

import com.abstracts.SynergyRequest;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class CreateAccountRequest extends SynergyRequest{
    private String username;
    private String email;
    private String hashedPassword;
    private String saltUsed;

    public CreateAccountRequest() {

    }

    public CreateAccountRequest(String username, String email, String hashedPassword, String salt) {
        this.email = email;
        this.username = username;
        this.setHashedPassword(hashedPassword);
        this.setSaltUsed(salt);
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

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSaltUsed() {
        return saltUsed;
    }

    public void setSaltUsed(String saltUsed) {
        this.saltUsed = saltUsed;
    }
}
