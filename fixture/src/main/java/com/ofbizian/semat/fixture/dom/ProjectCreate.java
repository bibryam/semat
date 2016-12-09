package com.ofbizian.semat.fixture.dom;

import com.ofbizian.semat.dom.domain.Project;
import com.ofbizian.semat.dom.domain.ProjectMenu;
import com.ofbizian.semat.fixture.scenarios.AbstractFixtureScript;

public class ProjectCreate extends AbstractFixtureScript {
    private String code;
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Project project;

    public Project getProject() {
        return project;
    }

    @Override
    protected void doExecute(final ExecutionContext ec) {
        String name = checkParam("name", ec, String.class);
        String code = checkParam("code", ec, String.class);
        String description = checkParam("description", ec, String.class);

        this.project = wrap(menu).newProject(code, name, description);
        ec.addResult(this, project);
    }

    @javax.inject.Inject
    private ProjectMenu menu;

}
