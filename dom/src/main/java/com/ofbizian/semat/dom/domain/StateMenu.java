package com.ofbizian.semat.dom.domain;

import java.util.List;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.wrapper.WrapperFactory;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = State.class
)
@DomainServiceLayout(
        named = "Templates",
        menuOrder = "20"
)
public class StateMenu {

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @MemberOrder(sequence = "1")
    public State newState(
            @ParameterLayout(named="Name")
            final String name,
            @ParameterLayout(named="Description")
            final String descriptions,
            @ParameterLayout(named="Alpha Type")
            final AlphaType alphaType) {
        return stateRepository.createState(name, descriptions, alphaType);
    }

    @Action(semantics = SemanticsOf.SAFE)
//    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<State> findStates(
            @ParameterLayout(named="Alpha Type")
            final AlphaType alphaType
    ) {
        return wrapperFactory.wrap(stateRepository).findStates(alphaType);
    }

    @Action(semantics = SemanticsOf.SAFE)
//    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "3")
    @Property()
    public List<State> allState() {
        return wrapperFactory.wrap(stateRepository).listStates();
    }

//
//    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
//    @MemberOrder(sequence = "1")
//    public State newStateItem(
//            @ParameterLayout(named="State")
//            final State state,
//            @ParameterLayout(named="Description")
//            final String descriptions) {
//        return stateRepository.createStateItem(descriptions, state);
//    }
//

    @javax.inject.Inject
    StateRepository stateRepository;

    @javax.inject.Inject
    WrapperFactory wrapperFactory;

}
