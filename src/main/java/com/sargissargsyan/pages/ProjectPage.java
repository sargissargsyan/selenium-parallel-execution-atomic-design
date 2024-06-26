package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class ProjectPage extends BasePage<ProjectPage> {
    @Override
    public ProjectPage open() {
        return openPage();
    }

    @Override
    public ProjectPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/project/";
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
