package com.ofbizian.semat.fixture.scenarios;

import java.util.Set;

import com.google.common.collect.Sets;
import com.ofbizian.semat.dom.domain.AlphaType;
import com.ofbizian.semat.dom.domain.Item;
import com.ofbizian.semat.dom.domain.Project;
import com.ofbizian.semat.dom.domain.ProjectRepository;
import com.ofbizian.semat.dom.domain.State;
import com.ofbizian.semat.fixture.dom.ItemCreate;
import com.ofbizian.semat.fixture.dom.ProjectCreate;
import com.ofbizian.semat.fixture.dom.ProjectTearDown;
import com.ofbizian.semat.fixture.dom.StateCreate;

public class DemoFixture extends AbstractFixtureScript {
    public DemoFixture() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    private Set<Project> projects = Sets.newLinkedHashSet();

    @Override
    protected void doExecute(ExecutionContext ec) {
        ec.executeChild(this, new ProjectTearDown());
        createProject(ec, "SOE", "Standard Operating Environment", "This is a demo SOE project");
        createProject(ec, "ESB", "Enterprise Service Bus",  "This is a demo ESB project");
    }

    private void createProject(ExecutionContext ec, String code, String name, String description) {
        ProjectCreate projectCreate = new ProjectCreate();
        projectCreate.setCode(code);
        projectCreate.setName(name);
        projectCreate.setDescription(description);
        ec.executeChild(this, projectCreate.getName(), projectCreate);
        Project project = projectCreate.getProject();
        projects.add(project);
    }

    @javax.inject.Inject
    private ProjectRepository repository;
}
