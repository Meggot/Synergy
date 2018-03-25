package requests;

/**
 * Created by bradleyw on 24/03/2018.
 */
public class LoginAccountRequest extends AccountServiceRequest {
    private boolean isLoginSuccessful;
    public LoginAccountRequest(Long accountId) {
        super(accountId);
    }


    public boolean isLoginSuccessful() {
        return isLoginSuccessful;
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        isLoginSuccessful = loginSuccessful;
    }
}
