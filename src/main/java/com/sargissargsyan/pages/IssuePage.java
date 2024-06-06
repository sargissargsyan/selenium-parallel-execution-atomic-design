package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class IssuePage extends BasePage<IssuePage> {
    private final String projectId = "";

    @FindBy(css = ".detail-status-inner")
    private WebElement issueStatus;

    @FindBy(css = ".user-list-single")
    private WebElement assignee;

    @Override
    public IssuePage open() {
        return openPage();
    }

    @Override
    public IssuePage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return null;
    }

    public String getIssueInnerStatus() {
        return issueStatus.getText();
    }

    public String getIssueAssignee() {
        return assignee.getText();
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
