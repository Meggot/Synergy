package com.responses;

import com.abstracts.SynergyRequest;
import com.abstracts.SynergyResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bradleyw on 25/03/2018.
 */
public class UpdateAccountResponse extends SynergyResponse {
    private List<String> updatedFields;

    public UpdateAccountResponse(SynergyRequest synergyRequest) {
        super(synergyRequest);
    }

    public List<String> getUpdatedFields() {
        return updatedFields;
    }

    public void setUpdatedFields(List<String> updatedFields) {
        this.updatedFields = updatedFields;
    }
}
