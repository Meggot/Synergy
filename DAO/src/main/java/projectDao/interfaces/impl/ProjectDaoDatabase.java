package projectDao.interfaces.impl;

import models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import projectDao.interfaces.ProjectDaoInterface;

import javax.sql.DataSource;
import java.util.List;

public class ProjectDaoDatabase implements ProjectDaoInterface {

    @Autowired
    DataSource dataSource;
    @Override
    public Project getProjectById(final Long projectId) {
        return null;
    }

    @Override
    public Project getProjectByName(final String projectName) {
        return null;
    }

    @Override
    public List<Project> getProjectsByTags(final String[] tags) {
        return null;
    }
}
