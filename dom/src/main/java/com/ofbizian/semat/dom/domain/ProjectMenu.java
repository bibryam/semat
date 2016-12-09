package com.ofbizian.semat.dom.domain;

import java.util.List;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.wrapper.WrapperFactory;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = Project.class
)
@DomainServiceLayout(
        named = "Projects",
        menuOrder = "10"
)
public class ProjectMenu {

    public static class CreateDomainEvent extends ActionDomainEvent<ProjectMenu> {}
    @Action(domainEvent = CreateDomainEvent.class,
            semantics = SemanticsOf.NON_IDEMPOTENT)
    @MemberOrder(sequence = "1")
    public Project newProject(
            @ParameterLayout(named="Code")
            final String code,
            @ParameterLayout(named="Name")
            final String name,
            @ParameterLayout(named="Description")
            @Parameter(optionality = Optionality.OPTIONAL)
            final String descriptions) {
        return projectRepository.create(code, name, descriptions);
    }

    @Action(semantics = SemanticsOf.SAFE)
//    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<Project> findProjects(
            @ParameterLayout(named="Name")
            final String name
    ) {
        return wrapperFactory.wrap(projectRepository).findByName(name);
    }

    @Action(semantics = SemanticsOf.SAFE)
//    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "3")
    @Property()
    public List<Project> allProjects() {
        return wrapperFactory.wrap(projectRepository).listAll();
    }

    @javax.inject.Inject
    ProjectRepository projectRepository;


    @javax.inject.Inject
    WrapperFactory wrapperFactory;
}
