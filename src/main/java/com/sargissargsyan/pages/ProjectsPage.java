package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import com.sargissargsyan.base.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class ProjectsPage extends BasePage<ProjectsPage> {
    @FindBy(css = "[tg-nav='create-project'].create-project-btn.btn-small")
    private WebElement newProjectButton;

    @Override
    public ProjectsPage open() {
        return openPage();
    }

    @Override
    public ProjectsPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/projects";
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public NewProjectPage clickNewProjectButton() {
        WaitHelper.getWait().waitForElementToBeVisible(newProjectButton).click();
        WaitHelper.getWait().waitForLoading();
        return new NewProjectPage().init();
    }
}
