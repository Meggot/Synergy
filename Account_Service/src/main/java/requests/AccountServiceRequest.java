package requests;

import abstracts.SynergyRequest;

/**
 * Created by bradleyw on 24/03/2018.
 */
public abstract class AccountServiceRequest extends SynergyRequest {
    private Long accountId;

    protected AccountServiceRequest(Long accountId) {
        this.setAccountId(accountId);
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
