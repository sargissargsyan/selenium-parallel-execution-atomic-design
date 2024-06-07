package com.sargissargsyan;

import com.sargissargsyan.api.BaseService;
import com.sargissargsyan.api.ProjectService;
import com.sargissargsyan.models.Project;
import com.sargissargsyan.models.User;
import com.sargissargsyan.pages.*;
import com.sargissargsyan.utils.TestUtils;
import okhttp3.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class ProjectTest extends SeleniumBase {
    private String name;
    private String username;
    private String email;
    private final String password = "Armenia2024";
    private User newUser;
    private Project newProject;

    @BeforeMethod
    public void setup() {
        name = TestUtils.randomString(5);
        username = TestUtils.randomString(7);
        email = TestUtils.randomEmail(username);
        newUser = User.builder()
                .fullName(name)
                .username(username)
                .email(email)
                .password(password)
                .acceptedTerms(true)
                .type("public")
                .build();
        newUser = BaseService.register(newUser);
        Project project = Project.builder()
                .name("Test Project X")
                .description("Test Project X")
                .creationTemplate(1)
                .isPrivate(false)
                .build();
        newProject = ProjectService.createProject(project);
    }


    @Test
    public void projectPage() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login(email, password);

        ProjectsPage projectsPage = new ProjectsPage().open();
        NewProjectPage newProjectPage = projectsPage.clickNewProjectButton();
        NewScrumProjectPage newScrumProjectPage = newProjectPage.selectScrum();
        newScrumProjectPage.typeProjectName("project name x");
        newScrumProjectPage.typeProjectDescription("project name x");
        ProjectBacklogPage projectBacklogPage = newScrumProjectPage.clickCreateProject();

        //do checks
    }


    @Test
    public void projectPageWithAPI() {
        login(username, password);
        new ProjectPage(newProject).open();
    }
}
