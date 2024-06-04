package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import com.sargissargsyan.base.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class IssuesPage extends BasePage<IssuesPage> {
    private String projectId = "";
    public IssuesPage (String projectId) {
        this.projectId = projectId;
    }
    public IssuesPage(){

    }
    @FindBy(css = ".taskboard-actions .btn-small")
    private WebElement newIssueButton;

    @Override
    public IssuesPage open() {
        return openPage();
    }

    @Override
    public IssuesPage init() {
        return initPage();
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public NewIssuePage clickNewIssueButton() {
        WaitHelper.getWait().waitForElementToBeVisible(newIssueButton).click();
        return new NewIssuePage().init();
    }

    @Override
    public String getUrl() {
        return "/project/" + projectId + "/issues" ;
    }
}
