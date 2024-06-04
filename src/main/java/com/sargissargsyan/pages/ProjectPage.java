package com.sargissargsyan.pages;

import com.sargissargsyan.base.BasePage;
import com.sargissargsyan.models.Project;

/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class ProjectPage extends BasePage<ProjectPage> {
    private final Project project;
    public ProjectPage(Project project) {
        this.project = project;
    }

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
        return "/project/" + project.getSlug();
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
