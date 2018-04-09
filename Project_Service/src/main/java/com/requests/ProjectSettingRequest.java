package com.requests;

import com.abstracts.SynergyRequest;

public class ProjectSettingRequest extends SynergyRequest {
    public Integer projectId;

    public ProjectSettingRequest(final Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(final Integer projectId) {
        this.projectId = projectId;
    }
}
