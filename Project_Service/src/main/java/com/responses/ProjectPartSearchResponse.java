package com.responses;

import com.abstracts.SynergyRequest;
import com.abstracts.SynergyResponse;
import com.models.entity.ProjectPart;

import java.util.List;

public class ProjectPartSearchResponse extends SynergyResponse{
    List<ProjectPart> projectPartList;

    public ProjectPartSearchResponse(final SynergyRequest synergyRequest) {
        super(synergyRequest);
    }

    public List<ProjectPart> getProjectPartList() {
        return projectPartList;
    }

    public void setProjectPartList(final List<ProjectPart> projectPartList) {
        this.projectPartList = projectPartList;
    }
}
