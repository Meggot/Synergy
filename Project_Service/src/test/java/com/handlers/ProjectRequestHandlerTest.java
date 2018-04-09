package com.handlers;

import com.models.ResponseMessages;
import com.models.entity.Account;
import com.models.entity.Password;
import com.models.entity.Project;
import com.models.entity.ProjectSetting;
import com.requests.ProjectCreationRequest;
import com.requests.ProjectSearchRequest;
import com.requests.ProjectSettingCreationRequest;
import com.requests.ProjectSettingRequest;
import com.responses.ProjectCreationResponse;
import com.responses.ProjectSearchResponse;
import com.responses.ProjectSettingCreationResponse;
import com.responses.ProjectSettingResponse;
import dao.daoImplementations.AccountDaoRepository;
import dao.daoImplementations.ProjectDaoRepository;
import dao.daoImplementations.ProjectSettingDaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@Import(ProjectRequestHandler.class)
public class ProjectRequestHandlerTest {

    @MockBean
    private ProjectDaoRepository projectDao;
    @MockBean
    private AccountDaoRepository accountDao;
    @MockBean
    private ProjectSettingDaoRepository projectSettingDao;

    @Autowired
    private ProjectRequestHandler projectRequestHandler;

    final Account modelAccount = new Account("TestUser", "TestEmail", new Password("test", "test"));


    @Test
    public void handleCreateNewProject() throws Exception {
        modelAccount.setId(1);
        when(accountDao.getAccountById(1)).thenReturn(modelAccount);
        ProjectCreationRequest validProjectCreationRequest = new ProjectCreationRequest("testtitle", "testSynopsis", 1);
        ProjectCreationResponse validProjectCreationResponse = projectRequestHandler.handleCreateNewProject(validProjectCreationRequest);
        assertThat(validProjectCreationResponse.isAccepted()).isTrue();
        assertThat(validProjectCreationResponse.getMessage()).isEqualTo(ResponseMessages.VALID_PROJECT_CREATION);
        verify(projectDao, times(1)).createNewProject(anyString(), anyString(), anyObject());

        ProjectCreationRequest accountDoesntExistRequest = new ProjectCreationRequest("testtitle", "test", 2);
        ProjectCreationResponse accountDoesntExistResponse = projectRequestHandler.handleCreateNewProject(accountDoesntExistRequest);
        assertThat(accountDoesntExistResponse.isAccepted()).isFalse();
        assertThat(accountDoesntExistResponse.getMessage()).isEqualTo(ResponseMessages.ACCOUNT_DOESNT_EXIST);
        verify(projectDao, times(1)).createNewProject(anyString(), anyString(), anyObject());
    }

    @Test
    public void getProjectById() throws Exception {
        modelAccount.setId(1);
        final Project project = new Project("projectName", "projectSynopsis", modelAccount);
        when(projectDao.getProjectById(1)).thenReturn(project);
        Project retrievedProject = projectRequestHandler.getProjectById(1);

        assertThat(project).isEqualTo(retrievedProject);
    }

    @Test
    public void handleSearchRequest() throws Exception {
        when(accountDao.getAccountById(1)).thenReturn(modelAccount);
        modelAccount.setId(1);
        ArrayList<Project> projectReturnList = new ArrayList<>();
        final Project project = new Project("searchForMe", "projectSynopsis", modelAccount);
        projectReturnList.add(project);

        when(projectDao.getProjectsWithTitle("searchForMe")).thenReturn(projectReturnList);
        ProjectSearchRequest namesSearchRequest = new ProjectSearchRequest();
        namesSearchRequest.setSearchTitle("searchForMe");
        ProjectSearchResponse namesSearchResponse = projectRequestHandler.handleSearchRequest(namesSearchRequest);
        then(projectDao).should((times(1))).getProjectsWithTitle(anyString());
        assertThat(namesSearchResponse.getReturnValues()).containsOnly(project);

        when(projectDao.getProjectsOwnedBy(modelAccount)).thenReturn(projectReturnList);
        ProjectSearchRequest accountSearchRequest = new ProjectSearchRequest();
        accountSearchRequest.setSearchOwnerId(modelAccount.getId());
        ProjectSearchResponse accountSearchResponse = projectRequestHandler.handleSearchRequest(accountSearchRequest);
        then(projectDao).should(times(1)).getProjectsOwnedBy(any(Account.class));
        assertThat(accountSearchResponse.getReturnValues()).containsOnly(project);

        when(projectDao.getProjectsInTimeFrame(any(Date.class), any(Date.class))).thenReturn(projectReturnList);
        ProjectSearchRequest timeframeSearchRequest = new ProjectSearchRequest();
        timeframeSearchRequest.setDateFrom(new Date());
        timeframeSearchRequest.setDateTo(new Date());
        ProjectSearchResponse timeframeSearchResponse = projectRequestHandler.handleSearchRequest(timeframeSearchRequest);
        then(projectDao).should(times(1)).getProjectsInTimeFrame(any(Date.class), any(Date.class));
        assertThat(timeframeSearchResponse.getReturnValues()).containsOnly(project);
    }

    @Test
    public void handleListProjectSettingRequest() {
        final Project project = new Project("searchForMe", "projectSynopsis", modelAccount);
        List<ProjectSetting> responseArray = new ArrayList<ProjectSetting>(){{
            add(new ProjectSetting(project, "value", "key"));
        }};
        when(projectDao.getProjectById(1)).thenReturn(project);
        when(projectSettingDao.getSettingsForProject(project)).thenReturn(responseArray);
        ProjectSettingRequest projectSettingRequest = new ProjectSettingRequest(1);
        ProjectSettingResponse projectSettingResponse = projectRequestHandler.handleListProjectSettingRequest(projectSettingRequest);
        assertThat(projectSettingResponse.getMessage()).isEqualTo(ResponseMessages.VALID_PROJECT_SETTING);
        assertThat(projectSettingResponse.isAccepted()).isTrue();
        assertThat(projectSettingResponse.getSettingResponse()).isEqualTo(responseArray);

        ProjectSettingRequest projectDoesntExistRequest = new ProjectSettingRequest(2);
        ProjectSettingResponse projectDoesntExistResponse = projectRequestHandler.handleListProjectSettingRequest(projectDoesntExistRequest);
        assertThat(projectDoesntExistResponse.getMessage()).isEqualTo(ResponseMessages.PROJECT_DOESNT_EXIST);
        assertThat(projectDoesntExistResponse.isAccepted()).isFalse();
        assertThat(projectDoesntExistResponse.getSettingResponse()).isNullOrEmpty();
    }

    @Test
    public void handleSettingCreationProjectRequest() {
        final Project project = new Project("searchForMe", "projectSynopsis", modelAccount);
        when(projectDao.getProjectById(1)).thenReturn(project);
        ProjectSettingCreationRequest validProjectSettingCreationRequest = new ProjectSettingCreationRequest(1, "test", "value");
        ProjectSettingCreationResponse validProjectSettingCreation = projectRequestHandler.handleCreateProjectSettingRequet(validProjectSettingCreationRequest);
        assertThat(validProjectSettingCreation.getMessage()).isEqualTo(ResponseMessages.PROJECT_SETTING_ADDED);
        assertThat(validProjectSettingCreation.isAccepted()).isTrue();
        verify(projectSettingDao,times(1)).addSettingForProject(any(Project.class), anyString(), anyString());

        ProjectSettingCreationRequest projectDoesntExistRequest = new ProjectSettingCreationRequest(2, "test", "value");
        ProjectSettingCreationResponse projectDoesntExistResponse = projectRequestHandler.handleCreateProjectSettingRequet(projectDoesntExistRequest);
        assertThat(projectDoesntExistResponse.getMessage()).isEqualTo(ResponseMessages.PROJECT_DOESNT_EXIST);
        assertThat(projectDoesntExistResponse.isAccepted()).isFalse();
    }
}

