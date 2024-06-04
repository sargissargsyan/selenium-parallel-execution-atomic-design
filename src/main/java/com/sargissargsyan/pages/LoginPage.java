package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import com.sargissargsyan.base.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class LoginPage extends BasePage<LoginPage> {
    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = ".login-form button")
    private WebElement loginButton;

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.getWait().waitForElementToBeVisible(By.name("username"));
    }

    @Override
    public LoginPage open() {
        return openPage();
    }

    @Override
    public LoginPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/login";
    }

    public HomePage login(String username, String password) {
        WaitHelper.getWait().waitForElementToBeVisible(By.name("username"));
        typeUsername(username);
        typePassword(password);
        loginButton.click();
        WaitHelper.getWait().waitForElementToBeVisible(By.cssSelector(".user-avatar"));
        return new HomePage().init();
    }

    public void typeUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void typePassword(String password) {
        passwordField.sendKeys(password);
    }
}
