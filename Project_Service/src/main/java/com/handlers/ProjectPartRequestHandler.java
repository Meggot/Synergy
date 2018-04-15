package com.handlers;

import com.models.entity.ProjectPart;
import com.requests.ProjectPartCreationRequest;
import com.requests.ProjectPartSearchRequest;
import com.responses.ProjectPartCreationResponse;
import com.responses.ProjectPartSearchResponse;
import dao.daoInterfaces.AccountDao;
import dao.daoInterfaces.AuthorDao;
import dao.daoInterfaces.ProjectDao;
import dao.daoInterfaces.ProjectPartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class ProjectPartRequestHandler {

    @Autowired
    ProjectDao projectDao;
    @Autowired
    AccountDao accountDao;
    @Autowired
    ProjectPartDao projectPartDao;
    @Autowired
    AuthorDao authorDao;

    public ProjectPart getProjectPartById(Integer projectPartId) {
        return projectPartDao.getProjectPartById(projectPartId);
    }

    public ProjectPartSearchResponse handleProjectPartSearchRequest(ProjectPartSearchRequest request) {
        throw new NotImplementedException();
    }

    public ProjectPartCreationResponse handleProjectPartCreationRequest(ProjectPartCreationRequest request){
        throw new NotImplementedException();
    }
}
;