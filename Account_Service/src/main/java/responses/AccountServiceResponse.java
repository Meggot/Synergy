package responses;

import abstracts.SynergyRequest;
import abstracts.SynergyResponse;

/**
 * Created by bradleyw on 24/03/2018.
 */
public abstract class AccountServiceResponse extends SynergyResponse{

    public AccountServiceResponse(SynergyRequest request) {
        super(request);
    }
}
