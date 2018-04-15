package com.handlers;

import com.models.ResponseMessages;
import com.models.entity.Author;
import com.models.entity.Project;
import com.models.entity.ProjectPart;
import com.requests.ProjectPartSearchRequest;
import com.responses.ProjectPartSearchResponse;
import dao.daoInterfaces.AccountDao;
import dao.daoInterfaces.AuthorDao;
import dao.daoInterfaces.ProjectDao;
import dao.daoInterfaces.ProjectPartDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by bradleyw on 15/04/2018.
 */
@RunWith(MockitoJUnitRunner.class)
@Import(ProjectPartRequestHandler.class)
public class ProjectPartRequestHandlerTest {
    @MockBean
    ProjectDao projectDao;
    @MockBean
    AccountDao accountDao;
    @MockBean
    ProjectPartDao projectPartDao;
    @MockBean
    AuthorDao authorDao;

    ProjectPartRequestHandler projectPartRequestHandler;

    @Before
    public void init() {
        projectPartRequestHandler = new ProjectPartRequestHandler();
    }

    @Test
    public void  testHandleProjectPartSearchRequest() {
        Project project = new Project();
        project.setId(1);

        ProjectPart projectPart = new ProjectPart();
        projectPart.setId(1);
        projectPart.setProject(project);

        Author author = new Author();
        author.setId(1);
        author.setProjectPart(projectPart);

        ProjectPartSearchRequest projectPartAuthorSearch = new ProjectPartSearchRequest();
        projectPartAuthorSearch.setAuthorId(1);
        ProjectPartSearchResponse projectPartAuthorSearchResponse = projectPartRequestHandler.handleProjectPartSearchRequest(projectPartAuthorSearch);
        assertThat(projectPartAuthorSearchResponse.getProjectPartList()).containsOnly(projectPart);
        assertThat(projectPartAuthorSearchResponse.getMessage()).isEqualTo(ResponseMessages.VALID_PROJECT_PART_SEARCH);
        assertThat(projectPartAuthorSearchResponse.isAccepted()).isTrue();

        ProjectPartSearchRequest projectPartProjectSearch = new ProjectPartSearchRequest();
        projectPartProjectSearch.setProjectId(1);
        ProjectPartSearchResponse projectPartProjectSearchResponse = projectPartRequestHandler.handleProjectPartSearchRequest(projectPartProjectSearch);
        assertThat(projectPartProjectSearchResponse.getProjectPartList()).containsOnly(projectPart);
        assertThat(projectPartProjectSearchResponse.isAccepted()).isTrue();
        assertThat(projectPartProjectSearchResponse.getMessage()).isEqualTo(ResponseMessages.VALID_PROJECT_PART_SEARCH);

        ProjectPartSearchRequest nullSearchTermSearch = new ProjectPartSearchRequest();
        ProjectPartSearchResponse nullSearchTermSearchResponse = projectPartRequestHandler.handleProjectPartSearchRequest(nullSearchTermSearch);
        assertThat(nullSearchTermSearchResponse.getProjectPartList()).isEmpty();
        assertThat(nullSearchTermSearchResponse.getMessage()).isEqualTo(ResponseMessages.INVALID_PROJECT_PART_SEARCH);
        assertThat(nullSearchTermSearchResponse.isAccepted()).isFalse();
    }
}