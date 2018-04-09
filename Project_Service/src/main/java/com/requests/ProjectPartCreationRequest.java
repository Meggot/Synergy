package com.requests;

import com.abstracts.SynergyRequest;

public class ProjectPartCreationRequest extends SynergyRequest {
    private Integer projectId;
    private Long partPosition;
    private String body;

    public ProjectPartCreationRequest(final Integer projectId, final Long partPosition, final String body) {
        this.projectId = projectId;
        this.partPosition = partPosition;
        this.body = body;
    }

    public ProjectPartCreationRequest() {
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(final Integer projectId) {
        this.projectId = projectId;
    }

    public Long getPartPosition() {
        return partPosition;
    }

    public void setPartPosition(final Long partPosition) {
        this.partPosition = partPosition;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }
}
