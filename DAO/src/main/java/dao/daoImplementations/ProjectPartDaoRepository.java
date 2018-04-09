package dao.daoImplementations;

import com.models.entity.Project;
import com.models.entity.ProjectPart;
import dao.daoInterfaces.ProjectPartDao;
import dao.repositories.ProjectPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProjectPartDaoRepository implements ProjectPartDao {

    @Autowired
    ProjectPartRepository projectPartRepository;

    @Override
    public ProjectPart getProjectPartById(final Integer projectPartId) {
        return projectPartRepository.getProjectPartById(projectPartId);
    }

    @Override
    public List<ProjectPart> getProjectPartsByProject(final Project project) {
        return projectPartRepository.getProjectPartsByProject(project);
    }

    @Override
    public void addProjectPartForProject(final Project project, final Long position, final String body) {
        projectPartRepository.save(new ProjectPart());
    }
}
