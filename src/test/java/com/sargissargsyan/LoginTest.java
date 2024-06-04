package com.sargissargsyan;

import com.sargissargsyan.api.BaseService;
import com.sargissargsyan.models.User;
import com.sargissargsyan.pages.LoginPage;
import com.sargissargsyan.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class LoginTest extends SeleniumBase {
    private String name;
    private String username;
    private String email;
    private final String password = "Armenia2023";
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
    public void loginViaUI() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.login(email, password);

        //do checks
    }

    @Test
    public void loginViaUIError() {
        LoginPage loginPage = new LoginPage().open();
        loginPage.typeUsername("qweqweqwe");
        loginPage.typePassword("qwqwqwqw");

        //do checks
    }
}

