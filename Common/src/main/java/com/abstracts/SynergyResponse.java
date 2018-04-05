package com.abstracts;

import com.models.ResponseMessages;

/**
 * Created by bradleyw on 24/03/2018.
 */
public abstract class SynergyResponse {

    private SynergyRequest request;
    private ResponseMessages message;
    private boolean accepted;

    public SynergyResponse(SynergyRequest synergyRequest) {
        this.setRequest(synergyRequest);
    }

    public SynergyRequest getRequest() {
        return request;
    }

    public void setRequest(SynergyRequest request) {
        this.request = request;
    }

    public ResponseMessages getMessage() {
        return message;
    }

    public void setMessage(ResponseMessages message) {
        this.message = message;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(final boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "SynergyResponse{" +
                "request=" + request +
                ", message=" + message +
                ", accepted=" + accepted +
                '}';
    }
}
