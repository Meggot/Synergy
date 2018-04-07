package com.responses;

import com.abstracts.SynergyRequest;
import com.abstracts.SynergyResponse;
import com.models.entity.Project;

import java.util.List;

public class ProjectSearchResponse extends SynergyResponse{

    private List<Project> returnValues;

    public ProjectSearchResponse(final SynergyRequest synergyRequest) {
        super(synergyRequest);
    }

    public List<Project> getReturnValues() {
        return returnValues;
    }

    public void setReturnValues(final List<Project> returnValues) {
        this.returnValues = returnValues;
    }
}
