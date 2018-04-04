package requests;

import com.abstracts.SynergyRequest;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class CreateAccountRequest extends SynergyRequest{
    private String requestedUsername;
    private String requestedEmail;
    private String hashedPassword;
    private String saltUsed;

    public CreateAccountRequest(String username, String email, String hashedPassword, String salt) {
        this.requestedEmail = email;
        this.requestedUsername = username;
        this.setHashedPassword(hashedPassword);
        this.setSaltUsed(salt);
    }

    public String getRequestedUsername() {
        return requestedUsername;
    }

    public void setRequestedUsername(String requestedUsername) {
        this.requestedUsername = requestedUsername;
    }

    public String getRequestedEmail() {
        return requestedEmail;
    }

    public void setRequestedEmail(String requestedEmail) {
        this.requestedEmail = requestedEmail;
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
