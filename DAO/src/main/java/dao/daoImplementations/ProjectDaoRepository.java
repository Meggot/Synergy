package dao.daoImplementations;

import com.models.entity.Account;
import com.models.entity.Project;
import dao.daoInterfaces.ProjectDao;
import dao.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class ProjectDaoRepository implements ProjectDao {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project getProjectById(final Integer projectId) {
        return projectRepository.getProjectById(projectId);
    }

    @Override
    public List<Project> getProjectsWithTitle(final String projectName) {
        return projectRepository.getProjectsByTitle(projectName);
    }

    @Override
    public List<Project> getProjectsOwnedBy(final Account account) {
        return projectRepository.getProjectsByOwner(account);
    }

    @Override
    public void createNewProject(final String title, final String synopsis, final Account owner) {
        projectRepository.save(new Project(title, synopsis, owner));
    }

    @Override
    public List<Project> getProjectsInTimeFrame(final Date from, final Date till) {
        return projectRepository.getProjectsByCreationDateBetween(from, till);
    }

}
