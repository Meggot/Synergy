package com.abstracts;

/**
 * Created by bradleyw on 24/03/2018.
 */
public abstract class SynergyResponse {
    private SynergyRequest request;
    private String message;

    public SynergyResponse(SynergyRequest synergyRequest) {
        this.setRequest(synergyRequest);
    }

    public SynergyRequest getRequest() {
        return request;
    }

    public void setRequest(SynergyRequest request) {
        this.request = request;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
