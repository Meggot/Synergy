package dao.daoInterfaces;

import com.models.entity.Account;
import com.models.entity.Project;

import java.util.Date;
import java.util.List;

public interface ProjectDao {
    Project getProjectById(Integer projectId);
    List<Project> getProjectsWithTitle(String projectName);
    List<Project> getProjectsOwnedBy(Account account);
    void createNewProject(String title, String synopsis, Account owner);
    List<Project> getProjectsInTimeFrame(Date from, Date till);
    List<Project> getNewProjects(int maxResults);
    List<Project> getUpdatedProjects(int maxResults);
    List<Project> getTopProjects(Date from, int maxResults);
}
