package com.sargissargsyan.api;

import com.sargissargsyan.models.Project;
import com.sargissargsyan.utils.Parser;
import okhttp3.Response;

public class ProjectService extends BaseService {
    public static Project createProject(Project project) {
        Response response = post("/projects", project);
        String jsonString = getJsonStringFromResponse(response);
        return Parser.parse(jsonString, Project.class);
    }

    public static void deleteProject(Project project) {
        delete("/projects", project.getId());
    }
}
