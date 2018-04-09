package dao.daoImplementations;

import com.models.entity.Project;
import com.models.entity.ProjectSetting;
import dao.daoInterfaces.ProjectSettingDao;
import dao.repositories.ProjectSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProjectSettingDaoRepository implements ProjectSettingDao {

    @Autowired
    ProjectSettingRepository projectSettingRepository;

    @Override
    public List<ProjectSetting> getSettingsForProject(final Project project) {
        return projectSettingRepository.getProjectSettingsByProject(project);
    }

    @Override
    public void addSettingForProject(final Project project, final String settingKey, final String settingValue) {
        projectSettingRepository.save(new ProjectSetting(project, settingKey, settingValue));
    }
}
