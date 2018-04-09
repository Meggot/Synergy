package com.requests;

public class ProjectSettingCreationRequest extends ProjectSettingRequest {
    private String settingKey;
    private String settingValue;

    public ProjectSettingCreationRequest(final Integer projectId, final String settingKey, final String settingValue) {
        super(projectId);
        this.settingKey = settingKey;
        this.settingValue = settingValue;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(final String settingValue) {
        this.settingValue = settingValue;
    }


    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(final String settingKey) {
        this.settingKey = settingKey;
    }
}
