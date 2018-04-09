package com.requests;

import com.abstracts.SynergyRequest;

public class ProjectPartSearchRequest extends SynergyRequest {
    private Integer authorId;
    private Integer projectId;

    public ProjectPartSearchRequest() {
    }

    public ProjectPartSearchRequest(final Integer authorId, final Integer projectId) {
        this.authorId = authorId;
        this.projectId = projectId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(final Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(final Integer projectId) {
        this.projectId = projectId;
    }
}
