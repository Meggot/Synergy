package dao.daoInterfaces;

import com.models.entity.Project;
import com.models.entity.ProjectPart;

import java.util.List;

public interface ProjectPartDao {
    ProjectPart getProjectPartById(Integer projectPartId);
    List<ProjectPart> getProjectPartsByProject(Project project);
    void addProjectPartForProject(Project project, Long position, String body);
}
