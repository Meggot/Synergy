package dao.repositories;

import com.models.entity.Project;
import com.models.entity.ProjectSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectSettingRepository extends JpaRepository<ProjectSetting, Integer>{
    List<ProjectSetting> getProjectSettingsByProject(Project project);
}
