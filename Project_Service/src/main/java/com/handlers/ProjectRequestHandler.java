package com.handlers;

import com.models.DatePeriod;
import com.models.ResponseMessages;
import com.models.entity.Account;
import com.models.entity.Project;
import com.requests.ProjectSearchRequest;
import com.requests.ProjectSettingCreationRequest;
import com.requests.ProjectSettingRequest;
import com.responses.ProjectSearchResponse;
import com.responses.ProjectSettingCreationResponse;
import com.responses.ProjectSettingResponse;
import dao.daoInterfaces.AccountDao;
import dao.daoInterfaces.ProjectDao;
import dao.daoInterfaces.ProjectSettingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.requests.ProjectCreationRequest;
import com.responses.ProjectCreationResponse;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bradleyw on 31/03/2018.
 */
@Component
public class ProjectRequestHandler {

    @Autowired
    ProjectDao projectDao;
    @Autowired
    AccountDao accountDao;
    @Autowired
    ProjectSettingDao projectSettingDao;

    public ProjectCreationResponse handleCreateNewProject(ProjectCreationRequest projectCreationRequest) {
        ProjectCreationResponse response =  new ProjectCreationResponse(projectCreationRequest);
        try {
            Account owner = accountDao.getAccountById(projectCreationRequest.getOwnerId());
            if (owner!=null) {
                projectDao.createNewProject(projectCreationRequest.getTitle(), projectCreationRequest.getSynopsis(), owner);
                response.setAccepted(true);
                response.setMessage(ResponseMessages.VALID_PROJECT_CREATION);
            } else {
                response.setAccepted(false);
                response.setMessage(ResponseMessages.ACCOUNT_DOESNT_EXIST);
            }
        } catch (SQLException e) {
            response.setAccepted(false);
            response.setMessage(ResponseMessages.DATABASE_ERROR);
        }
        return response;
    }

    public Project getProjectById(Integer id) {
        return projectDao.getProjectById(id);
    }

    public ProjectSearchResponse handleSearchRequest(ProjectSearchRequest searchRequest) {
        ProjectSearchResponse response = new ProjectSearchResponse(searchRequest);
        response.setAccepted(true);
        List<Project> responseProjects = null;
        try {
            String searchTitle = searchRequest.getSearchTitle();
            Integer searchOwnerId = searchRequest.getSearchOwnerId();
            Date searchFrom = searchRequest.getDateFrom();
            Date searchTo = searchRequest.getDateTo();
            if (searchTitle!=null) {
                responseProjects = projectDao.getProjectsWithTitle(searchTitle);
            }
            if (searchOwnerId!=null) {
                Account owner = accountDao.getAccountById(searchOwnerId);
                if (owner!=null) {
                    if (responseProjects == null) {
                        responseProjects = projectDao.getProjectsOwnedBy(owner);
                    } else {
                        responseProjects = responseProjects.stream()
                                .filter(project -> project.getOwner().equals(owner))
                                .collect(Collectors.toList());
                    }
                } else {
                    response.setAccepted(false);
                    response.setMessage(ResponseMessages.ACCOUNT_DOESNT_EXIST);
                }
            }
            if (searchFrom != null && searchTo != null) {
                if (responseProjects==null) {
                    responseProjects = projectDao.getProjectsInTimeFrame(searchFrom, searchTo);
                } else {
                    responseProjects = responseProjects.stream()
                            .filter(project -> project.getCreationDate().after(searchFrom))
                            .filter(project -> project.getCreationDate().before(searchTo))
                            .collect(Collectors.toList());
                }
            }
        } catch (SQLException e) {
            response.setAccepted(false);
            response.setMessage(ResponseMessages.DATABASE_ERROR);
        }
        if (response.isAccepted())
        {
            response.setMessage(ResponseMessages.VALID_PROJECT_SEARCH);
            response.setReturnValues(responseProjects);
        }
        return response;
    }

    public ProjectSettingResponse handleListProjectSettingRequest(final ProjectSettingRequest projectSettingRequest) {
        Project project = projectDao.getProjectById(projectSettingRequest.getProjectId());
        ProjectSettingResponse response = new ProjectSettingResponse(projectSettingRequest);
        if (project!=null) {
            response.setSettingResponse(projectSettingDao.getSettingsForProject(project));
            response.setMessage(ResponseMessages.VALID_PROJECT_SETTING);
            response.setAccepted(true);
        } else {
            response.setMessage(ResponseMessages.PROJECT_DOESNT_EXIST);
            response.setAccepted(false);
        }
        return response;
    }

    public ProjectSettingCreationResponse handleCreateProjectSettingRequet(final ProjectSettingCreationRequest createProjectSettingRequest) {
        Project project = projectDao.getProjectById(createProjectSettingRequest.getProjectId());
        ProjectSettingCreationResponse response = new ProjectSettingCreationResponse(createProjectSettingRequest);
        if (project!=null) {
            projectSettingDao.addSettingForProject(project, createProjectSettingRequest.getSettingKey(), createProjectSettingRequest.getSettingValue());
            response.setMessage(ResponseMessages.PROJECT_SETTING_ADDED);
            response.setAccepted(true);
        } else {
            response.setMessage(ResponseMessages.PROJECT_DOESNT_EXIST);
            response.setAccepted(false);
        }
        return response;
    }


    public List<Project> getNewProjects(int maxResults) {
        return this.projectDao.getNewProjects(maxResults);
    }


    public List<Project> getUpdatedProjects(int maxResults) {
        return this.projectDao.getUpdatedProjects(maxResults);
    }


    public List<Project> getTopProjects(DatePeriod period, int maxResults) {

        Date date = Date.from(period.getDate().toInstant());
        return null;
    }
}
