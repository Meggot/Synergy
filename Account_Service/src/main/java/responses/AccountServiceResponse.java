package responses;

import com.abstracts.SynergyRequest;
import com.abstracts.SynergyResponse;

/**
 * Created by bradleyw on 24/03/2018.
 */
public abstract class AccountServiceResponse extends SynergyResponse{

    public AccountServiceResponse(SynergyRequest request) {
        super(request);
    }
}
