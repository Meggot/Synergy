package dao.daoImplementations;

import com.models.entity.Account;
import com.models.entity.Project;
import dao.daoInterfaces.ProjectDao;
import dao.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Project> getNewProjects(int maxResults) {
        return getSortedProjects(maxResults, "created_date");
    }

    @Override
    public List<Project> getUpdatedProjects(int maxResults) {
        return getSortedProjects(maxResults, "modified_date");
    }

    private List<Project> getSortedProjects(int maxResults, String sortField) {
        final Sort sort = new Sort(Sort.Direction.DESC, sortField);
        final Pageable limit = new PageRequest(0, maxResults);
        return projectRepository.getProjectsSorted(limit, sort);
    }

    @Override
    public List<Project> getTopProjects(Date from, int maxResults) {
        return projectRepository.getTopProjects(from, maxResults);
    }
}
