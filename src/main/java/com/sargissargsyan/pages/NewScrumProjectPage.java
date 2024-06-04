package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import com.sargissargsyan.base.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */

public class NewScrumProjectPage extends BasePage<NewScrumProjectPage> {
    @FindBy(css = "[name='project-name']")
    private WebElement projectNameInput;

    @FindBy(css = "[name='projectForm'] textarea")
    private WebElement projectDescriptionInput;

    @FindBy(css = ".create-project-action-submit")
    private WebElement createProjectButton;

    @Override
    public NewScrumProjectPage open() {
        return openPage();
    }

    @Override
    public NewScrumProjectPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void typeProjectName(String projectName) {
        WaitHelper.getWait().waitForElementToBeVisible(projectNameInput).sendKeys(projectName);
    }
    public void typeProjectDescription(String projectDescription) {
        projectDescriptionInput.sendKeys(projectDescription);
    }

    public ProjectBacklogPage clickCreateProject() {
        createProjectButton.click();
        WaitHelper.getWait().waitForLoading();
        return new ProjectBacklogPage().init();
    }

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.getWait().waitForElementToBeVisible(projectNameInput);
    }

}
