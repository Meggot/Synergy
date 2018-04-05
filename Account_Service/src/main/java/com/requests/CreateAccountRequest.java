package com.requests;

import com.abstracts.SynergyRequest;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class CreateAccountRequest extends SynergyRequest{
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String hashedPassword;
    @NotNull
    @NotBlank
    private String salt;

    public CreateAccountRequest() {

    }

    public CreateAccountRequest(String username, String email, String hashedPassword, String salt) {
        this.email = email;
        this.username = username;
        this.setHashedPassword(hashedPassword);
        this.setSalt(salt);
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "CreateAccountRequest{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
