package requests;

import abstracts.SynergyRequest;

/**
 * Created by bradleyw on 24/03/2018.
 */
public abstract class AccountServiceRequest extends SynergyRequest {
    private Integer accountId;

    protected AccountServiceRequest(Integer accountId) {
        this.setAccountId(accountId);
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
