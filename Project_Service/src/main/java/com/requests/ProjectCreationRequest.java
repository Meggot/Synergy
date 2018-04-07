package com.requests;

import com.abstracts.SynergyRequest;
import com.models.entity.Account;

/**
 * Created by bradleyw on 31/03/2018.
 */
public class ProjectCreationRequest extends SynergyRequest{
    private String title;
    private String synopsis;
    private Integer ownerId;

    public ProjectCreationRequest() {

    }

    public ProjectCreationRequest(String title, String synopsis, Integer ownerId) {
        this.title = title;
        this.synopsis = synopsis;
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(final String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final Integer ownerId) {
        this.ownerId = ownerId;
    }
}
