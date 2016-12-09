package com.ofbizian.semat.dom.domain;

import java.util.List;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.registry.ServiceRegistry2;
import org.apache.isis.applib.services.repository.RepositoryService;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Project.class)
public class ProjectRepository {

    public List<Project> listAll() {
        return repositoryService.allInstances(Project.class);
    }

    public List<Project> findByName(final String name) {
        return repositoryService.allMatches(
                new QueryDefault<>(
                        Project.class,
                        "findByName",
                        "name", name));
    }

    public Project create(String code, String name, String description) {
        final Project object = new Project();
        object.setCode(code);
        object.setName(name);
        object.setDescription(description);

        serviceRegistry.injectServicesInto(object);
        object.init();
        final List<Alpha> projectAlphas = stateRepository.createProjectAlphas(object);

        repositoryService.persist(object);

        for (Alpha alpha : projectAlphas) {
            alpha.setProject(object);
        }
        return object;
    }

    public void remove(Project project) {
        repositoryService.removeAndFlush(project.getOpportunity().getAlphaStates());
//        repositoryService.removeAndFlush(project.getOpportunity());
//        repositoryService.removeAndFlush(project.getStakeholders());
//        repositoryService.removeAndFlush(project.getRequirements());
//        repositoryService.removeAndFlush(project.getSoftwareSystem());
//        repositoryService.removeAndFlush(project.getTeam());
//        repositoryService.removeAndFlush(project.getWork());
//        repositoryService.removeAndFlush(project.getWayOfWorking());
//        repositoryService.removeAndFlush(project);
    }

    @javax.inject.Inject
    StateRepository stateRepository;

    @javax.inject.Inject
    RepositoryService repositoryService;

    @javax.inject.Inject
    ServiceRegistry2 serviceRegistry;

}
