package com.responses;

import com.abstracts.SynergyRequest;
import com.abstracts.SynergyResponse;
import com.models.entity.ProjectSetting;

import java.util.List;

public class ProjectSettingResponse extends SynergyResponse{

    private List<ProjectSetting> settingResponse;

    public ProjectSettingResponse(final SynergyRequest synergyRequest) {
        super(synergyRequest);
    }

    public List<ProjectSetting> getSettingResponse() {
        return settingResponse;
    }

    public void setSettingResponse(final List<ProjectSetting> settingResponse) {
        this.settingResponse = settingResponse;
    }
}
