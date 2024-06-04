package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */

public class RegisterPage extends BasePage<RegisterPage> {
    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "full_name")
    private WebElement fullNameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = ".end button")
    private WebElement signUpButton;

    @Override
    public RegisterPage open() {
        return openPage();
    }

    @Override
    public RegisterPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/register";
    }

    public void setUsername(String username){
        usernameField.sendKeys(username);
    }

    public void setpassword(String password){
        passwordField.sendKeys(password);
    }

    public void setFullName(String fullName){
        fullNameField.sendKeys(fullName);
    }

    public void setEmail(String email){
        emailField.sendKeys(email);
    }

    public void  clickSignUpButton() {
        signUpButton.click();

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
