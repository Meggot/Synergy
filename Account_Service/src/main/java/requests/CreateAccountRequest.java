package requests;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class CreateAccountRequest {
    private String requestedUsername;
    private String requestedEmail;
    private int pwdKey;

    public CreateAccountRequest(String username, String email) {
        this.requestedEmail = email;
        this.requestedUsername = username;
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
}
