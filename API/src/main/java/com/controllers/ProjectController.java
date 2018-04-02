package com.controllers;

import handlers.ProjectRequestHandler;
import models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bradleyw on 26/03/2018.
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectRequestHandler projectRequestHandler;

    @ResponseBody
    @RequestMapping(path="/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Project getProjectById(@PathVariable Long projectId) {
        return null;
    }

    @ResponseBody
    @RequestMapping(path="/name/{name}",  method = RequestMethod.GET, produces = "application/json")
    public List<Project> getProjectsByName(@PathVariable String projectName) {
        return null;
    }

    @ResponseBody
    @RequestMapping(path="/tag/{tag}", method = RequestMethod.GET, produces = "application/json")
    public List<Project> getProjectsWithTags(@PathVariable String tags) {
        //Extrapolate tags from csv value in path?
        return null;
    }

}
