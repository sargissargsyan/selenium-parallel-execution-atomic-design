package com.sargissargsyan;

import com.sargissargsyan.api.BaseService;
import com.sargissargsyan.models.User;
import com.sargissargsyan.pages.*;
import com.sargissargsyan.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
}
