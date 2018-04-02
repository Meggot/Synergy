package projectDao.interfaces;

import models.Project;
import java.util.List;

public interface ProjectDaoInterface {
    Project getProjectById(Long projectId);
    Project getProjectByName(String projectName);
    List<Project> getProjectsByTags(String[] tags);
}
