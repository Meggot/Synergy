package handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import requests.ProjectCreationRequest;
import responses.ProjectCreationResponse;

/**
 * Created by bradleyw on 31/03/2018.
 */
@Component
public class ProjectRequestHandler {

    //@Autowired
    //ProjectDao projectDao;

    public ProjectCreationResponse handleCreateNewProject(ProjectCreationRequest projectCreationRequest) {
            return null;
    }

}
