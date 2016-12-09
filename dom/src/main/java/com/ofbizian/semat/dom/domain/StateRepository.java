package com.ofbizian.semat.dom.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.registry.ServiceRegistry2;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.wrapper.WrapperFactory;

@DomainService(
        nature = NatureOfService.DOMAIN,
        repositoryFor = State.class
)
public class StateRepository {

    @javax.inject.Inject
    RepositoryService repositoryService;

    @javax.inject.Inject
    ServiceRegistry2 serviceRegistry;

    @javax.inject.Inject
    WrapperFactory wrapperFactory;

    public List<Alpha> createProjectAlphas(Project object) {
        Alpha opportunity = new Alpha(AlphaType.OPPORTUNITY, "Opportunity", Concern.CUSTOMER);
        Alpha stakeholders = new Alpha(AlphaType.STAKEHOLDERS, "Stakeholders", Concern.CUSTOMER);
        Alpha requirements = new Alpha(AlphaType.REQUIREMENTS, "Requirements", Concern.SOLUTION);
        Alpha softwareSystem = new Alpha(AlphaType.SOFTWARE_SYSTEM, "Software System", Concern.SOLUTION);
        Alpha team = new Alpha(AlphaType.TEAM, "Team", Concern.ENDEAVOR);
        Alpha work = new Alpha(AlphaType.WORK, "Work", Concern.ENDEAVOR);
        Alpha wayOfWorking = new Alpha(AlphaType.WAY_OF_WORKING, "Way Of Working", Concern.ENDEAVOR);

        List<Alpha> alphas = new ArrayList<>();
        alphas.add(createAlpha(opportunity));
        alphas.add(createAlpha(stakeholders));
        alphas.add(createAlpha(requirements));
        alphas.add(createAlpha(softwareSystem));
        alphas.add(createAlpha(team));
        alphas.add(createAlpha(work));
        alphas.add(createAlpha(wayOfWorking));

        object.setOpportunity(opportunity);
        object.setStakeholders(stakeholders);
        object.setRequirements(requirements);
        object.setSoftwareSystem(softwareSystem);
        object.setTeam(team);
        object.setWork(work);
        object.setWayOfWorking(wayOfWorking);
        return alphas;
    }

    private Alpha createAlpha(Alpha object) {
        serviceRegistry.injectServicesInto(object);
        object.init();
        repositoryService.persist(object);

        int i = 0;
        List<State> states = wrapperFactory.wrap(this).findStates(object.getAlphaType());
        for (State state : states) {
            final AlphaState alphaState = createAlphaState(object, state, false, i++);
            final SortedSet<Item> items = state.getItems();
            int j = 0;
            for (Item item : items) {
                createChecklist(alphaState, item, false, j++);
            }
        }
        return object;
    }

    public List<Alpha> listAlphas() {
        return repositoryService.allInstances(Alpha.class);
    }

    public State createState(final String name, String description, AlphaType alphaType) {
        State object = new State();
        object.setName(name);
        object.setDescription(description);
        object.setAlphaType(alphaType);
        serviceRegistry.injectServicesInto(object);
        object.init();
        repositoryService.persist(object);
        return object;
    }

    public List<State> listStates() {
        return repositoryService.allInstances(State.class);
    }

    public List<State> findStates(AlphaType alphaType) {
        return repositoryService.allMatches(
                new QueryDefault<>(
                        State.class,
                        "findByAlphaType",
                        "alphaType", alphaType));

    }

    public AlphaState createAlphaState(Alpha alpha, State state, boolean achieved, int sequence) {
        AlphaState object = new AlphaState();
        object.setAlpha(alpha);
        object.setState(state);
        object.setAchieved(achieved);
        object.setSequence(sequence);
        serviceRegistry.injectServicesInto(object);
        object.init();
        repositoryService.persist(object);
        return object;
    }

    public List<AlphaState> listAlphaState() {
        return repositoryService.allInstances(AlphaState.class);
    }

    private Item createItem(String description) {
        Item object = new Item();
        object.setDescription(description);
        serviceRegistry.injectServicesInto(object);
        object.init();
        repositoryService.persist(object);
        return object;
    }

    public List<Item> listItems() {
        return repositoryService.allInstances(Item.class);
    }

    public Checklist createChecklist(AlphaState alphaState, Item item, boolean achieved, int sequence) {
        Checklist object = new Checklist();
        object.setAlphaState(alphaState);
        object.setItem(item);
        object.setAchieved(achieved);
        object.setSequence(sequence);
        serviceRegistry.injectServicesInto(object);
        object.init();
        repositoryService.persist(object);
        return object;
    }

    public List<Checklist> listChecklists() {
        return repositoryService.allInstances(Checklist.class);
    }

    public Item createStateItem(String descriptions, State state) {
        final Item item = createItem(descriptions);
        state.addToItems(item);
        item.setState(state);
        return item;
    }
}
