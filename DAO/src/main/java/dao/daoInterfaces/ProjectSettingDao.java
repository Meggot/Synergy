package dao.daoInterfaces;

import com.models.entity.Project;
import com.models.entity.ProjectSetting;

import java.util.List;

public interface ProjectSettingDao {
    List<ProjectSetting> getSettingsForProject(Project project);
    void addSettingForProject(Project project, String settingKey, String settingValue);
}
