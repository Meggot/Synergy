package com.controllers;

import com.handlers.ProjectRequestHandler;
import com.models.DatePeriod;
import com.models.entity.Project;
import com.requests.ProjectCreationRequest;
import com.requests.ProjectSearchRequest;
import com.requests.ProjectSettingCreationRequest;
import com.requests.ProjectSettingRequest;
import com.responses.ProjectCreationResponse;
import com.responses.ProjectSearchResponse;
import com.responses.ProjectSettingCreationResponse;
import com.responses.ProjectSettingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by bradleyw on 26/03/2018.
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends AbstractController {

    @Autowired
    ProjectRequestHandler projectRequestHandler;

    @ResponseBody
    @RequestMapping(path = "/setting/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ProjectSettingResponse> listProjectSettingsForProject(@PathVariable final Integer id) {
        return ResponseEntity.ok(projectRequestHandler.handleListProjectSettingRequest(new ProjectSettingRequest(id)));
    }

    @ResponseBody
    @RequestMapping(path = "/setting/{id}/create", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<ProjectSettingCreationResponse> createNewProjectSetting(@PathVariable final Integer id,
                                                                                  @RequestParam final String settingKey,
                                                                                  @RequestParam final String settingValue) {
        ProjectSettingCreationRequest createProjectSettingRequest = new ProjectSettingCreationRequest(id, settingKey, settingValue);
        return ResponseEntity.ok(projectRequestHandler.handleCreateProjectSettingRequet(createProjectSettingRequest));
    }

    @ResponseBody
    @RequestMapping(path = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Project getProjectById(@PathVariable Integer id) {
        return projectRequestHandler.getProjectById(id);
    }

    @ResponseBody
    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getProjectsByName(@PathVariable String projectName) {
        return null;
    }

    @ResponseBody
    @RequestMapping(path = "/tag/{tag}", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getProjectsWithTags(@PathVariable String tags) {
        //Extrapolate tags from csv value in path?
        return null;
    }

    @ResponseBody
    @RequestMapping(path = "/create", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<ProjectCreationResponse> createNewProject(@RequestBody final ProjectCreationRequest request) throws SQLException {
        return ResponseEntity.ok(projectRequestHandler.handleCreateNewProject(request));
    }

    @ResponseBody
    @RequestMapping(path = "/search", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ProjectSearchResponse> searchProjects(@RequestParam(required = false) final String name,
                                                                @RequestParam(required = false) final Integer ownerId,
                                                                @RequestParam(required = false) final Date dateFrom,
                                                                @RequestParam(required = false) final Date dateTo) {
        ProjectSearchRequest request = new ProjectSearchRequest();
        request.setSearchTitle(name);
        request.setSearchOwnerId(ownerId);
        request.setDateFrom(dateFrom);
        request.setDateTo(dateTo);
        return ResponseEntity.ok(projectRequestHandler.handleSearchRequest(request));
    }

    @ResponseBody
    @RequestMapping(path = "/top", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getTopProjects(@RequestParam(name = "maxResults", defaultValue = "50") int maxResults,
                                        @RequestParam DatePeriod period) {
        return this.projectRequestHandler.getTopProjects(period, maxResults);
    }

    @ResponseBody
    @RequestMapping(path = "/hot", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getHotProjects(@RequestParam(name = "maxResults", defaultValue = "50") int maxResults) {
        //need to add logic for upvotes
        return null;
    }

    @ResponseBody
    @RequestMapping(path = "/new", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getNewProjects(@RequestParam(name = "maxResults", defaultValue = "50") int maxResults) {
        return this.projectRequestHandler.getNewProjects(maxResults);
    }

    @ResponseBody
    @RequestMapping(path = "/updated", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getUpdatedProjects(@RequestParam(name = "maxResults", defaultValue = "50") int maxResults) {
        return this.projectRequestHandler.getUpdatedProjects(maxResults);
    }



}
